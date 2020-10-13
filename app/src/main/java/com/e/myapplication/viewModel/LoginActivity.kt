package com.e.myapplication.viewModel

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.e.myapplication.R

class LoginActivity : AppCompatActivity() {

    private lateinit var mLoginDisposable: Disposable

    private lateinit var mBinding: ActivityLoginBinding

    private lateinit var mloginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getResources().getBoolean(R.bool.portrait)) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT
        }
        mBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_login
        )
        setUpActivityComponents()
    }


    /**
     * @description method to set up the activity components
     */
    private fun setUpActivityComponents() {
        mloginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        mBinding.viewmodel = mloginViewModel
    }

    /**
     * @description rx observer to handle the change password observer
     */
    private var loginObserver = object : SingleObserver<Unit> {
        override fun onSuccess(t: Unit) {
            mLoginDisposable.dispose()

        }

        override fun onSubscribe(d: Disposable) {
            mloginViewModel = d
        }

        override fun onError(e: Throwable) {
            mloginViewModel.dispose()

        }
    }


    fun onClick(v: View) {
        when (v.id) {
            R.id.btn_submit -> {
                loginListener()
            }
        }
    }

    private fun loginListener() {

        if (mloginViewModel.validateLoginCredential(
                mloginViewModel.email.get() ?: "",
                mloginViewModel.password.get() ?: "",
                mloginViewModel.confirmPassword.get() ?: ""
            )
        ) {

        }
    }
}