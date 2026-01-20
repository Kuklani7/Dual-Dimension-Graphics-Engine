package app.tests;

import app.gameengine.Level;
import app.gameengine.model.ai.Decision;
import app.gameengine.model.gameobjects.DynamicGameObject;

public class Worker extends Decision {
    private boolean check;
    public Worker(String name, boolean check){
        super(name);
        this.check=check;
    }
    @Override
    public boolean decide(DynamicGameObject d1, Level l1, double dt){
        return this.check;
    }
    @Override
    public void doAction(DynamicGameObject d1, Level l1, double dt){
        this.check=false;
    }
    public void setCheck(boolean check){
        this.check=check;
    }

}
