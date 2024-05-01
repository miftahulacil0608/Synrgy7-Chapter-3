package com.anangkur.synrgychapter3.ui.activity

import android.content.Context
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.anangkur.synrgychapter3.data.AuthRepositoryImpl
import com.anangkur.synrgychapter3.data.datasource.local.AuthLocalDataSourceImpl
import com.anangkur.synrgychapter3.data.datasource.local.SharedPreferencesFactory
import com.anangkur.synrgychapter3.data.datasource.remote.AuthRemoteDataSourceImpl
import com.anangkur.synrgychapter3.domain.AuthRepository

class MainViewModel(private val authRepository: AuthRepository) : ViewModel() {

    companion object {
        fun provideFactory(
            owner: SavedStateRegistryOwner,
            context: Context,
        ): AbstractSavedStateViewModelFactory =
            object : AbstractSavedStateViewModelFactory(owner, null) {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(
                    key: String,
                    modelClass: Class<T>,
                    handle: SavedStateHandle,
                ): T {
                    val authRepository: AuthRepository = AuthRepositoryImpl(
                        authLocalDataSource = AuthLocalDataSourceImpl(
                            sharedPreferences = SharedPreferencesFactory().createSharedPreferences(context),
                        ),
                        authRemoteDataSource = AuthRemoteDataSourceImpl(),
                    )
                    return MainViewModel(authRepository = authRepository) as T
                }
            }
    }

    fun logout() {
        authRepository.clearToken()
    }
}