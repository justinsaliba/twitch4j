package com.uprised.twitch4j.utils.exceptions;

import com.uprised.twitch4j.beans.TwitchError;

public class ChannelNotFoundException extends TwitchException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2259380273574330530L;

	public ChannelNotFoundException(TwitchError error) {
		super(error);
	}
	
}
