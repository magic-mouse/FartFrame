package fart;

import java.awt.*;

/**
 * Created by niepe on 2017-06-09.
 */
public class Farm implements Square {

    private int id;
    private Color c;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id ;
    }

    public Paint getPaint() {
        return Color.GREEN;
    }


    public void setTerrain(Color c) {
        this.c = c;
    }

    public Color getTerrain() {
        return c;
    }


}
