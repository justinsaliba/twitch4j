package com.uprised.twitch4j.helpers;

import org.apache.http.impl.client.DefaultHttpClient;

public class HttpHelper {

	private static DefaultHttpClient client = new DefaultHttpClient();
	
	public static DefaultHttpClient getInstance() {
		return client;
	}
	
}
