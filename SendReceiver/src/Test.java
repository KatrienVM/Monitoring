import org.json.JSONObject;

import javax.xml.bind.JAXBException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] argv) throws JAXBException, FileNotFoundException {
        FileInputStream fis = new FileInputStream("../SendReceiver/Bezoeker.xml");
        FileInputStream fis2 = new FileInputStream("../SendReceiver/Event.xml");
        FileInputStream fis3 = new FileInputStream("../SendReceiver/Exception.xml");
        FileInputStream fis4 = new FileInputStream("../SendReceiver/Reservatie.xml");

        Bezoeker v = new Bezoeker();
        Bezoeker o = v.convertToBezoeker(fis);
        Event e = new Event();
        Event u = e.convertToEvent(fis2);
        Exception ex = new Exception();
        Exception ux = ex.convertToException(fis3);
        Reservatie res = new Reservatie();
        Reservatie r = res.convertToReservatie(fis4);

        if( o != null){
            System.out.println("Success");
            System.out.println(o.toString());
            System.out.println(u.toString());
            System.out.println(ux.toString());
            System.out.println(r.toString());
        }
        else{
            System.out.println("Fail");
        }


    }
}