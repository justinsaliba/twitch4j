package com.uprised.twitch4j;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;

import junit.framework.TestCase;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import com.uprised.twitch4j.beans.Channel;
import com.uprised.twitch4j.utils.ChannelRestCalls;
import com.uprised.twitch4j.utils.exceptions.ChannelNotFoundException;

public class TestChannelUtils extends TestCase {

	@Test
	public void testGetChannel() throws ClientProtocolException, URISyntaxException, IOException, ChannelNotFoundException {
		Channel channel = ChannelRestCalls.getChannel("athenelive");
		assertNotNull(channel);
	}
	
	@Test
	public void testGetWrongChannel() throws ClientProtocolException, URISyntaxException, IOException {
		String channelName = "anonexistantchannel";
		try {
			Channel channel = ChannelRestCalls.getChannel(channelName);
		} catch (ChannelNotFoundException e) {
			assertTrue(e.getTwitchError() != null);
			assertTrue(e.getTwitchError().getMessage().equals("Channel '"+channelName+"' does not exist"));
			assertTrue(e.getTwitchError().getError().equals("Not Found"));
			assertTrue(e.getTwitchError().getStatus() == 404);
		}
		
	}
		
}
