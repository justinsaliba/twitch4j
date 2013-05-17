package com.uprised.twitch4j.utils;

import java.io.IOException;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.uprised.twitch4j.helpers.HttpHelper;

public class RestCalls {
	
	protected static String getResponse(URI uri) throws ClientProtocolException, IOException {
		DefaultHttpClient client = HttpHelper.getInstance();
		HttpGet get = new HttpGet(uri);
		HttpResponse response = client.execute(get);
		HttpEntity entity = response.getEntity();
		return EntityUtils.toString(entity);
	}

}
