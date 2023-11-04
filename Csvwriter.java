import java.io.FileWriter;
import java.io.IOException;

public class Csvwriter {
    public static void escribirCsv(List<AmericanExpress> transacciones, String archivoCSV) {
        
        try (FileWriter writer = new FileWriter(archivoCSV);
             CSVWriter csvWriter = new CSVWriter(writer)) {

            String[] cabeceras = {"Usuario", "ID", "PublicKey", "Monto", "Cuotas", "NumeroDeTarjeta", "FechaDeVencimiento", "CodigoCVV"};

            // Escribir las cabeceras en el archivo CSV
            csvWriter.writeNext(cabeceras);

            // Recorrer la lista de transacciones y escribirlas en el archivo CSV
            for (AmericanExpress transaccion : transacciones) {
                String[] datos = {
                    transaccion.getUsuario(),
                    String.valueOf(transaccion.getId()),
                    transaccion.getPublicKey(),
                    String.valueOf(transaccion.getMonto()),
                    String.valueOf(transaccion.getCuotas()),
                    String.valueOf(transaccion.getNumeroDeTarjeta()),
                    String.valueOf(transaccion.getFechaDeVencimiento()),
                    transaccion.getCodigo()
                };

                csvWriter.writeNext(datos);
            }

            System.out.println("Datos de American Express guardados en el archivo CSV: " + archivoCSV);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
