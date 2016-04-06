package lesson2.tasks.task1;

import lesson2.examples.example2.Book;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Anet
 * Date: 06.04.16
 * Time: 15:22
 * Task 1. Class that contains list of trains.
 */
@XmlRootElement(name="trains")
public class Trains {

    //List contains id of existing trains
    private static HashSet<Integer> idOfExistedTrains;

    @XmlElement(name="train")
    private List<Train> timeTable = new ArrayList<Train>();

    public Trains(){
        idOfExistedTrains = new HashSet<>();
    }

    /**
     * If ID of a new train isn't listed in idOfExistedTrains, then it's added to the XML
     * @param train New train
     */
    public void addTrainInTimeTable(Train train){
        if(!idOfExistedTrains.contains(train.getId())){
            timeTable.add(train);
            idOfExistedTrains.add(train.getId());
        }
    }

    /**
     * Reading information from the file, numbers are saved in the list to keep track of uniqueness.
     * @param trains List of train
     */
    public static void addID(Trains trains) {
        for (Train train : trains.timeTable){
            if(!idOfExistedTrains.contains(train.getId())){
                idOfExistedTrains.add(train.getId());
            }
        }
    }

    /**
     * Output data about all trains on the console.
     * @param trains List of train
     */
    public static void printData(Trains trains){
        for (Train train : trains.timeTable){
            System.out.println("ID: "+ train.getId());
            System.out.println("Path: "+ train.getFrom()+" - "+train.getTo());
            System.out.println("Time: "+ train.getDeparture()+" "+ train.getDate());
        }
        System.out.println();
    }

    /**
     * Checking the conditions of time. Type
     * Print information of trains that depart today from 15 to 19.
     * @param trains List of train
     * @throws ParseException
     */
    public static void checkConditionsOfTime (Trains trains) throws ParseException {
        Date today=new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm dd.MM.yyyy");
        String templateDay="dd.MM.yyyy";
        DateFormat formatDay=new SimpleDateFormat(templateDay);
        for (Train train : trains.timeTable){
            Date dataTrain=format.parse(train.getDeparture()+" "+train.getDate());
            if(formatDay.format(today).equals(train.getDate())){
                Date firstLine=format.parse("14:59 "+formatDay.format(today));
                Date secondLine=format.parse("19:01 "+formatDay.format(today));
                if(firstLine.before(dataTrain)){
                    if(secondLine.after(dataTrain)){
                        System.out.println("ID: "+ train.getId());
                        System.out.println("Path: "+ train.getFrom()+" - "+train.getTo());
                        System.out.println("Time: "+ train.getDeparture()+" "+ train.getDate());
                    }
                }
            }

        }
    }
}
