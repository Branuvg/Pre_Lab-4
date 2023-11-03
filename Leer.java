import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Leer {
    
public static void LeerArchivo(List<Transaccion> transacciones){

    JSONParser jsonParser = new JSONParser();
    try (FileReader reader = new FileReader("prueba.json")) {
        JSONObject obj = (JSONObject) jsonParser.parse(reader);
        JSONArray Array = (JSONArray) obj.get("SpaceUVG");

        for(int i=0;i<Array.size();i++){
            JSONObject Tran = (JSONObject) Array.get(i);
            String usuario = (String) Tran.get("usuario");
            long id = (long) Tran.get("id");
            String publicKey = (String) Tran.get("public_key");
            double monto = (double) Tran.get("monto");
            long cuotas = (long) Tran.get("cuotas");
            long numeroDeTarjeta = (long) Tran.get("numero_de_tarjeta");
            long fechaDeVencimiento = (long) Tran.get("fecha_de_vencimiento");
            long codigoCVV = (long) Tran.get("codigo_CVV");
            Transaccion transaccion = new Transaccion(usuario, id, publicKey, monto, cuotas, numeroDeTarjeta, fechaDeVencimiento, codigoCVV);
            transacciones.add(transaccion);
        }
        
    System.out.println("que paso");

    } catch (IOException | ParseException e) {
        System.out.println("quie paso");
    }

}

}
