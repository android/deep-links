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

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.devrel.deeplinksbasics.data.Restaurant

@Composable
fun RestaurantCardDetails (
    restaurant: Restaurant,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler() {
       onBack()
    }
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Transparent,
                elevation = 0.dp,
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = modifier.padding(start = 8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Arrow Back",
                        modifier = modifier.clickable {
                            onBack()
                        }
                    )
                    Spacer(modifier = modifier.width(8.dp))
                    Text(text = restaurant.name)
                }
            }
        }
    ) { paddingValues ->
        Card(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxWidth(),
            elevation = 2.dp,
            shape = RoundedCornerShape(corner = CornerSize(8.dp))
        ) {
            Column(
                modifier = modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(text = restaurant.name, style = MaterialTheme.typography.h6)
                Text(text = restaurant.type, style = MaterialTheme.typography.caption)
                Text(text = restaurant.address, style = MaterialTheme.typography.caption)
                SelectionContainer {
                    Text(text = restaurant.website, style = MaterialTheme.typography.caption)
                }
                Image(painter = painterResource(id = restaurant.drawable), contentDescription = "${restaurant.name}")
            }
        }
    }
}