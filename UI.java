import java.util.List;
import java.util.ArrayList;

public class UI {
    
    public static void main(String[] args) {
        List<Transaccion> transacciones = new ArrayList<>();
        XMLwriter xmLwriter = new XMLwriter();
        List<Transaccion> transaccionesVisa = new ArrayList<>();

        Leer.LeerArchivo(transacciones);
        System.out.println(transacciones + "\n \n");


for (Transaccion transaccion : transacciones) {
    if (String.valueOf(transaccion.getNumeroDeTarjeta()).charAt(0) =='4' ){ //factible cambiar por if transaccion instanceof Visa 
        // Agregar la transacción Visa a la lista
        transaccionesVisa.add(transaccion);
    } 
}
// Llamar al método escribir solo una vez con las transacciones de Visa
xmLwriter.escribir(transaccionesVisa);

    }
}
