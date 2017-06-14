package fart;


import java.awt.*;

public class Castle implements Square {

    private int id;
    private Color c;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paint getPaint() {
        return Color.RED;
    }

    public void setTerrain(Color c) {
        this.c = c;
    }

    public Color getTerrain() {
        return c;
    }

}
