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
        if (numEvent==0) {
        eventList [0]=e;
        } else if (numEvent==10) {
        return 0;
        }
        for (int i=0; i<numEvent;++i) {
            if (eventList[i].getPriority()>e.getPriority()) {
                for (int j=numEvent;j>=i;j++) {
                    eventList[j+1]=eventList[j];
                }
                eventList[i]=e;
                break;
            }
        }
        
        return 0;
    }
    
    public Event eventAt(int i) {
        return eventList[i];
    }
    
    public void delEvent(String name) {
        
        for (int i = 0;i < numEvent;i++) {
            if (eventList[i].getEventName()==name) {
                for (int j=i+1;j<numEvent; j++) {
                    eventList[j-1]=eventList[j];
                }
                numEvent--;
                break;
            }
        }
        //may be throw an error
    }
    
    //return the Event with the given stirng name, return null if not find
    public Event eventFind(String name) {
        for (int i = 0;i < numEvent;i++) {
            if (eventList[i].getEventName()==name) {
                return eventList[i];
            }
        }
        return null;
    }
    
    //when the event is expired or finished by the user,call this function to 
    //update the cycle
    public void finished(String name) {
        if (eventFind(name)==null) {return;}
        Event finish=eventFind(name);
        if (finish.getRepeat()<=1) {
            delEvent(name);
        } else {
            delEvent(name);
            finish.decRepeat();
            addEvent(finish);
        }
    }
    
    
    public void update(int index) {
        if (index>=0) {
            finished(eventList[index].getEventName());
        } else {
        
            for (int i = 0; i < numEvent; i++) {
                if (eventList[i].isExpired()) {
                    finished(eventList[i].getEventName());
                }
            }
        }
        
        //sorting by priority
        
        
    }
    
    
    
    
    
}