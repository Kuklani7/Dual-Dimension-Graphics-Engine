package app.gameengine.model.ai;

import app.gameengine.Level;
import app.gameengine.model.gameobjects.DynamicGameObject;

public class NearPlayer extends Decision {
    static final double PY = 0.01;
    private double dist;
    public NearPlayer(String name,double dist){
        super(name);
        this.dist=dist;
    }
    @Override
    public boolean decide(DynamicGameObject d1, Level l1, double dt){
        if (Math.sqrt(Math.pow(d1.getLocation().getX() - l1.getPlayer().getLocation().getX(), 2)+
                Math.pow(d1.getLocation().getY() - l1.getPlayer().getLocation().getY(), 2)) <= this.dist){
            return true;
        }
        else{
            return false;
        }

    }
}
