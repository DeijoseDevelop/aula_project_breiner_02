import java.util.Scanner;

public class Principal {
    static Scanner entrada = new Scanner(System.in);
    static final int elementos = 5;
    static Premio[] premios = new Premio[elementos];
    static Premio premio;
    static Estudiante[] estudiantes = new Estudiante[elementos];
    static Estudiante estudiante = new Estudiante();
    static Residuo[] residuos = new Residuo[elementos];
    static Residuo residuo;
    static Reciclaje[] reciclajes = new Reciclaje[elementos];
    static Reciclaje reciclaje;
    static final String fecha = "21/11/2023";
    static int op, opCrub, ne = 2, pos, opEst, nr = 2, nrc = 1, nda = 0, opRerecicla, canti, contador, np = 1, opPremi;
    static String documento, codigo;

    public static void main(String[] args) {
        estudiante = new Estudiante();
        estudiante.nombres = "Isabel";
        estudiante.apellido = "Loaiza";
        estudiante.programaAcademico = "Contadutia";
        estudiante.nroDocumento = "1234";
        estudiantes[0] = estudiante;

        estudiante = new Estudiante();
        estudiante.nombres = "Sara";
        estudiante.apellido = "Salazar";
        estudiante.programaAcademico = "Medicina";
        estudiante.nroDocumento = "4567";
        estudiantes[1] = estudiante;

        residuo = new Residuo();
        residuo.codigo = "A101";
        residuo.material = "Plastico";
        residuo.objeto = "Botella";
        residuo.puntos = 4;
        residuos[0] = residuo;

        residuo = new Residuo();
        residuo.codigo = "A102";
        residuo.material = "Carton";
        residuo.objeto = "Caja";
        residuo.puntos = 3;
        residuos[1] = residuo;

        reciclaje = new Reciclaje();
        reciclaje.nrodocumento = "4567";
        reciclaje.fecha = fecha;
        reciclaje.detalle_reciclaje[0] = "A101";
        reciclaje.detalle_reciclaje[1] = "A102";
        reciclaje.puntosreciclaje = 7;
        reciclaje.nda = 2;
        reciclajes[0] = reciclaje;

        premio = new Premio();
        premio.id = "P101";
        premio.nombres = "Combo";
        premio.valor_puntos = 50;
        premios[0] = premio;

        do {
            try {
                limpiarPantalla();
                menu_principal();
                System.out.println("Digite la opcion");
                op = entrada.nextInt();
                switch (op) {
                    case 1:
                        Gestionar_estudiantes();
                        pausa();
                        break;
                    case 2:
                        Getionar_residuos();
                        pausa();

                        break;
                    case 3:
                        Gestionar_premio();
                        pausa();
                        break;
                    case 4:
                        Reciclaje();
                        pausa();

                }
            } catch (Exception e) {
                System.out.println("Error: Ingrese una opcion valida");
                entrada.next();
                pausa();
            }

        } while (op >= 1 && op < 5 || false);
        System.out.println("Gracias por utilizar el sofware");

    }

