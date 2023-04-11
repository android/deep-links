/*
 * Copyright 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.devrel.deeplinksbasics.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route: String) {
   object Grid : Screen("restaurants")
   object Name : Screen("restaurants/{name}") {
       fun createRoute(name: String) = "restaurants/$name"
   }
}

@Composable
fun rememberRestaurantAppState(
    navController: NavHostController = rememberNavController(),
) = remember(navController) {
    RestaurantAppState(navController)
}

class RestaurantAppState(
    val navController: NavHostController,
) {
    fun navigateToRestaurant(restaurantName: String) {
        navController.navigate(Screen.Name.createRoute(restaurantName))
    }

    fun navigateBack() {
        navController.popBackStack()
    }
}