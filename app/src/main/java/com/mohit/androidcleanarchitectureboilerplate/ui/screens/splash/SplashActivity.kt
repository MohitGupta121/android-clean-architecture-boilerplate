package com.mohit.androidcleanarchitectureboilerplate.ui.screens.splash

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mohit.androidcleanarchitectureboilerplate.R
import com.mohit.androidcleanarchitectureboilerplate.ui.screens.auth.AuthActivity
import com.mohit.androidcleanarchitectureboilerplate.ui.screens.main.DocuBoxActivity
import com.mohit.androidcleanarchitectureboilerplate.util.extensions.launchAndCollect
import com.mohit.androidcleanarchitectureboilerplate.util.extensions.navigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private val viewModel by viewModels<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        collectEvents()
    }

    private fun collectEvents() = viewModel.events.launchAndCollect(this) {
        when (it) {
            SplashScreenEvents.NavigateToAuthScreen -> navigate(AuthActivity::class.java, true)
            SplashScreenEvents.NavigateToHomeScreen -> navigate(DocuBoxActivity::class.java, true)
        }
    }
}
