package lesson2.tasks.task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: Anet
 * Date: 05.04.16
 * Time: 20:43
 * Task 2.
 * Pars data structure from the file "json".
 */
public class Task2 {

    /**
     * Creating an object based on JSON and data from the file.
     * @param filename Name of the file which contains the data.
     * @return Object of class Person after reading the data.
     * @throws Exception If an error occurred reading the file.
     */
    public static Person task2(String filename) throws Exception {
        String file = read(filename);
        Gson gson = new GsonBuilder().create();
        Person person = gson.fromJson(file, Person.class);
        return person;
    }

    /**
     * Read string from the file of the provided name.
     * @param filename Name of file from which string is to be read.
     * @return String from the file.
     * @throws IOException
     */
    public static String read(String filename) throws IOException {
        File file=new File(filename);
        FileReader reader = new FileReader(file);
        char[] buffer = new char[(int)file.length()];
        reader.read(buffer);
        return new String(buffer);
    }

    /**
     * Output data of object to the console.
     * @param person Object for extracting information.
     */
    public static void printDataPerson(Person person){
        System.out.println("Name: "+person.name);
        System.out.println("Surname: "+person.surname);
        System.out.println("Phones:");
        for (String phone : person.phones){
            System.out.println("   "+phone);
        }
        System.out.println("Sites:");
        for (String site : person.sites){
            System.out.println("   "+site);
        }
        System.out.println("Adress: "+person.address.country+", "+person.address.city+", "+person.address.street);
    }
}
