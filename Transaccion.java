public class Transaccion implements Especificacion{
    private String usuario;
    private long id;
    private String publicKey;
    private double monto;
    private long cuotas;
    private long numeroDeTarjeta;
    private long fechaDeVencimiento;
    private long codigoCVV;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public long getCuotas() {
        return cuotas;
    }

    public void setCuotas(long cuotas) {
        this.cuotas = cuotas;
    }

    public long getNumeroDeTarjeta() {
        return numeroDeTarjeta;
    }

    public void setNumeroDeTarjeta(long numeroDeTarjeta) {
        this.numeroDeTarjeta = numeroDeTarjeta;
    }

    public long getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    public void setFechaDeVencimiento(long fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    public long getCodigoCVV() {
        return codigoCVV;
    }

    public void setCodigoCVV(long codigoCVV) {
        this.codigoCVV = codigoCVV;
    }

    public Transaccion(String usuario, long id, String publicKey, double monto, long cuotas, long numeroDeTarjeta, long fechaDeVencimiento, long codigoCVV) {
        this.usuario = usuario;
        this.id = id;
        this.publicKey = publicKey;
        this.monto = monto;
        this.cuotas = cuotas;
        this.numeroDeTarjeta = numeroDeTarjeta;
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.codigoCVV = codigoCVV;
    }

    @Override
    public String toString() {
        return "usuario=" + getUsuario() + 
                ", id=" + getId() + 
                ", publicKey=" + getPublicKey() + 
                ", monto=" + getMonto() + 
                ", cuotas=" + getCuotas() + 
                ", numeroDeTarjeta=" + getNumeroDeTarjeta() + 
                ", fechaDeVencimiento=" + getFechaDeVencimiento() + 
                ", codigoCVV=" + getCodigoCVV();
    }

    @Override
    public void especificar() {
        // TODO Auto-generated method stub
    }

}