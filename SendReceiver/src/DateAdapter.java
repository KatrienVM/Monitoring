import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

//https://stackoverflow.com/questions/2519432/jaxb-unmarshal-timestamp?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
public class DateAdapter extends XmlAdapter<String, Date> {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String marshal(Date v) throws java.lang.Exception {
        return dateFormat.format(v);
    }

    @Override
    public Date unmarshal(String v) throws java.lang.Exception {
        return dateFormat.parse(v);
    }

}