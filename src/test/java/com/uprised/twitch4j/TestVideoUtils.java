package com.uprised.twitch4j;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import com.uprised.twitch4j.beans.Video;
import com.uprised.twitch4j.utils.VideoRestCalls;
import com.uprised.twitch4j.utils.exceptions.VideoNotFoundException;

public class TestVideoUtils {
	
	@Test
	public void testGetVideo() throws ClientProtocolException, VideoNotFoundException, URISyntaxException, IOException {
		List<Video> videos = VideoRestCalls.getChannelVideos("athenelive");
		assertNotNull(videos);
	}

}
