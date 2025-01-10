package com.example.feature_show_case.via_cep

import androidx.lifecycle.ViewModel
import com.example.domain.extensions.useCase
import com.example.domain.usecase.GetAddressUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent

class AddressViewModel : ViewModel(), KoinComponent {
    private val getAddressUseCase: GetAddressUseCase by useCase()

    private val _uiState = MutableStateFlow<AddressUiState>(AddressUiState.Idle)
    val uiState: StateFlow<AddressUiState> = _uiState

    fun getAddress(cep: String) {
        _uiState.update { AddressUiState.Loading }
        getAddressUseCase(
            params = cep,
            onSuccess = { address ->
                _uiState.update { AddressUiState.Success(address) }
            },
            onError = {  error ->
                _uiState.update { AddressUiState.Error(error.message ?: "Unknown error") }
            }
        )
    }

}