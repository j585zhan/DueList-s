package duelist;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;


public class DueListGraphics extends JFrame {
    private Image dbI;
    private Graphics dbg;
    int SCREEN_SIZE_X = 500, SCREEN_SIZE_Y = 200;
    
    public static void main(String[] args) {
        DueListGraphics dl = new DueListGraphics();
    }

    public DueListGraphics() {
        this.setTitle("Todo or Todie");
        this.setVisible(true);
        this.setSize(SCREEN_SIZE_X, SCREEN_SIZE_Y);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addMouseListener(new ML());
        this.addMouseMotionListener(new ML());
    }

    
    @Override
    public void paint(Graphics g) {
        dbI = createImage(getWidth(),getHeight());
        dbg = dbI.getGraphics();
        
        dbg.setColor(Color.black);
        dbg.drawRoundRect(350, 80, 100, 50, 20, 20);
        g.drawImage(dbI,0,0,this);
    }
    
    public class ML extends MouseAdapter {
        public void mouseRightClick(MouseEvent e) {
            int mx = e.getX();
            int my = e.getY();
            
        }
        
        public void mouseMoved(MouseEvent e){
            int mx = e.getX();
            int my = e.getY();
        }
        
        public void mouseReleased (MouseEvent e) {
            int mx = e.getX();
            int my = e.getY();
            
        }
        
        public void mousePressed(MouseEvent e) {
            int mx = e.getX();
            int my = e.getY();
            
        }
    }
    
}
