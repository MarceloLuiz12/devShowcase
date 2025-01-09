package com.example.feature_show_case.via_cep

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.domain.model.AddressModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun AddressLookupScreen(viewModel: AddressViewModel = koinViewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    var cep by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = cep,
            onValueChange = { cep = it },
            label = { Text("Enter Postal Code") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { viewModel.getAddress(cep) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Fetch Address")
        }
        Spacer(modifier = Modifier.height(16.dp))

        when (uiState) {
            is AddressUiState.Idle -> Text("Enter a postal code to search.")
            is AddressUiState.Loading -> CircularProgressIndicator()
            is AddressUiState.Success -> AddressDetails((uiState as AddressUiState.Success).address)
            is AddressUiState.Error -> Text(
                text = (uiState as AddressUiState.Error).message,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun AddressDetails(address: AddressModel) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text("Street: ${address.street}")
        Text("Neighborhood: ${address.neighborhood}")
        Text("City: ${address.city}")
        Text("State: ${address.state}")
    }
}
