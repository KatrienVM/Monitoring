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

@XmlRootElement(name="Exception")
@XmlAccessorType(XmlAccessType.FIELD)
public class Exception {
    @XmlElement
    private String ErrorCode;
    @XmlElement
    private String ApplicationEvent;
    @XmlElement
    private String ErrorMessage;
    @XmlElement
    private  String SourceID;
    @XmlElement
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date timestamp;

    public String getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(String errorCode) {
        ErrorCode = errorCode;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    public String getApplicationEvent() {
        return ApplicationEvent;
    }

    public void setApplicationEvent(String applicationEvent) {
        ApplicationEvent = applicationEvent;
    }

    public String getSourceID() {
        return SourceID;
    }

    public void setSourceID(String sourceID) {
        SourceID = sourceID;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    //convert from String
    public Exception convertToException(String xml) throws JAXBException{
        JAXBContext jc = JAXBContext.newInstance(Exception.class);
        Unmarshaller u = jc.createUnmarshaller();
        StringReader reader = new StringReader(xml);
        Exception e = (Exception) u.unmarshal(reader);
        return e;
    }
    //convert from input file
    public Exception convertToException(FileInputStream xml) throws JAXBException{
        InputStream is = xml;
        JAXBContext jc = JAXBContext.newInstance(Exception.class);
        Unmarshaller u = jc.createUnmarshaller();
        Exception e = (Exception) u.unmarshal(is);
        return e;
    }

    @Override
    public String toString() {
        return "Exception{" +
                "ErrorCode='" + ErrorCode + '\'' +
                ", ApplicationEvent='" + ApplicationEvent + '\'' +
                ", ErrorMessage=" + ErrorMessage +
                ", SourceID='" + SourceID + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }



}