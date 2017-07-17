package net.magicmouse.fart;

import net.magicmouse.fart.movables.Movable;
import net.magicmouse.fart.statics.Static;
import net.magicmouse.fart.terrain.Terrain;

/**
 * Created by niepe on 2017-07-17.
 */
public class Piece {

    Terrain terrain;
    Static aStatic;
    Movable movable;
    int rightClicked = 0;

    public int getRightClicked() {
        return rightClicked;
    }

    public void setRightClicked(int rightClicked) {
        this.rightClicked = rightClicked;
    }


    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public Static getStatic() {
        return aStatic;
    }

    public void setStatic(Static aStatic) {
        this.aStatic = aStatic;
    }

    public Movable getMovable() {
        return movable;
    }

    public void setMovable(Movable movable) {
        this.movable = movable;
    }
}
