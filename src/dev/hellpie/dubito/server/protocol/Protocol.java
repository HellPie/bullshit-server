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

import dev.hellpie.dubito.server.protocol.packets.BinaryPacket;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class Protocol {

	public static final String JSON_KEY_PACKET_TYPE = "packet_type";

	private final static HashMap<PacketType, Class<? extends BinaryPacket>> protocol = new HashMap<>();

	// TODO: Setup static{} block and registerDecoder() in it for each PacketType

	Protocol() {
	} // Disallow instantiation

	private static void registerDecoder(PacketType type, Class<? extends BinaryPacket> decoder) {
		if(protocol.containsKey(type)) return;

		try {
			decoder.getConstructor(byte[].class);
		} catch(NoSuchMethodException e) {
			return;
		}

		protocol.put(type, decoder);
	}

	public static BinaryPacket decode(String data) {
		if(data == null) return null;


		// TODO: Find packet and .getDeclaredConstructor(byte[].class).newInstance((Object) data) on it

		JSONObject jsonObject = new JSONObject(data);
		try {
			String key = jsonObject.getString(JSON_KEY_PACKET_TYPE);

			Class<? extends BinaryPacket> decoder = protocol.get(PacketType.valueOf(key));
			BinaryPacket binaryPacket = decoder.getDeclaredConstructor(String.class).newInstance(data);
			binaryPacket.decode();

			return binaryPacket;
		} catch(JSONException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException ignored) {
		}

		return null;
	}

}
