package com.uprised.twitch4j.helpers;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.utils.URIBuilder;

public class UriHelper {
	
	private static final String API_PATH = "https://api.twitch.tv/kraken";
	
	public static URI getChannelURI(String channel) throws URISyntaxException {
		URIBuilder builder = new URIBuilder(API_PATH + "/channels/" + channel);
		return builder.build();
	}

	public static URI getTopGames() throws URISyntaxException { 
		URIBuilder builder = new URIBuilder(API_PATH + "/games/top");
		return builder.build();
	}

	public static URI getTopGames(int offset) throws URISyntaxException { 
		URIBuilder builder = new URIBuilder(API_PATH + "/games/top");
		builder.addParameter("offset", offset + "");
		return builder.build();
	}
	
	public static URI getTopGames(int offset, int limit) throws URISyntaxException { 
		URIBuilder builder = new URIBuilder(API_PATH + "/games/top");
		builder.addParameter("offset", offset + "");
		builder.addParameter("limit", limit + "");
		return builder.build();
	}
	
	public static URI getTeam(String name) throws URISyntaxException {
		URIBuilder builder = new URIBuilder(API_PATH + "/teams/"+name);
		return builder.build();
	}
	
	public static URI getTeams() throws URISyntaxException {
		URIBuilder builder = new URIBuilder(API_PATH + "/teams");
		return builder.build();
	}
	
	public static URI getUser(String username) throws URISyntaxException {
		URIBuilder builder = new URIBuilder(API_PATH + "/users/"+username);
		return builder.build();
	}
	
	public static URI getSelf() throws URISyntaxException {
		URIBuilder builder = new URIBuilder(API_PATH + "/user");
		return builder.build();
	}
	
	public static URI getChannelStream(String channel) throws URISyntaxException {
		URIBuilder builder = new URIBuilder(API_PATH + "/streams/"+channel);
		return builder.build();
	}
	
	public static URI getStreams() throws URISyntaxException {
		URIBuilder builder = new URIBuilder(API_PATH + "/streams");
		return builder.build();
	}
	
	public static URI getStreams(String game) throws URISyntaxException {
		URIBuilder builder = new URIBuilder(API_PATH + "/streams");
		builder.addParameter("game", game);
		return builder.build();
	}
	
	public static URI getStreams(String... channels) throws URISyntaxException {
		URIBuilder builder = new URIBuilder(API_PATH + "/streams");
		String channelsString = StringUtils.join(channels, ',');
		builder.addParameter("channel", channelsString);
		return builder.build();
	}
	
	public static URI getStreams(String game, String... channels) throws URISyntaxException {
		URIBuilder builder = new URIBuilder(API_PATH + "/streams");
		builder.addParameter("game", game);
		String channelsString = StringUtils.join(channels, ',');
		builder.addParameter("channel", channelsString);
		return builder.build();
	}
	
	public static URI getStreams(String game, int limit, int offset) throws URISyntaxException {
		URIBuilder builder = new URIBuilder(API_PATH + "/streams");
		builder.addParameter("game", game);
		builder.addParameter("limit", limit + "");
		builder.addParameter("offset", offset + "");
		return builder.build();
	}
	
	public static URI getStreams(String game, int limit, int offset, String... channels) throws URISyntaxException {
		URIBuilder builder = new URIBuilder(API_PATH + "/streams");
		builder.addParameter("game", game);
		String channelsString = StringUtils.join(channels, ',');
		builder.addParameter("channel", channelsString);
		builder.addParameter("limit", limit + "");
		builder.addParameter("offset", offset + "");
		return builder.build();
	}
	
	public static URI getFeaturedStreams() throws URISyntaxException {
		URIBuilder builder = new URIBuilder(API_PATH + "/streams/featured");
		return builder.build();
	}
	
	public static URI getFeaturedStreams(int limit, int offset) throws URISyntaxException {
		URIBuilder builder = new URIBuilder(API_PATH + "/streams/featured");
		builder.addParameter("limit", limit + "");
		builder.addParameter("offset", offset + "");
		return builder.build();
	}
	
	public static URI getStreamsSummary() throws URISyntaxException {
		URIBuilder builder = new URIBuilder(API_PATH + "/streams/summary");
		return builder.build();
	}
	
	public static URI getStreamsSummary(int limit, int offset) throws URISyntaxException {
		URIBuilder builder = new URIBuilder(API_PATH + "/streams/summary");
		builder.addParameter("limit", limit + "");
		builder.addParameter("offset", offset + "");
		return builder.build();
	}
	
	public static URI getFollowedStreams() throws URISyntaxException {
		URIBuilder builder = new URIBuilder(API_PATH + "/streams/followed");
		return builder.build();
	}
	
	public static URI getStreamSearch(String query) throws URISyntaxException {
		URIBuilder builder = new URIBuilder(API_PATH + "/search/streams");
		builder.addParameter("query", query);
		return builder.build();
	}	
	
	public static URI getStreamSearch(String query, int limit, int offset) throws URISyntaxException {
		URIBuilder builder = new URIBuilder(API_PATH + "/search/streams");
		builder.addParameter("query", query);
		builder.addParameter("limit", limit + "");
		builder.addParameter("offset", offset + "");
		return builder.build();
	}
	
	/**
	 * Returns all games.
	 * @param query
	 * @return
	 * @throws URISyntaxException
	 */
	public static URI getGameSearch(String query) throws URISyntaxException {
		return getGameSearch(query, false);
	}
	
	/**
	 * Return only games which are live on at least one channel.
	 * @param query
	 * @param live
	 * @return
	 * @throws URISyntaxException
	 */
	public static URI getGameSearch(String query, boolean live) throws URISyntaxException {
		URIBuilder builder = new URIBuilder(API_PATH + "/search/games");
		builder.addParameter("query", query);
		builder.addParameter("live", Boolean.toString(live));
		builder.addParameter("type", "suggest");
		return builder.build();
	}
	
	public static URI getChannelVideos(String channel) throws URISyntaxException {
		URIBuilder builder = new URIBuilder(API_PATH + "/channels/"+channel+"/videos");
		return builder.build();
	}
	
	public static URI getChannelVideos(String channel, int limit, int offset) throws URISyntaxException {
		URIBuilder builder = new URIBuilder(API_PATH + "/channels/"+channel+"/videos");
		builder.addParameter("limit", limit + "");
		builder.addParameter("offset", offset + "");
		return builder.build();
	}
	
	public static URI getVideo(String id) throws URISyntaxException {
		URIBuilder builder = new URIBuilder(API_PATH + "/videos/"+id);
		return builder.build();
	}
	
}
