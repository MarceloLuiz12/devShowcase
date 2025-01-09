package com.example.di.modules

import com.example.feature_show_case.via_cep.AddressViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val presentationModule = module {
    viewModel { AddressViewModel() }
}