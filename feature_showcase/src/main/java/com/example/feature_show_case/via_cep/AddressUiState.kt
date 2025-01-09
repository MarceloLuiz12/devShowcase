package com.example.feature_show_case.via_cep

import com.example.domain.model.AddressModel

sealed class AddressUiState  {
    data object Idle : AddressUiState()
    data object Loading : AddressUiState()
    data class Success(val address: AddressModel) : AddressUiState()
    data class Error(val message: String) : AddressUiState()
}