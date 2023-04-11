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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.devrel.deeplinksbasics.ui.restaurant.RestaurantViewModel

/**
 *  This is the main composable app. It handles the general app logic such as navigation,
 *  state management and UI logic
 *
 *  @property viewModel Handles the data layer, such as the restaurants to be displayed
 *  @property appState UI state holder class for the Restaurant Composable. This will handle
 *  UI navigation state.
 */
@Composable
fun RestaurantApp(
    viewModel: RestaurantViewModel = viewModel(),
    appState: RestaurantAppState = rememberRestaurantAppState(),
) {
    val selectedRestaurant by viewModel.selectedRestaurant.collectAsStateWithLifecycle()
    val onRestaurantSelected: (String) -> Unit = { viewModel.updateSelectedRestaurantByName(it) }

    NavHost(
        navController = appState.navController,
        startDestination = Screen.Grid.route,
    ) {

        // Default route that points to the restaurant grid
        composable(Screen.Grid.route) {
            RestaurantGrid(
                restaurants = viewModel.restaurants,
                onRestaurantSelected = onRestaurantSelected,
                navigateToRestaurant = { restaurantName ->
                    appState.navigateToRestaurant(restaurantName)
                },
            )
        }

        //  Route for the navigation to a particular restaurant when a user clicks on it
        // TODO: update for Android App Link Route
        composable(Screen.Name.route) {
            RestaurantCardDetails(restaurant = selectedRestaurant!!, onBack = appState::navigateBack)
        }
    }
}