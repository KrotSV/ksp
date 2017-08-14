package spring.tutorial.bins;

import java.text.DateFormat;
import java.util.Date;

public class Event {
  private int id;
  private String msg;
  private Date date;
  private DateFormat df;

  public String toString(){
    return "id: " + id + "; msg: " + msg + "; Date: " + df.format(date);
  }

  public Event(Date date, DateFormat df) {
    this.date = date;
    this.df = df;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
}
