package br.senai.sp.jandira.loginapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.loginapp.model.Category
import br.senai.sp.jandira.loginapp.repository.CategoryRepository
import br.senai.sp.jandira.loginapp.ui.theme.LoginAPPTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginAPPTheme {
                // A surface container using the 'background' color from the theme


                HomeScreen()

            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreen() {
    HomeScreen( category = CategoryRepository.getCategory())

}


@Composable
fun HomeScreen(category: List<Category>) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Mail ,
                    contentDescription ="" )
            }
        }
    ) {

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Column() {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    backgroundColor = Color.Magenta,
                    shape = RectangleShape
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.paris),
                        contentDescription = "Logo",
                        contentScale = ContentScale.Crop
                    )
                }
                Text(
                    text = stringResource(id = R.string.categories_home),
                    modifier = Modifier.padding(top = 14.dp, start = 16.dp)
                )
                LazyRow() {
                    items(category) { category ->
                        Card(
                            modifier = Modifier
                                .size(200.dp, 80.dp)
                                .padding(4.dp),
                            backgroundColor = Color.Green
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    painter =category.icon!!,
                                    contentDescription =""
                                )
                                Text(text = category.nome)
                            }

                        }

                    }

                }
            }
        }
    }
    LoginAPPTheme {

    }
}