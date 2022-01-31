/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.chess.ui;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.SwingNode;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.swing.JPanel;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.batik.anim.dom.SAXSVGDocumentFactory;
import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.apache.batik.bridge.TextNode;

import org.apache.batik.dom.svg.SVGOMPoint;
import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.util.XMLResourceDescriptor;
import org.w3c.dom.*;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.svg.SVGPoint;
import pedro.ieslaencanta.com.chess.controller.Game;
import pedro.ieslaencanta.com.chess.model.Board;
import pedro.ieslaencanta.com.chess.model.ChessPiece.Piece;
import pedro.ieslaencanta.com.chess.model.ChessPiece.PieceType;
import pedro.ieslaencanta.com.chess.model.Move;
import pedro.ieslaencanta.com.chess.ui.piece.PieceUI;

/**
 *
 * @author Pedro
 */
public class Principal extends Application implements EventListener {

    JSVGCanvas canvas = null;
    Element seleccionado;
    Game game;
    BoardUI boardui;
    SVGPoint punto_origen, punto_destino;
    Document doc;
    SwingNode swingNode;
    Message msg;
    String blancas_id[][] = {
        {"RW", "rook_white.svg"},
        {"NW", "knight_white.svg"},
        {"BW", "bishop_white.svg"},
        {"KW", "king_white.svg"},
        {"QW", "queen_white.svg"},
        {"PW", "pawn_white.svg"},};
    String negras_id[][] = {
        {"RB", "rook_black.svg"},
        {"NB", "knight_black.svg"},
        {"BB", "bishop_black.svg"},
        {"KB", "king_black.svg"},
        {"QB", "queen_black.svg"},
        {"PB", "pawn_black.svg"},};
    PieceUI blancas[], negras[];
    private int width = 500;
    private int height = 500;
    private float escalax;
    private float escalay;
    private float anchocelda;
    private float altocelda;

    @Override
    public void start(Stage stage) throws Exception {
        this.seleccionado = null;
        this.game = new Game();
        swingNode = new SwingNode();

        this.blancas = new PieceUI[this.blancas_id.length];
        this.negras = new PieceUI[this.negras_id.length];
        this.anchocelda = (this.width / 8);
        this.altocelda = (this.height / 8);
        this.escalax = this.anchocelda / 45.0f;
        this.escalay = this.altocelda / 45.0f;
        this.initGame();
        this.msg = new Message("Jaque", 2000, this.doc);

        StackPane panel = new StackPane();
        panel.getChildren().add(swingNode);

        Scene scene = new Scene(panel, this.width, this.height);

        stage.setTitle("DAW Ajedrez");
        stage.setResizable(false);
        stage.setScene(scene);
        //para que cierre al pulsar el icono
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
        stage.show();

    }

    private Element createCSS() {
        Element style = doc.createElementNS(SVGDOMImplementation.SVG_NAMESPACE_URI, "style");
        style.setAttributeNS(null, "type", "text/css");
        ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(
                " .seleccionado {\n"
                + "           stroke: #006600;\n"
                + "           fill:   " + BoardUI.COLOR_SELECCIONADO + ";\n"
                + "        }\n"
                + " .opcion {\n"
                + "           stroke: #006600;\n"
                + "           fill:   " + "#0000FF" + ";\n"
                + "        }\n"
                + " .opcion_matar {\n"
                + "           stroke: #006600;\n"
                + "           fill:   " + BoardUI.COLOR_MATAR + ";\n"
                + "        }\n"
                + "\n"
                + " ");

        style.setTextContent(StandardCharsets.UTF_8.decode(byteBuffer).toString());
        return style;
    }

