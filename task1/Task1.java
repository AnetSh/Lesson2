package lesson2.tasks.task1;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.text.ParseException;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Anet
 * Date: 06.04.16
 * Time: 15:17
 * Task 1
 * Display the information from the XML about trains that depart today from 15:00 to 19:00.
 * Add new trains into existing XML.
 * This is class for reading the information from the file and adding new trains.
 */
public class Task1 {

    /**
     * Helper method. Can be deleted.
     * @param filename  Name of XML which contains trains.
     * @return List of trains
     * @throws JAXBException
     * @throws ParseException
     */
    public static Trains task1(String filename) throws JAXBException, ParseException {
        Trains timeTable;
        if(new File(filename).exists()){
            timeTable=readXML(filename);
        }   else {
            timeTable = new Trains();
            timeTable=addTrainXML(timeTable, filename);
        }
        Trains.checkConditionsOfTime(timeTable);
        return timeTable;
    }

    /**
     * Add new trains into existing XML.
     * @param timeTable List of trains
     * @param filename  Name of XML which contains trains.
     * @return List of trains
     * @throws JAXBException
     */
    public static Trains addTrainXML(Trains timeTable, String filename) throws JAXBException {
        timeTable.addTrainInTimeTable(newTrain());
        File file = new File(filename);
        JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(timeTable, file);
        return timeTable;
    }

    /**
     * Read the information about trains from the XML.
     * @param filename Name of XML which contains trains.
     * @return List of trains
     * @throws JAXBException
     */
    public static Trains readXML(String filename) throws JAXBException{
        File file = new File(filename);
        JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Trains timeTable = (Trains) jaxbUnmarshaller.unmarshal(file);
        Trains.addID(timeTable);
        return timeTable;
    }

    /**
     * Read the information of the new train from the console.
     * @return  New train
     */
    public static Train newTrain() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ID of train: ");
        int id=Integer.parseInt(sc.nextLine());
        System.out.println("From: ");
        String from = sc.nextLine();
        System.out.println("To: ");
        String to= sc.nextLine();
        System.out.println("Data: ");
        String data= sc.nextLine();
        System.out.println("Time: ");
        String time = sc.nextLine();
        return new Train(id, from, to, data, time);
    }
}
