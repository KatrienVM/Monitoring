import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="Event")
@XmlAccessorType(XmlAccessType.FIELD)
public class Event {
    @XmlElement
    private String UUID;
    @XmlElement
    private String titel;
    @XmlElement
    private boolean beschrijving;
    @XmlElement
    private Adres adres;
    @XmlElement
    private double prijs;
    @XmlElement
    private int maxBezoekers;
    @XmlElement
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date begin;
    @XmlElement
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date einde;
    @XmlElement
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date timestamp;

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public boolean isBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(boolean beschrijving) {
        this.beschrijving = beschrijving;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public int getMaxBezoekers() {
        return maxBezoekers;
    }

    public void setMaxBezoekers(int maxBezoekers) {
        this.maxBezoekers = maxBezoekers;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEinde() {
        return einde;
    }

    public void setEinde(Date einde) {
        this.einde = einde;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    //Convert from string
    public Event convertToEvent(String xml) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Event.class);
        Unmarshaller u = jc.createUnmarshaller();
        StringReader reader = new StringReader(xml);
        Event e = (Event) u.unmarshal(reader);
        return e;
    }
    //Covert from input file
    public Event convertToEvent(FileInputStream xml) throws JAXBException {
        InputStream is = xml;
        JAXBContext jc = JAXBContext.newInstance(Event.class);
        Unmarshaller u = jc.createUnmarshaller();
        Event e = (Event) u.unmarshal(is);
        return e;
    }

    @Override
    public String toString() {
        return "Event{" +
                "UUID='" + UUID + '\'' +
                ", titel='" + titel + '\'' +
                ", beschrijving=" + beschrijving +
                ", adres=" + adres +
                ", prijs=" + prijs +
                ", maxBezoekers=" + maxBezoekers +
                ", begin=" + begin +
                ", einde=" + einde +
                ", timestamp=" + timestamp +
                '}';
    }

}


