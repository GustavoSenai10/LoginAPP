package br.senai.sp.jandira.loginapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.loginapp.ui.theme.LoginAPPTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginAPPTheme {
                SignUpScreen()
                
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpScreen() {
    LoginAPPTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
            ) {
                Box(
                    modifier = Modifier
                        .width(120.dp)
                        .height(40.dp)
                        .background(
                            Color(207, 6, 240),
                            shape = RoundedCornerShape(bottomStart = 16.dp)
                        )
                )
            }
            Row(
                horizontalArrangement = Arrangement.Center
            ) {

            }
       }
    }
}
