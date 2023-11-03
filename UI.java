import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    
    public static void main(String[] args) {
        List<Transaccion> transacciones = new ArrayList<>();
        Leer.LeerArchivo(transacciones);

        System.out.println(transacciones);

        //Scanner scanner = new Scanner(System.in);

    }
}