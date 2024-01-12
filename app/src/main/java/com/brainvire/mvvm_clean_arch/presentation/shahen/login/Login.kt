package com.brainvire.mvvm_clean_arch.presentation.shahen.login

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.brainvire.learning.R
import com.brainvire.mvvm_clean_arch.presentation.shahen.component.LoadingDialog
import com.brainvire.mvvm_clean_arch.presentation.shahen.component.SnakeBar
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.edt_border_color
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.shahen_app_color

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun Login(
    context: Context = LocalContext.current,
    navController: NavHostController = NavHostController(context)
) {

    val TAG = "Login"

    val viewModel: LoginViewModel = hiltViewModel()
    val context = LocalContext.current
    val scaffoldState: ScaffoldState = rememberScaffoldState()

    val isLoadingState = viewModel.isLoadingState.collectAsState().value
    val emailState = viewModel.emailState.value
    val passwordState = viewModel.passwordState.value
    val showPasswordState = viewModel.showPasswordState.collectAsState().value
    val loginErrorMsg = viewModel.loginErrorMsg.collectAsState().value

    //todo show login error message Snake-bar
    if(loginErrorMsg != "") {
        SnakeBar(scaffoldState = scaffoldState, message = loginErrorMsg, viewModel)
    }

    Scaffold(scaffoldState = scaffoldState) {

        Box(
            Modifier
                .fillMaxSize()
                .padding(it)
                .paint(
                    painterResource(id = R.drawable.login_bg),
                    contentScale = ContentScale.Crop
                )
        ) {

            if (isLoadingState) {
                LoadingDialog()
            }

            Column(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .fillMaxWidth()
            ) {

                Row(Modifier.padding(start = 80.dp, end = 80.dp, top = 60.dp)) {
                    Image(
                        modifier = Modifier
                            .width(202.dp)
                            .height(119.dp),
                        painter = painterResource(id = R.drawable.shahen_logo),
                        contentDescription = null
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 45.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Welcome Back!",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Login",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }

                Card(
                    modifier = Modifier.padding(top = 18.dp, start = 16.dp, end = 16.dp),
                    elevation = 8.dp,
                    backgroundColor = Color.White,
                    shape = RoundedCornerShape(16.dp),
                ) {
                    Column(
                        Modifier.padding(16.dp)
                    ) {
                        /*TextField(
                            value = emailState.text,
//                            value = "",
                            maxLines = 1,
                            singleLine = true,
                            shape = RoundedCornerShape(12.dp),
                            label = {
                                Text(text = "Email Id")
                            },
                            onValueChange = { input ->
                                viewModel.setEmail(input)
                            },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color.Transparent,
                                unfocusedBorderColor = Color.Transparent,
                                disabledBorderColor = Color.Transparent,
                                errorBorderColor = Color.Transparent
                            ),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Outlined.Email,
                                    contentDescription = "",
                                    tint = edt_border_color
                                )
                            },
                            placeholder = {
                                Text(text = "Email Id", color = edt_border_color)
                            },
                            isError = emailState.error != "",
                            keyboardOptions = KeyboardOptions(
                                imeAction = ImeAction.Next
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(64.dp)
                                .background(
                                    shape = RoundedCornerShape(0.dp),
                                    color = Color.Transparent
                                )
                                .border(
                                    width = 1.dp,
                                    color = shahen_app_color,
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .padding(horizontal = 0.dp, vertical = 8.dp)
                        )*/

                        OutlinedTextField(
                            value = emailState.text,
//                            value = "",
                            maxLines = 1,
                            singleLine = true,
                            shape = RoundedCornerShape(12.dp),
                            onValueChange = { input ->
                                viewModel.setEmail(input)
                            },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = edt_border_color,
                                unfocusedBorderColor = edt_border_color
                            ),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Outlined.Email,
                                    contentDescription = "",
                                    tint = edt_border_color
                                )
                            },
                            placeholder = {
                                Text(text = "Email Id", color = edt_border_color)
                            },
                            isError = emailState.error != "",
                            keyboardOptions = KeyboardOptions(
                                imeAction = ImeAction.Next
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 0.dp, vertical = 8.dp)
                        )

                        if (emailState.error != "") {
                            Text(
                                text = emailState.error ?: "",
                                color = MaterialTheme.colors.error,
                            )
                        }

                        OutlinedTextField(
                            value = passwordState.text,
//                            value = "",
                            maxLines = 1,
                            singleLine = true,
                            shape = RoundedCornerShape(12.dp),
                            trailingIcon = {
                                ClickableText(
                                    modifier = Modifier.padding(end = 12.dp),
                                    text = if (showPasswordState) AnnotatedString("Hide") else AnnotatedString(
                                        "Show"
                                    ),
                                    style = TextStyle(
                                        color = shahen_app_color,
                                        fontSize = 14.sp,
                                    ),
                                    onClick = {
                                        viewModel.setShowPassword(!showPasswordState)
                                    }
                                )
                            },
                            onValueChange = { input ->
                                viewModel.setPassword(input)
                            },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = edt_border_color,
                                unfocusedBorderColor = edt_border_color
                            ),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Outlined.Lock,
                                    contentDescription = "",
                                    tint = edt_border_color
                                )
                            },
                            placeholder = {
                                Text(text = "Password", color = edt_border_color)
                            },
                            isError = passwordState.error != "",
                            visualTransformation = if (showPasswordState) VisualTransformation.None else PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions(
                                imeAction = ImeAction.Next
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 0.dp, vertical = 8.dp)
                        )

                        if (passwordState.error != "") {
                            Text(
                                text = passwordState.error ?: "",
                                color = MaterialTheme.colors.error,
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 14.dp),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Text(
                                text = "Forgot Password?",
                                color = shahen_app_color,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                            )
                        }

                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 24.dp),
                            shape = RoundedCornerShape(32.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = shahen_app_color,
                                contentColor = Color.White
                            ),
                            onClick = {
                                viewModel.isValid(navController = navController)
                            },
                        ) {
                            Text(
                                modifier = Modifier.padding(8.dp),
                                text = "Login",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 18.sp,
                            )
                        }
                    }
                }

            }

            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 42.dp)
            ) {
                Text(
                    text = "Don't have an account? ",
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                )
                Text(
                    text = "Register",
                    color = shahen_app_color,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    }
}