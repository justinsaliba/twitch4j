package com.uprised.twitch4j.utils.exceptions;

import com.uprised.twitch4j.beans.TwitchError;

public class VideoNotFoundException extends TwitchException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2263639492677274015L;

	public VideoNotFoundException(TwitchError error) {
		super(error);
	}
	
}
