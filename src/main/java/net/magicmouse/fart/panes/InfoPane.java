package net.magicmouse.fart.panes;

import javax.swing.*;
import java.awt.*;

/**
 * Created by niepe on 2017-07-17.
 */
public class InfoPane extends JPanel {

    JLabel jLabel;
    JButton jButton;

    public InfoPane() {

        this.setLayout(new GridLayout(0,1));
        this.setSize(200, 600);


        jLabel = new JLabel("Hello World!");
        jButton = new JButton("Mountain this square");

        this.add(jLabel);
        this.add(jButton);

        this.setVisible(true);

    }

    public void setjLabel(String labelText) {
        this.jLabel.setText(labelText);
    }
}
