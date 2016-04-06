package lesson2.tasks.task3;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by IntelliJ IDEA.
 * User: Anet
 * Date: 06.04.16
 * Time: 22:00
 * Task3
 */
@XmlRootElement(name="rate")
public class Rate {

    public String Name;

    public String Rate;

    public String Date;

    public String Time;

    public String Ask;

    public String Bid;

    public Rate(){}

}
