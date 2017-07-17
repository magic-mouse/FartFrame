package net.magicmouse.fart.panes;

import javax.swing.*;

/**
 * Created by niepe on 2017-07-17.
 */
public class InfoPane extends JPanel {

    JLabel jLabel;

    public InfoPane() {

        jLabel = new JLabel("Hello World!");

        this.add(jLabel);

        this.setVisible(true);

    }

    public void setjLabel(String labelText) {
        this.jLabel.setText(labelText);
    }
}
