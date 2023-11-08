package br.com.alura.estudo.aluvery.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import br.com.alura.estudo.aluvery.dao.ProductDao
import br.com.alura.estudo.aluvery.ui.screens.ProductFormScreen
import br.com.alura.estudo.aluvery.ui.theme.AluveryTheme

class ProductFormActivity : ComponentActivity() {

    private val dao = ProductDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            AluveryTheme {
                Surface {
                    ProductFormScreen(onSaveClick = {
                        dao.save(it)
                        finish()
                    })
                }
            }
        }

    }
}
