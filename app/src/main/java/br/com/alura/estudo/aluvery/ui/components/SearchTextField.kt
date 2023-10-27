package br.com.alura.estudo.aluvery.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun SearchTextField(
    searchText:String,
    onSearchTextChanged:(String)->Unit,
    modifier: Modifier = Modifier,
) {


    OutlinedTextField(
        value = searchText,
        onValueChange = { newValue ->
            onSearchTextChanged(newValue)
        },
        modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(100),
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Ícone de busca") },
        label = { Text(text = "Produtos") },
        placeholder = { Text(text = "O que você procura?") }

    )
}