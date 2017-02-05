package duelist;


public class Event implements Comparable<Event> {
    private int eventRepeatTime;
    private Timer eventTimer;
    private String eventName;
    private EventPriority eventPriority;
    private long priority;
    private String Duedate;
    
    //consturctor
    public Event(int repeat,String name,EventPriority P,String time) {
        eventRepeatTime=repeat;
        eventTimer= new Timer(time);
        eventName=name;
        eventPriority=P;
        priority=eventTimer.getMSeconds();
        Duedate=time;
    }
    
 
    
    public void update() {
        eventTimer.update();
        if (this.TimeLeft() <= 0) {
            
            eventTimer.dueDayUpdate();
            
        }
    }
    
    public void finished() {
    
    }
    
    public long getPriority() {
        return this.priority;
    }
    
    public String getEventName () {
        return this.eventName;
    }
    
    public Timer getTimer() {
        return eventTimer;
    }
    
    public int getRepeat() {
        return eventRepeatTime;
    }
    
    public void decRepeat() {
        eventRepeatTime--;
    }
    
    public String Duedate() {
        return Duedate;
    }
    
    public boolean isExpired() {
        this.update();
        return eventRepeatTime <= 0;
    }
    
    public long TimeLeft() {
        return eventTimer.getMSeconds();
    }
    
    
    
    

    @Override
    public int compareTo(Event t) {
        return (int)(this.TimeLeft() - t.TimeLeft());
    }
    
}