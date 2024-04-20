public class Residuo {
    private String codigo;
    private String material;
    private String objeto;
    private int puntos;

    public Residuo() {}

    public Residuo(String codigo, String material, String objeto, int puntos) {
        this.codigo = codigo;
        this.material = material;
        this.objeto = objeto;
        this.puntos = puntos;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getMaterial() {
        return this.material;
    }

    public int getPuntos() {
        return this.puntos;
    }

    public String getObjeto() {
        return this.objeto;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
