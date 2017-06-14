package fart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class StartFart extends JPanel implements MouseListener{
    private static final long serialVersionUID = 1L;
    private final int WIDTH = 1200;
    private final int HEIGHT = 800;

    int height = 25;
    int width = 25;

    private Font font = new Font("Arial", Font.BOLD, 18);
    FontMetrics metrics;

    Square[][] world = new Square[WIDTH / width][HEIGHT / height];

    public StartFart() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        for(int layer = 0; layer < 1; layer++)
        for(int i = 0; i < world.length; i++){
            for(int j = 0; j < world[i].length; j++){

                if(layer == 0){

                    if(world[i][j] == null){
                        world[i][j] = new Blank();
                    }

                    if( world[i][j].getTerrain() == null) {
                        Random r = new Random();
                        int rnd = r.nextInt(3);

                        Color c = null;
                        switch (rnd) {
                            case 0:
                                c = Color.GRAY;
                                break;
                            case 1:
                                c = Color.DARK_GRAY;
                                break;
                            case 2:
                                c = Color.BLUE;
                                break;
                        }


                        g2d.setPaint(c);
                        g2d.fillRect(i * width, j * height, width, height);

                        g2d.setStroke(new BasicStroke(1));
                        g2d.setColor(Color.BLACK);
                        g2d.drawRect(i * width, j * width, width, height);

                        world[i][j].setTerrain(c);
                    }
                }

if(layer == 1) {
    if (world[i][j] == null) {
        Random r = new Random();
        int rnd = r.nextInt(7);
        if (rnd < 4) {
            world[i][j] = new Blank();
        } else if (rnd == 4) {
            world[i][j] = new Castle();
        } else if (rnd > 4) {
            world[i][j] = new Farm();
        }
        world[i][j].setId(i + (j * width));
    }


    int padding = 6;

    Square current = world[i][j];
    g2d.setPaint(current.getPaint());
    g2d.fillRect(i * width+(padding/2), j * height+(padding/2), width-padding, height-padding);
}

if(layer == 2){
                    //people stuff here
}
            }
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

        while(true){
            p.repaint();
            Thread.sleep(10);
        }

    }

    public void mouseClicked(MouseEvent e) {

        System.out.println(world[e.getX()/width][e.getY()/height].getId());

        if(e.getButton() == 1) {
            world[e.getX() / width][e.getY() / height] = new Farm();
        }

        if(e.getButton() == 2){
            world[e.getX() / width][e.getY() / height] = new Castle();
        }

        if(e.getButton() == 3){
            world[e.getX() / width][e.getY() / height] = new Blank();
        }

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