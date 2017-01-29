package duelist;


public class Event implements Comparable<Event> {
    private int eventRepeatTime;
    private Timer eventTimer;
    private String eventName;
    private EventPriority eventPriority;
    
    public Event(int repeat,String name,EventPriority P) {
        eventRepeatTime=repeat;
        eventName=name;
        eventPriority=P;
        
    }
    
 
    
    public void update() {
        eventTimer.update();
        if (this.TimeLeft() <= 0) {
            if (eventRepeatTime <= 0) {
                eventTimer.dueDayUpdate();
            }
        }
    }
    
    public String getEventName () {
        return this.eventName;
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