    private void getSVG() {
        /*try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            StreamResult sr = new StreamResult(new File("fichero salida"));
            Result output = new StreamResult(System.out);
            Source input = new DOMSource(doc);
            try {
                transformer.transform(input, output);
                transformer.transform(input, sr);
            } catch (TransformerException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    private void initGame() {
        this.canvas = new JSVGCanvas();
        DOMImplementation impl = SVGDOMImplementation.getDOMImplementation();
        String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
        String parser = XMLResourceDescriptor.getXMLParserClassName();
        SAXSVGDocumentFactory f = new SAXSVGDocumentFactory(parser);
        this.canvas.setDocumentState(JSVGCanvas.ALWAYS_DYNAMIC);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(this.canvas);
        this.canvas.setBounds(0, 0, this.width, this.height);
        doc = impl.createDocument(svgNS, "svg", null);
        this.canvas.setDocument(doc);
        this.boardui = new BoardUI(doc, this.width, this.height);
        Element svgRoot = doc.getDocumentElement();
        svgRoot.appendChild(createCSS());
        svgRoot.setAttributeNS(null, "width", String.valueOf(this.width));
        svgRoot.setAttributeNS(null, "height", String.valueOf(this.height));
        //svgRoot.appendChild(this.createBackound());
        EventTarget t = (EventTarget) this.boardui.getElement();
        t.addEventListener("click", this, false);
        svgRoot.appendChild(this.boardui.getElement());

        this.swingNode.setContent(panel);
        this.loadPieces();
        this.createPieceBoard();

        //this.getSVG();
    }

    private void seleccionarCelda(MouseEvent m) {
        Element element = (Element) m.getCurrentTarget();
        int f, c;
        Piece piece;
        f = (int) (m.getClientY() / this.altocelda);
        c = (int) (m.getClientX() / this.anchocelda);
        //si se ha pulsado sobre una figura y el turno es el correcto
        if (element.getAttribute("class").equals("figura")){
                //&& this.game.getPieceType(f, c) == this.game.getTurn()) {
            this.punto_origen = new SVGOMPoint();
            this.punto_origen.setX(c);
            this.punto_origen.setY(f);
            this.seleccionado = element;
            this.setClassCell((int) this.punto_origen.getY(), (int) this.punto_origen.getX(), "seleccionado");
            //se pintan los movimientos
            Move mvs[] = this.game.getMoves((int) punto_origen.getY(), (int) punto_origen.getX());
            for (int i = 0; mvs != null && i < mvs.length; i++) {
                if (mvs[i] != null) {
                    if (mvs[i].getReplaced() == null) {
                        this.setClassCell(mvs[i].getEnd().getRow(), mvs[i].getEnd().getCol(), "opcion");
                    } else {
                        this.setClassCell(mvs[i].getEnd().getRow(), mvs[i].getEnd().getCol(), "opcion_matar");
                    }

                }
            }
        }

    }
    public void moverCelda(MouseEvent m) {

        Move mvs[];
        String mensaje;
        Node n;
        Move[] mates;
        this.punto_destino = new SVGOMPoint();
        this.punto_destino.setX((int) (m.getClientX() / this.anchocelda));
        this.punto_destino.setY((int) (m.getClientY() / this.altocelda));
        //si los puntos no son los mismos
        if (this.punto_origen.getX() != this.punto_destino.getX() || this.punto_origen.getY() != this.punto_destino.getY()) {
            //se comprueba si es posible mover a la posicion
            if (this.game.canMove((int) this.punto_origen.getY(), (int) this.punto_origen.getX(), (int) this.punto_destino.getY(), (int) this.punto_destino.getX())) {
                //no es necesario volve a calcular
                mvs = this.game.getCalculatesMoves((int) punto_origen.getY(), (int) punto_origen.getX());

                //se quitan los seleccionados
                this.clearMoves(mvs);
                //se mueve
                Move mvt = this.game.move(
                        (int) this.punto_origen.getY(),
                        (int) this.punto_origen.getX(),
                        (int) this.punto_destino.getY(),
                        (int) this.punto_destino.getX());

                if (mvt != null && mvt.getReplaced() != null) {
                    n = this.doc.getElementById(mvt.getReplaced().toString());
                    this.doc.getDocumentElement().removeChild(n);
                    this.unsetClassCell((int) this.punto_origen.getY(), (int) this.punto_origen.getX());
                }
                mates = this.game.Jaque();
                //se produce un mate
                if (mates != null && mates.length > 0) {

                    //FALLA AQUÍ, CAMBIA LA POSICIÓN DEL REY
                    if (this.game.JaqueMate(PieceType.Black)) {
                        mensaje = "JAQUE MATE";
                        System.out.println("Se produce un jaque mate a las negras");
                    } else {
                        if (this.game.JaqueMate(PieceType.White)) {
                            mensaje = "JAQUE MATE";
                        } else {
                            mensaje = "JAQUE";

                        }
                    }
                    this.msg.setMsg(mensaje);
                    this.msg.start();
                }
                this.unsetClassCell((int) this.punto_origen.getY(), (int) this.punto_origen.getX());

                this.seleccionado.setAttributeNS(null, "transform", " translate(" + this.punto_destino.getX() * this.anchocelda + "," + this.punto_destino.getY() * this.altocelda + ") scale(" + this.escalax + " " + this.escalay + ")");
                this.seleccionado = null;

            }
        } else {
            mvs = this.game.getCalculatesMoves((int) punto_origen.getY(), (int) punto_origen.getX());
            this.clearMoves(mvs);
            this.unsetClassCell((int) this.punto_origen.getY(), (int) this.punto_origen.getX());
            this.seleccionado = null;

            //this.seleccionado.setAttributeNS(null, "transform", this.seleccionado.getAttributeNS(null, "transform"));
        }

    }

    private void clearMoves(Move[] mvs) {
        for (int i = 0; mvs != null && i < mvs.length; i++) {
            if (mvs[i] != null) {
                this.unsetClassCell(mvs[i].getEnd().getRow(), mvs[i].getEnd().getCol());

            }
        }
    }

    @Override
    public void handleEvent(Event event) {

        if (event instanceof MouseEvent) {
            if (this.seleccionado == null) {
                this.seleccionarCelda((MouseEvent) event);
            } else {
                this.moverCelda((MouseEvent) event);
            }
        }

    }

    private void setClassCell(int row, int col, String cssclass) {
        Element celda;
        celda = this.doc.getElementById("r" + row + "c" + col);
        if (celda != null) {
            celda.setAttributeNS(null, "class", cssclass);
        }

    }

    private void unsetClassCell(int row, int col) {
        Element celda;
        celda = this.doc.getElementById("r" + row + "c" + col);
        if (celda != null) {
            celda.setAttributeNS(null, "class", "");

        }
    }

    private PieceUI loadPiece(String file, String id, String transform, Point2D point) {
        PieceUI pieza = new PieceUI(file, id, transform, point);
        return pieza;
    }

    private void createPieceBoard() {
        EventTarget t;
        String name;
        Board b = this.game.getBoard();
        Element element = null;
        Piece tempo;

        for (int i = 0; i < b.getHeight(); i++) {
            for (int j = 0; j < b.getWidht(); j++) {
                if (b.getCell(i, j)!=null && b.getCell(i, j).getPiece() != null 
                        //para que se muestre
                        || i<2 || i>=6) {
                    //tempo = b.getCell(i, j).getPiece();
                    //name = tempo.getLetter() + (tempo.getType() == PieceType.White ? "W" : "B");
                    name="PB";
                    switch (name) {
                        case ("RW"):
                            element = (Element) this.blancas[0].getElement().cloneNode(true);
                            break;
                        case ("NW"):
                            element = (Element) this.blancas[1].getElement().cloneNode(true);
                            break;
                        case ("BW"):
                            element = (Element) this.blancas[2].getElement().cloneNode(true);
                            break;
                        case ("KW"):
                            element = (Element) this.blancas[3].getElement().cloneNode(true);
                            break;
                        case ("QW"):
                            element = (Element) this.blancas[4].getElement().cloneNode(true);
                            break;
                        case ("PW"):
                            element = (Element) this.blancas[5].getElement().cloneNode(true);
                            break;
                        case ("RB"):
                            element = (Element) this.negras[0].getElement().cloneNode(true);
                            break;
                        case ("NB"):
                            element = (Element) this.negras[1].getElement().cloneNode(true);
                            break;
                        case ("BB"):
                            element = (Element) this.negras[2].getElement().cloneNode(true);
                            break;
                        case ("KB"):
                            element = (Element) this.negras[3].getElement().cloneNode(true);
                            break;
                        case ("QB"):
                            element = (Element) this.negras[4].getElement().cloneNode(true);
                            break;
                        case ("PB"):
                            element = (Element) this.negras[5].getElement().cloneNode(true);
                            break;
                        default:
                            element = (Element) this.blancas[5].getElement().cloneNode(true);
                    }
                    //se asinga un id para poder tomal el valor 
                    //element.setAttributeNS(null, "id", tempo.getId());
                    element.setAttributeNS(null, "class", "figura");
                   // element.setAttributeNS(null, "transform", " translate(" + String.valueOf(this.anchocelda * b.getCell(i, j).getPosition().getCol()) + "," + String.valueOf(this.altocelda * b.getCell(i, j).getPosition().getRow()) + ")" + " " + element.getAttribute("transform"));
                   element.setAttributeNS(null, "transform", " translate(" + String.valueOf(this.anchocelda * j) + "," + String.valueOf(this.altocelda * i) + ")" + " " + element.getAttribute("transform"));
                     
                   t = (EventTarget) element;
                    t.addEventListener("click", this, false);

                    this.doc.getDocumentElement().appendChild(element);
                }
            }
        }
    }

    private void reset() {
        this.game.reset();
        //pendiente quitar los nodos
    }

    private void loadPieces() {
        EventTarget t;
        float fila = 0;
        float columna = 0;
        //se cargan las negras
        for (int i = 0; i < this.negras.length; i++) {

            this.negras[i] = this.loadPiece(this.negras_id[i][1], this.negras_id[i][0], "scale(" + this.escalax + " " + this.escalay + ")", new Point2D(columna, fila));
            this.negras[i].load(this.doc);
            this.negras[i].getElement().setAttributeNS(null, "class", "figura");

        }
        for (int i = 0; i < this.blancas.length; i++) {

            this.blancas[i] = this.loadPiece(this.blancas_id[i][1], this.blancas_id[i][0], "scale(" + this.escalax + " " + this.escalay + ")", new Point2D(columna, fila));
            this.blancas[i].load(this.doc);
            this.blancas[i].getElement().setAttributeNS(null, "class", "figura");

        }

    }

}
