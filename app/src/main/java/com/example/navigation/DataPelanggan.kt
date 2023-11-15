package com.example.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataPelanggan(
    onSubmitButtonClick: (MutableList<String>)-> Unit,
    onBackButtonClick: (MutableList<String>) -> Unit
){
    var namaTxt by rememberSaveable {
        mutableStateOf("")
    }
    var teleponTxt by rememberSaveable {
        mutableStateOf("")
    }
    var alamatTxt by rememberSaveable {
        mutableStateOf("")
    }
    

    var listDataTxt : MutableList<String> = mutableListOf(namaTxt, alamatTxt, teleponTxt)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ){
        OutlinedTextField(value = namaTxt, onValueChange = {namaTxt = it},
            label = {
                Text(text = "Nama")
            })
        OutlinedTextField(value = teleponTxt, onValueChange = {teleponTxt = it},
            label = {
                Text(text = "Telepom")
            })
        OutlinedTextField(value = alamatTxt, onValueChange = {alamatTxt = it},
            label = {
                Text(text = "Alamat")
            })
        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick = {onBackButtonClick(listDataTxt)}) {
            Text(text = stringResource(id = R.string.back_button))
        }
        Button(onClick = {onSubmitButtonClick(listDataTxt)}) {
            Text(text = stringResource(id = R.string.submit))
        }
    }
}