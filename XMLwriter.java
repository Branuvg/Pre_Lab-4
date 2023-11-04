import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class XMLwriter implements Escritor {
    @Override
public void escribir(List<Transaccion> transacciones) {
    try {
        // Crear un documento XML con una raíz llamada "transacciones"
        Element root = new Element("transacciones");
        Document doc = new Document(root);

        // Agregar cada transacción Visa como elemento "transaccion" al documento
        for (Transaccion transaccion : transacciones) {
            if (String.valueOf(transaccion.getNumeroDeTarjeta()).charAt(0) =='4' ){
                // Agregar la transacción Visa a la lista
                Element transaccionElement = new Element("transaccion");
                transaccionElement.addContent(new Element("usuario").setText(transaccion.getUsuario()));
                transaccionElement.addContent(new Element("id").setText(String.valueOf(transaccion.getId())));
                transaccionElement.addContent(new Element("public_key").setText(transaccion.getPublicKey()));
                transaccionElement.addContent(new Element("monto").setText(String.valueOf(transaccion.getMonto())));
                // Agregar más elementos según tus datos
        
                root.addContent(transaccionElement);
            } 
        }

        // Crear un objeto XMLOutputter para escribir el documento a un archivo
        XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.setFormat(Format.getPrettyFormat());

        // Escribir el documento a un archivo llamado "transacciones.xml"
        File archivoXML = new File("transacciones.xml");
        FileWriter writer = new FileWriter(archivoXML);
        xmlOutput.output(doc, writer);
        writer.close();

        System.out.println("Archivo XML generado exitosamente: transacciones.xml");
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
