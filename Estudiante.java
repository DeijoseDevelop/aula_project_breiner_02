public class Estudiante {
    private String nroDocumento;
    private String apellido;
    private String nombres;
    private String programaAcademico;

    public Estudiante() {}

    public Estudiante(String nroDocumento, String apellido, String nombres, String programaAcademico) {
        this.nroDocumento = nroDocumento;
        this.apellido = apellido;
        this.nombres = nombres;
        this.programaAcademico = programaAcademico;
    }

    public String getNroDocumento() {
        return this.nroDocumento;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getNombres() {
        return this.nombres;
    }

    public String getProgramaAcademico() {
        return this.programaAcademico;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setProgramaAcademico(String programaAcademico) {
        this.programaAcademico = programaAcademico;
    }
}
