package com.template.supplier.base.uicomponent

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

private val minHeight = 45.dp
private val cornerRadius: Dp = 10.dp

@Composable
fun PrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit,
) {
    Box {
        Button(
            onClick,
            modifier.defaultMinSize(minHeight = minHeight),
            enabled,
            remember { MutableInteractionSource() },
            elevation,
            RoundedCornerShape(cornerRadius),
            null,
            colors,
            contentPadding,
            content
        )
    }
}

@Composable
fun SecondaryOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit,
) {
    OutlinedButton(
        onClick,
        modifier.defaultMinSize(minHeight = minHeight),
        enabled,
        remember { MutableInteractionSource() },
        null,
        RoundedCornerShape(cornerRadius),
        BorderStroke(
            width = ButtonDefaults.OutlinedBorderSize,
            color = Cyan
        ),
        ButtonDefaults.outlinedButtonColors(),
        contentPadding,
        content
    )

}

@Composable
fun LoadingButton(
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = minHeight)
            .clickable(false) { }
            .background(
                color = MaterialTheme.colors.onSurface
                    .copy(alpha = 0.12f)
                    .compositeOver(MaterialTheme.colors.surface),
                shape = RoundedCornerShape(cornerRadius)
            )
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(20.dp),
            color = Cyan
        )
    }

}