package duelist;

import static java.util.Arrays.sort;

/**
 *
 * @author jimmy
 */
public class ProcessingList {
    private Event eventList [];
    private int maxEvent;
    private int numEvent;
    

    public ProcessingList() {
        eventList = new Event[10];
        maxEvent = 10;
        numEvent = 0;
    }
    
    public int addEvent(Event e) {
        if (numEvent < maxEvent) {
            eventList[numEvent] = e;
            numEvent++;
            return 1;
        }
        
        return 0;
    }
    
    public Event eventAt(int i) {
        return eventList[i];
    }
    
    public void delEvent(String name) {
        
    }
    
    public void update() {
        for (int i = 0; i < numEvent; i++) {
            if (eventList[i].isExpired()) {
                this.delEvent(eventList[i].getEventName());
            }
        }
        
        sort(eventList);
        
        //sorting by priority
        
        
    }
    
    
    
}