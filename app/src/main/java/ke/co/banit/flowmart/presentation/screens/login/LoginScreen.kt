package ke.co.banit.flowmart.presentation.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ke.co.banit.flowmart.presentation.components.MOutlinedTextField
import ke.co.banit.flowmart.presentation.components.ThemedAppLogo
import ke.co.banit.flowmart.presentation.theme.Dimensions

/**
 * @Author: Angatia Benson
 * @Date: 9/27/2024
 * Copyright (c) 2024 BanIT
 */
@Composable
fun LoginScreen(onSignUpClick: () -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = Dimensions.defaultSpace)
        ) {
            Box(
                modifier = Modifier
                    .weight(0.6f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                ThemedAppLogo()
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // **Login Form**
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
                        value = username,
                        onValueChange = { username = it },
                        label = "Username",
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
                        value = password,
                        onValueChange = { password = it },
                        label = "Password",
                        keyboardType = KeyboardType.Password,
                        hasRoundedCorners = true,
                        isPassword = true,
                        prefixIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = "Password Icon",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        },
                        modifier = Modifier
                    )
                    Spacer(modifier = Modifier.height(Dimensions.lg))

                    Button(
                        onClick = {
                            //validate input
                            //login
                            //navigate to home screen
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onSecondaryContainer)
                    ) {
                        Text("Login")
                    }
                    SignUpPrompt(onSignUpClick = onSignUpClick)
                }

                Spacer(modifier = Modifier.height(Dimensions.spaceBetweenSections))
            }
        }
    }
}

@Composable
fun SignUpPrompt(onSignUpClick: () -> Unit) {
    Row(
        modifier = Modifier.padding(top = Dimensions.spaceBetweenItems),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Don't have an account? ",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        TextButton(onClick = onSignUpClick, contentPadding = PaddingValues(0.dp)) {
            Text(
                text = "Sign Up",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                ),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(onSignUpClick = {})
}