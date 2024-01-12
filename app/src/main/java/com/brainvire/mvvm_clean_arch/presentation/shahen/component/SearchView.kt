package com.brainvire.mvvm_clean_arch.presentation.shahen.component

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brainvire.learning.R
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.search_view_bg
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.text_color

@Preview
@Composable
fun SearchView(
    searchKey: String = "",
    context: Context = LocalContext.current,
    onSearchType: (searchKey: String) -> Unit = {}
) {

    TextField(
        modifier = Modifier
            .requiredHeight(50.dp)
            .fillMaxWidth()
            .padding(0.dp)
            .background(shape = RoundedCornerShape(12.dp), color = search_view_bg),
        placeholder = {
            Text(text = "Search", color = text_color, fontSize = 14.sp)
        },
        value = searchKey,
        onValueChange = {
            onSearchType(it)
        },
        textStyle = TextStyle(
            fontSize = 16.sp,
            color = Color.Gray
        ),
        singleLine = true,
        leadingIcon = {
            IconButton(onClick = {
            }) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_search),
                    contentDescription = "",
                    tint = Color.Black.copy(alpha = 0.5f)
                )
            }
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            cursorColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),
    )
}