package com.ogrvassiem.partygames.ui.destination.gameScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ogrvassiem.partygames.aplication.readModels.GameAtributesNavArgs
import com.ogrvassiem.partygames.aplication.readModels.RoundTime
import com.ogrvassiem.partygames.ui.destination.gameScreen.component.Timer
import com.ogrvassiem.partygames.ui.destination.gameScreen.presentation.GameScreenViewModel
import com.ogrvassiem.partygames.ui.navGraphs.RootNavigator
import com.ogrvassiem.partygames.ui.theme.Theme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import kotlin.jvm.Throws

@Destination(navArgsDelegate = GameAtributesNavArgs::class)
@RootNavGraph
@Composable
fun GameScreen(
    rootNavigator: RootNavigator,
    viewModel: GameScreenViewModel = hiltViewModel()
) {
    val timeLeft by viewModel.timeLeft.collectAsState()
    val initialTime by viewModel.initialTime.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.startTimer()
    }
    GameScreenUI(
        timeLeft = timeLeft,
        initialTime = initialTime
    )
}

@Composable
fun GameScreenUI(
    timeLeft: Long,
    initialTime: Long
) {
    Scaffold(
        containerColor = Theme.colors.bg,

        ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Timer(
                timeLeft = timeLeft,
                initialTime = initialTime
            )
        }
    }
}