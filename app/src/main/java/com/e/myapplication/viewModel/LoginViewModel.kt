package com.e.myapplication.viewModel

import android.text.TextUtils
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    val email: ObservableField<String> = ObservableField()
    val password: ObservableField<String> = ObservableField()
    val confirmPassword: ObservableField<String> = ObservableField()

    fun validateLoginCredential(
        email: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        when {
            TextUtils.isEmpty(email) -> {
                return false
            }
            TextUtils.isEmpty(password) -> {
                return false
            }
            TextUtils.isEmpty(confirmPassword) -> {

                return false
            }
            password != confirmPassword -> {
                return false
            }
            else -> return true
        }
    }
}