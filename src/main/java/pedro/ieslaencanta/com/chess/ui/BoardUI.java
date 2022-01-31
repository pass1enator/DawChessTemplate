/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.chess.ui;

import javafx.geometry.Point2D;
import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.w3c.dom.*;

/**
 *
 * @author Pedro
 */
public class BoardUI {

    private Element element;
    public static String COLOR_NEGRAS="#aaaaaa";
    public static  String COLOR_BLANCAS="#FFFFFF";
    public static  String COLOR_SELECCIONADO="#00FF00";
    public static  String COLOR_POSIBLES="#222222";
    public static  String COLOR_MATAR="#770000";
    public BoardUI(Document doc, int board_width, int board_height) {
        Element rect = doc.createElementNS(SVGDOMImplementation.SVG_NAMESPACE_URI, "g");
        Element cell;
        rect.setAttributeNS(null, "x", "0");
         this.element = rect;
        float width = board_width / 8;
        float height = board_height / 8;
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cell = doc.createElementNS(SVGDOMImplementation.SVG_NAMESPACE_URI, "rect");
                cell.setAttributeNS(null, "x", String.valueOf(width * j));
                cell.setAttributeNS(null, "y", String.valueOf(height * i));
                cell.setAttributeNS(null, "width", String.valueOf(width));
                cell.setAttributeNS(null, "height", String.valueOf(height));

                cell.setAttributeNS(null, "id", ("r" + i + "c" + j));
              if (i % 2 != 0) {
                    if (j % 2 != 0) {
                        cell.setAttributeNS(null, "fill", BoardUI.COLOR_BLANCAS);
                    } else {
                        cell.setAttributeNS(null, "fill", BoardUI.COLOR_NEGRAS);
                    }
                } else {
                    if (j % 2 != 0) {
                        cell.setAttributeNS(null, "fill", BoardUI.COLOR_NEGRAS);
                    } else {
                        cell.setAttributeNS(null, "fill", BoardUI.COLOR_BLANCAS);
                    }
                }

                this.element.appendChild(cell);
            }
        }

    }

    /**
     * @return the element
     */
    public Element getElement() {
        return element;
    }

    /**
     * @param element the element to set
     */
    public void setElement(Element element) {
        this.element = element;
    }
}
