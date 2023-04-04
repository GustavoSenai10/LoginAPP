package br.senai.sp.jandira.loginapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.loginapp.components.BottomShape
import br.senai.sp.jandira.loginapp.components.TopShape
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
                TopShape()
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(50.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.sign_up_title),
                    fontWeight = FontWeight.Bold,
                    color = Color(207, 6, 240),
                    fontSize = 32.sp
                )
                Text(
                    text = stringResource(id = R.string.create_account),
                    fontSize = 14.sp,
                    color = Color(160, 159, 156),
                    modifier = Modifier.padding(start = 17.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                Box(
                    modifier = Modifier
                        .size(100.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .size(100.dp)
                            .align(alignment = Alignment.BottomEnd),
                             shape = CircleShape,
                            border = BorderStroke(width = 2.dp,
                                        Brush.horizontalGradient(listOf(Color.Magenta,Color.Green)))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.perfil),
                            contentDescription =null,
                            modifier = Modifier
                                .size(92.dp)
                                .align(alignment = Alignment.Center))

                    }
                    Card(
                        modifier = Modifier
                            .size(50.dp)
                            .align(alignment = Alignment.BottomEnd,),
                            shape = CircleShape,
                        backgroundColor = Color.White
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.adicionar_foto),
                            contentDescription = null,
                            modifier = Modifier
                                .align(alignment = Alignment.BottomEnd)
                                .offset(x = 0.dp, y = 0.dp)
                                .size(10.dp))

                    }
                }
                Spacer(modifier = Modifier.height(50.dp))
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(text = stringResource(id = R.string.username))
                        },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.person_24),
                                contentDescription = ""
                            )

                        },
                    )
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(text = stringResource(id = R.string.phone))
                        },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_phone_android_24),
                                contentDescription = ""
                            )
                        },
                    )
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(text = stringResource(id = R.string.Email))
                        },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.email_24),
                                contentDescription = ""
                            )
                        }
                    )
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(text = stringResource(id = R.string.Pass))
                        },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.https_24),
                                contentDescription = ""
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(18.dp))
                    Row(
                        modifier = Modifier.height(45.dp)

                    ) {
                        Checkbox(
                            checked = false, onCheckedChange = {},
                            modifier = Modifier
                                .width(27.dp)
                                .height(27.dp)
                                .padding(start = 25.dp)
                        )
                        Text(
                            text = stringResource(id = R.string.age),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp, top = 4.dp)
                        )

                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .padding(start = 17.dp, end = 17.dp, top = 2.dp)
                                .fillMaxWidth()
                                .height(48.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults
                                .buttonColors
                                    (Color(207, 6, 240))
                        ) {
                            Text(
                                text = stringResource(id = R.string.create_account),
                                color = Color.White
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            text = stringResource(id = R.string.already)
                        )
                        Text(
                            text = stringResource(id = R.string.sign_in),
                            color = Color(207, 6, 240),
                            fontWeight = FontWeight.Bold
                        )
                    }

                }

            }

        }
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            BottomShape()
        }

    }
}
