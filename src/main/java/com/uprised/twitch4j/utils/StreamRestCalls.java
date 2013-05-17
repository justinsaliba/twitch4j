package com.uprised.twitch4j.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.uprised.twitch4j.beans.FeaturedStream;
import com.uprised.twitch4j.beans.Stream;
import com.uprised.twitch4j.beans.TwitchError;
import com.uprised.twitch4j.helpers.JsonHelper;
import com.uprised.twitch4j.helpers.UriHelper;
import com.uprised.twitch4j.utils.exceptions.ChannelNotFoundException;

public class StreamRestCalls extends RestCalls {

	public static Stream getChannelStream(String channel) throws URISyntaxException, ClientProtocolException, IOException, ChannelNotFoundException {
		URI streamURI = UriHelper.getChannelStream(channel);
		String response = getResponse(streamURI);
		
		ObjectMapper mapper = JsonHelper.getMapper();
		
		JsonNode node = mapper.readValue(response, JsonNode.class);
		if (node.has("error")) {
			TwitchError error = mapper.readValue(node, TwitchError.class);
			throw new ChannelNotFoundException(error);
		}
		
		if (node.get("stream").isNull()) {
			return null;
		}
		else {
			Stream stream = mapper.readValue(node, Stream.class);
			return stream;
		}		
	}
	
	public static List<Stream> getStreams(String game) throws ClientProtocolException, IOException, URISyntaxException {
		URI gameStreamsURI = UriHelper.getStreams(game);
		String response = getResponse(gameStreamsURI);
		ObjectMapper mapper = JsonHelper.getMapper();
		
		JsonNode node = mapper.readValue(response, JsonNode.class);
		
		JsonNode streamsNode = node.get("streams");
		List<Stream> streams = mapper.readValue(streamsNode, new TypeReference<List<Stream>>() {});

		return streams;
	}
	
	public static List<Stream> getStreams(String game, int limit, int offset) throws ClientProtocolException, IOException, URISyntaxException {
		URI gameStreamsURI = UriHelper.getStreams(game, limit, offset);
		String response = getResponse(gameStreamsURI);
		ObjectMapper mapper = JsonHelper.getMapper();
		
		JsonNode node = mapper.readValue(response, JsonNode.class);
		
		JsonNode streamsNode = node.get("streams");
		List<Stream> streams = mapper.readValue(streamsNode, new TypeReference<List<Stream>>() {});

		return streams;
	}
	
	public static List<Stream> getStreams(String game, int limit, int offset, String... channels) throws ClientProtocolException, IOException, URISyntaxException {
		URI gameStreamsURI = UriHelper.getStreams(game, limit, offset, channels);
		String response = getResponse(gameStreamsURI);
		ObjectMapper mapper = JsonHelper.getMapper();
		
		JsonNode node = mapper.readValue(response, JsonNode.class);
		
		JsonNode streamsNode = node.get("streams");
		List<Stream> streams = mapper.readValue(streamsNode, new TypeReference<List<Stream>>() {});

		return streams;
	}
	
	public static List<FeaturedStream> getFeaturedStreams() throws URISyntaxException, ClientProtocolException, IOException {
		URI featuredStreamsURI = UriHelper.getFeaturedStreams();
		String response = getResponse(featuredStreamsURI);
		
		ObjectMapper mapper = JsonHelper.getMapper();
		JsonNode node = mapper.readValue(response, JsonNode.class);
		JsonNode streamsNode = node.get("featured");
		
		List<FeaturedStream> streams = mapper.readValue(streamsNode, new TypeReference<List<FeaturedStream>>() {});
		return streams;
	}
	
	public static List<FeaturedStream> getFeaturedStreams(int limit, int offset) throws URISyntaxException, ClientProtocolException, IOException {
		URI featuredStreamsURI = UriHelper.getFeaturedStreams(limit, offset);
		String response = getResponse(featuredStreamsURI);
		
		ObjectMapper mapper = JsonHelper.getMapper();
		JsonNode node = mapper.readValue(response, JsonNode.class);
		JsonNode streamsNode = node.get("featured");
		
		List<FeaturedStream> streams = mapper.readValue(streamsNode, new TypeReference<List<FeaturedStream>>() {});
		return streams;
	}
	
	
	
}
