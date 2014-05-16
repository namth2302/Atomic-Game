package com.atomic.abstractgame;

import com.atomic.asset.JsonLevel;
import com.atomic.option.OptionGame;

public class BroadGame {
	
	private String[][] map;
	private String[][] mapResulf;
	private String[][] mapReset;
	private JsonLevel mapInfo;
	private int width;
	private int height;
	private float startDrawX;
	private float startDrawY;
	
	public BroadGame(JsonLevel _mapInfo) {
		mapInfo = _mapInfo;
		setUpMapBroad();
	}
	
	public void setUpMapBroad() {
		setHeightBroad(mapInfo.getListArena().size());
		setWidthBroad(mapInfo.getListArena().get(0).split("").length);
		map = new String[height][width];
		mapReset = new String[height][width];
		startDrawX = (OptionGame.MAX_SIZE_BROAD - width)/2;
		startDrawY = (OptionGame.MAX_SIZE_BROAD - height)/2;
		for (int i = 0; i < getHeightBroad(); i++) {
			for (int j = 0; j < getWidthBroad(); j++) {
				String[] temList = mapInfo.getListArena().get(i).split(""); 
				map[i][j] = temList[j];
				mapReset[i][j] = temList[j];
			}
		}
		int tempW = mapInfo.getListMolecule().get(0).length();
		int tempH = mapInfo.getListMolecule().size();
		mapResulf = new String[tempH][tempW];
		for (int i = 0; i < tempH; i++) {
			for (int j = 0; j < tempW; j++) {
				String[] tempList = mapInfo.getListMolecule().get(i).split("");
				mapReset[i][j] = tempList[j];
			}
		}
	}
	
	public float getStartDrawX() {
		return startDrawX*53;
	}
	
	public float getStartDrawY() {
		return startDrawY;
	}
	
	public String[][] getMapBroad() {
		return map;
	}
	
	public void setWidthBroad(int _width) {
		width = _width;
	}
	
	public void setHeightBroad(int _height) {
		height = _height;
	}
	
	public int getWidthBroad() {
		return width;
	}
	
	public int getHeightBroad() {
		return height;
	}
	
	public String getLocal(int x, int y) {
		return map[x][y];
	}
	
	public JsonLevel getMapInfo() {
		return mapInfo;
	}
	
	public void reset() {
		for (int i = 0; i < getHeightBroad(); i++) {
			for (int j = 0; j < getWidthBroad(); j++) {
				map[i][j] = mapReset[i][j];
			}
			
		}
	}
}
