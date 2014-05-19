package com.atomic.game;

public class Btn {
	private String id;
	private int posX;
	private int posY;
	
	public Btn() {
	}

	public Btn(String _id, int _posX, int _posY) {
		id = _id;
		posX = _posX;
		posY = _posY;
	}


	public String getID(){
		return id;
	}
	public int getPosX(){
		return posX;
	}
	public int getPosY(){
		return posY;
	}
	
	public void setID(String _id){
		id = _id;
	}
	public void setPosX(int _posX){
		posX = _posX;
	}
	public void setPosY(int _posY){
		posY = _posY;
	}
}
