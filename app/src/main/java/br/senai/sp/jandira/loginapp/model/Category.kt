package br.senai.sp.jandira.loginapp.model

import androidx.compose.ui.graphics.painter.Painter

data class Category(
    var id: Long = 0,
    var nome:String = "",
    var icon: Painter? = null
)