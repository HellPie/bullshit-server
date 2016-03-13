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

package dev.hellpie.dubito.server.protocol;

// NOTICE: Enum PacketType is not finished, contains unplanned values and is subject to major changes
public enum PacketType {
	CLIENT_CONNECT("client_connect"),
	CLIENT_HANDSHAKE("client_handshake"),
	CLIENT_DISCONNECT("client_disconnect"),
	GAME_BEGIN("game_begin"),
	GAME_MOVE("game_move"),
	GAME_END("game_end"),
	SHOW_MESSAGE("show_message");

	private final String jsonBind;

	PacketType(String jsonBind) {
		if(jsonBind == null || jsonBind.isEmpty()) {
			throw new RuntimeException("String \"" + String.valueOf(jsonBind) + "\" is not a valid value.");
		}

		this.jsonBind = jsonBind;
	}

	private String getJSONBind() {
		return jsonBind;
	}
}