    public static void Gestionar_estudiantes() {
        do {

            limpiarPantalla();
            System.out.println("-----Gestion de estudiantes-----\n");
            menu_crub();
            try {
                System.out.println("Digite la opcion");
                opCrub = entrada.nextInt();
                switch (opCrub) {
                    case 1:
                        if (ne < elementos) {
                            System.out.println("Digite el documento: ");
                            documento = entrada.next();
                            pos = consultarEstudiante(documento);
                            if (pos == -1) {
                                estudiante = new Estudiante();
                                estudiante.nroDocumento = documento;
                                System.out.println("Digite el apellido ");
                                estudiante.apellido = entrada.next();
                                System.out.println("Digite el nombre ");
                                estudiante.nombres = entrada.next();
                                System.out.println("Digite el programa academico ");
                                estudiante.programaAcademico = entrada.next();
                                estudiantes[ne] = estudiante;
                                System.out.println("Registro con exito");
                                ne++;

                            } else {
                                System.out.println("El estudiante ya esta registrado");
                                pausa();
                            }

                        } else {
                            System.out.println("No se puede agregar estudiantes");
                            pausa();
                        }
                        pausa();
                        break;
                    case 2:
                        listar_Estudiantes();
                        pausa();
                        break;
                    case 3:
                        System.out.println("Digite el documento");
                        documento = entrada.next();
                        pos = consultarEstudiante(documento);
                        if (pos == -1) {
                            System.out.println("No se encuentra registrado");
                            pausa();
                        } else {
                            mostarEstudiantes(pos);
                            System.out.println("¿Que campo desea modificar?");
                            System.out.println("1.Apellido");
                            System.out.println("2.Nombre");
                            System.out.println("3.Carrera");
                            opCrub = entrada.nextInt();
                            switch (opCrub) {
                                case 1:
                                    System.out.println("Digite el nuevo apellido");
                                    estudiantes[pos].apellido = entrada.next();
                                    break;
                                case 2:
                                    System.out.println("Digite el nuevo nombre");
                                    estudiantes[pos].nombres = entrada.next();
                                    break;
                                case 3:
                                    System.out.println("Digite la nuevo programa acdemico");
                                    estudiantes[pos].programaAcademico = entrada.next();
                                    break;
                            }
                            System.out.println("Los datos fueron actualizados correctamente");
                            mostarEstudiantes(pos);
                        }
                        pausa();
                        break;
                    case 4:
                        System.out.println("Digite el documento");
                        documento = entrada.next();
                        pos = consultarEstudiante(documento);
                        if (pos == -1) {
                            System.out.println("No se encuentra registrado");
                            pausa();
                        } else {
                            mostarEstudiantes(pos);
                            System.out.println("¿Esta seguro que desea eliminar al estudiante (1.si) (2.No) ? ");
                            opEst = entrada.nextInt();
                            if (opEst == 1) {
                                for (int i = 0; i <= ne + 1; i++) {
                                    estudiantes[pos] = estudiantes[pos + 1];
                                }
                                ne = ne - 1;
                                System.out.println("El registro fue eliminado");
                            }
                        }
                        pausa();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: Ingrese una opcion valida");
                entrada.next();
            }

        } while (opCrub != 5);

    }

    public static void Getionar_residuos() {
        do {
            limpiarPantalla();
            System.out.println("-----Gestion de residuos-----\n");
            menu_crub();
            System.out.println("Digite la opcion");
            opCrub = entrada.nextInt();
            switch (opCrub) {
                case 1:
                    if (ne < elementos) {
                        System.out.println("Digite el codigo del residuo: ");
                        codigo = entrada.next();
                        pos = consultarResiduo(codigo);
                        if (pos == -1) {
                            residuo = new Residuo();
                            residuo.codigo = codigo;
                            System.out.println("Digite el material del residuo");
                            residuo.material = entrada.next();
                            System.out.println("Digite el objeto");
                            residuo.objeto = entrada.next();
                            System.out.println("Digite la cantidad de puntos");
                            residuo.puntos = entrada.nextInt();
                            residuos[nr] = residuo;
                            nr++;
                            System.out.println("Registro con exito");

                        } else {
                            System.out.println("El residuo ya esta registrado");
                            pausa();
                        }

                    } else {
                        System.out.println("No se puede agregar mas residuos");
                        pausa();
                    }
                    pausa();
                    break;
                case 2:
                    listar_Residuo();
                    pausa();
                    break;
                case 3:
                    System.out.println("Digite el codigo");
                    codigo = entrada.next();
                    pos = consultarResiduo(codigo);
                    if (pos == -1) {
                        System.out.println("No se encuentra registrado este residuo");
                        pausa();
                    } else {
                        mostrarResiduos(codigo);
                        System.out.println("¿Que campo desea modificar?");
                        System.out.println("1.Material");
                        System.out.println("2.Objeto");
                        System.out.println("3.Puntos");
                        opCrub = entrada.nextInt();
                        switch (opCrub) {
                            case 1:
                                System.out.println("Digite el nuevo material");
                                residuos[pos].material = entrada.next();
                                break;
                            case 2:
                                System.out.println("Digite el nuevo objeto");
                                residuos[pos].objeto = entrada.next();
                                break;
                            case 3:
                                System.out.println("Digite la nueva cantidad de puntos");
                                residuos[pos].puntos = entrada.nextInt();

                        }
                        System.out.println("Los datos fueron actualizados correctamente");
                        mostrarResiduos(codigo);
                    }
                    pausa();
                    break;
                case 4:
                    System.out.println("Digite el codigo");
                    codigo = entrada.next();
                    pos = consultarResiduo(codigo);
                    if (pos == -1) {
                        System.out.println("No se encuentra registrado");
                        pausa();
                    } else {
                        mostrarResiduos(codigo);
                        System.out.println("¿Esta seguro que desea eliminar este residuo (1.si) (2.No) ? ");
                        opEst = entrada.nextInt();
                        if (opEst == 1) {
                            for (int i = 0; i <= ne + 1; i++) {
                                residuos[pos] = residuos[pos + 1];
                            }
                            nr = nr - 1;
                            System.out.println("La asignatura fue eliminada");
                        }
                    }
                    pausa();
                    break;
            }
        } while (opCrub != 5);
    }

    public static void listar_Residuo() {
        System.out.println("             Listado de Residuos            ");
        System.out.println("-----------------------------------------------");
        System.out.println("     Codigo     Material    Objeto     Puntos");
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < nr; i++) {
            System.out.println(residuos[i].codigo + "\t\t" + residuos[i].material + "\t\t" + residuos[i].objeto + "\t\t"
                    + residuos[i].puntos);
        }
    }

