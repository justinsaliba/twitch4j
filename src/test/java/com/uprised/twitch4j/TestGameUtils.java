package com.uprised.twitch4j;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import com.uprised.twitch4j.beans.Game;
import com.uprised.twitch4j.utils.GameRestCalls;

public class TestGameUtils {
	
	@Test
	public void testTopGames() throws ClientProtocolException, URISyntaxException, IOException {
		List<Game> games = GameRestCalls.getTopGames();		
		assertNotNull(games);
	}
		
}