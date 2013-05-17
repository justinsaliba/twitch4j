package com.uprised.twitch4j.utils.exceptions;

import com.uprised.twitch4j.beans.TwitchError;

public class TwitchUnauthenticatedException extends TwitchException {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 20650145691085110L;

	public TwitchUnauthenticatedException(TwitchError error) {
		super(error);
	}
	
}
