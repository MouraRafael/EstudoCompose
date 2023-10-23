package br.com.alura.estudo.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ItemComposable()
        }
    }


}

@Preview(showBackground = true)
@Composable
fun ItemComposable(){
    Column {
        Box(
            Modifier
                .width(50.dp)
                .height(50.dp)
                .background(Color.Blue)
        )
        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = null)
        Text(text = "Texto1")
        Text(text = "Texto2")
    }
}

@Preview(showBackground = true)
@Composable
fun DesafioLayout(){

    Row(
        Modifier.height(150.dp)
    ){
        Box(modifier = Modifier
            .fillMaxHeight()
            .width(100.dp)
            .background(Color.Blue)
        ){}
        Column() {
            Text(text = "Test 1",Modifier.fillMaxWidth()
                .background(Color(0xFFededed))
                .padding(16.dp))
            Text(text = "Test 2",Modifier.padding(16.dp))
        }
    }
}