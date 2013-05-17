package com.uprised.twitch4j.beans;

import org.codehaus.jackson.annotate.JsonProperty;

public class Stream {
	@JsonProperty("channel")
	private Channel channel;
	@JsonProperty("broadcaster")
	private String broadcaster;
	@JsonProperty("_id")
	private long ID;
	@JsonProperty("viewers")
	private int viewers;
	@JsonProperty("preview")
	private String preview;
	
	/**
	 * @return the channel
	 */
	public Channel getChannel() {
		return channel;
	}
	/**
	 * @param channel the channel to set
	 */
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	/**
	 * @return the broadcaster
	 */
	public String getBroadcaster() {
		return broadcaster;
	}
	/**
	 * @param broadcaster the broadcaster to set
	 */
	public void setBroadcaster(String broadcaster) {
		this.broadcaster = broadcaster;
	}
	/**
	 * @return the iD
	 */
	public long getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(long iD) {
		ID = iD;
	}
	/**
	 * @return the viewers
	 */
	public int getViewers() {
		return viewers;
	}
	/**
	 * @param viewers the viewers to set
	 */
	public void setViewers(int viewers) {
		this.viewers = viewers;
	}
	/**
	 * @return the preview
	 */
	public String getPreview() {
		return preview;
	}
	/**
	 * @param preview the preview to set
	 */
	public void setPreview(String preview) {
		this.preview = preview;
	}

}
