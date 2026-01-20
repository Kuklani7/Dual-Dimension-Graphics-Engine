package app.games;

import app.gameengine.Game;
import app.gameengine.Level;
import app.gameengine.model.datastructures.LinkedListNode;
import app.gameengine.model.physics.Vector2D;
import app.games.commonobjects.Goal;
import app.games.commonobjects.Potion;
import app.games.topdownobjects.*;
import app.games.commonobjects.Wall;

public class SampleTopDownGame extends Game {
    private LinkedListNode<Level> LL=null;

//    public SampleTopDownGame() {
//
//    }
    public void init() {
        this.LL=new LinkedListNode<>(levelZero(),null);
        this.LL.append(levelOne());
        this.LL.append(levelTwo());
        this.loadLevel(LL.getValue());
    }
    public LinkedListNode<Level> getLevelList(){
        return this.LL;
    }
    public void setLevelList(LinkedListNode<Level> input){
        this.LL=input;
    }
    public void addLevel(Level cng){
        if (LL==null){
            this.LL=new LinkedListNode<Level>(cng,null);
        }
        else{
            this.LL.append(cng);
        }
    }
    public void removeLevelByName(String name){
        if(this.LL==null){
            return;
        }
        else if(this.LL.size()==1){
            if(this.LL.getValue().getName().equals(name)){
                this.LL=null;
            }
            else{
                return;
            }
        }
        else if (this.LL.getValue().getName().equals(name)){
            this.LL=this.LL.getNext();
        }
        else{
            removeLevelByName_Recur(name,this.LL);
        }

    }
    private void removeLevelByName_Recur(String name,LinkedListNode<Level> LL){
        if(LL.getNext().getValue()!=null){
            if(LL.getNext().getValue().getName().equals(name)){
                LL.setNext(LL.getNext().getNext());
                return;
            }
            else{
                removeLevelByName_Recur(name,LL.getNext());
            }
        }
        return;
    }



    @Override
   public void advanceLevel(){
        if(this.LL==null){
            return;
        }
        Level l1=this.getCurrentLevel();
        LinkedListNode<Level> next_Level=advanceLevel_Recur(l1,this.LL);
        if(next_Level==null){
            return;
        }
        Level l2=next_Level.getValue();
        this.loadLevel(l2);
    }
    public LinkedListNode<Level> advanceLevel_Recur(Level l1,LinkedListNode<Level> LL){
        if(LL.getNext()==null){
            return null;
        }
        else if(LL.getValue()==l1){
            return LL.getNext();
        }
        else{
            return advanceLevel_Recur(l1, LL.getNext());
        }
    }



    public Level levelZero() {
        Level firstLevel = new TopDownLevel(this, 12, 8, "level0");
        firstLevel.getStaticObjects().add(new Wall(4, 1));
        firstLevel.getStaticObjects().add(new Wall(4, 2));
        firstLevel.getStaticObjects().add(new Wall(4, 3));
        firstLevel.getStaticObjects().add(new Wall(4, 4));
        firstLevel.getStaticObjects().add(new Wall(5, 4));
        firstLevel.getStaticObjects().add(new Wall(6, 4));
        firstLevel.getStaticObjects().add(new Wall(7, 4));
        firstLevel.getStaticObjects().add(new Wall(8, 4));
        firstLevel.getStaticObjects().add(new Tower(10, 1));
        firstLevel.getStaticObjects().add(new Goal(6, 2, this));
        firstLevel.getPlayerStartLocation().setX(2.0);
        firstLevel.getPlayerStartLocation().setY(2.0);


        firstLevel.getDynamicObjects().add(new SmartEnemy(new Vector2D(8.0, 1.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(9.0, 5.0)));
        firstLevel.getDynamicObjects().add(new Potion(new Vector2D(5,5),10));
        firstLevel.getDynamicObjects().add(new Potion(new Vector2D(3.4,3.7),5));
        return firstLevel;
    }

    public Level levelOne() {
        Level firstLevel = new TopDownLevel(this, 12, 9, "level1");
        firstLevel.getStaticObjects().add(new Goal(7, 4, this));
        firstLevel.getPlayerStartLocation().setX(2.0);
        firstLevel.getPlayerStartLocation().setY(4.0);

        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(5.0, 2.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(5.0, 3.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(5.0, 4.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(5.0, 5.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(5.0, 6.0)));

        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(6.0, 6.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(7.0, 6.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(8.0, 6.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(9.0, 6.0)));

        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(9.0, 5.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(9.0, 4.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(9.0, 3.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(9.0, 2.0)));

        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(8.0, 2.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(7.0, 2.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(6.0, 2.0)));

        return firstLevel;
    }

    public Level levelTwo() {
        Level firstLevel = new TopDownLevel(this, 17, 9, "level2");


        firstLevel.getStaticObjects().add(new Wall(2, 2));
        firstLevel.getStaticObjects().add(new Wall(2, 3));
        firstLevel.getStaticObjects().add(new Wall(2, 4));
        firstLevel.getStaticObjects().add(new Wall(2, 5));
        firstLevel.getStaticObjects().add(new Wall(2, 6));

        firstLevel.getStaticObjects().add(new Wall(3, 5));
        firstLevel.getDynamicObjects().add(new AxePickup(new Vector2D(2,3)));

        firstLevel.getStaticObjects().add(new Wall(4, 4));

        firstLevel.getStaticObjects().add(new Wall(5, 5));

        firstLevel.getStaticObjects().add(new Wall(6, 2));
        firstLevel.getStaticObjects().add(new Wall(6, 3));
        firstLevel.getStaticObjects().add(new Wall(6, 4));
        firstLevel.getStaticObjects().add(new Wall(6, 5));
        firstLevel.getStaticObjects().add(new Wall(6, 6));

        firstLevel.getStaticObjects().add(new Wall(8, 2));
        firstLevel.getStaticObjects().add(new Wall(8, 3));
        firstLevel.getStaticObjects().add(new Wall(8, 4));
        firstLevel.getStaticObjects().add(new Wall(8, 5));
        firstLevel.getStaticObjects().add(new Wall(8, 6));

        firstLevel.getStaticObjects().add(new Wall(10, 2));
        firstLevel.getStaticObjects().add(new Wall(10, 3));
        firstLevel.getStaticObjects().add(new Wall(10, 4));
        firstLevel.getStaticObjects().add(new Wall(10, 5));
        firstLevel.getStaticObjects().add(new Wall(10, 6));

        firstLevel.getStaticObjects().add(new Wall(11, 3));

        firstLevel.getStaticObjects().add(new Wall(12, 4));

        firstLevel.getStaticObjects().add(new Wall(13, 5));

        firstLevel.getStaticObjects().add(new Wall(14, 2));
        firstLevel.getStaticObjects().add(new Wall(14, 3));
        firstLevel.getStaticObjects().add(new Wall(14, 4));
        firstLevel.getStaticObjects().add(new Wall(14, 5));
        firstLevel.getStaticObjects().add(new Wall(14, 6));

        firstLevel.getPlayerStartLocation().setX(4.0);
        firstLevel.getPlayerStartLocation().setY(2.0);

        return firstLevel;
    }
}

