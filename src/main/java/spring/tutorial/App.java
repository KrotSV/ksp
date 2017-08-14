package spring.tutorial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.tutorial.bins.Client;
import spring.tutorial.bins.Event;
import spring.tutorial.interfaces.EventLogger;

public class App {
  private Client client;
  private EventLogger eventLogger;

  public App(Client client, EventLogger logger) {
    this.client = client;
    this.eventLogger = logger;
  }

  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    App app = (App) ctx.getBean("app");
    Event event =  ctx.getBean(Event.class);

    app.logEvent(event, "some event for 3");
    app.logEvent(event, "some event for 1");
  }

  private void logEvent(Event event, String msg){
    String message = msg.replaceAll(client.getId(), client.getFullName());
    event.setMsg(message);
    eventLogger.logEvent(event);
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public EventLogger getEventLogger() {
    return eventLogger;
  }

  public void setEventLogger(EventLogger eventLogger) {
    this.eventLogger = eventLogger;
  }
}
