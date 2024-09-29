package ke.co.banit.flowmart.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Eye
import compose.icons.fontawesomeicons.solid.EyeSlash
import ke.co.banit.flowmart.presentation.theme.Dimensions

/**
 * @Author: Angatia Benson
 * @Date: 9/27/2024
 * Copyright (c) 2024 BanIT
 */

@Composable
fun MOutlinedTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    hasRoundedCorners: Boolean = true,
    prefixIcon: @Composable (() -> Unit)? = null,
    enabledTogglePassword: Boolean = false,
    ) {
    var passwordVisible by remember { mutableStateOf(!enabledTogglePassword) }
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, style = MaterialTheme.typography.labelLarge) },
        singleLine = true,
        leadingIcon = prefixIcon,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        shape = if (hasRoundedCorners) RoundedCornerShape(Dimensions.borderRadiusLg) else RectangleShape,
        visualTransformation = if (passwordVisible) VisualTransformation.None
        else PasswordVisualTransformation(),
        modifier = modifier
            .fillMaxWidth(),
        trailingIcon = {
            if (enabledTogglePassword) {
                val image: ImageVector = if (passwordVisible) {
                    FontAwesomeIcons.Solid.EyeSlash
                } else {
                    FontAwesomeIcons.Solid.Eye
                }
                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, contentDescription = description, modifier = Modifier.size(Dimensions.iconMd))
                }
            }
        },
    )
}
