package com.ogrvassiem.partygames.ui.navGraphs

import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.annotation.RootNavGraph

@NavGraph
@RootNavGraph(start = true)
annotation class MainSectionNavGraph(val start: Boolean = false)