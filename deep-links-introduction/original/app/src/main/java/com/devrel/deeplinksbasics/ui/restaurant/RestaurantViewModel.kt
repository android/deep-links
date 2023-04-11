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

package com.devrel.deeplinksbasics.ui.restaurant

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devrel.deeplinksbasics.data.Restaurant
import com.devrel.deeplinksbasics.data.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    private val restaurantRepository: RestaurantRepository,
) : ViewModel() {
    // restaurants and selected restaurant could be used as one UIState stream
    // which will scale better when exposing more data.
    // Since there are only these two, it is okay to expose them as separate streams
    val restaurants: List<Restaurant> = restaurantRepository.restaurants

    private val _selectedRestaurant = MutableStateFlow<Restaurant?>(value = null)
    val selectedRestaurant: StateFlow<Restaurant?>
        get() = _selectedRestaurant

    // Method to update the current restaurant selection
    fun updateSelectedRestaurantByName(name: String) {
        viewModelScope.launch {
            val selectedRestaurant: Restaurant? = restaurantRepository.getRestaurantByName(name)
            if (selectedRestaurant != null) {
                _selectedRestaurant.value = selectedRestaurant
            }
        }
    }
}