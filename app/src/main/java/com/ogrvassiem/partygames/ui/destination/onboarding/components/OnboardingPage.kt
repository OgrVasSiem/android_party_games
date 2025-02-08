package com.ogrvassiem.partygames.ui.destination.onboarding.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.ogrvassiem.partygames.R
import com.ogrvassiem.partygames.ui.components.AutoResizeText
import com.ogrvassiem.partygames.ui.components.FontSizeRange
import com.ogrvassiem.partygames.ui.theme.Theme
import com.ogrvassiem.partygames.ui.utils.verticalGradient

data class OnboardingPage(
    private val photoResId: Int,
    @StringRes private val text1ResId: Int,
    @StringRes private val text2ResId: Int,
    @StringRes private val buttonName: Int,
) {
    companion object {
        val entries = listOf(
            OnboardingPage(
                photoResId = R.drawable.ic_launcher_foreground,
                text1ResId = R.string.onboarding_text_description_1,
                text2ResId = R.string.onboarding_small_text_description_1,
                buttonName = R.string.onboarding_button_text_1,
            ),
            OnboardingPage(
                photoResId = R.drawable.ic_launcher_foreground,
                text1ResId = R.string.onboarding_text_description_2,
                text2ResId = R.string.onboarding_small_text_description_2,
                buttonName = R.string.onboarding_button_text_2,
            ),
            OnboardingPage(
                photoResId = R.drawable.ic_launcher_foreground,
                text1ResId = R.string.onboarding_text_description_3,
                text2ResId = R.string.onboarding_small_text_description_3,
                buttonName = R.string.onboarding_button_text_3,
            ),
        )
    }

    val anim: Int
        @Composable get() = photoResId

    val text1: String
        @Composable get() = stringResource(id = text1ResId)

    val text2: String
        @Composable get() = stringResource(id = text2ResId)

    val text3: String
        @Composable get() = stringResource(id = buttonName)
}

@Composable
fun OnboardingPager(
    pagerState: PagerState
) {
    HorizontalPager(
        state = pagerState,
    ) { pageIndex ->
        PageContent(
            page = OnboardingPage.entries[pageIndex],
            pageIndex = pageIndex,
            pagerState = pagerState
        )
    }
}

@Composable
private fun PageContent(
    modifier: Modifier = Modifier,
    page: OnboardingPage,
    pageIndex: Int,
    pagerState: PagerState
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(page.anim))

    val isCurrentPage = pagerState.currentPage == pageIndex

    val iterations = if (pageIndex == 0) {
        LottieConstants.IterateForever
    } else {
        1
    }

    val progress by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = isCurrentPage,
        iterations = iterations,
        restartOnPlay = true
    )

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .height(400.dp)
        ) {
            LottieAnimation(
                composition = composition,
                progress = { progress },
                enableMergePaths = true,
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(74.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            Theme.gradients.dark1
                        )
                    )
                    .align(Alignment.TopCenter)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(74.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            Theme.gradients.dark2
                        )
                    )
                    .align(Alignment.BottomCenter)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Column(modifier = Modifier.height(140.dp)) {
            Text(
                text = page.text1,
                color = Theme.colors.white,
                style = Theme.textStyles.title1,
                modifier = Modifier.padding(horizontal = 30.dp),
                minLines = 2,
                maxLines = 3,
            )

            Spacer(modifier = Modifier.height(10.dp))

            AutoResizeText(
                text = page.text2,
                color = Theme.colors.textOnboarding,
                style = Theme.textStyles.subtitle1,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(horizontal = 30.dp),
                minLines = 2,
                maxLines = 2,
                fontSizeRange = FontSizeRange(min = 13.sp, max = 17.sp)
            )
        }
    }
}