    public static int consultarResiduo(String codigoAsignatura) {
        int posicion = -1;
        for (int i = 0; i < nr; i++) {
            if (residuos[i].codigo.equals(codigoAsignatura)) {
                posicion = i;
            }
        }
        return posicion;
    }

    public static void mostrarResiduos(String codigoAsignatura) {
        for (int i = 0; i < nr; i++) {
            if (residuos[i].codigo.equals(codigoAsignatura)) {
                System.out.println("-------------------------------------");
                System.out.println("               Residuos              ");
                System.out.println("--------------------------------------");
                System.out.println("Codigo      Material       Objeto      Puntos");
                System.out.println(residuos[i].codigo + "\t" + residuos[i].material + "\t " + residuos[i].objeto
                        + "\t\t" + residuos[i].puntos);

            }
        }
    }

    public static void mostarEstudiantes(int posicion_estu) {
        System.out.println("------------------------------------");
        System.out.println("     Informacion del estudiante     ");
        System.out.println("------------------------------------");
        System.out.println("Numero de documento : " + estudiantes[posicion_estu].nroDocumento);
        System.out.println("Apellido            : " + estudiantes[posicion_estu].apellido);
        System.out.println("Nombre              : " + estudiantes[posicion_estu].nombres);
        System.out.println("Programa            : " + estudiantes[posicion_estu].programaAcademico);

    }

    public static int consultarEstudiante(String cedula) {
        int posicion = -1;
        for (int i = 0; i < ne; i++) {
            if (estudiantes[i].nroDocumento.equals(cedula)) {
                posicion = i;

            }

        }
        return posicion;
    }

