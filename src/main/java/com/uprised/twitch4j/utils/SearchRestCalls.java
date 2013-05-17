package com.uprised.twitch4j.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.uprised.twitch4j.beans.Game;
import com.uprised.twitch4j.beans.Stream;
import com.uprised.twitch4j.helpers.JsonHelper;
import com.uprised.twitch4j.helpers.UriHelper;

public class SearchRestCalls extends RestCalls {

	public static List<Stream> findStreams(String query) throws URISyntaxException, ClientProtocolException, IOException {
		URI streamQuery = UriHelper.getStreamSearch(query);
		String response = getResponse(streamQuery);
		
		ObjectMapper mapper = JsonHelper.getMapper();
		
		JsonNode node = mapper.readValue(response, JsonNode.class);
		JsonNode streamsNode = node.get("streams");
		
		List<Stream> streams = mapper.readValue(streamsNode, new TypeReference<List<Stream>>() {});

		return streams;		
	}
	
	public static List<Stream> findStreams(String query, int limit, int offset) throws URISyntaxException, ClientProtocolException, IOException {
		URI streamQuery = UriHelper.getStreamSearch(query, limit, offset);
		String response = getResponse(streamQuery);
		
		ObjectMapper mapper = JsonHelper.getMapper();
		
		JsonNode node = mapper.readValue(response, JsonNode.class);
		JsonNode streamsNode = node.get("streams");
		
		List<Stream> streams = mapper.readValue(streamsNode, new TypeReference<List<Stream>>() {});

		return streams;		
	}
	
	public static List<Game> findGames(String query) throws URISyntaxException, ClientProtocolException, IOException {
		return findGames(query, false);
	}
	
	public static List<Game> findGames(String query, boolean live) throws URISyntaxException, ClientProtocolException, IOException {
		URI gamesQuery = UriHelper.getGameSearch(query, live);
		String response = getResponse(gamesQuery);
		
		ObjectMapper mapper = JsonHelper.getMapper();
		
		JsonNode node = mapper.readValue(response, JsonNode.class);
		JsonNode streamsNode = node.get("games");
		
		List<Game> games = mapper.readValue(streamsNode, new TypeReference<List<Game>>() {});

		return games;		
	}
	
	
}
