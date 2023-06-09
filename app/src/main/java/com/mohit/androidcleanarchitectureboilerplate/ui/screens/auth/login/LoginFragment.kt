package com.mohit.androidcleanarchitectureboilerplate.ui.screens.auth.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mohit.androidcleanarchitectureboilerplate.R
import com.mohit.androidcleanarchitectureboilerplate.databinding.FragmentLoginBinding
import com.mohit.androidcleanarchitectureboilerplate.ui.screens.main.DocuBoxActivity
import com.mohit.androidcleanarchitectureboilerplate.util.extensions.*
import com.mohit.androidcleanarchitectureboilerplate.util.viewBinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding by viewBinding(FragmentLoginBinding::bind)
    private val viewModel by viewModels<LoginViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initListeners()
        collectUIState()
        collectUiEvents()
    }

    private fun collectUiEvents() = viewModel.events.launchAndCollect(viewLifecycleOwner) {
        when (it) {
            LoginScreenEvents.NavigateToMainScreen -> requireActivity().navigate(
                DocuBoxActivity::class.java,
                true
            )
            LoginScreenEvents.NavigateToRegisterScreen -> findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            is LoginScreenEvents.ShowToast -> requireContext().showToast(it.message)
            else -> {}
        }
    }

    private fun collectUIState() = viewModel.uiState.launchAndCollectLatest(viewLifecycleOwner) {
        // change progress bar visibility acc to isLoading
        with(binding) {
            emailTIL.error = it.emailError
            passwordTIL.error = it.passwordError
            emailTIET.isEnabled = it.areTextFieldsEnabled
            passwordTIET.isEnabled = it.areTextFieldsEnabled
            loginBtn.isEnabled = it.isLoginButtonEnabled
            progressLayout.visibleOrGone(it.isLoading)
        }
    }

    private fun initListeners() = with(binding) {
        emailTIET.doAfterTextChanged { viewModel.onEmailTextChange(it.toString()) }
        passwordTIET.doAfterTextChanged { viewModel.onPasswordTextChange(it.toString()) }
        loginBtn.singleClick(viewModel::onLoginButtonPressed)
        goToRegister.singleClick(viewModel::onGoToRegisterPress)
    }

    private fun initViews() = with(binding) {}
}
