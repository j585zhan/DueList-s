package duelist;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class DueListGraphics extends JFrame {
    private Image dbI;
    private Graphics dbg;
    int SCREEN_SIZE_X = 500, SCREEN_SIZE_Y = 200;
    Rectangle submit = new Rectangle(350,80,100,50);
    boolean submit_hovered;
    boolean submit_pressed;
    
    Rectangle name = new Rectangle(150,80,50,20);
    boolean name_hovered;
    boolean name_pressed;
    String nameString;
    
    Rectangle cycles = new Rectangle(250,80,50,20);
    boolean cycles_hovered;
    boolean cycles_pressed;
    String cyclesString;
    
    Rectangle first_DueDay = new Rectangle(150,110,150,20);
    boolean first_DueDay_hovered;
    boolean first_DueDay_pressed;
    String first_DueDayString;
    
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
        
        if (submit_pressed) {
            dbg.setColor(Color.LIGHT_GRAY);
        } else {
            dbg.setColor(Color.white);
        }
        dbg.fillRoundRect(submit.x, submit.y, submit.width, submit.height, 20, 20);
        
        if (name_pressed) {
            dbg.setColor(Color.LIGHT_GRAY);
        } else {
            dbg.setColor(Color.white);
        }
        dbg.fillRect(name.x, name.y, name.width, name.height);
        
        if (cycles_pressed) {
            dbg.setColor(Color.LIGHT_GRAY);
        } else {
            dbg.setColor(Color.white);
        }
        dbg.fillRect(cycles.x, cycles.y, cycles.width, cycles.height);
        
        if (first_DueDay_pressed) {
            dbg.setColor(Color.LIGHT_GRAY);
        } else {
            dbg.setColor(Color.white);
        }
        dbg.fillRect(first_DueDay.x, first_DueDay.y, first_DueDay.width, first_DueDay.height);

        if (submit_hovered) {
            dbg.setColor(Color.LIGHT_GRAY);
            dbg.drawRoundRect(submit.x, submit.y, submit.width, submit.height, 20, 20);
        }
        
        if (name_hovered) {
            dbg.setColor(Color.LIGHT_GRAY);
            dbg.drawRect(name.x, name.y, name.width, name.height);
        }
        
        if (cycles_hovered) {
            dbg.setColor(Color.LIGHT_GRAY);
            dbg.drawRect(cycles.x, cycles.y, cycles.width, cycles.height);
        }
        
        if (first_DueDay_hovered) {
            dbg.setColor(Color.LIGHT_GRAY);
            dbg.drawRect(first_DueDay.x, first_DueDay.y, first_DueDay.width, first_DueDay.height);
        }
        
        
        //dbg.fillRoundRect(submit.x, submit.y, submit.width, submit.height, 20, 20);
        
        
        g.drawImage(dbI,0,0,this);
        repaint();
        
    }
    
    public class ML extends MouseAdapter {
        public void mouseRightClick(MouseEvent e) {
            int mx = e.getX();
            int my = e.getY();
            
        }
        
        public void mouseMoved(MouseEvent e){
            int mx = e.getX();
            int my = e.getY();
            
            submit_hovered = mx >= submit.x && mx <= submit.x+submit.width
                          && my >= submit.y && my <= submit.y+submit.height;
            
            name_hovered = mx >= name.x && mx <= name.x+name.width
                        && my >= name.y && my <= name.y+name.height;
            
            cycles_hovered = mx >= cycles.x && mx <= cycles.x+cycles.width
                         &&  my >= cycles.y && my <= cycles.y+cycles.height;
            
            first_DueDay_hovered = mx >= first_DueDay.x && mx <= first_DueDay.x+first_DueDay.width
                               &&  my >= first_DueDay.y && my <= first_DueDay.y+first_DueDay.height;
            
        }
        
        public void mouseReleased (MouseEvent e) {
            int mx = e.getX();
            int my = e.getY();
            
            if (mx >= name.x && mx <= name.x+name.width
            &&  my >= name.y && my <= name.y+name.height && name_pressed) {
                nameString = JOptionPane.showInputDialog(null, "ENTER EVENT NAME");
            }
            
            if (mx >= cycles.x && mx <= cycles.x+cycles.width
            &&  my >= cycles.y && my <= cycles.y+cycles.height && cycles_pressed) {
                nameString = JOptionPane.showInputDialog(null, "ENTER EVENT REPEAT TIMES");
            }
            
            if (mx >= first_DueDay.x && mx <= first_DueDay.x+first_DueDay.width
            &&  my >= first_DueDay.y && my <= first_DueDay.y+first_DueDay.height && first_DueDay_pressed) {
                nameString = JOptionPane.showInputDialog(null, "ENTER THE FIRST DUEDAY");
            }
            
            submit_pressed = false;
            name_pressed = false;
            cycles_pressed = false;
            first_DueDay_pressed = false;
        }
        
        public void mousePressed(MouseEvent e) {
            int mx = e.getX();
            int my = e.getY();
            if (mx >= submit.x && mx <= submit.x+submit.width
            &&  my >= submit.y && my <= submit.y+submit.height) {
                submit_pressed = true;
            }
            
            if (mx >= name.x && mx <= name.x+name.width
            &&  my >= name.y && my <= name.y+name.height) {
                name_pressed = true;
            }
            
            if (mx >= cycles.x && mx <= cycles.x+cycles.width
            &&  my >= cycles.y && my <= cycles.y+cycles.height) {
                cycles_pressed = true;
            }
            
            if (mx >= first_DueDay.x && mx <= first_DueDay.x+first_DueDay.width
            &&  my >= first_DueDay.y && my <= first_DueDay.y+first_DueDay.height) {
                first_DueDay_pressed = true;
            }
            
        }
    }
    
}
