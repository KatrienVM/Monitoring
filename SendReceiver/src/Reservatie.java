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

@XmlRootElement(name="Reservatie")
@XmlAccessorType(XmlAccessType.FIELD)
public class Reservatie {
    @XmlElement
    private String UUIDBezoeker;
    @XmlElement
    private String UUIDEvent;
    @XmlElement
    private String BetaalMethode;
    @XmlElement
    private Boolean InkomBetaald;
    @XmlElement
    private Boolean IsAanwezig;
    @XmlElement
    private Boolean IsActif;
    @XmlElement
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date timestamp;

    public String getUUIDBezoeker() {
        return UUIDBezoeker;
    }

    public void setUUIDBezoeker(String UUIDBezoeker) {
        this.UUIDBezoeker = UUIDBezoeker;
    }

    public String getUUIDEvent() {
        return UUIDEvent;
    }

    public void setUUIDEvent(String UUIDEvent) {
        this.UUIDEvent = UUIDEvent;
    }

    public String getBetaalMethode() {
        return BetaalMethode;
    }

    public void setBetaalMethode(String betaalMethode) {
        BetaalMethode = betaalMethode;
    }

    public Boolean getInkomBetaald() {
        return InkomBetaald;
    }

    public void setInkomBetaald(Boolean inkomBetaald) {
        InkomBetaald = inkomBetaald;
    }

    public Boolean getAanwezig() {
        return IsAanwezig;
    }

    public void setAanwezig(Boolean aanwezig) {
        IsAanwezig = aanwezig;
    }

    public Boolean getActif() {
        return IsActif;
    }
    public void setActif(Boolean actif) {
        IsActif = actif;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date getTimestamp() {
        return timestamp;
    }
    //convert from String
    public Reservatie convertToReservatie(String xml) throws JAXBException{
        JAXBContext jc = JAXBContext.newInstance(Reservatie.class);
        Unmarshaller u = jc.createUnmarshaller();
        StringReader reader = new StringReader(xml);
        Reservatie r = (Reservatie) u.unmarshal(reader);
        return r;
    }

    //convert from input file
    public Reservatie convertToReservatie(FileInputStream xml) throws JAXBException{
        InputStream is = xml;
        JAXBContext jc = JAXBContext.newInstance(Reservatie.class);
        Unmarshaller u = jc.createUnmarshaller();
        Reservatie r = (Reservatie) u.unmarshal(is);
        return r;
    }

    @Override
    public String toString() {
        return "Reservatie{" +
                "UUIDBezoeker='" + UUIDBezoeker + '\'' +
                ", UUIDEvent='" + UUIDEvent + '\'' +
                ", BetaalMethode=" + BetaalMethode +
                ", InkomBetaald='" + InkomBetaald + '\'' +
                ", IsAanwezig='" + IsAanwezig + '\'' +
                ", IsActif='" + IsActif + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}