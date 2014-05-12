package com.atomic.helper;

import com.atomic.option.jlevel;
import com.badlogic.gdx.utils.Json;

public class BroadGame {
	private String[][] map;
	
	private int width;
	private int height;
	private float marginx;
	private float marginy;
	private jlevel text;
	private Json json;
	
	public BroadGame(jlevel _text, Json _json) {
		text = _text;
		json = _json;
		width = 11;
		height = 9;
		setUpArenaGame();
		marginx = (15 - width)*53/2;
		marginy = (15 - height)*53/2;	
	}
	
	public void setUpArenaGame() {
		map = new String[9][11];
		for (int i = 0; i < text.getArena().size(); i++) {
			String[] splArena = text.getArena().get(i).split("");
			for (int j = 0; j < splArena.length; j++) {
				map[i][j] = splArena[j];
			}
		}
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 11; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println("");
		}
	}
	
	public String[][] getMap() {
		return map;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public String getLocalMap(int x, int y) {
		return map[x][y];
	}
	
	public float getMarginX() {
		return marginx;
	}
	
	public float getMarginY() {
		return marginy;
	}
}
