package datamanagement;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

import java.io.FileWriter;

import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.io.IOException;

import org.jdom.JDOMException;

public class XmlManager {

    private final static XmlManager instance_ = new XmlManager();
    private Document document_;

    public static XmlManager getInstance() {
        return instance_;
    }

    private XmlManager() {
        initializeDocument();
    }

    public void initializeDocument() {
        String documentFileName = AppProperties.getInstance().getProperties().getProperty("XMLFILE");

        try {

            SAXBuilder builder = new SAXBuilder();
            builder.setExpandEntities(true);

            document_ = builder.build(documentFileName);
        }
        catch (JDOMException e) {

            System.err.printf("%s", "DBMD: XmlManager : initializeDocument : caught JDOMException\n");

            throw new RuntimeException("DBMD: XmlManager : initializeDocument : JDOMException");
        }
        catch (IOException e) {

            System.err.printf("%s", "DBMD: XmlManager : initializeDocument : caught IOException\n");

            throw new RuntimeException("DBMD: XmlManager : initializeDocument : IOException");
        }
    }

    public Document getDocument() {
        return document_;
    }

    public void saveDocument() {
        String documentFileName = AppProperties.getInstance().getProperties().getProperty("XMLFILE");

        try (FileWriter fileStream = new FileWriter(documentFileName)) {

            XMLOutputter outputFormatter = new XMLOutputter(Format.getPrettyFormat());

            outputFormatter.output(document_, fileStream);

            fileStream.close();
        }
        catch (IOException ioe) {

            System.err.printf("%s\n", "DBMD : XmlManager : saveDocument : Error saving XML to " + documentFileName);

            throw new RuntimeException("DBMD: XmlManager : saveDocument : error writing to file");
        }
    }
}
