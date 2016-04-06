package lesson2.tasks.task3;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Anet
 * Date: 06.04.16
 * Time: 21:58
 * Task 3
 */
@XmlRootElement(name="results")
public class Results {

    @XmlElement(name="rate")
    private List<Rate> rate = new ArrayList<Rate>();

    public Results(){}
}
