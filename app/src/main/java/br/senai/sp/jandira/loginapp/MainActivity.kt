package br.senai.sp.jandira.loginapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.loginapp.repository.UserRepository
import br.senai.sp.jandira.loginapp.ui.theme.LoginAPPTheme
import br.senai.sp.jandira.loginapp.ui.theme.Shapes
import java.net.Authenticator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginAPPTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    LoginAPPTheme {
        val context = LocalContext.current

        var emailState by remember {
            mutableStateOf("")
        }

        var passwordState by remember {
            mutableStateOf("")
        }
        var passwordVisibilityState by remember {
            mutableStateOf(false)
        }
        Surface(
            modifier = Modifier.fillMaxSize(),

            ) {
            Row(
                horizontalArrangement = Arrangement.End
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
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center,

                ) {
                Text(
                    text = stringResource(id = R.string.login),
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(207, 6, 240),
                    modifier = Modifier.padding(start = 17.dp)
                )
                Text(
                    text = stringResource(id = R.string.conti),
                    fontSize = 14.sp,
                    color = Color(160, 156, 156),
                    modifier = Modifier.padding(start = 17.dp)
                )


                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    OutlinedTextField(
                        value = emailState,
                        onValueChange = {
                            emailState = it
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(text = stringResource(id = R.string.Email))
                        }, leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.email_24),
                                contentDescription = "",
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                    )
                    OutlinedTextField(
                        value = passwordState,
                        onValueChange = {
                            passwordState = it
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        visualTransformation = if (!passwordVisibilityState) PasswordVisualTransformation()else VisualTransformation.None,
                        label = {
                            Text(text = stringResource(id = R.string.Pass))
                        },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.https_24),
                                contentDescription = "",
                            )
                        },
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisibilityState = !passwordVisibilityState
                            }) {
                                Icon(
                                    imageVector = if (passwordVisibilityState) {
                                        Icons.Default.VisibilityOff
                                    } else {
                                        Icons.Default.Visibility
                                    },
                                    contentDescription = null
                                )
                            }
                        }
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {
                    Button(
                        onClick = {

                            authenticate(emailState, passwordState, context)

                        },
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(Color(207, 6, 240))

                    ) {
                        Text(
                            text = stringResource(id = R.string.sign_in),
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_forward_24),
                            contentDescription = "", tint =
                            Color.White
                        )

                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(id = R.string.mes)
                        )
                        TextButton(
                            onClick = {
                                var openSignUp = Intent(context, SignUpActivity::class.java)
                                context.startActivity(openSignUp)
                            }
                        ) {
                            Text(
                                text = stringResource(id = R.string.Sign_up),
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
                Box(
                    modifier = Modifier
                        .width(120.dp)
                        .height(40.dp)
                        .background(
                            Color(207, 6, 240),
                            shape = RoundedCornerShape(topEnd = 16.dp)
                        )
                )
            }
        }
    }
}

fun authenticate(
    email: String,
    password: String,
    context: Context,
) {
    val userRepository = UserRepository(context)
    val user = userRepository.authenticate(email, password)

    if (user == null) {
        val openHome = Intent(context, HomeActivity::class.java)
        context.startActivity(openHome)
    }
}
