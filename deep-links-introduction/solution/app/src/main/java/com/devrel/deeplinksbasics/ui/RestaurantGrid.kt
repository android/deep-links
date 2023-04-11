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

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devrel.deeplinksbasics.data.Restaurant

@Composable
fun RestaurantGrid(
    restaurants: List<Restaurant>,
    onRestaurantSelected: (String) -> Unit,
    navigateToRestaurant: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(topBar = {
        TopAppBar( 
            backgroundColor = Color.Transparent,
            elevation = 0.dp,
        ) {
            Text(text = "Restaurants", fontWeight = FontWeight.Bold)
        }
    }) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 200.dp),
            modifier = modifier.padding(paddingValues)
        ) {
            items(items = restaurants) { restaurant ->
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .clickable(onClick = {
                            onRestaurantSelected(restaurant.name)
                            navigateToRestaurant(restaurant.name)
                        })
                ) {
                    RestaurantCell(restaurant)
                }
            }
        }
    }
}