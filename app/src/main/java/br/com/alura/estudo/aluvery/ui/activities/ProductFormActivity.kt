package br.com.alura.estudo.aluvery.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.estudo.aluvery.R
import br.com.alura.estudo.aluvery.model.Product
import br.com.alura.estudo.aluvery.ui.theme.AluveryTheme
import coil.compose.AsyncImage
import coil.request.ImageRequest
import java.math.BigDecimal

class ProductFormActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            AluveryTheme {
                Surface {
                    ProductFormScreen()
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductFormScreen() {

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

        var url by remember { mutableStateOf("") }

        if (url.isNotBlank()) {
            AsyncImage(
                model = ImageRequest
                    .Builder(LocalContext.current)
                    .data(url)
                    .crossfade(1000)
                    .build(),
                contentDescription = null,
                Modifier.fillMaxWidth().height(200.dp),
                placeholder = painterResource(id = R.drawable.placeholder),
                error = painterResource(id = R.drawable.placeholder),

            )
        }


        TextField(value = url, onValueChange = {
            url = it
        },
            Modifier.fillMaxWidth(),
            label = { Text(text = "Url da Imagem") },
            placeholder = { Text(text = "Insira a Url da Imagem") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Uri,
                imeAction = ImeAction.Next
            )
        )


        var name by remember { mutableStateOf("") }
        TextField(value = name, onValueChange = {
            name = it
        },
            Modifier.fillMaxWidth(),
            label = { Text(text = "Nome") },
            placeholder = { Text(text = "Digite o Nome") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
                
            )
        )

        var price by remember { mutableStateOf("") }
        TextField(value = price, onValueChange = {
            price = it
        },
            Modifier.fillMaxWidth(),
            label = { Text(text = "Preço") },
            placeholder = { Text(text = "Digite o preço") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            )
        )


        var description by remember { mutableStateOf("") }
        TextField(value = description, onValueChange = {
            description = it
        },
            Modifier
                .fillMaxWidth()
                .heightIn(100.dp),
            label = { Text(text = "Descrição") },
            placeholder = { Text(text = "Digite a descrição") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
            )
        )

        Button(
            onClick = {
                val convertedPrice = try {
                    BigDecimal(price)
                } catch (e: NumberFormatException) {
                    Log.e("ProductFormScreen", "ProductFormScreen: ${e.message}", e)
                    BigDecimal.ZERO
                }
                val product = Product(
                    name = name,
                    image = url,
                    price = convertedPrice,
                    description = description
                )
                Log.i("ProductFormScreen", "ProductFormScreen: $product")
            },
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
    ProductFormScreen()
}