package BuenosAires.Herramientas;

import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.*;

public class XMLSerializer {
    public static void writeXMLFile(Object f, String filename) throws Exception{
        XMLEncoder encoder =
           new XMLEncoder(
              new BufferedOutputStream(
                new FileOutputStream(filename)));
        encoder.writeObject(f);
        encoder.close();
    }

    public static Object readXMLFile(String filename) throws Exception {
        XMLDecoder decoder =
            new XMLDecoder(new BufferedInputStream(
                new FileInputStream(filename)));
        Object o = (Object)decoder.readObject();
        decoder.close();
        return o;
    }
    
    public static String toXMLString(Object obj) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        XMLEncoder e = new XMLEncoder(baos);
        e.writeObject(obj);
        e.close();
        return new String(baos.toByteArray());
    }

    public static Object fromXMLString(String str) {
        XMLDecoder d = new XMLDecoder(new ByteArrayInputStream(str.getBytes()));
        Object obj = (Object) d.readObject();
        d.close();
        return obj;
    }
}