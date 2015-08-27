package datamanagement;


import java.io.FileWriter;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.jdom.JDOMException;

/**
 * The class controls access to the XML Datasource.
 *
 * @author Andrew Tobin
 * @since 2015-08-05
 */
public class XmlManager
{

    private final static XmlManager instance_ = new XmlManager();
    private Document document_;

    /**
     * Return singleton instance
     * @return
     */
    public static XmlManager getInstance() {
        return instance_;
    }



    /**
     * Class constructor
     */
    private XmlManager() {
        initializeDocument();
    }



    /**
     * Initialize the connection to the source document.
     */
    public void initializeDocument() {
        String documentFileName = AppProperties.getInstance()
                .getProperties().getProperty("XMLFILE");

        try {

            SAXBuilder builder = new SAXBuilder();
            builder.setExpandEntities(true);

            document_ = builder.build(documentFileName);
        }
        catch (JDOMException exception) {

            System.err.printf("%s",
                    "DBMD: XmlManager : initializeDocument : caught JDOMException\n");

            throw new RuntimeException(
                    "DBMD: XmlManager : initializeDocument : JDOMException");
        }
        catch (IOException exception) {

            System.err.printf("%s",
                    "DBMD: XmlManager : initializeDocument : caught IOException\n");

            throw new RuntimeException(
                    "DBMD: XmlManager : initializeDocument : IOException");
        }
    }



    /**
     * Get the current Xml Document
     * @return
     */
    public Document getDocument() {
        return document_;
    }



    /**
     * Save the current Xml Document
     */
    public void saveDocument() {
        String documentFileName = AppProperties.getInstance()
                .getProperties().getProperty("XMLFILE");

        try (FileWriter fileStream = new FileWriter(documentFileName)) {

            XMLOutputter outputFormatter =
                    new XMLOutputter(Format.getPrettyFormat());

            outputFormatter.output(document_, fileStream);

            fileStream.close();
        }
        catch (IOException exception) {

            System.err.printf("%s\n",
                    "DBMD : XmlManager : saveDocument : Error saving XML to "
                            + documentFileName);

            throw new RuntimeException(
                    "DBMD: XmlManager : saveDocument : error writing to file");
        }
    }
}