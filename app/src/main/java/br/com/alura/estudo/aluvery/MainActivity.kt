package br.com.alura.estudo.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import br.com.alura.estudo.aluvery.ui.screens.HomeScreen
import br.com.alura.estudo.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }




}
@Composable
private fun App() {
    AluveryTheme {
        Surface {
            HomeScreen()
        }
    }
}
