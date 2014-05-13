package com.atomic.abstractgame;

import com.atomic.option.OptionGame;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.FitViewport;

public abstract class AbstractScreen implements Screen {
	
	// Thiết lập kích thước màn hình máy ảo
	private static final int SCREEN_WIDTH = OptionGame.SCREEN_WIDTH;
	private static final int SCREEN_HEIGHT = OptionGame.SCREEN_HEIGHT;
	
	private Game game;
	private String nameScreen;
	private Stage stage;
	
	private boolean isBackButtonActive = false; 
	
	// Khởi tạo một screen game
	public AbstractScreen(Game _game, String _nameScreen) {
		game = _game;
		nameScreen = _nameScreen;
		stage = new Stage(new FitViewport(SCREEN_WIDTH, SCREEN_HEIGHT));
		Gdx.input.setInputProcessor(stage);
	}
	
	// Tùy chỉnh giao diện
	public void setUpScreenElement() {
		
	}
	
	// Thiết lập hình n�?n cho giao diện màn hình
	public void setBackground(TextureRegion fileBackGround) {
		Drawable textureBackgound = new TextureRegionDrawable(fileBackGround);
		Image imgBg = new Image(textureBackgound, Scaling.fit);
		stage.addActor(imgBg);
	}
	
	// Chức năng cho nút Back
	public void keyBackPressed() {
		
	}
	
	public void setBackButton(boolean _isBackButtonActive) {
		Gdx.input.setCatchBackKey(true);
		isBackButtonActive = _isBackButtonActive;
	}
	
	public boolean isBackButtonActive() {
		return isBackButtonActive;
	}
	
	public Stage getStage() {
		return stage;
	}
	
	public void setGame(Game _game) {
		game = _game;
	}
	
	public Game getGame() {
		return game;
	}
	
	public void setNameScreen(String _nameScreen) {
		nameScreen = _nameScreen;
	}
	
	public String getNameScreen() {
		return nameScreen;
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	   
		stage.act(delta);
	    stage.draw();
	    
	    // Nút Back
		if(isBackButtonActive){
			if(Gdx.input.isKeyPressed(Keys.BACK)){
				keyBackPressed();
			}
		}
	}

	@Override
	public void resize(int width, int height) {
		// thay đổi kích thước giao diện

	}

	@Override
	public void show() {
		// Hiển thị màn hình
		Gdx.app.log(nameScreen, "Trình diễn: " + nameScreen);
	}

	@Override
	public void hide() {
		// Ẩn màn hình
		Gdx.app.log(nameScreen, "Ẩn màn hình: " + nameScreen);
	}

	@Override
	public void pause() {
		// Dừng màn hình
		Gdx.app.log(nameScreen, "Paused: " + nameScreen);
	}

	@Override
	public void resume() {
		// Quay lại
		Gdx.app.log(nameScreen, "Resumed: " + nameScreen);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		stage.dispose();
		Gdx.app.log(nameScreen, "Giải phóng thoát kh�?i " + nameScreen);
	}
	
}
