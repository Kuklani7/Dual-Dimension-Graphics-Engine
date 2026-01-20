package app.gameengine;
import app.gameengine.graphics.SpriteGraphics;
import app.gameengine.model.datastructures.LinkedListNode;
import app.gameengine.model.gameobjects.GameObject;
import app.gameengine.model.gameobjects.Player;
import app.gameengine.model.physics.Vector2D;

import java.util.HashMap;

/**
 * Controls the UI and levels of the game.
 *
 * You can extend this class if you would like to build a different
 * game. The game that is played by default is `SampleTopDownGame.java`
 */
public class Game {
    protected LinkedListNode<Level> LL = null;

    private Player player = new Player(new Vector2D(0.0, 0.0), 10);
    private Level currentLevel;
    private long lastUpdate = 0L;
    protected String displayString = "This is where UI information would go, like HP, number of keys, or inventory";

    public Game() {
        this.init();
    }


    public Player getPlayer() {
        return player;
    }

    public String getUI() {
        return this.getPlayer().getActiveItemID();
    }
    public Level getCurrentLevel() {
        return this.currentLevel;
    }

    public void addLevel(Level cng) {
        if (LL == null) {
            this.LL = new LinkedListNode<Level>(cng, null);
        } else {
            this.LL.append(cng);
        }
    }

    public LinkedListNode<Level> getLevelList() {
        return this.LL;
    }

    public void setLevelList(LinkedListNode<Level> input) {
        this.LL = input;
    }

    public void loadLevel(Level level) {
        this.currentLevel = level;
        this.player.getLocation().setX(level.getPlayerStartLocation().getX());
        this.player.getLocation().setY(level.getPlayerStartLocation().getY());
        this.currentLevel.getDynamicObjects().removeIf(GameObject::isPlayer); // prevents the player from being in the level more than once
        this.currentLevel.getDynamicObjects().add(this.player);
    }

    public void update(long timestamp) {
        if (this.lastUpdate != 0) {
            double dt = (timestamp - this.lastUpdate) / 1000000000.0;
            this.currentLevel.update(dt);
            if (this.player.isDestroyed()) {
                this.player.setHP(this.player.getMaxHP());
                this.player.revive();
                this.loadLevel(this.currentLevel);
            }
        }
        this.lastUpdate = timestamp;
    }

    public void removeLevelByName(String name) {
        if (this.LL == null) {
            return;
        } else if (this.LL.size() == 1) {
            if (this.LL.getValue().getName().equals(name)) {
                this.LL = null;
            } else {
                return;
            }
        } else if (this.LL.getValue().getName().equals(name)) {
            this.LL = this.LL.getNext();
        } else {
            removeLevelByName_Recur(name, this.LL);
        }

    }

    private void removeLevelByName_Recur(String name, LinkedListNode<Level> LL) {
        if (LL.getNext().getValue() != null) {
            if (LL.getNext().getValue().getName().equals(name)) {
                LL.setNext(LL.getNext().getNext());
                return;
            } else {
                removeLevelByName_Recur(name, LL.getNext());
            }
        }
        return;
    }

    public void advanceLevel() {
        if (this.LL == null) {
            return;
        }
        Level l1 = this.getCurrentLevel();
        LinkedListNode<Level> next_Level = advanceLevel_Recur(l1, this.LL);
        if (next_Level == null) {
            return;
        }
        Level l2 = next_Level.getValue();
        this.loadLevel(l2);
    }

    public LinkedListNode<Level> advanceLevel_Recur(Level l1, LinkedListNode<Level> LL) {
        if (LL.getNext() == null) {
            return null;
        } else if (LL.getValue() == l1) {
            return LL.getNext();
        } else {
            return advanceLevel_Recur(l1, LL.getNext());
        }
    }
    public void init(){

    }
}




