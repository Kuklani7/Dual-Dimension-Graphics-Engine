package app.gameengine.model.gameobjects;

import app.gameengine.Level;
import app.gameengine.model.physics.Vector2D;

public abstract class CollectibleGameObject extends DynamicGameObject {
    private String ID;

    public CollectibleGameObject(Vector2D location, String ID) {
        super(location, 10);
        this.ID = ID;
    }

    public String getItemID() {
        return this.ID;
    }

    @Override
    public void takeDamage(int damage) {
    }
    public abstract void use(Level l);
    @Override
    public void collideWithDynamicObject(DynamicGameObject otherObject) {
        if(otherObject.isPlayer()){
           otherObject.addInventoryItem(this);
           this.destroy();
        }
    }
}
