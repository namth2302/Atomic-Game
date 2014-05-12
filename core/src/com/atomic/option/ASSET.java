package com.atomic.option;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ASSET {
	
	// Avantar mặc định
	public static TextureRegion imgDefaultAvantarMan;
	public static TextureRegion imgDefaultAvatarWoman;
	
	// Hình ảnh tường viền
	public static TextureRegion imgWall;
	
	// Hình ảnh các button chỉ hướng đi
	public static TextureRegion btnLeft;
	public static TextureRegion btnRight;
	public static TextureRegion btnUp;
	public static TextureRegion btnDown;
	
	// Hình ảnh các nút chức năng
	public static TextureRegion btnUndo;
	public static TextureRegion btnRecno;
	public static TextureRegion btnReset;
	
	// Tải tập tin ảnh Texture
	public static Texture loadTexture(String pathImage) {
		return new Texture(Gdx.files.internal(pathImage));
	}
	
	// Tải toàn bộ tập tin chung mặc định
	public static void loadAllFile() {
		loadImageAvantar();
		loadImageItemGame();
		loadButtonGame();
		loadFont();
	}
	
	private static void loadImageAvantar() {
		imgDefaultAvantarMan = new TextureRegion(loadTexture("avantar/avatar_nam.png"));
		imgDefaultAvatarWoman = new TextureRegion(loadTexture("avantar/avatar_nu.png"));
	}
	
	private static void loadImageItemGame() {	
		// Load Wall
		imgWall = new TextureRegion(loadTexture("katomic/wall.png"));
	}
	
	private static void loadButtonGame() {
		// Load các nút chỉ hướng
		btnLeft = new TextureRegion(loadTexture("katomic/arrow-left.png"));
		btnRight = new TextureRegion(loadTexture("katomic/arrow-right.png"));
		btnUp = new TextureRegion(loadTexture("katomic/arrow-up.png"));
		btnDown = new TextureRegion(loadTexture("katomic/arrow-down.png"));
		
		// Load các nút chức năng
		btnRecno = new TextureRegion(loadTexture("_redo.png"));
		btnUndo = new TextureRegion(loadTexture("_undo.png"));
		btnReset = new TextureRegion(loadTexture("refresh.png"));
	}
	
	// Cấu hình tải font
	private static void loadFont() {
		
	}
}
