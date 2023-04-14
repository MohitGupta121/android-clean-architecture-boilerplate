package com.mohit.androidcleanarchitectureboilerplate.ui.screens.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mohit.androidcleanarchitectureboilerplate.data.local.models.FileOption
import com.mohit.androidcleanarchitectureboilerplate.databinding.ItemOptionsBinding
import com.mohit.androidcleanarchitectureboilerplate.databinding.OptionsBottomSheetBinding
import com.mohit.androidcleanarchitectureboilerplate.util.extensions.compose
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FileOptionsBottomSheetFragment(
    private val items: List<FileOption> = emptyList(),
    private val onOptionSelected: (FileOption) -> Unit = {}
) : BottomSheetDialogFragment() {

    private lateinit var binding: OptionsBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = OptionsBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.optionsRv.setHasFixedSize(false)
        binding.optionsRv.compose(
            ItemOptionsBinding::inflate,
            onBind = { item: FileOption, pos ->
                text.text = item.text
            },
        ) {
            onOptionSelected(this)
            dismiss()
        }.apply { submitList(items) }
    }
}