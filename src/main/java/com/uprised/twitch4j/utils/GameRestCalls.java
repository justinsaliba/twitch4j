package com.uprised.twitch4j.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import com.uprised.twitch4j.beans.Game;
import com.uprised.twitch4j.helpers.JsonHelper;
import com.uprised.twitch4j.helpers.UriHelper;

public class GameRestCalls extends RestCalls {

	public static List<Game> getTopGames() throws URISyntaxException, ClientProtocolException, IOException {
		
		URI gameListURI = UriHelper.getTopGames();
		String response = RestCalls.getResponse(gameListURI);
		
		ObjectMapper mapper = JsonHelper.getMapper();
		
		JsonNode node = mapper.readValue(response, JsonNode.class);
		JsonNode topNode = node.get("top");
		
		List<Game> games = new ArrayList<Game>();
		
		for (JsonNode n : topNode) {
			Game game = Game.fromJson(n.toString());
			games.add(game);
		}
		return games;
	}
	
}
