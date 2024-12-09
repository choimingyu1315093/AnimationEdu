package com.example.navigationedu.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigationedu.screens.detail.DetailScreen
import com.example.navigationedu.screens.home.HomeScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BookNavigation(){
    val navController = rememberAnimatedNavController()
    AnimatedNavHost (
        navController = navController,
        startDestination = BookScreens.HOMESCREEN.name,

        //수평
//        enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
//        exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) },
//        popEnterTransition = { slideInHorizontally(initialOffsetX = { -it }) },
//        popExitTransition = { slideOutHorizontally(targetOffsetX = { it }) }

        //수직
//        enterTransition = {
//            slideInVertically(initialOffsetY = { it }) + fadeIn(animationSpec = tween(500)) // 아래에서 위로 슬라이드 + 페이드 인
//        },
//        exitTransition = {
//            slideOutVertically(targetOffsetY = { -it }) + fadeOut(animationSpec = tween(500)) // 위에서 사라짐 + 페이드 아웃
//        },
//        popEnterTransition = {
//            slideInVertically(initialOffsetY = { -it }) + fadeIn(animationSpec = tween(500)) // 위에서 아래로 슬라이드 + 페이드 인
//        },
//        popExitTransition = {
//            slideOutVertically(targetOffsetY = { it }) + fadeOut(animationSpec = tween(500)) // 아래로 사라짐 + 페이드 아웃
//        }

        //확장, 축소
        enterTransition = { scaleIn(initialScale = 0.8f) },
        exitTransition = { scaleOut(targetScale = 0.8f) },
        popEnterTransition = { scaleIn(initialScale = 0.8f) },
        popExitTransition = { scaleOut(targetScale = 0.8f) }
    ) {
        composable(route = BookScreens.HOMESCREEN.name){
            HomeScreen(navController = navController)
        }

        composable(
            route = BookScreens.DETAILSCREEN.name+"/{book}",
            arguments = listOf(navArgument("book"){type = NavType.StringType})
        ){
            DetailScreen(navController = navController, it.arguments?.getString("book"))
        }
    }
}