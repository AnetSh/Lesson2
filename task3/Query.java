package lesson2.tasks.task3;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Anet
 * Date: 06.04.16
 * Time: 21:45
 * Task 3
 */
@XmlRootElement(name="query")
public class Query {

    @XmlElement(name="results")
    private List<Results> results = new ArrayList<Results>();

    public Query(){}

}