    public static void listar_Estudiantes() {
        System.out.println("             Listado de estudiantes            ");
        System.out.println("-----------------------------------------------");
        System.out.println("  Documento    Apellidos    Nombres    Programa");
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < ne; i++) {
            System.out.println("    " + estudiantes[i].nroDocumento + "      " + estudiantes[i].apellido + "      "
                    + estudiantes[i].nombres + "       " + estudiantes[i].programaAcademico);
        }
    }

    public static void Reciclaje() {
        do {
            limpiarPantalla();
            System.out.println();
            menu_reciclaje();
            System.out.println("Digite la opcion");
            opCrub = entrada.nextInt();
            switch (opCrub) {
                case 1:
                    if (nrc < elementos) {
                        System.out.println("Digite el documento del estudiante");
                        documento = entrada.next();
                        pos = consultarEstudiante(documento);
                        if (pos > -1) {
                            mostarEstudiantes(pos);
                            reciclaje = new Reciclaje();
                            reciclaje.fecha = fecha;
                            reciclaje.nrodocumento = documento;
                            do {
                                listar_Residuo();
                                System.out.println("Digite el codigo del residuos que estas reciclando");
                                codigo = entrada.next();
                                pos = consultarResiduo(codigo);
                                if (pos > -1) {
                                    System.out.println("Digita la cantidad");
                                    canti = entrada.nextInt();
                                    contador = (residuos[pos].puntos * canti);
                                    reciclaje.puntosreciclaje = (reciclaje.puntosreciclaje + contador);
                                    reciclaje.detalle_reciclaje[nda] = codigo;
                                    nda = nda + 1;
                                }
                                System.out.println("¿Algun otro objeto por reciclar? si(1) no(2)");
                                opRerecicla = entrada.nextInt();
                            } while (opRerecicla == 1);
                            reciclaje.nda = nda;
                            reciclajes[nrc] = reciclaje;
                            nrc = nrc + 1;
                            System.out.println("Guardado con exito");
                            pausa();
                        } else {
                            System.out.println("El residuo no esta registrado");
                            pausa();
                        }
                    } else {
                        System.out.println("El vector ya esta lleno no es posible dijitar mas");
                        pausa();
                    }
                case 2:
                    listarReciclaje();
                    pausa();
                    break;
            }
        } while (opCrub != 3);
    }

    public static void listarReciclaje() {
        System.out.println("                Listado de reciclaje             ");
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < nrc; i++) {
            System.out.println("Fecha            Documento         Puntos optenidos   ");
            System.out.println("--------------------------------------------------");
            System.out.println(
                    reciclajes[i].fecha + "\t\t" + reciclajes[i].nrodocumento + "\t\t" + reciclajes[i].puntosreciclaje);
            System.out.println();
            System.out.println("----Residuos reciclados-----");
            System.out.println();
            for (int j = 0; j < reciclajes[i].nda; j++) {
                mostrarResiduos(reciclajes[i].detalle_reciclaje[j]);
            }
            System.out.println();
        }
    }

    public static void Gestionar_premio() {
        do {
            limpiarPantalla();
            System.out.println("-----Gestion de premios-----\n");
            menu_crub();
            System.out.println("Digite la opcion");
            opCrub = entrada.nextInt();
            switch (opCrub) {
                case 1:
                    if (np < elementos) {
                        System.out.println("Digite el id del premio: ");
                        codigo = entrada.next();
                        pos = consultarPremio(codigo);
                        if (pos == -1) {
                            premio = new Premio();
                            premio.id = codigo;
                            System.out.println("Digite el nombre del premio");
                            premio.nombres = entrada.next();
                            System.out.println("Digite la cantidad de puntos que se necesitan");
                            premio.valor_puntos = entrada.nextInt();
                            premios[np] = premio;
                            np++;
                            System.out.println("Registro con exito");

                        } else {
                            System.out.println("El premio ya esta registrado");
                            pausa();
                        }

                    } else {
                        System.out.println("No se puede agregar mas premios");
                        pausa();
                    }
                    pausa();
                    break;
                case 2:
                    listar_Premio();
                    pausa();
                    break;
                case 3:
                    System.out.println("Digite el id del premio");
                    codigo = entrada.next();
                    pos = consultarPremio(codigo);
                    if (pos == -1) {
                        System.out.println("No se encuentra registrado este premio");
                        pausa();
                    } else {
                        mostrarPremio(codigo);
                        System.out.println("¿Que campo desea modificar?");
                        System.out.println("1.Nombre");
                        System.out.println("2.Valor del premios en puntos");
                        opCrub = entrada.nextInt();
                        switch (opCrub) {
                            case 1:
                                System.out.println("Digite el nuevo nombre");
                                premios[pos].nombres = entrada.next();
                                break;
                            case 2:
                                System.out.println("Digite el nuevo valor de puntos");
                                premios[pos].valor_puntos = entrada.nextInt();
                                break;
                        }
                        System.out.println("Los datos fueron actualizados correctamente");
                        mostrarPremio(codigo);
                    }
                    pausa();
                    break;
                case 4:
                    System.out.println("Digite el id");
                    codigo = entrada.next();
                    pos = consultarPremio(codigo);
                    if (pos == -1) {
                        System.out.println("No se encuentra registrado el premio");
                        pausa();
                    } else {
                        mostrarPremio(codigo);
                        System.out.println("¿Esta seguro que desea eliminar este premio (1.si) (2.No) ? ");
                        opPremi = entrada.nextInt();
                        if (opPremi == 1) {
                            for (int i = 0; i <= np + 1; i++) {
                                premios[pos] = premios[pos + 1];
                            }
                            np = np - 1;
                            System.out.println("El premio fue eliminado");
                        }
                    }
                    pausa();
                    break;
            }
        } while (opCrub != 5);
    }

    public static void listar_Premio() {
        System.out.println("              Listado de Premios             ");
        System.out.println("-----------------------------------------------");
        System.out.println("Id           Nombre         Valor en puntos   ");
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < np; i++) {
            System.out.println(premios[i].id + "\t\t" + premios[i].nombres + "\t\t" + premios[i].valor_puntos);
        }
    }

    public static int consultarPremio(String codigoPremio) {
        int posicion = -1;
        for (int i = 0; i < np; i++) {
            if (premios[i].id.equals(codigoPremio)) {
                posicion = i;
            }
        }
        return posicion;
    }

    public static void mostrarPremio(String codigoPremio) {
        for (int i = 0; i < np; i++) {
            if (premios[i].id.equals(codigoPremio)) {
                System.out.println("-------------------------------------");
                System.out.println("               Residuos              ");
                System.out.println("--------------------------------------");
                System.out.println("Id         Nombre       Valor en Puntos");
                System.out.println(premios[i].id + "\t\t" + premios[i].nombres + "\t\t " + premios[i].valor_puntos);

            }
        }
    }

    public static void menu_reciclaje() {
        System.out.println("     Menu reciclaje    ");
        System.out.println("1.Reciclar");
        System.out.println("2.Listado del reciclaje");
        System.out.println("3.Volver atras");
    }

    public static void menu_principal() {
        System.out.println("-------ECOFRIENLY COD------");
        System.out.println();
        System.out.println("     Menu principal     ");
        System.out.println("1. Gestion de estudiantes");
        System.out.println("2. Gestion de residuos");
        System.out.println("3. Gestion de premios");
        System.out.println("4. Reciclar");
        System.out.println("5. Salir");
        System.out.println();
    }

    public static void menu_crub() {
        System.out.println("1. Registrar");
        System.out.println("2. Listar");
        System.out.println("3. Modificar");
        System.out.println("4. Eliminar");
        System.out.println("5. Regresar al menu principal");
    }

    public static void limpiarPantalla() {
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
            Process startProcess = pb.inheritIO().start();
            startProcess.waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void pausa() {
        entrada.nextLine(); // Limpiamos buffer del System.in
        System.out.println("\t\nPresione enter para continuar...");
        entrada.nextLine(); // Ahora el programa se detiene hasta que se pulse ENTER
    }
}
