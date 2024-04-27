import java.util.Scanner;

public class Principal {
    static Scanner entrada = new Scanner(System.in);
    static final int elementos = 5;
    static Premio[] premios = new Premio[elementos];
    static Premio premio;
    static Estudiante[] estudiantes = new Estudiante[elementos];
    static Estudiante estudiante = new Estudiante();
    static Residuo[] residuos = new Residuo[elementos];
    static Reciclaje[] reciclajes = new Reciclaje[elementos];
    static Reciclaje reciclaje;
    static final String fecha = "21/11/2023";
    static int op, opCrub, ne = 2, pos, opEst, nr = 2, nrc = 1, nda = 0, opRerecicla, canti, contador, np = 1, opPremi;
    static String documento, codigo;

    public static void main(String[] args) {
        estudiante = new Estudiante(
            "1234",
            "Loaiza",
            "Isabel",
            "Contadutia"
        );
        estudiantes[0] = estudiante;

        estudiante = new Estudiante(
            "4567",
            "Salazar",
            "Sara",
            "Medicina"
        );
        estudiantes[1] = estudiante;

        Residuo residuo1 = new Residuo(
            "A101",
            "Plastico",
            "Botella",
            4
        );
        residuos[0] = residuo1;

        Residuo residuo2 = new Residuo(
            "A102",
            "Carton",
            "Caja",
            3
        );
        residuos[1] = residuo2;

        reciclaje = new Reciclaje(
            fecha,
            "4567",
            5,
            7,
            2
        );
        reciclaje.agregarDetalleReciclaje("A101", 0);
        reciclaje.agregarDetalleReciclaje("A102", 1);
        reciclajes[0] = reciclaje;

        premio = new Premio(
            "Combo",
            50,
            "P101"
        );
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
                        reciclar();
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
                                System.out.println("Digite el apellido ");
                                String apellidoT = entrada.next();
                                System.out.println("Digite el nombre ");
                                String nombreT = entrada.next();
                                System.out.println("Digite el programa academico ");
                                String programaT = entrada.next();
                                estudiante = new Estudiante(
                                    documento,
                                    apellidoT,
                                    nombreT,
                                    programaT
                                );
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
                            Estudiante student = estudiantes[pos];
                            switch (opCrub) {
                                case 1:
                                    System.out.println("Digite el nuevo apellido");
                                    student.setApellido(entrada.next());
                                    break;
                                case 2:
                                    System.out.println("Digite el nuevo nombre");
                                    student.setNombres(entrada.next());
                                    break;
                                case 3:
                                    System.out.println("Digite la nuevo programa acdemico");
                                    student.setProgramaAcademico(entrada.next());
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
                            System.out.println("Digite el material del residuo");
                            String material = entrada.next();

                            System.out.println("Digite el objeto");
                            String objeto = entrada.next();

                            System.out.println("Digite la cantidad de puntos");
                            int puntos = entrada.nextInt();

                            Residuo residuo = new Residuo(
                                codigo,
                                material,
                                objeto,
                                puntos
                            );
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

                        Residuo residuoActual = residuos[pos];
                        switch (opCrub) {
                            case 1:
                                System.out.println("Digite el nuevo material");
                                residuoActual.setMaterial(entrada.next());
                                break;
                            case 2:
                                System.out.println("Digite el nuevo objeto");
                                residuoActual.setObjeto(entrada.next());
                                break;
                            case 3:
                                System.out.println("Digite la nueva cantidad de puntos");
                                residuoActual.setPuntos(entrada.nextInt());

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
            Residuo residuoActual = residuos[i];
            System.out.println(residuoActual.getCodigo() + "\t\t" + residuoActual.getMaterial() + "\t\t" + residuoActual.getObjeto() + "\t\t"
                    + residuoActual.getPuntos());
        }
    }

    public static int consultarResiduo(String codigoAsignatura) {
        int posicion = -1;
        for (int i = 0; i < nr; i++) {
            if (residuos[i].getCodigo().equals(codigoAsignatura)) {
                posicion = i;
            }
        }
        return posicion;
    }

    public static void mostrarResiduos(String codigoAsignatura) {
        for (int i = 0; i < nr; i++) {
            Residuo residuoActual = residuos[i];
            if (residuoActual.getCodigo().equals(codigoAsignatura)) {
                System.out.println("-------------------------------------");
                System.out.println("               Residuos              ");
                System.out.println("--------------------------------------");
                System.out.println("Codigo      Material       Objeto      Puntos");
                System.out.println(residuoActual.getCodigo() + "\t" + residuoActual.getMaterial() + "\t " + residuoActual.getObjeto()
                        + "\t\t" + residuoActual.getPuntos());

            }
        }
    }

    public static void mostarEstudiantes(int posicion_estu) {
        System.out.println("------------------------------------");
        System.out.println("     Informacion del estudiante     ");
        System.out.println("------------------------------------");
        System.out.println("Numero de documento : " + estudiantes[posicion_estu].getNroDocumento());
        System.out.println("Apellido            : " + estudiantes[posicion_estu].getApellido());
        System.out.println("Nombre              : " + estudiantes[posicion_estu].getNombres());
        System.out.println("Programa            : " + estudiantes[posicion_estu].getProgramaAcademico());

    }

    public static int consultarEstudiante(String cedula) {
        int posicion = -1;
        for (int i = 0; i < ne; i++) {
            if (estudiantes[i].getNroDocumento().equals(cedula)) {
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
            System.out.println("    " + estudiantes[i].getNroDocumento() + "      " + estudiantes[i].getApellido() + "      "
                    + estudiantes[i].getNombres() + "       " + estudiantes[i].getProgramaAcademico());
        }
    }

    public static void reciclar() {
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
                            reciclaje = new Reciclaje(
                                fecha,
                                documento,
                                5
                            );
                            do {
                                listar_Residuo();
                                System.out.println("Digite el codigo del residuos que estas reciclando");
                                codigo = entrada.next();
                                pos = consultarResiduo(codigo);
                                if (pos > -1) {
                                    System.out.println("Digita la cantidad");
                                    canti = entrada.nextInt();
                                    contador = (residuos[pos].getPuntos() * canti);
                                    reciclaje.setPuntosReciclaje(reciclaje.getPuntosReciclaje() + contador);
                                    reciclaje.agregarDetalleReciclaje(codigo, nda);
                                    nda = nda + 1;
                                }
                                System.out.println("¿Algun otro objeto por reciclar? si(1) no(2)");
                                opRerecicla = entrada.nextInt();
                            } while (opRerecicla == 1);
                            reciclaje.setNda(nda);
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
                    reciclajes[i].getFecha() + "\t\t" + reciclajes[i].getNroDocumento() + "\t\t" + reciclajes[i].getPuntosReciclaje());
            System.out.println();
            System.out.println("----Residuos reciclados-----");
            System.out.println();
            for (int j = 0; j < reciclajes[i].getNda(); j++) {
                mostrarResiduos(reciclajes[i].getDetalleReciclaje()[j]);
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
                            premio.setId(codigo);
                            System.out.println("Digite el nombre del premio");
                            premio.setNombres(entrada.next());
                            System.out.println("Digite la cantidad de puntos que se necesitan");
                            premio.setValorPuntos(entrada.nextInt());
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
                                premios[pos].setNombres(entrada.next());
                                break;
                            case 2:
                                System.out.println("Digite el nuevo valor de puntos");
                                premios[pos].setValorPuntos(entrada.nextInt());
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
            System.out.println(premios[i].getId() + "\t\t" + premios[i].getNombres() + "\t\t" + premios[i].getValorPuntos());
        }
    }

    public static int consultarPremio(String codigoPremio) {
        int posicion = -1;
        for (int i = 0; i < np; i++) {
            if (premios[i].getId().equals(codigoPremio)) {
                posicion = i;
            }
        }
        return posicion;
    }

    public static void mostrarPremio(String codigoPremio) {
        for (int i = 0; i < np; i++) {
            if (premios[i].getId().equals(codigoPremio)) {
                System.out.println("-------------------------------------");
                System.out.println("               Residuos              ");
                System.out.println("--------------------------------------");
                System.out.println("Id         Nombre       Valor en Puntos");
                System.out.println(premios[i].getId() + "\t\t" + premios[i].getNombres() + "\t\t " + premios[i].getValorPuntos());

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
