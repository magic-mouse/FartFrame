package fart;

import java.awt.*;

/**
 * Created by niepe on 2017-06-09.
 */
public interface Square {

    int getId();
    void setId(int id);

    Paint getPaint();

    void setTerrain(Color c);
    Color getTerrain();
}
