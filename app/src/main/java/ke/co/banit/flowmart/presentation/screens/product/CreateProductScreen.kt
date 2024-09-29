package ke.co.banit.flowmart.presentation.screens.product

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ke.co.banit.flowmart.presentation.components.MScreenTitle
import ke.co.banit.flowmart.presentation.components.MTopAppBar

/**
 * @Author: Angatia Benson
 * @Date: 9/29/2024
 * Copyright (c) 2024 BanIT
 */

@Composable
fun CreateProductScreen() {
    Scaffold(
        topBar = {
            MTopAppBar(title = { MScreenTitle(title = "Create Product") }, showBackButton = true)
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) { }
    }
}