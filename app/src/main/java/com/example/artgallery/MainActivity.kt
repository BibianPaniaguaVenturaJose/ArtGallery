package com.example.artgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.artgallery.ui.theme.ArtGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtGalleryTheme {
                ArtImage()
            }
        }
    }
}

@Preview//(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentWidth(Alignment.CenterHorizontally)
    )

}

@Composable
fun ArtImage(modifier : Modifier=Modifier){
    var imagen by remember {mutableStateOf(1) }
    val imagenResource = getImage(imagen)
    val textoResource = getTexto(imagen)
    val tituloResource= getTitulo(imagen)

    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Spacer(modifier = Modifier.height(80.dp))


       Row(horizontalArrangement = Arrangement.Start) {
            Image(painter = painterResource(id = imagenResource), contentDescription =null)
            Spacer(modifier = Modifier.padding(vertical = 16.dp))
        }

        Row(horizontalArrangement = Arrangement.Center) {
            Text(stringResource(id = tituloResource))
            Spacer(modifier = Modifier.padding(all = 16.dp))
        }
        Row(horizontalArrangement = Arrangement.Center) {
            Text(stringResource(id = textoResource), textAlign = TextAlign.Center)
        }

        Row(horizontalArrangement = Arrangement.Center) {
            Button(onClick = {
                if (imagen>0 || imagen<4){
                    imagen--
                }
                if(imagen<0){
                    imagen=4
                }
            }, modifier = Modifier.padding(vertical = 16.dp)
            ) {
                Text(text = "Anterior")
            }
            Spacer(modifier = Modifier.padding(horizontal = 16.dp))
            Button(onClick = {
                if (imagen>0 || imagen<4){
                    imagen++
                }
                if(imagen>4){
                    imagen=0
                }
            }, modifier = Modifier.padding(vertical = 16.dp)
            ) {
                Text(text = "Siguiente ")
            }
        }
    }
}

private fun getImage(id:Int):Int{
    val imagenResource = when(id) {
        1->R.drawable.sun_eater_kayle
        2->R.drawable.pyke
        3->R.drawable.mordekaiser
        4->R.drawable.velkoz_
        else->R.drawable.zed
    }
    return  imagenResource
}

private fun getTexto(id:Int):Int{
    val textoResource = when(id) {
        1->R.string.Info_kayle
        2->R.string.Info_pyke
        3->R.string.Info_mordekaiser
        4->R.string.Info_velkoz
        else->R.string.Info_zed
    }

    return  textoResource
}

private fun getTitulo(id:Int):Int{
    val tituloResource = when(id) {
        1->R.string.Titulo_kayle
        2->R.string.Titulo_pyke
        3->R.string.Titulo_mordekaiser
        4->R.string.Titulo_velkoz
        else->R.string.Titulo_zed
    }
    return tituloResource
}