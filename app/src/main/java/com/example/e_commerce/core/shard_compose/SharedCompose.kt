package com.example.e_commerce.core.shard_compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.e_commerce.core.AppPadding
import com.example.e_commerce.core.AppRadius

@Composable
fun FormTextField(labelText: String, trailingIcon: (@Composable (() -> Unit))? = null) {
    TextField(
        shape = RoundedCornerShape(AppRadius.formRadius),
        value = "",
        textStyle = MaterialTheme.typography.labelSmall,
        onValueChange = {},
        label = {
            Text(
                text = labelText,
                style = MaterialTheme.typography.labelSmall
            )
        },
        trailingIcon = trailingIcon?.let { { it() } },
        modifier = Modifier.fillMaxWidth(),

        )
}


@Composable
fun CustomButton(text : String,onClick:()-> Unit){
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