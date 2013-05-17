package com.uprised.twitch4j.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import com.uprised.twitch4j.beans.Channel;
import com.uprised.twitch4j.beans.TwitchError;
import com.uprised.twitch4j.helpers.JsonHelper;
import com.uprised.twitch4j.helpers.UriHelper;
import com.uprised.twitch4j.utils.exceptions.ChannelNotFoundException;

public class ChannelRestCalls extends RestCalls {

	public static Channel getChannel(String channelName) throws URISyntaxException, ClientProtocolException, IOException, ChannelNotFoundException {
		
		URI channelURI = UriHelper.getChannelURI(channelName);
		String response = getResponse(channelURI);
				
		ObjectMapper mapper = JsonHelper.getMapper();
		JsonNode node = mapper.readValue(response, JsonNode.class);
		
		if (node.has("error")) {
			TwitchError errorBean = mapper.readValue(node, TwitchError.class);
			throw new ChannelNotFoundException(errorBean);
		}
		
		Channel channel = mapper.readValue(response, Channel.class);
		
		return channel;		
	}
		
}
