package ke.co.banit.flowmart.presentation.screens.profile

import androidx.annotation.Dimension
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ke.co.banit.flowmart.presentation.components.MButton
import ke.co.banit.flowmart.presentation.components.MOutlinedTextField
import ke.co.banit.flowmart.presentation.components.MScreenTitle
import ke.co.banit.flowmart.presentation.components.ThemedAppLogo
import ke.co.banit.flowmart.presentation.theme.Dimensions

/**
 * @Author: Angatia Benson
 * @Date: 9/28/2024
 * Copyright (c) 2024 BanIT
 */
@Composable
fun ProfileScreen() {
    var name by remember { mutableStateOf("Angatia Benson") }
    var email by remember { mutableStateOf("angatiabenson1@gmail.com") }
    var phone by remember { mutableStateOf("0748355080") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(Dimensions.defaultSpace),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MScreenTitle(title = "My Profile", modifier = Modifier.align(Alignment.Start))
        // User Icon
        Box(
            modifier = Modifier
                .weight(0.5f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "User Profile",
                modifier = Modifier
                    .size(120.dp)
                    .padding(bottom = Dimensions.md),
                tint = MaterialTheme.colorScheme.primary
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(Dimensions.spaceBetweenSections))
            MOutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = "Name",
                keyboardType = KeyboardType.Text,
                prefixIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Username Icon",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            )
            Spacer(modifier = Modifier.height(Dimensions.spaceBetweenInputFields))

            MOutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = "Email",
                keyboardType = KeyboardType.Email,
                prefixIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email Icon",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            )
            Spacer(modifier = Modifier.height(Dimensions.spaceBetweenInputFields))

            MOutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                label = "Phone Number",
                keyboardType = KeyboardType.Phone,
                prefixIcon = {
                    Icon(
                        imageVector = Icons.Default.Phone,
                        contentDescription = "Phone Icon",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            )
            Spacer(modifier = Modifier.height(Dimensions.spaceBetweenSections))
            MButton(
                onClick = {
                },
                text = "Save Changes"
            )
        }
    }
}