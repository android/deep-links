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

package com.devrel.deeplinksbasics.data

import javax.inject.Inject

class RestaurantRepository @Inject constructor(
    private val restaurantLocalDataSource: RestaurantLocalDataSource
){
    val restaurants: List<Restaurant> = restaurantLocalDataSource.restaurantList

    // Method to obtain a restaurant object by its name
    fun getRestaurantByName(name: String): Restaurant ? {
        return restaurantLocalDataSource.restaurantList.find {
            val processedName = it.name.filterNot { it.isWhitespace() }.lowercase()
            val nameToTest = name.filterNot { it.isWhitespace() }.lowercase()
            nameToTest == processedName
        }
    }
}