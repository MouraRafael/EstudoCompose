package br.com.alura.estudo.aluvery.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.estudo.aluvery.R
import br.com.alura.estudo.aluvery.model.Product
import br.com.alura.estudo.aluvery.ui.states.ProductFormScreenUiState
import br.com.alura.estudo.aluvery.ui.viewmodels.ProductFormScreenViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import java.math.BigDecimal
import java.text.DecimalFormat




@Composable
fun ProductFormScreen(
    viewModel: ProductFormScreenViewModel,
    onSaveClick:(Product)->Unit={}
) {
    val state by viewModel.uiState.collectAsState()

    ProductFormScreen(state = state)

}

//val click = {
//    val convertedPrice = try {
//        BigDecimal(price)
//    } catch (e: NumberFormatException) {
//        Log.e("ProductFormScreen", "ProductFormScreen: ${e.message}", e)
//        BigDecimal.ZERO
//    }
//    val product = Product(
//        name = name,
//        image = url,
//        price = convertedPrice,
//        description = if(description.isNotBlank()) description else null
//    )
//    Log.i("ProductFormScreen", "ProductFormScreen: $product")
//    onSaveClick(product)
//}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductFormScreen(
    state: ProductFormScreenUiState,
    onSaveClick: () -> Unit = {}
) {
    var url =state.url
    var name = state.name
    var price = state.price

    var description =state.description

    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Spacer(modifier = Modifier)


        Text(
            text = "Criando o Produto",
            Modifier
                .fillMaxWidth(),
            fontSize = 28.sp
        )



        if (state.isShowPreview) {
            AsyncImage(
                model = ImageRequest
                    .Builder(LocalContext.current)
                    .data(url)
                    .crossfade(1000)
                    .build(),
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                placeholder = painterResource(id = R.drawable.placeholder),
                error = painterResource(id = R.drawable.placeholder),

                )
        }


        TextField(
            value = url, onValueChange = state.onUrlChange,
            Modifier.fillMaxWidth(),
            label = { Text(text = "Url da Imagem") },
            placeholder = { Text(text = "Insira a Url da Imagem") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Uri,
                imeAction = ImeAction.Next,

                )
        )


        TextField(
            value = name, onValueChange = state.onNameChange,
            Modifier.fillMaxWidth(),
            label = { Text(text = "Nome") },
            placeholder = { Text(text = "Digite o Nome") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Words

            )
        )


        TextField(
            value = price,
            onValueChange = state.onPriceChange,
            Modifier.fillMaxWidth(),
            label = { Text(text = "Preço") },
            placeholder = { Text(text = "Digite o preço") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            )
        )


        TextField(
            value = description, onValueChange = state.onDescriptionChange,
            Modifier
                .fillMaxWidth()
                .heightIn(100.dp),
            label = { Text(text = "Descrição") },
            placeholder = { Text(text = "Digite a descrição") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Sentences
            )
        )

        Button(
            onClick = onSaveClick,
            Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Salvar")
        }

        Spacer(modifier = Modifier)
    }

}

@Preview(showBackground = true)
@Composable
fun ProductFormScreenPreview() {
    ProductFormScreen(ProductFormScreenViewModel())
}