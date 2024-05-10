package com.d3if3136.coffeeorder.screen

import android.content.res.Configuration
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.d3if3136.coffeeorder.R
import com.d3if3136.coffeeorder.ui.theme.CoffeeOrderTheme

@Composable
fun DisplayAlertDialog(
    openDialog: Boolean,
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
) {
    if (openDialog) {
        AlertDialog(
            text = { Text(text = stringResource(R.string.delete_toast)) },
            confirmButton = {
                TextButton(onClick = { onConfirmation() }) {
                    Text(text = stringResource(R.string.delete_button))
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismissRequest() }) {
                    Text(text = stringResource(R.string.cancel_button))
                }
            },
            onDismissRequest = { onDismissRequest() }
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun DialogPreview() {
    CoffeeOrderTheme {
        DisplayAlertDialog(
            openDialog = true,
            onDismissRequest = {},
            onConfirmation = {}
        )
    }
}