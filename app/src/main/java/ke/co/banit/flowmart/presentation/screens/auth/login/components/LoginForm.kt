package ke.co.banit.flowmart.presentation.screens.auth.login.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import ke.co.banit.flowmart.presentation.components.MButton
import ke.co.banit.flowmart.presentation.components.MOutlinedTextField
import ke.co.banit.flowmart.presentation.theme.Dimensions

/**
 * @Author: Angatia Benson
 * @Date: 10/6/2024
 * Copyright (c) 2024 BanIT
 */


@Composable
fun LoginForm(
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(Dimensions.spaceBetweenSections))
        Text(
            text = "Login",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(Dimensions.spaceBetweenItems))

        MOutlinedTextField(
            value = email,
            onValueChange = onEmailChange,
            label = "Email Address",
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
            value = password,
            onValueChange = onPasswordChange,
            label = "Password",
            keyboardType = KeyboardType.Password,
            hasRoundedCorners = true,
            enabledTogglePassword = true,
            prefixIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Password Icon",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        )
        Spacer(modifier = Modifier.height(Dimensions.lg))

        MButton(
            onClick = onLoginClick,
            text = "Login"
        )
        SignUpPrompt(onSignUpClick = onSignUpClick)
    }
}