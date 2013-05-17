
package com.uprised.twitch4j.beans;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.uprised.twitch4j.helpers.JsonHelper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Game {

	private String name;
   	private int viewers;
   	private int channels;
   	@JsonProperty("_id")
   	private long ID;
   	@JsonProperty("giantbomb_id")
   	private long giantbombID;
   	
   	@JsonProperty("logo")
   	private GameLogo gameLogo;
   	@JsonProperty("box")
   	private GameBoxArt gameBoxArt;
  	
//   	public Game(GameBoxArt gameBoxArt, GameLogo logo) {
//   		this.gameBoxArt = gameBoxArt;
//   		this.gameLogo = logo;
//   	}
//   	
//   	public Game() {}
 	
	/**
	 * @param totalViewers the totalViewers to set
	 */
	public void setViewers(int viewers) {
		this.viewers = viewers;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the giantbombID
	 */
	public long getGiantbombID() {
		return giantbombID;
	}

	/**
	 * @param giantbombID the giantbombID to set
	 */
	public void setGiantbombID(long giantbombID) {
		this.giantbombID = giantbombID;
	}

	/**
	 * @return the channels
	 */
	public int getChannels() {
		return channels;
	}

	/**
	 * @param channels the channels to set
	 */
	public void setChannels(int channels) {
		this.channels = channels;
	}

	/**
	 * @return the viewers
	 */
	public int getViewers() {
		return viewers;
	}

	/**
	 * @return the gameLogo
	 */
	public GameLogo getGameLogo() {
		return gameLogo;
	}

	/**
	 * @param gameLogo the gameLogo to set
	 */
	public void setGameLogo(GameLogo gameLogo) {
		this.gameLogo = gameLogo;
	}

	/**
	 * @return the gameBoxArt
	 */
	public GameBoxArt getGameBoxArt() {
		return gameBoxArt;
	}

	/**
	 * @param gameBoxArt the gameBoxArt to set
	 */
	public void setGameBoxArt(GameBoxArt gameBoxArt) {
		this.gameBoxArt = gameBoxArt;
	}
   	
   	public static Game fromJson(String json) throws JsonParseException, JsonMappingException, IOException {
   		
   		ObjectMapper mapper = JsonHelper.getMapper();
 		
   		JsonNode topNode = mapper.readValue(json, JsonNode.class);
   		JsonNode gameNode = topNode.get("game");
   		int viewers = topNode.get("viewers").asInt();
   		int channels = topNode.get("channels").asInt();
   		Game game = mapper.readValue(gameNode, Game.class);
   		game.setViewers(viewers);
   		game.setChannels(channels);
   		
   		return game;
   	}
	
	
}
