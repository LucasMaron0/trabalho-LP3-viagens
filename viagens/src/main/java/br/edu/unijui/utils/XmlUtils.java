package br.edu.unijui.utils;

import br.edu.unijui.model.Passageiro;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XmlUtils {
    
    public static String objectToXml(Object object) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writeValueAsString(object);
            return xml;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }       
    }

    
    public static Passageiro xmlToObject(File file){
        try{
            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.readValue(file, Passageiro.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }     
    }

}
