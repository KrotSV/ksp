package spring.tutorial.loggers;

import spring.tutorial.bins.Event;
import spring.tutorial.interfaces.EventLogger;

class ConsoleEventLogger implements EventLogger{

  Event event;

  public ConsoleEventLogger() {
  }

  public ConsoleEventLogger(Event event) {

    this.event = event;
  }

  public Event getEvent() {

    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }

  public void logEvent(Event event){
    System.out.println(event.toString());
  }


}
