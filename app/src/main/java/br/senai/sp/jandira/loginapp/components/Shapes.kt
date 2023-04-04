package br.senai.sp.jandira.loginapp.components

import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TopShape() {
    Card(
        modifier = Modifier
            .width(120.dp)
            .height(40.dp),
            shape = RoundedCornerShape(bottomStart = 16.dp)
    ){
        Box(
            modifier =Modifier.
            background(color = Color(217,0,255,255),
            shape = RoundedCornerShape(bottomStart = 16.dp)
            ).size(120.dp,40.dp)
        ){}
    }
}
@Preview
@Composable
fun toShapePreview(){
    TopShape()
    BottomShape()
}

@Composable
fun BottomShape() {
    Box(modifier = Modifier
        .background(
            color = Color(217, 0, 255, 255),
            shape = RoundedCornerShape(topEnd = 16.dp)
        ).size(120.dp,40.dp)
    )
}
