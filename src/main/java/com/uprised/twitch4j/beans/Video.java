package com.uprised.twitch4j.beans;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonProperty;

public class Video {
	
	@JsonProperty("recorded_at")
	private String recordedAt;
	@JsonProperty("title")
	private String title;
	@JsonProperty("url")
	private String url;
	@JsonProperty("_id")
	private String ID;
	@JsonProperty("embed")
	private String embedCode;
	@JsonProperty("description")
	private String description;
	@JsonProperty("views")
	private int views;
	@JsonProperty("length")
	private int length;
	@JsonProperty("game")
	private String game;
	@JsonProperty("preview")
	private String preview;
	@JsonProperty("channel")
	private Channel channel;
	
	public boolean hasEmbedCode() {
		return StringUtils.isBlank(embedCode);
	}
		
	/**
	 * @return the recordedAt
	 */
	public String getRecordedAt() {
		return recordedAt;
	}
	/**
	 * @param recordedAt the recordedAt to set
	 */
	public void setRecordedAt(String recordedAt) {
		this.recordedAt = recordedAt;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the embedCode
	 */
	public String getEmbedCode() {
		return embedCode;
	}
	/**
	 * @param embedCode the embedCode to set
	 */
	public void setEmbedCode(String embedCode) {
		this.embedCode = embedCode;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the views
	 */
	public int getViews() {
		return views;
	}
	/**
	 * @param views the views to set
	 */
	public void setViews(int views) {
		this.views = views;
	}
	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
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
	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}
	/**
	 * @return the game
	 */
	public String getGame() {
		return game;
	}
	/**
	 * @param game the game to set
	 */
	public void setGame(String game) {
		this.game = game;
	}
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
	
	

}
