/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.chess.ui.piece;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Point2D;
import org.apache.batik.anim.dom.SAXSVGDocumentFactory;
import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.apache.batik.util.XMLResourceDescriptor;
import org.w3c.dom.*;

/**
 *
 * @author Pedro
 */
public class PieceUI {

    private String url;
    private Element element;
    private String id;
    private String defaulttransform;
    private Point2D punto;

    public PieceUI() {
        this.url = null;
        this.element = null;
        this.id = null;
        this.defaulttransform = null;
        this.punto = new Point2D(0, 0);
    }

    public PieceUI(String namefile, String id, String defaulttransform, Point2D coordenada) {

        this.punto = coordenada;
        this.setUrl(namefile);
        this.setId(id);
        this.setDefaulttransform(" translate("+this.punto.getX()+","+this.punto.getY()+")"+defaulttransform);
    }

    /**
     * Carga la imagen de resources a partir
     */
    public void load(Document doc) {
        ClassLoader classLoader = getClass().getClassLoader();

        try {
            String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
            String parser = XMLResourceDescriptor.getXMLParserClassName();
            SAXSVGDocumentFactory f = new SAXSVGDocumentFactory(parser);

            Document tempodoc;
            
            Node n;
            URL u = classLoader.getResource(this.url);//getClass().getClassLoader().getResource( this.url);
            url = u.toString();
            tempodoc = f.createDocument(url);
            n = tempodoc.getElementsByTagName("g").item(0);

            //n.setAttributeNS(null, "transform", " scale(0.22) translate(70)");
            element = (Element) doc.importNode(n, true);
            element.setAttribute("id", this.getId());
            element.setAttribute("transform", this.getDefaulttransform());
        } catch (IOException ex) {
            Logger.getLogger(PieceUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return the element
     */
    public Element getElement() {
        return element;
    }

    /**
     * @return the defaulttransform
     */
    public String getDefaulttransform() {
        return defaulttransform;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @param element the element to set
     */
    public void setElement(Element element) {
        this.element = element;
    }

    /**
     * @param defaulttransform the defaulttransform to set
     */
    public void setDefaulttransform(String defaulttransform) {
        this.defaulttransform = defaulttransform;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the punto
     */
    public Point2D getPunto() {
        return punto;
    }

    /**
     * @param punto the punto to set
     */
    public void setPunto(Point2D punto) {
        this.punto = punto;
    }

}
