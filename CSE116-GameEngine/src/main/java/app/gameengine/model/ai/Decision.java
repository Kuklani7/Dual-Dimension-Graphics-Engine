package app.gameengine.model.ai;

import app.gameengine.Level;
import app.gameengine.model.gameobjects.DynamicGameObject;

public class Decision {
    private String name;
    public Decision(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public boolean decide(DynamicGameObject d1, Level l1, double dt){
        return false;
    }
    public void doAction(DynamicGameObject d1, Level l1, double dt){
        return;
    }

}
