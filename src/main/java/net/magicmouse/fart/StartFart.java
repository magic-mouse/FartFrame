package net.magicmouse.fart;

import net.magicmouse.fart.statics.*;
import net.magicmouse.fart.terrain.*;
import net.magicmouse.fart.utils.Blank;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class StartFart extends JPanel implements MouseListener {
    private static final long serialVersionUID = 1L;
    private final int WIDTH = 1200;
    private final int HEIGHT = 800;

    int height = 25;
    int width = 25;


    Terrain[] terrains = {new Mountain(), new Plain(), new Dessert()};
    private Font font = new Font("Arial", Font.BOLD, 18);
    FontMetrics metrics;

    Piece[][] world = new Piece[WIDTH / width][HEIGHT / height];

    public StartFart() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[i].length; j++) {
                layerZero(g2d, i, j);
            }
        }
    }

    private void layerZero(Graphics2D g2d, int i, int j) {

        if (world[i][j] == null) {
            world[i][j] = new Piece();
            Random r = new Random();
            int rnd = r.nextInt(terrains.length);


            Terrain terrain = terrains[rnd];
            Paint c = terrain.getPaint();
            world[i][j].setTerrain(terrain);

            System.out.println("Terrain: " + terrain.getClass());

            g2d.setPaint(c);
            g2d.fillRect(i * width, j * height, width, height);

            g2d.setStroke(new BasicStroke(1));
            g2d.setColor(Color.BLACK);
            g2d.drawRect(i * width, j * width, width, height);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        JFrame f = new JFrame();
        StartFart p = new StartFart();

        f.setContentPane(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        while (true) {
            p.repaint();
            Thread.sleep(10);
        }

    }

    public void mouseClicked(MouseEvent e) {

        Piece current = world[e.getX() / width][e.getY() / height];


        if(SwingUtilities.isRightMouseButton(e)){
            current.setRightClicked(current.getRightClicked() + 1);
        }

        System.out.println(current.getTerrain().getClass() + " Clicked times: " + current.getRightClicked());

    }

    public void mousePressed(MouseEvent e) {
        //  System.out.println("mouse pressed");
    }

    public void mouseReleased(MouseEvent e) {
        //  System.out.println("mouse released");
    }

    public void mouseEntered(MouseEvent e) {
        ///  System.out.println("mouse entered");
    }

    public void mouseExited(MouseEvent e) {
        // System.out.println("mouse exited");
    }
}