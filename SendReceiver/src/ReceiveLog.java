import com.rabbitmq.client.*;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ReceiveLog {
    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] argv) throws java.lang.Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("10.3.50.39");
        factory.setUsername("radmin");
        factory.setPassword("radmin1");
        factory.setPort(5672);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
        String queueName = "Monitor";
        channel.queueBind(queueName, EXCHANGE_NAME, "");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {

                String xml = new String(body, "UTF-8");
                String message = null;
                try {
                    message = ConverterXML.getRootElement(xml);
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                }
                switch (message){
                    case "Event":
                        Event e = new Event();
                        Event u = null;
                        try {
                            u = e.convertToEvent(xml);
                        } catch (JAXBException ex) {
                            ex.printStackTrace();
                        }
                        System.out.println(u.toString());
                        break;
                    case "Bezoeker":
                        Bezoeker v = new Bezoeker();
                        Bezoeker o = null;
                        try {
                            o = v.convertToBezoeker(xml);
                        } catch (JAXBException ex) {
                            ex.printStackTrace();
                        }
                        System.out.println(o.toString());

                        break;
                    case "Exception":
                        Exception a = new Exception();
                        Exception s = null;
                        try {
                            s = a.convertToException(xml);
                        } catch (JAXBException ex) {
                            ex.printStackTrace();
                        }
                        System.out.println(s.toString());
                        break;
                    case "Reservatie":
                        Reservatie q = new Reservatie();
                        Reservatie d = null;
                        try {
                            d = q.convertToReservatie(xml);
                        } catch (JAXBException ex) {
                            ex.printStackTrace();
                        }
                        System.out.println(d.toString());
                        break;
                }
                //System.out.println(o.toString());
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }
}