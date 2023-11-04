import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AmericanExpress extends Transaccion {
    
    //variable especifica para codificar el codigo de la tarjeta
    private String codigo;

    //constructor 
    public AmericanExpress(String usuario, long id, String publicKey, double monto, long cuotas, long numeroDeTarjeta,
            long fechaDeVencimiento, long codigoCVV, String codigo) {
        super(usuario, id, publicKey, monto, cuotas, numeroDeTarjeta, fechaDeVencimiento, codigoCVV);
        this.codigo = codigo;

        // Realizar cálculos adicionales específicos para Visa en el constructor
        if (esAmericanExpress(numeroDeTarjeta)) {
            especificar(); // Llamamos al método especificar para realizar los cálculos adicionales
        }
    }
    
    @Override
    public void especificar() {
        //realizar los cobros especificados de la tarjeta 
        double cobroCuotas;
        double totalMonto;
        
        //condicional para especificar el recargo
        if (getCuotas() > 0) {
            cobroCuotas = getMonto() * 0.15;
        } else {
            cobroCuotas = getMonto() * 0.07;
        }

        //cambiar dato
        totalMonto = getMonto() + cobroCuotas;
        setMonto(totalMonto);

        //codificar el numero de la tarjeta
        long entrada = getCodigoCVV();
        try {
            // Convertir el valor long a una cadena
            String cadenaLong = Long.toString(entrada);
            
            // Crear una instancia de MessageDigest para MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            // Calcular el hash MD5
            byte[] bytesHash = md.digest(cadenaLong.getBytes());
            
            // Convertir los bytes del hash a una representación hexadecimal
            StringBuilder cadenaHexadecimal = new StringBuilder();
            for (byte byteHash : bytesHash) {
                String hex = Integer.toHexString(0xff & byteHash);
                if (hex.length() == 1) {
                    cadenaHexadecimal.append('0');
                }
                cadenaHexadecimal.append(hex);
            }
            
            setCodigo(cadenaHexadecimal.toString());
        } catch (NoSuchAlgorithmException e) {
            // Manejar cualquier excepción
            e.printStackTrace();
            setCodigo("");
        }

    }
    
    public static boolean esAmericanExpress(long numeroDeTarjeta) {
        // Verificar si el primer dígito es 3
        return String.valueOf(numeroDeTarjeta).charAt(0) == '3';
    }

    // get y set del atributo especifico
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
