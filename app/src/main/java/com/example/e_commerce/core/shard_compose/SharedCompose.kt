package com.example.e_commerce.core.shard_compose

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.e_commerce.core.AppPadding
import com.example.e_commerce.core.AppRadius

@Composable
fun FormTextField(
    value: String,
    labelText: String,
    trailingIcon: (@Composable (() -> Unit))? = null,
    onValueChanged: (String) -> Unit,
    isError: Boolean,
    errorMessage: String?,
    isVisible : Boolean
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        TextField(
            visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation(),
            shape = RoundedCornerShape(AppRadius.formRadius),
            value = value,
            textStyle = MaterialTheme.typography.labelSmall,
            onValueChange = onValueChanged,
            label = {
                Text(
                    text = labelText,
                    style = MaterialTheme.typography.labelSmall
                )
            },
            isError = isError,
            trailingIcon = trailingIcon?.let { { it() } },
            modifier = Modifier.fillMaxWidth().then(
                if(isError){
                    Modifier.border(width = 2.dp, shape = RoundedCornerShape(8.dp), color = MaterialTheme.colorScheme.error)
                }else{
                    Modifier
                }
            ),
        )
        if (isError && errorMessage != null) {
            Text(
                text = errorMessage,
                style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.error),
                modifier = Modifier.padding(start = AppPadding.medium, top = AppPadding.small)
            )
        }
    }
}


@Composable
fun CustomButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = AppPadding.large),
        shape = RoundedCornerShape(AppRadius.formRadius),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge.copy(color = MaterialTheme.colorScheme.primary),
            modifier = Modifier.padding(top = AppPadding.small, bottom = AppPadding.small)
        )
    }
}