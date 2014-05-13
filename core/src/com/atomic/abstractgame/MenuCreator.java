package com.atomic.abstractgame;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class MenuCreator {
    
    public static ButtonGame createCustomGameButton(TextureRegion up, TextureRegion down){
        Drawable dUp = new TextureRegionDrawable(up);
        Drawable dDown = new TextureRegionDrawable(down);
        return new ButtonGame(dUp, dDown);
    }
}
