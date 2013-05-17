package com.uprised.twitch4j.utils.exceptions;

import com.uprised.twitch4j.beans.TwitchError;

public class TeamNotFoundException extends TwitchException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -911452160486430759L;
	
	public TeamNotFoundException(TwitchError error) {
		super (error);
	}
	
}
