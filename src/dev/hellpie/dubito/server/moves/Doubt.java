/*
 * Copyright 2016 Mattia Bonazza and Diego Rossi (@_HellPie)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.hellpie.dubito.server.moves;

import dev.hellpie.dubito.server.types.Card;
import dev.hellpie.dubito.server.types.CardNumber;
import dev.hellpie.dubito.server.types.Player;

import java.util.ArrayList;

public class Doubt implements IMove {
	@Override
	public boolean onChosen(ArrayList<Card> cardsOnTable, Player player, CardNumber numberOnTable) {
		return false;
	}
}
