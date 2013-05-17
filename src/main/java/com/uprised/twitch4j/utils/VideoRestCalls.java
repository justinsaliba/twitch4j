package com.uprised.twitch4j.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.uprised.twitch4j.beans.TwitchError;
import com.uprised.twitch4j.beans.Video;
import com.uprised.twitch4j.helpers.JsonHelper;
import com.uprised.twitch4j.helpers.UriHelper;
import com.uprised.twitch4j.utils.exceptions.VideoNotFoundException;

public class VideoRestCalls extends RestCalls {

	public static Video getVideo(String id) throws URISyntaxException, ClientProtocolException, IOException, VideoNotFoundException {
		URI videoURI = UriHelper.getVideo(id);
		String response = getResponse(videoURI);
		ObjectMapper mapper = JsonHelper.getMapper();
		
		JsonNode node = mapper.readValue(response, JsonNode.class);
		if (node.has("error")) {
			TwitchError error = mapper.readValue(node, TwitchError.class);
			throw new VideoNotFoundException(error);
		}
		
		Video video = mapper.readValue(node, Video.class);
		return video;		
	}
	
	public static List<Video> getChannelVideos(String channel) throws URISyntaxException, ClientProtocolException, IOException, VideoNotFoundException {
		URI videosURI = UriHelper.getChannelVideos(channel);
		String response = getResponse(videosURI);
		ObjectMapper mapper = JsonHelper.getMapper();
		
		JsonNode node = mapper.readValue(response, JsonNode.class);
		if (node.has("error")) {
			TwitchError error = mapper.readValue(node, TwitchError.class);
			throw new VideoNotFoundException(error);
		}
		
		JsonNode videosNode = node.get("videos");
		System.out.println(videosNode.toString());
		List<Video> videos = mapper.readValue(videosNode, new TypeReference<List<Video>>() {});
		return videos;	
	}

	public static List<Video> getChannelVideos(String channel, int limit, int offset) 
							throws URISyntaxException, ClientProtocolException, IOException, VideoNotFoundException {
		URI videosURI = UriHelper.getChannelVideos(channel, limit, offset);
		String response = getResponse(videosURI);
		ObjectMapper mapper = JsonHelper.getMapper();
		
		JsonNode node = mapper.readValue(response, JsonNode.class);
		if (node.has("error")) {
			TwitchError error = mapper.readValue(node, TwitchError.class);
			throw new VideoNotFoundException(error);
		}
		
		JsonNode videosNode = node.get("videos");
		List<Video> videos = mapper.readValue(videosNode, new TypeReference<List<Video>>() {});
		return videos;	
	}
}
