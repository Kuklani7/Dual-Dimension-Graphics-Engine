package app.gameengine.model.ai;

import app.gameengine.Level;
import app.gameengine.model.gameobjects.DynamicGameObject;

public class LowHP extends Decision {
    private int low;
    public LowHP(String name, int low){
        super(name);
        this.low=low;
    }
    @Override
    public boolean decide(DynamicGameObject d1, Level l1, double dt){
        if(d1.getHP()<=this.low){
            return true;
        }
        return false;
    }

}
