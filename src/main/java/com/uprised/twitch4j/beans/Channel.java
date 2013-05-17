package com.uprised.twitch4j.beans;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Channel {
	private long ID;
	private String background;
	private String banner;
	private String createdAt;
	private String displayName;
	private String game;
	private String logo;
	private String mature;
	private String name;
	private String status;
	private List<Team> teams;
	private String updatedAt;
	private String url;
	private String videoBanner;

	public long get_id() {
		return this.ID;
	}

	public void set_id(long ID) {
		this.ID = ID;
	}

	public String getBackground() {
		return this.background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getBanner() {
		return this.banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getCreated_at() {
		return this.createdAt;
	}

	public void setCreated_at(String created_at) {
		this.createdAt = created_at;
	}

	public String getDisplay_name() {
		return this.displayName;
	}

	public void setDisplay_name(String display_name) {
		this.displayName = display_name;
	}

	public String getGame() {
		return this.game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getMature() {
		return this.mature;
	}

	public void setMature(String mature) {
		this.mature = mature;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Team> getTeams() {
		return this.teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public String getUpdated_at() {
		return this.updatedAt;
	}

	public void setUpdated_at(String updated_at) {
		this.updatedAt = updated_at;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVideo_banner() {
		return this.videoBanner;
	}

	public void setVideo_banner(String video_banner) {
		this.videoBanner = video_banner;
	}
}
