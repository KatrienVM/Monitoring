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

@XmlRootElement(name="Bezoeker")
@XmlAccessorType(XmlAccessType.FIELD)
public class Bezoeker {
    @XmlElement
    private String UUIDBezoeker;
    @XmlElement
    private String UUIDEvent;
    @XmlElement
    private boolean isStudent;
    @XmlElement
    private String voornaam;
    @XmlElement
    private String achternaam;
    @XmlElement
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date geboortedatum;
    @XmlElement
    private Adres adres;
    @XmlElement
    private String email;
    @XmlElement
    private int telefoonnummer;
    @XmlElement
    private boolean isActif;
    @XmlElement
    private boolean IsAangemeld;
    @XmlElement
    private boolean magAankopenDoen;
    @XmlElement
    private boolean InkomBetaald;
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

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(int telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public boolean isActif() {
        return isActif;
    }

    public void setActif(boolean actif) {
        isActif = actif;
    }

    public boolean isAangemeld() {
        return IsAangemeld;
    }

    public void setAangemeld(boolean aangemeld) {
        IsAangemeld = aangemeld;
    }

    public boolean isMagAankopenDoen() {
        return magAankopenDoen;
    }

    public void setMagAankopenDoen(boolean magAankopenDoen) {
        magAankopenDoen = magAankopenDoen;
    }

    public boolean isInkomBetaald() {
        return InkomBetaald;
    }

    public void setInkomBetaald(boolean inkomBetaald) {
        InkomBetaald = inkomBetaald;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    //Convert from string
    public Bezoeker convertToBezoeker(String xml) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Bezoeker.class);
        Unmarshaller u = jc.createUnmarshaller();
        StringReader reader = new StringReader(xml);
        Bezoeker b = (Bezoeker) u.unmarshal(reader);
        return b;
    }
    //Covert from input file
    public Bezoeker convertToBezoeker(FileInputStream xml) throws JAXBException {
        InputStream is = xml;
        JAXBContext jc = JAXBContext.newInstance(Bezoeker.class);
        Unmarshaller u = jc.createUnmarshaller();
        Bezoeker b = (Bezoeker) u.unmarshal(is);
        return b;
    }

    @Override
    public String toString() {
        return "Bezoeker{" +
                "UUIDBezoeker='" + UUIDBezoeker + '\'' +
                ", UUIDEvent='" + UUIDEvent + '\'' +
                ", isStudent=" + isStudent +
                ", voornaam='" + voornaam + '\'' +
                ", achternaam='" + achternaam + '\'' +
                ", geboortedatum='" + geboortedatum + '\'' +
                ", adres=" + adres +
                ", email='" + email + '\'' +
                ", telefoonnummer=" + telefoonnummer +
                ", isActif=" + isActif +
                ", IsAangemeld=" + IsAangemeld +
                ", MagAankopenDoen=" + magAankopenDoen +
                ", InkomBetaald=" + InkomBetaald +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}

