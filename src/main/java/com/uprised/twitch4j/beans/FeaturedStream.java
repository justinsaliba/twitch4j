package com.uprised.twitch4j.beans;

import org.codehaus.jackson.annotate.JsonProperty;

public class FeaturedStream {

	@JsonProperty("image")
	private String image;
	@JsonProperty("text")
	private String text;
	@JsonProperty("stream")
	private Stream stream;
	
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @param stream the stream to set
	 */
	public void setStream(Stream stream) {
		this.stream = stream;
	}
	/**
	 * @return the stream
	 */
	public Stream getStream() {
		return stream;
	}
	
	
	
}
