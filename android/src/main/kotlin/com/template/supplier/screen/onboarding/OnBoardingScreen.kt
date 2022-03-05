package com.template.supplier.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState


@ExperimentalPagerApi
@Composable
fun OnBoardingScreen(navController: NavController) {
    OnBoardingScreenContent(navController)
}

@ExperimentalPagerApi
@Composable
fun OnBoardingScreenContent(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize(),
    )
    {
        Text(
            text = stringResource(id = R.string.onboarding_skip_button),
            color = Gray,
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 50.dp, end = 22.dp)
                .clickable {
                    navController.go(OnBoardingDirections.toSignIn())
                }
        )
        ComposeViewPager()
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(start = 22.dp, end = 22.dp, bottom = 87.dp)
        ) {
            ScreenFooter(navController)
        }
    }
}

@ExperimentalPagerApi
@Composable
private fun ComposeViewPager() {
    val pagerItems = arrayListOf(
        PagerItem(
            image = R.drawable.ic_onboarding_1,
            title = stringResource(id = R.string.onboarding_title_1),
            description = stringResource(id = R.string.onboarding_description_1)
        ),
        PagerItem(
            image = R.drawable.ic_onboarding_2,
            title = stringResource(id = R.string.onboarding_title_2),
            description = stringResource(id = R.string.onboarding_description_2)
        ),
        PagerItem(
            image = R.drawable.ic_onboarding_3,
            title = stringResource(id = R.string.onboarding_title_3),
            description = stringResource(id = R.string.onboarding_description_3)
        ),
        PagerItem(
            image = R.drawable.ic_onboarding_4,
            title = stringResource(id = R.string.onboarding_title_4),
            description = stringResource(id = R.string.onboarding_description_4)
        ),
    )

    val pagerState = rememberPagerState(pageCount = pagerItems.size)

    Column(modifier = Modifier.padding(top = 100.dp)) {
        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth(),
            state = pagerState
        ) { page ->
            ComposePagerItem(pagerItems[page])
        }

        Spacer(modifier = Modifier.padding(all = 50.dp))

        HorizontalPagerIndicator(
            pagerState = pagerState,
            activeColor = MaterialTheme.colors.primary,
            inactiveColor = LightGrayD,
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(all = 16.dp),
        )
    }

}

@Composable
private fun ComposePagerItem(pagerItem: PagerItem) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = pagerItem.image),
            contentDescription = null,
            modifier = Modifier.padding(horizontal = 22.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = pagerItem.title,
            fontWeight = Bold,
            fontSize = 24.sp,
            color = BlackBlue,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 22.dp)
        )
        Spacer(modifier = Modifier.height(14.dp))
        Text(
            text = pagerItem.description,
            fontWeight = Normal,
            fontSize = 18.sp,
            color = Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 22.dp)
        )
    }

}

@Composable
private fun ScreenFooter(navController: NavController) {

    Column {
        Divider(
            color = LightGrayA,
            modifier = Modifier.height(1.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            PrimaryButton(
                onClick = {
                    navController.go(OnBoardingDirections.toSignIn())
                },
                modifier = Modifier.width(156.dp)
            ) {
                Text(text = stringResource(id = R.string.onboarding_login_button), fontSize = 16.sp)
            }

            SecondaryOutlinedButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.width(156.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.onboarding_signup_button),
                    fontSize = 16.sp
                )
            }

        }
    }
}


private data class PagerItem(
    val image: Int,
    val title: String,
    val description: String
)
