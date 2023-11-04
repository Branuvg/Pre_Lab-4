public class Visa extends Transaccion {

    public Visa(String usuario, long id, String publicKey, double monto, long cuotas, long numeroDeTarjeta,
                long fechaDeVencimiento, long codigoCVV) {
        super(usuario, id, publicKey, monto, cuotas, numeroDeTarjeta, fechaDeVencimiento, codigoCVV);

        // Realizar cálculos adicionales específicos para Visa en el constructor
        if (esVisa(numeroDeTarjeta)) {
            especificar(); // Llamamos al método especificar para realizar los cálculos adicionales
        }
    }

    @Override
    public void especificar() {
        // Implementa aquí los cálculos adicionales de IVA, comisiones u otros cálculos específicos de Visa
        double comision = getMonto() * 0.05;
        double iva = comision * 0.12;
        double montoConComision = getMonto() + comision + iva;
        setMonto(montoConComision);
    }

    public static boolean esVisa(long numeroDeTarjeta) {
        // Verificar si el primer dígito es 4 
        return String.valueOf(numeroDeTarjeta).charAt(0) == '4';
    }
}
