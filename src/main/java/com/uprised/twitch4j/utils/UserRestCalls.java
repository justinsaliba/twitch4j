package com.uprised.twitch4j.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.uprised.twitch4j.beans.TwitchError;
import com.uprised.twitch4j.beans.User;
import com.uprised.twitch4j.helpers.JsonHelper;
import com.uprised.twitch4j.helpers.UriHelper;
import com.uprised.twitch4j.utils.exceptions.TwitchUnauthenticatedException;

public class UserRestCalls extends RestCalls {

	public static User getSelf() throws URISyntaxException, ClientProtocolException, IOException, TwitchUnauthenticatedException {
		URI selfURI = UriHelper.getSelf();
		String response = getResponse(selfURI);
		
		ObjectMapper mapper = JsonHelper.getMapper();
		
		JsonNode node = mapper.readValue(response, JsonNode.class);
		
		if (node.has("error")) {
			TwitchError errorBean = mapper.readValue(node, TwitchError.class);
			throw new TwitchUnauthenticatedException(errorBean);
		}
		
		User user = mapper.readValue(node, User.class);
		return user;
	}
	
	public static User getUser(String username) throws URISyntaxException, IOException {
		URI userURI = UriHelper.getUser(username);
		String response = getResponse(userURI);
		
		ObjectMapper mapper = JsonHelper.getMapper();
		JsonNode node = mapper.readValue(response, JsonNode.class);

		User user = mapper.readValue(node, User.class);
		return user;
	}
	
}
