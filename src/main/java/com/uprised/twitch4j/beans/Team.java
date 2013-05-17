package com.uprised.twitch4j.beans;


public class Team {
	private long ID;
	private String background;
	private String banner;
	private String createdAt;
	private String displayName;
	private String info;
	private String logo;
	private String name;
	private String updatedAt;

	public Number get_id() {
		return this.ID;
	}

	public void set_id(long id) {
		this.ID = id;
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

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUpdated_at() {
		return this.updatedAt;
	}

	public void setUpdated_at(String updated_at) {
		this.updatedAt = updated_at;
	}
}
