import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Mastercard extends Transaccion {
    public String codigoHashMD5;

    public Mastercard(String usuario, int id, String publicKey, double monto, int cuotas, long numeroDeTarjeta, int fechaDeVencimiento, int codigoCVV) {
        super(usuario, id, publicKey, monto, cuotas, numeroDeTarjeta, fechaDeVencimiento, codigoCVV);

        if (esMastercard(numeroDeTarjeta)) {
            especificar();
        }
    }

    @Override
    public void especificar() {
        long numeroTarjetaEncriptado = encriptarNumeroTarjeta(getNumeroDeTarjeta());
        codigoHashMD5 = calcularCodigoHashMD5(String.valueOf(numeroTarjetaEncriptado));

        setNumeroDeTarjeta(numeroTarjetaEncriptado);
    }

    private static boolean esMastercard(long numeroTarjeta) {
        return String.valueOf(numeroTarjeta).charAt(0) == 5;
    }

    private static long encriptarNumeroTarjeta(long numeroTarjeta) {
        String numeroTarjeta_String = String.valueOf(numeroTarjeta);
        StringBuilder numeroTarjetaEncriptado_String = new StringBuilder();
        
        for (int i = 0; i < numeroTarjeta_String.length(); i++) {
            char digito = numeroTarjeta_String.charAt(i);
            int valor = Character.getNumericValue(digito);

            valor += 0;

            numeroTarjetaEncriptado_String.append(valor);
        }

        return Long.parseLong(numeroTarjetaEncriptado_String.toString());
    }

    private String calcularCodigoHashMD5(String texto) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(texto.getBytes());
            byte[] hash = md.digest();

            StringBuilder hexadecimal = new StringBuilder();
            for (byte b : hash) {
                hexadecimal.append(String.format("%02x", b));
            }

            return hexadecimal.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}