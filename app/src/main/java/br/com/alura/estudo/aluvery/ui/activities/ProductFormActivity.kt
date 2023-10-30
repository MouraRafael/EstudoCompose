package br.com.alura.estudo.aluvery.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import br.com.alura.estudo.aluvery.ui.theme.AluveryTheme

class ProductFormActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent{
            AluveryTheme {
                Surface {
                    Text(text = "ASDF")
                }
            }
        }

    }
}