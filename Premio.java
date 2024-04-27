public class Premio {
    private String nombres;
    private int valorPuntos;
    private String id;
    
    public Premio() {
    }

    public Premio(String nombres, int valorPuntos, String id) {
        this.nombres = nombres;
        this.valorPuntos = valorPuntos;
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getValorPuntos() {
        return valorPuntos;
    }

    public void setValorPuntos(int valorPuntos) {
        this.valorPuntos = valorPuntos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}