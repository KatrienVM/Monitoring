import javax.xml.bind.annotation.XmlElement;


public class Adres{
    private String straat;
    private int huisnummer;
    private int postcode;
    private String stad;
    private String land;

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public int getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(int huisnummer) {
        this.huisnummer = huisnummer;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "straat='" + straat + '\'' +
                ", huisnummer=" + huisnummer +
                ", postcode=" + postcode +
                ", stad='" + stad + '\'' +
                ", land='" + land + '\'' +
                '}';
    }
}

