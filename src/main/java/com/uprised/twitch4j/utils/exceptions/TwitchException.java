package com.uprised.twitch4j.utils.exceptions;

import com.uprised.twitch4j.beans.TwitchError;

public class TwitchException extends Exception {
	
	private TwitchError twitchError;
	
	public TwitchException(TwitchError error) {
		super(error.getMessage());
		this.twitchError = error;
	}

	/**
	 * @return the twitchError
	 */
	public TwitchError getTwitchError() {
		return twitchError;
	}

	/**
	 * @param twitchError the twitchError to set
	 */
	public void setTwitchError(TwitchError twitchError) {
		this.twitchError = twitchError;
	}
	
	
}
