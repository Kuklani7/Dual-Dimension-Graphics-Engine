package app.gameengine.model.gameobjects;

import app.gameengine.Level;
import app.gameengine.model.ai.DecisionTree;
import app.gameengine.model.datastructures.LinkedListNode;
import app.gameengine.model.physics.Vector2D;
import app.games.topdownobjects.Projectile;

import java.util.ArrayList;

public abstract class DynamicGameObject extends GameObject {
    private ArrayList<CollectibleGameObject> inventory =new ArrayList<>();
    private CollectibleGameObject active=null;
    private DecisionTree tree;
    private double timer=0.0;
    private LinkedListNode<Vector2D> guide = null;

    protected Vector2D velocity = new Vector2D(0.0, 0.0);
    protected Vector2D Orientation=new Vector2D(0.0,1.0);
    protected int maxHp;
    protected int Hp;
    boolean on_Ground=false;


    public DynamicGameObject(Vector2D location, int maxHP) {
        super(location);
        this.Hp=maxHP;
        this.maxHp=maxHP;
    }
    public DecisionTree getDecisionTree(){
        return this.tree;
    }
    public void setDecisionTree(DecisionTree tree){
        this.tree=tree;
    }
    public LinkedListNode<Vector2D> getPath() {
        return this.guide;
    }
    public void setPath(LinkedListNode<Vector2D> v1) {
        this.guide = v1;
    }
    public double getInvincibilityFrames(){
        return this.timer;
    }
    public void setInvincibilityFrames(double timer){
        this.timer=timer;
    }
    @Override
    public void update(double dt, Level level){
        super.update(dt,level);
        this.timer-=dt;
        // How do I apply the get damage?
        if(this.Hp<=0){
            this.destroy();
        }

    }
    public ArrayList<CollectibleGameObject> getInventory(){
        return this.inventory;
    }
    public int findIndex(CollectibleGameObject CO){
        int x=0;
        for(CollectibleGameObject item:this.inventory){
            if(item==CO){
                return x;
            }
            else{x++;}
        }
        return -1;
    }
    public void addInventoryItem(CollectibleGameObject CO){
        this.inventory.add(CO);
        if(this.inventory.size()==1){
            this.active=CO;
        }
    }
    public void removeActiveItem(){
        if(this.inventory.isEmpty()){
            return;
        }
        if(this.inventory.size()==1){
            this.inventory.remove(0);
            this.active=null;
            return;
        }
        if(this.inventory.get(this.inventory.size()-1).equals(this.active)){
            this.inventory.remove(this.active);
            this.active=this.inventory.getFirst();
            return;
        }
        //Case where the active Item is a middle element.
        int index=findIndex(this.active);
        if(index==-1){
            return;
        }
        this.inventory.remove(this.active);
        this.active=this.inventory.get(index);
    }
    public CollectibleGameObject getActiveItem(){
        if(this.inventory.isEmpty()){
            return null;
        }
        else{
            return this.active;
        }
    }
    public String getActiveItemID(){
        if(this.inventory.isEmpty()){
            return "No item equipped";
        }
        else{
            return this.active.getItemID();
        }
    }
    public void cycleInventory(){
        if(this.inventory.isEmpty()){
            return;
        }
        int indexing=findIndex(this.active);
        if(indexing==-1){
            return;
        }
        if(indexing==(this.inventory.size()-1)){
            this.active=this.inventory.getFirst();
        }
        else{
            this.active=this.inventory.get(indexing+1);
        }
    }
    public void fireProjectile(Projectile pe, double speed, Level l){
        if(pe==null){
            return;
        }
        pe.getLocation().setX(this.getLocation().getX());
        pe.getLocation().setY(this.getLocation().getY());
        pe.getVelocity().setX(this.getOrientation().getX()*speed);
        pe.getVelocity().setY(this.getOrientation().getY()*speed);
        l.getDynamicObjects().add(pe);
    }
    public int getMaxHP() {
        return this.maxHp;
    }

    public int getHP() {

        return this.Hp;
    }

    public void setHP(int hp) {
        if (hp>this.maxHp){
            this.Hp=maxHp;
        }
        else
        {
        this.Hp=hp;
        }
    }


    public void setMaxHp(int maxHp){
        this.maxHp=maxHp;
    }


    public Vector2D getOrientation() {
        return this.Orientation;
    }

    public Vector2D getVelocity() {

        return this.velocity;
    }
    public void setVelocity(Vector2D velocity){
        this.velocity=velocity;
    }
    public void takeDamage(int damage){
        if (damage>0){
            this.Hp=this.Hp-damage;
        }
    }
    public boolean isOnGround(){
        return this.on_Ground;
    }
    public void setOnGround(boolean b){
        this.on_Ground=b;
    }

    @Override
    public boolean isDestroyed() {
        return super.isDestroyed();
    }

    @Override
    public void revive() {
        super.revive();
    }

    @Override
    public void collideWithStaticObject(StaticGameObject otherObject) {

    }

    @Override
    public void collideWithDynamicObject(DynamicGameObject otherObject) {

    }

}
