package com.uprised.twitch4j;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import com.uprised.twitch4j.beans.FeaturedStream;
import com.uprised.twitch4j.beans.Stream;
import com.uprised.twitch4j.utils.StreamRestCalls;
import com.uprised.twitch4j.utils.exceptions.ChannelNotFoundException;

public class TestStreamUtils {

	/**
	 * Will succeed only if stream is offline
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ChannelNotFoundException 
	 */
	@Test
	public void testGetOfflineStream() throws ClientProtocolException, URISyntaxException, IOException, ChannelNotFoundException {
		Stream stream = StreamRestCalls.getChannelStream("athenelive");
		assertNull(stream);
	}
	
	/**
	 * Will succeed only if stream is online
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ChannelNotFoundException 
	 */
	@Test
	public void testGetOnlineStream() throws ClientProtocolException, URISyntaxException, IOException, ChannelNotFoundException {
		Stream stream = StreamRestCalls.getChannelStream("athenelive");
		assertNotNull(stream);
	}
	
	@Test
	public void testGetWrongStream() throws ClientProtocolException, URISyntaxException, IOException {
		try {
			@SuppressWarnings("unused")
			Stream stream = StreamRestCalls.getChannelStream("blahblahblahblah");
		} catch (ChannelNotFoundException e) {
			assertNotNull(e);
		}
	}
	
	@Test
	public void testGetGameStreams() throws ClientProtocolException, IOException, URISyntaxException {
		List<Stream> streams = StreamRestCalls.getStreams("League of Legends");
		assertNotNull(streams);
	}
	
	@Test
	public void testGetGameStreamsWithLimitOffset() throws ClientProtocolException, IOException, URISyntaxException {
		
		int limit = 10;
		
		List<Stream> firstBatch = StreamRestCalls.getStreams("League of Legends", limit, 0);
		List<Stream> secondBatch = StreamRestCalls.getStreams("League of Legends", limit, limit);
		
		assertTrue(firstBatch.size() == limit);
		assertTrue(secondBatch.size() == limit);
		
		for (Stream first : firstBatch) {
			for (Stream second : secondBatch) {
				assertTrue(!(first.getID() == second.getID()));
			}
		}
	}

	@Test
	public void testGetFeaturedStreams() throws ClientProtocolException, IOException, URISyntaxException {
		List<FeaturedStream> streams = StreamRestCalls.getFeaturedStreams();
		assertNotNull(streams);
	}
	
	@Test
	public void testGetFeaturedStreamsWithLimitOffset() throws ClientProtocolException, IOException, URISyntaxException {
		
		int limit = 10;
		
		List<FeaturedStream> firstBatch = StreamRestCalls.getFeaturedStreams(limit, 0);
		List<FeaturedStream> secondBatch = StreamRestCalls.getFeaturedStreams(limit, limit);
		
		assertTrue(firstBatch.size() == limit);
		assertTrue(secondBatch.size() == limit);
		
		for (FeaturedStream first : firstBatch) {
			for (FeaturedStream second : secondBatch) {
				assertTrue(!(first.getStream().getID() == second.getStream().getID()));
			}
		}
	}
	
}
