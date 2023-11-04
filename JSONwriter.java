import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONwriter implements Escritor {
    @Override
    public void escribir(List<Transaccion> transacciones) {
        try {
            // Crear un objeto JSON para almacenar las transacciones Mastercard
            JSONObject jsonTransacciones = new JSONObject();

            // Crear un arreglo JSON para las transacciones
            JSONArray transaccionesArray = new JSONArray();

            // Agregar cada transacción Mastercard al arreglo JSON
            for (Transaccion transaccion : transacciones) {
                if (transaccion instanceof Mastercard) {
                    // Crear un objeto JSON para representar la transacción
                    JSONObject jsonTransaccion = new JSONObject();
                    jsonTransaccion.put("usuario", transaccion.getUsuario());
                    jsonTransaccion.put("id", transaccion.getId());
                    jsonTransaccion.put("public_key", transaccion.getPublicKey());
                    jsonTransaccion.put("monto", transaccion.getMonto());
                    // Agregar más atributos según tus datos

                    // Agregar la transacción al arreglo JSON
                    transaccionesArray.add(jsonTransaccion);
                }
            }

            // Agregar el arreglo de transacciones al objeto JSON principal
            jsonTransacciones.put("transacciones", transaccionesArray);

            // Escribir el objeto JSON en un archivo
            try (FileWriter writer = new FileWriter("transacciones.json")) {
                writer.write(jsonTransacciones.toJSONString());
            }

            System.out.println("Archivo JSON generado exitosamente: transacciones.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
