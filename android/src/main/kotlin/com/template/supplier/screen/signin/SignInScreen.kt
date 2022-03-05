package com.template.supplier.screen.signin

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.template.signin.SignInSideEffect
import com.template.signin.SignInViewEvent
import com.template.signin.SignInViewModel
import com.template.signin.SignInViewState
import com.template.supplier.R
import com.template.supplier.base.ComposeViewModel
import com.template.supplier.base.OnSideEffect
import com.template.supplier.base.theme.BlackBlue
import com.template.supplier.base.theme.BrightRed
import com.template.supplier.base.theme.DarkGray
import com.template.supplier.base.theme.Gray
import com.template.supplier.base.uicomponent.InputText
import com.template.supplier.base.uicomponent.LoadingButton
import com.template.supplier.base.uicomponent.PrimaryButton
import com.template.supplier.base.uicomponent.SecondaryOutlinedButton


@ExperimentalComposeUiApi
@Composable
fun SignInScreen(navController: NavController) {
    ComposeViewModel<SignInViewModel, SignInViewState> { viewModel, viewState ->
        SignInScreenContent(state = viewState.value, onViewEvent = viewModel::onEvent)
        OnSideEffect(viewModel) { effect ->
            when (effect) {
                is SignInSideEffect.GoToHome -> {
                    // TODO navController.navigate(SignInDirections.toHome())
                }
                is SignInSideEffect.GoToSignUp -> {
                    // TODO navController.navigate(SignInDirections.toSignUp())
                }
                is SignInSideEffect.GoToForgotPassword -> {
                    // TODO navController.navigate(SignInDirections.toForgotPassword())
                }
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun SignInScreenContent(
    state: SignInViewState,
    onViewEvent: (SignInViewEvent) -> Unit
) {

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(
                start = 21.dp,
                top = 40.dp,
                end = 21.dp,
                bottom = 50.dp
            )
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        SignInHeader()
        Spacer(modifier = Modifier.height(48.dp))
        Text(
            text = stringResource(id = R.string.signin_screen_signin_title),
            color = BlackBlue,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            maxLines = 1
        )

        Spacer(modifier = Modifier.height(38.dp))

        UsernameInput(
            value = userName,
            isError = state.isUsernameError,
            onValueChange = { userName = it })

        Spacer(modifier = Modifier.height(22.dp))

        PasswordInput(
            value = password,
            isError = state.isPasswordError,
            onValueChange = { password = it },
            onGo = {
                signIn(userName, password, keyboardController, focusManager, onViewEvent)
            }
        )

        Spacer(modifier = Modifier.height(30.dp))
        if (state.isLoading) {
            LoadingButton()
        } else {
            PrimaryButton(
                onClick = {
                    signIn(
                        userName,
                        password,
                        keyboardController,
                        focusManager,
                        onViewEvent
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.signin_screen_login_button),
                    fontSize = 16.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(90.dp))

        Text(
            text = stringResource(id = R.string.signin_screen_not_having_account_text),
            color = Gray,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(20.dp))

        SecondaryOutlinedButton(
            onClick = {
                // TODO navController.navigate(SignInDirections.toSignUp())
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.signin_screen_signup_button), fontSize = 16.sp)
        }

        Box(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            contentAlignment = Alignment.Center
        ) {
            androidx.compose.animation.AnimatedVisibility(
                visible = state.errorMessage != null,
                enter = fadeIn(),
                exit = fadeOut(),
                content = { ErrorContent(state) }
            )
        }

    }


}

@Composable
fun SignInHeader() {
//    Image(painter = painterResource(id = R.drawable.ic_main), contentDescription = null)
}

@ExperimentalComposeUiApi
private fun signIn(
    userName: String,
    password: String,
    keyboardController: SoftwareKeyboardController?,
    focusManager: FocusManager,
    onViewEvent: (SignInViewEvent) -> Unit
) {
    keyboardController?.hide()
    focusManager.clearFocus()
    onViewEvent(SignInViewEvent.SignIn(userName, password))
}

@Composable
private fun UsernameInput(
    value: String,
    isError: Boolean,
    onValueChange: (String) -> Unit
) {
    Column {
        Text(
            text = stringResource(id = R.string.signin_screen_phone_number_field),
            color = DarkGray,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start,
        )
        Spacer(modifier = Modifier.height(12.dp))
        InputText(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            singleLine = true,
            isError = isError,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Next
            ),
            onValueChange = onValueChange,
        )
        if (isError) {
            Text(
                text = stringResource(id = R.string.signin_screen_invalid_phone_text),
                color = BrightRed,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Start,
            )
        }
    }
}

@Composable
private fun PasswordInput(
    value: String,
    isError: Boolean,
    onValueChange: (String) -> Unit,
    onGo: () -> Unit
) {
    var showPassword by remember { mutableStateOf(false) }
    Column {
        Text(
            text = stringResource(id = R.string.signin_screen_password_field),
            color = DarkGray,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start,
        )
        Spacer(modifier = Modifier.height(12.dp))
        InputText(
            modifier = Modifier
                .fillMaxWidth(),
            value = value,
            singleLine = true,
            trailingIcon = {
                IconButton(onClick = { showPassword = !showPassword }) {
                    Icon(
                        painter = if (showPassword) {
                            painterResource(R.drawable.ic_password_visible)
                        } else {
                            painterResource(R.drawable.ic_password_hidden)
                        },
                        contentDescription = null
                    )
                }
            },
            isError = isError,
            visualTransformation = if (showPassword) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Go
            ),
            keyboardActions = KeyboardActions(onGo = { onGo() }),
            onValueChange = onValueChange,
        )
        if (isError) {
            Text(
                text = stringResource(id = R.string.signin_screen_invalid_password_text),
                color = BrightRed,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Start,
            )
        }

    }
}

@Composable
private fun ErrorContent(state: SignInViewState) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Filled.Warning,
            contentDescription = null,
            tint = MaterialTheme.colors.error
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = state.errorMessage.orEmpty(),
            color = MaterialTheme.colors.error
        )
    }
}