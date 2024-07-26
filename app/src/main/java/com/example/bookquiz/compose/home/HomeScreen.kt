package com.example.bookquiz.compose.home

import android.graphics.drawable.shapes.Shape
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookquiz.R
import com.example.bookquiz.ui.theme.BookQuizTheme
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.enums.EnumEntries

val notoSansKRFamily = FontFamily(
    Font(R.font.noto_sans_kr_regular, FontWeight.Normal),
    Font(R.font.noto_sans_kr_bold, FontWeight.Bold),
    Font(R.font.noto_sans_kr_medium, FontWeight.Medium),
    Font(R.font.noto_sans_kr_light, FontWeight.Light),
    Font(R.font.noto_sans_kr_thin, FontWeight.Thin),
    Font(R.font.noto_sans_kr_black, FontWeight.Black),
)

enum class RecommendedBookListPage(
    @StringRes val titleResId: Int
) {
    LowerGradeElementarySchool(R.string.lower_grade_elementary_school),
    HigherGradeElementarySchool(R.string.higher_grade_elementary_school),
    MiddleSchool(R.string.middle_school),
    HighSchool(R.string.high_school)
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    pages: EnumEntries<RecommendedBookListPage> = RecommendedBookListPage.entries
) {
    var searchText by remember { mutableStateOf("") }

    val pagerState = rememberPagerState(pageCount = { pages.size })

    Scaffold(
        modifier = modifier,
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier
                    .padding(horizontal = 14.dp, vertical = 0.dp),
                navigationIcon = {
                    IconButton(
                        modifier = Modifier
                            .padding(0.dp),
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.menu_icon),
                            "Menu Icon",
                            modifier = Modifier
                        )
                    }
                },
                title = {},
                actions = {
                    Button(modifier = Modifier
                        .padding(end = 16.dp)
                        .size(40.dp), onClick = {}) {
                    }
                }
            )
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .padding(horizontal = 30.dp)
        ) {
            Spacer(modifier = Modifier.size(height = 24.dp, width = 0.dp))
            Column(modifier = modifier.padding(end = 48.dp)) {
                Text(
                    "독서는 창조적 놀이다",
                    fontFamily = notoSansKRFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 26.sp
                )
                Spacer(modifier = Modifier.size(height = 0.dp, width = 0.dp))
                Text(
                    "책과 친해지는, 책읽기가 재미있는, 퀴즈로 즐기는 독서교육 프로그램",
                    fontFamily = notoSansKRFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = Color.hsl(hue = 0.0f, saturation = 0.0f, lightness = 0.62f)
                )
            }
            Box(modifier = Modifier.size(height = 38.dp, width = 0.dp))

            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clip(shape = RoundedCornerShape(size = 10.dp))
                    .background(
                        color = Color.hsl(
                            hue = 0.0f,
                            saturation = 0.0f,
                            lightness = 0.77f,
                            alpha = 0.15f,
                        )
                    )
                    .onFocusChanged {
                        searchText = if (it.isFocused) {
                            ""
                        } else {
                            "Search"
                        }
                    },
                value = searchText,
                onValueChange = { searchText = it },
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Start,
                    color = Color.hsl(hue = 0.0f, saturation = 0.0f, lightness = 0.77f)
                ),
                singleLine = true,
                decorationBox = { innerTextField ->
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 24.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.magnifyingglass),
                            contentDescription = "",
                            tint = Color.hsl(hue = 0.0f, saturation = 0.0f, lightness = 0.77f),
                        )
                        Spacer(modifier = Modifier.width(width = 8.dp))
                        innerTextField()
                    }
                },
            )

            RecommendedBooksPagerScreen(
                pagerState = pagerState,
                pages = pages,
            )
        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecommendedBooksPagerScreen(
    pagerState: PagerState,
    pages: EnumEntries<RecommendedBookListPage>,
    modifier: Modifier = Modifier
) {
    TabRow(
        modifier = modifier,
        selectedTabIndex = pagerState.currentPage
    ) {
        val coroutineScope = rememberCoroutineScope()
        pages.forEachIndexed { index, page ->
            val title = stringResource(id = page.titleResId)
            Tab(
                selected = pagerState.currentPage == index,
                onClick = { coroutineScope.launch{ pagerState.animateScrollToPage(index) } },
                text = { Text(text = title) },
                unselectedContentColor = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    BookQuizTheme {
        HomeScreen()
    }
}