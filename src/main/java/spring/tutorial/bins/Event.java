package spring.tutorial.bins;

import sun.util.calendar.BaseCalendar.Date;

public class Event {
  private int id;
  private String msg;
  Date date;
  public String toString(){
    return "id: " + id + "; msg: " + msg + "; Date: " + date;
  }
}
