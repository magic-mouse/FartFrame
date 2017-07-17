package net.magicmouse.fart;

import net.magicmouse.fart.panes.InfoPane;
import net.magicmouse.fart.statics.*;
import net.magicmouse.fart.terrain.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.Random;

public class StartFart extends JPanel implements MouseListener {
    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    int height = 32;
    int width = 32;


    static InfoPane ip;
    Terrain[] terrains = {new Mountain(), new Plain(), new Dessert()};
    private Font font = new Font("Arial", Font.BOLD, 18);
    FontMetrics metrics;

    Piece[] world = new Piece[width * height];

    public StartFart() {
        setPreferredSize(new Dimension(HEIGHT, HEIGHT));
        addMouseListener(this);

        for(int i = 0; i < world.length; i++){
            world[i] = new Piece();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < world.length; i++) {

                Piece piece = layerZero(g2d, i);

                Paint c = piece.getTerrain().getPaint();




                g2d.setPaint(c);

                int pieceHeight = (HEIGHT/height);
                int pieceWidth = (HEIGHT/width);

                int pieceX = i * pieceWidth % (pieceWidth * width);
                int pieceY = (i * pieceWidth / ( pieceWidth * width)) * pieceWidth;

//                System.out.println("somerun " + i);
//                System.out.println("Height: " + pieceHeight + ", Width: " + pieceWidth + ", pieceX: " + pieceX + ", pieceY: " + pieceY);
//                System.out.println( i * pieceWidth );
//                System.out.println( (pieceWidth * width));
//                System.out.println( i * pieceWidth % (pieceWidth * width));
//                System.out.println( i * pieceWidth / (pieceWidth * width));



                g2d.fillRect( pieceX , pieceY , pieceWidth, pieceHeight);
                g2d.setStroke(new BasicStroke(1));
                g2d.setColor(Color.BLACK);
                g2d.drawRect(pieceX,pieceY, pieceWidth,pieceHeight);

        }

    }

    private Piece layerZero(Graphics2D g2d, int i) {
        if (world[i].getTerrain() == null) {
            Random r = new Random();
            int rnd = r.nextInt(terrains.length);
            Terrain terrain = terrains[rnd];
            world[i].setTerrain(terrain);
        }

        return world[i];
    }


    public static void main(String[] args) throws InterruptedException {
        JFrame f = new JFrame("World Peas");
        f.setLayout(new BorderLayout());
        f.setSize(WIDTH, HEIGHT);

        StartFart p = new StartFart();
        p.setVisible(true);
        ip = new InfoPane();


        f.add(ip, BorderLayout.EAST);
        f.add(p, BorderLayout.WEST);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setLocationRelativeTo(null);
        f.setVisible(true);

        while (true) {
            // f.repaint();

            p.repaint();
            //     ip.repaint();
            Thread.sleep(100);
        }

    }

    public void mouseClicked(MouseEvent e) {


        int pieceHeight = (HEIGHT/height);
        int pieceWidth = (HEIGHT/width);



       Piece current = world[(e.getY()/pieceWidth) * width + (e.getX()/pieceHeight)];
        if (SwingUtilities.isRightMouseButton(e)) {
            current.setRightClicked(current.getRightClicked() + 1);
        }
        ip.setjLabel(current.getTerrain().getClass().toString() +
                "," + "\r\n" +  " Clicked times: " + current.getRightClicked() );


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