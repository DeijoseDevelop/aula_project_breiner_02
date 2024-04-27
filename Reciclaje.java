
public class Reciclaje {
    private String fecha;
    private String nroDocumento;
    private int cantidad;
    private int puntosReciclaje;
    private String[] detalleReciclaje;
    private int nda;

    public Reciclaje() {}

    public Reciclaje(String fecha, String nroDocumento, int cantidad) {
        this.fecha = fecha;
        this.nroDocumento = nroDocumento;
        this.cantidad = cantidad;
        this.detalleReciclaje = new String[cantidad];
    }

    public Reciclaje(
        String fecha,
        String nroDocumento,
        int cantidad,
        int puntosReciclaje,
        int nda
    ) {
        this.fecha = fecha;
        this.nroDocumento = nroDocumento;
        this.cantidad = cantidad;
        this.puntosReciclaje = puntosReciclaje;
        this.detalleReciclaje = new String[cantidad];
        this.nda = nda;
    }

    public void agregarDetalleReciclaje(String detalle, int index){
        if (this.detalleReciclaje.length < 5 && index < 5) {
            this.detalleReciclaje[index] = detalle;
        }
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPuntosReciclaje() {
        return puntosReciclaje;
    }

    public void setPuntosReciclaje(int puntosReciclaje) {
        this.puntosReciclaje = puntosReciclaje;
    }

    public String[] getDetalleReciclaje() {
        return detalleReciclaje;
    }

    public void setDetalleReciclaje(String[] detalleReciclaje) {
        this.detalleReciclaje = detalleReciclaje;
    }

    public int getNda() {
        return nda;
    }

    public void setNda(int nda) {
        this.nda = nda;
    }

    
}
