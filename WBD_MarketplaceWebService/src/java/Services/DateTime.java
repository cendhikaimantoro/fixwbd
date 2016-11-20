/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS-A451LB
 */

@XmlRootElement(name = "DateTime")
public class DateTime {
  @XmlElement(name="timestamp", required=true)
  public Timestamp timestamp;
  @XmlElement(name="second", required=true)
  public int second;
  @XmlElement(name="minute", required=true)
  public int minute;
  @XmlElement(name="hour", required=true)
  public int hour;
  @XmlElement(name="date", required=true)
  public int date;
  @XmlElement(name="weekday", required=true)
  public int weekday;
  @XmlElement(name="month", required=true)
  public int month;
  @XmlElement(name="year", required=true)
  public int year;
  
  public DateTime() {
    this.timestamp = null;
    this.second = 0;
    this.minute = 0;
    this.hour = 0;
    this.weekday = 0;
    this.date = 0;
    this.month = 0;
    this.year = 0;
  }
  
  public DateTime(Timestamp timestamp) {
    
    long ts = timestamp.getTime();
    Calendar cal = Calendar.getInstance();
    cal.setTimeInMillis(ts);
    
    this.timestamp = timestamp;
    this.second = cal.get(Calendar.SECOND);
    this.minute = cal.get(Calendar.MINUTE);
    this.hour = cal.get(Calendar.HOUR);
    this.weekday = cal.get(Calendar.DAY_OF_WEEK);
    this.date = cal.get(Calendar.DAY_OF_WEEK);
    this.month = cal.get(Calendar.MONTH);
    this.year = cal.get(Calendar.YEAR);
  }
}
