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
    ProcessingList pList;
    int SCREEN_SIZE_X = 500, SCREEN_SIZE_Y = 1000;
    Rectangle TimerBase = new Rectangle (150, 80, 200, 30);
    Rectangle EventBase = new Rectangle (20, 100, 460, 80);
    boolean EventHover [] = new boolean [7];
    int gap = 130;
    
    Rectangle submit = new Rectangle(330,50,130,20);
    boolean submit_hovered;
    boolean submit_pressed;
    boolean submit_processing;
    int submit_ball_pos = submit.x;
    
    Rectangle name = new Rectangle(20,50,80,20);
    boolean name_hovered;
    boolean name_pressed;
    String nameString = "";
    boolean setName;
    
    Rectangle cycles = new Rectangle(110,50,50,20);
    boolean cycles_hovered;
    boolean cycles_pressed;
    String cyclesString = "";
    boolean setCycles;
    
    Rectangle first_DueDay = new Rectangle(170,50,150,20);
    boolean first_DueDay_hovered;
    boolean first_DueDay_pressed;
    String first_DueDayString = "yy/MM/dd HH:mm:ss";
    boolean setFirst_DueDay;
    
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
            dbg.setColor(Color.GREEN);
            dbg.fillOval(submit_ball_pos, submit.y, submit.height, submit.height);
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
        
        if (submit_processing) {
            dbg.setColor(Color.GREEN);
            dbg.drawOval(submit.x+submit.width, submit.y, submit.height, submit.height);
        }
        dbg.setColor(Color.BLACK);
        dbg.drawString("SUBMIT", submit.x, submit.y);
        dbg.drawString("CLASS", name.x, name.y);
        dbg.drawString("CYCLES", cycles.x, cycles.y);
        dbg.drawString("1st DueDay", first_DueDay.x, first_DueDay.y);
        
        dbg.setColor(Color.GREEN);
        dbg.drawString(nameString, name.x+5, name.y+15);
        dbg.drawString(cyclesString, cycles.x+5, cycles.y+15);
        if (!setFirst_DueDay) {
            dbg.setColor(Color.LIGHT_GRAY);
        }
        if (first_DueDay_pressed) {
            dbg.setColor(Color.WHITE);
        }
        dbg.drawString(first_DueDayString, first_DueDay.x+5, first_DueDay.y+15);
        
        
        
        // Draw all events
        for (int i = 0; i < 7*gap; i += gap) {
            if (i > 300) 
                dbg.setColor(Color.GRAY);
            else
                dbg.setColor(Color.GRAY);
            dbg.fillRect(TimerBase.x, TimerBase.y+i, TimerBase.width, TimerBase.height);
            if (EventHover[i/gap])
                dbg.setColor(Color.GRAY);
            else
                dbg.setColor(Color.LIGHT_GRAY);
            dbg.drawRect(EventBase.x, EventBase.y+i, EventBase.width, EventBase.height);
        }
        
        
        g.drawImage(dbI,0,0,this);
        repaint();
        
    }
    
    public class ML extends MouseAdapter {
        public void mouseRightClick(MouseEvent e) {
            int mx = e.getX();
            int my = e.getY();
            
        }
        
        public void mouseDragged(MouseEvent e) {
            int mx = e.getX();
            int my = e.getY();
            
            if (mx >= submit.x && mx <= submit.x+submit.width) {
                submit_ball_pos = mx;
            }
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
            
            for (int i = 0; i < 7*gap; i += gap) {
                EventHover[i/gap] = mx >= EventBase.x && mx <= EventBase.x+EventBase.width
                        && my >= EventBase.y+i && my <= EventBase.y+i+EventBase.height;
            }
            
        }
        
        public void mouseReleased (MouseEvent e) {
            int mx = e.getX();
            int my = e.getY();
             submit_processing = false;
            
            String temp;
            if (submit_ball_pos >= submit.x + submit.width) {
                if (setCycles && setName && setFirst_DueDay) {
                    //Event newEvent = null;
                    //pList.addEvent(newEvent);
                    cyclesString = "";
                    first_DueDayString = "yy/MM/dd HH:mm:ss";
                    nameString = "";
                    setCycles = false;
                    setFirst_DueDay = false;
                    setName = false;
                }
            }
            
            submit_ball_pos = submit.x;
            
            
            if (mx >= name.x && mx <= name.x+name.width
            &&  my >= name.y && my <= name.y+name.height && name_pressed) {
                temp = JOptionPane.showInputDialog(null, "ENTER EVENT NAME");
                if (temp != null) {
                    nameString = temp;
                    setName = true;
                }
            }
            
            if (mx >= cycles.x && mx <= cycles.x+cycles.width
            &&  my >= cycles.y && my <= cycles.y+cycles.height && cycles_pressed) {
                temp = JOptionPane.showInputDialog(null, "ENTER EVENT REPEAT TIMES");
                if (temp != null) {
                    cyclesString = temp;
                    setCycles = true;
                }
            }
            
            if (mx >= first_DueDay.x && mx <= first_DueDay.x+first_DueDay.width
            &&  my >= first_DueDay.y && my <= first_DueDay.y+first_DueDay.height && first_DueDay_pressed) {
                temp = JOptionPane.showInputDialog(null, "ENTER THE FIRST DUEDAY");
                if (temp != null) {
                    String format = "yy/MM/dd HH:mm:ss";
                    boolean invalid = (temp.length() != format.length()
                            || temp.charAt(2) != format.charAt(2)
                            || temp.charAt(5) != format.charAt(5)
                            || temp.charAt(8) != format.charAt(8)
                            || temp.charAt(11) != format.charAt(11)
                            || temp.charAt(14) != format.charAt(14));
                    first_DueDayString = temp;
                    setFirst_DueDay = true;
                }
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
                if (my <= submit.x + 2*submit.height) {
                    submit_processing = true;
                }
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
