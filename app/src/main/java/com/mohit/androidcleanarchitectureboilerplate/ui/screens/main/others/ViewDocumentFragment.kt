package com.mohit.androidcleanarchitectureboilerplate.ui.screens.main.others

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mohit.androidcleanarchitectureboilerplate.R
import com.mohit.androidcleanarchitectureboilerplate.data.remote.models.responses.file.FileDto
import com.mohit.androidcleanarchitectureboilerplate.databinding.FragmentViewDocumentBinding
import com.mohit.androidcleanarchitectureboilerplate.util.viewBinding.viewBinding


class ViewDocumentFragment : Fragment(R.layout.fragment_view_document) {

    private val args: ViewDocumentFragmentArgs by navArgs()
    private val binding by viewBinding(FragmentViewDocumentBinding::bind)
    private lateinit var file: FileDto

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        file = args.file.file
        initActionBar()
        initWebView()
    }

    private fun initActionBar() = with(binding) {
        actionBar.setupActionBar(
            title = "Document Viewer",
            backButtonEnabled = true,
            backButtonOnClickListener = { findNavController().popBackStack() }
        )
    }

    private fun initWebView() = with(binding) {
        webView.apply {
            settings.builtInZoomControls = true
            settings.supportZoom()
            loadUrl("${BASE_URL}documents/file/${file.id}")
        }
    }

}