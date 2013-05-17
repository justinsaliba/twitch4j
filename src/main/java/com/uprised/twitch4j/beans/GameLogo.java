package com.uprised.twitch4j.beans;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GameLogo {
	@JsonProperty("small")
	private String smallURL;
	@JsonProperty("medium")
	private String mediumURL;
	@JsonProperty("large")
	private String largeURL;
	@JsonProperty("template")
	private String templateURL;
	
	public GameLogo() {}
	
	/**
	 * @return the smallURL
	 */
	public String getSmallURL() {
		return smallURL;
	}
	/**
	 * @param smallURL the smallURL to set
	 */
	public void setSmallURL(String smallURL) {
		this.smallURL = smallURL;
	}
	/**
	 * @return the mediumURL
	 */
	public String getMediumURL() {
		return mediumURL;
	}
	/**
	 * @param mediumURL the mediumURL to set
	 */
	public void setMediumURL(String mediumURL) {
		this.mediumURL = mediumURL;
	}
	/**
	 * @return the largeURL
	 */
	public String getLargeURL() {
		return largeURL;
	}
	/**
	 * @param largeURL the largeURL to set
	 */
	public void setLargeURL(String largeURL) {
		this.largeURL = largeURL;
	}
	/**
	 * @return the templateURL
	 */
	public String getTemplateURL() {
		return templateURL;
	}
	/**
	 * @param templateURL the templateURL to set
	 */
	public void setTemplateURL(String templateURL) {
		this.templateURL = templateURL;
	}
}
