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

import com.devrel.deeplinksbasics.R
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RestaurantLocalDataSource @Inject constructor() {
    val restaurantList = listOf(
        Restaurant(
            id = 1,
            name = "Pawtato",
            address = "3140 Skinner Hollow Road, Medford, Oregon 97501",
            type = "Potato and gnochi",
            // TODO: Update with your own domain
            website = "https://your.own.domain/restaurants/pawtato/",
            drawable = R.drawable.restaurant1,
        ),
        Restaurant(
            id = 2,
            name = "Rawrbucha",
            address = "2064 Carriage Lane, Mansfield, Ohio 44907",
            type = "Kombucha",
            // TODO: Update with your own domain
            website = "https://your.own.domain/restaurants/rawrbucha/",
            drawable = R.drawable.restaurant2,
        ),
        Restaurant(
            id = 3,
            name = "Pizzabus",
            address = "1447 Davis Avenue, Petaluma, California 94952",
            type = "Pizza",
            // TODO: Update with your own domain
            website = "https://your.own.domain/restaurants/pizzabus/",
            drawable = R.drawable.restaurant3,
        ),
        Restaurant(
            id = 4,
            name = "Keybabs",
            address = "3708 Pinnickinnick Street, Perth Amboy, New Jersey 08861",
            type = "Kebabs",
            // TODO: Update with your own domain
            website = "https://your.own.domain/restaurants/keybabs/",
            drawable = R.drawable.restaurant4,
        ),
        Restaurant(
            id = 5,
            name = "BBQ",
            address = "998 Newton Street, Saint Cloud, Minnesota 56301",
            type = "BBQ",
            // TODO: Update with your own domain
            website = "https://your.own.domain/restaurants/bbq/",
            drawable = R.drawable.restaurant5,
        ),
        Restaurant(
            id = 6,
            name = "Salades",
            address = "4522 Rockford Mountain Lane, Oshkosh, Wisconsin 54901",
            type = "salads",
            // TODO: Update with your own domain
            website = "https://your.own.domain/restaurants/salades/",
            drawable = R.drawable.restaurant6,
        ),
        Restaurant(
            id = 7,
            name = "Gyros and moar",
            address = "1993 Bird Spring Lane, Houston, Texas 77077",
            type = "Gyro",
            // TODO: Update with your own domain
            website = "https://your.own.domain/restaurants/gyrosAndMoar/",
            drawable = R.drawable.restaurant7,
        ),
        Restaurant(
            id = 8,
            name = "Peruvian ceviche",
            address = "2125 Deer Ridge Drive, Newark, New Jersey 07102",
            type = "seafood",
            // TODO: Update with your own domain
            website = "https://your.own.domain/restaurants/peruvianCeviche/",
            drawable = R.drawable.restaurant8,
        ),
        Restaurant(
            id = 9,
            name = "Vegan burgers",
            address = "594 Warner Street, Casper, Wyoming 82601",
            type = "vegan",
            // TODO: Update with your own domain
            website = "https://your.own.domain/restaurants/veganBurgers/",
            drawable = R.drawable.restaurant9,
        ),
        Restaurant(
            id = 10,
            name = "Taquitos",
            address = "1654 Hart Country Lane, Blue Ridge, Georgia 30513",
            type = "mexican",
            // TODO: Update with your own domain
            website = "https://your.own.domain/restaurants/taquitos/",
            drawable = R.drawable.restaurant10,
        ),
    )
}