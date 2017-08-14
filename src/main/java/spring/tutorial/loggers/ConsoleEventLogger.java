package spring.tutorial.loggers;

import spring.tutorial.bins.Event;
import spring.tutorial.interfaces.EventLogger;

class ConsoleEventLogger implements EventLogger{

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

  Event event;
  public void logEvent(String msg){
    System.out.println(event.toString());
  }
}
