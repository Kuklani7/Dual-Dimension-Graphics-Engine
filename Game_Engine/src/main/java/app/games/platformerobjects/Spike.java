package app.games.platformerobjects;

import app.gameengine.graphics.SpriteLocation;
import app.gameengine.model.gameobjects.DynamicGameObject;
import app.gameengine.model.gameobjects.StaticGameObject;

public class Spike extends StaticGameObject {
    public Spike(int x_loc, int y_loc){
        super(x_loc,y_loc);
        this.spriteSheetFilename="User Interface/UiIcons.png";
        this.defaultSpriteLocation=new SpriteLocation(2,10);
    }
    @Override
    public void collideWithDynamicObject(DynamicGameObject p3){
        if(p3.isPlayer()){
            p3.destroy();
        }
    }
}
