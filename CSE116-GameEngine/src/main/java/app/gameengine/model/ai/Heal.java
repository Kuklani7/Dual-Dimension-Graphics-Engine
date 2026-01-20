package app.gameengine.model.ai;

import app.gameengine.Level;
import app.gameengine.model.gameobjects.DynamicGameObject;

public class Heal extends Decision {
    private int gain;
    private double cool_down;
    private double time_spent;
    public Heal(String name,int gain,double cool_down){
        super(name);
        this.gain=gain;
        this.cool_down=cool_down;
    }
    @Override
    public void doAction(DynamicGameObject d1, Level l1, double dt){
        this.time_spent+=dt;
        if(this.time_spent>=cool_down){
            d1.getVelocity().setX(0.0);
            d1.getVelocity().setY(0.0);
            int curr_hp= d1.getHP();
            d1.setHP(curr_hp+this.gain);
            time_spent=0.0;
        }
    }

}
