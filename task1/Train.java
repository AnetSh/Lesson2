package lesson2.tasks.task1;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by IntelliJ IDEA.
 * User: Anet
 * Date: 06.04.16
 * Time: 15:25
 * Task 1
 * Class that contains data of train.
 */
@XmlRootElement(name="train")
public class Train {
    //12
    private int id;
    //Kiev
    private String from;
    //Lviv
    private String to;
    //19.12.2013
    private String date;
    //15:05
    private String departure;

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    @XmlElement
    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    @XmlElement
    public void setTo(String to) {
        this.to = to;
    }

    public String getDate() {
        return date;
    }

    @XmlElement
    public void setDate(String date) {
        this.date = date;
    }

    public String getDeparture() {
        return departure;
    }

    @XmlElement
    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public Train(int id, String from, String to, String date, String departure){
        this.id = id;
        this.from = from;
        this.to = to;
        this.date = date;
        this.departure=departure;
    }

    public Train(){ }

}
