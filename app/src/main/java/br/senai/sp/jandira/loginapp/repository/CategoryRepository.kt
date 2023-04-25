package br.senai.sp.jandira.loginapp.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.loginapp.R
import br.senai.sp.jandira.loginapp.model.Category

class CategoryRepository {
    companion object{
        @Composable
        fun getCategory(): List<Category>{
            return listOf(
                Category(
                    id = 1,
                    nome = "montain",
                    icon = painterResource(id =R.drawable.montain)
                ),
                Category(
                    id = 2,
                    nome = "snow",
                    icon = painterResource(id =R.drawable.snow)
                ),
                Category(
                    id = 3,
                    nome = "beach",
                    icon = painterResource(id =R.drawable.beach)
                )
            )
        }
    }
}