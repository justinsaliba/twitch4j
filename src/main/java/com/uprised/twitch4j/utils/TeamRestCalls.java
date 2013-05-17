package com.uprised.twitch4j.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.uprised.twitch4j.beans.Team;
import com.uprised.twitch4j.beans.TwitchError;
import com.uprised.twitch4j.helpers.JsonHelper;
import com.uprised.twitch4j.helpers.UriHelper;
import com.uprised.twitch4j.utils.exceptions.TeamNotFoundException;

public class TeamRestCalls extends RestCalls {

	public static List<Team> getTeams() throws ClientProtocolException, IOException, URISyntaxException {

		URI teamsURI = UriHelper.getTeams();
		String response = getResponse(teamsURI);
				
		ObjectMapper mapper = JsonHelper.getMapper();
		JsonNode node = mapper.readValue(response, JsonNode.class);
		
		List<Team> teams = mapper.readValue(node.get("teams"), new TypeReference<List<Team>>() {});
		return teams;
	}
	
	public static Team getTeam(String teamName) throws URISyntaxException, ClientProtocolException, IOException, TeamNotFoundException {
		URI teamURI = UriHelper.getTeam(teamName);
		String response = getResponse(teamURI);
		ObjectMapper mapper = JsonHelper.getMapper();
		JsonNode node = mapper.readValue(response, JsonNode.class);
		
		if (node.has("error")) {
			TwitchError errorBean = mapper.readValue(node, TwitchError.class);
			throw new TeamNotFoundException(errorBean);
		}
		
		Team team = mapper.readValue(node, Team.class);
		return team;
	}
	
}
