package com.uprised.twitch4j;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import com.uprised.twitch4j.beans.Team;
import com.uprised.twitch4j.utils.TeamRestCalls;
import com.uprised.twitch4j.utils.exceptions.TeamNotFoundException;

public class TestTeamUtils {

	@Test
	public void testGetTeams() throws ClientProtocolException, IOException, URISyntaxException {
		List<Team> teams = TeamRestCalls.getTeams();
		assertNotNull(teams);
	}

	@Test
	public void testGetTeam() throws ClientProtocolException, IOException, URISyntaxException, TeamNotFoundException {
		Team team = TeamRestCalls.getTeam("testteam");
		assertNotNull(team);
	}
	
	@Test
	public void testGetWrongTeam() throws ClientProtocolException, URISyntaxException, IOException {
		try {
			Team team = TeamRestCalls.getTeam("thisisdefinitelyincorrect");
			assertNotNull(team);
		} catch (TeamNotFoundException e) {
			assertTrue(e.getTwitchError() != null);
			assertTrue(e.getTwitchError().getMessage().equals("Team does not exist"));
			assertTrue(e.getTwitchError().getError().equals("Not Found"));
			assertTrue(e.getTwitchError().getStatus() == 404);
		}
	}
	
}
