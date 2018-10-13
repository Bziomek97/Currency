package RepoCurrency.WebclientParse;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ParseFromXML implements InterfaceParse{

    @Override
    public ArrayList<String> Parse(){
        String Information = null;

        Webclient web = new Webclient();
        try {
            Information=web.RequireData(new URL("http://www.nbp.pl/kursy/xml/lasta.xml"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //parse
        ArrayList<String> CurrInformation= new ArrayList<>();
        DocumentBuilder builder = null;
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        InputSource src = new InputSource();
        if (Information != null) {
            src.setCharacterStream(new StringReader(Information));
        }

        Document doc = null;
        try {
            if (builder != null) {
                doc = builder.parse(src);
            }
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        assert doc != null;
        NodeList nList = doc.getElementsByTagName("pozycja");

        for (int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;
                CurrInformation.add(eElement.getElementsByTagName("nazwa_waluty").item(0).getTextContent());
                CurrInformation.add(eElement.getElementsByTagName("przelicznik").item(0).getTextContent());
                CurrInformation.add(eElement.getElementsByTagName("kod_waluty").item(0).getTextContent());
                CurrInformation.add(eElement.getElementsByTagName("kurs_sredni").item(0).getTextContent());

            }
        }

        return CurrInformation;
    }
}
