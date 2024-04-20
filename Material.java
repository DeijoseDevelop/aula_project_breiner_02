import java.util.Scanner;

public class Material {
    static int op, ob, canti, suma;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        menu_principal();
        do {
            try {

                System.out.println("Digite la opcion");
                op = entrada.nextInt();
                switch (op) {
                    case 1:
                        menu_papel();
                        System.out.println("Digite el objeto ");
                        ob = entrada.nextInt();
                        switch (ob) {
                            case 1:
                                System.out.println("Cuantos hojas o preriodico esta reciclando");
                                canti = entrada.nextInt();
                                suma = canti * 1;
                                break;
                            case 2:
                                System.out.println("Cuantos libros o cuadernos esta reciclando");
                                canti = entrada.nextInt();
                                suma = canti * 3;
                                break;
                            case 3:
                                System.out.println("Cuantas cajas esta reciclando");
                                canti = entrada.nextInt();
                                suma = canti * 3;
                                break;
                        }
                        break;
                    case 2:
                        menu_plastico();
                        System.out.println("Digite el objeto ");
                        ob = entrada.nextInt();
                        switch (ob) {
                            case 1:
                                System.out.println("Cuantas botellas esta reciclando");
                                canti = entrada.nextInt();
                                suma = canti * 3;
                                break;
                            case 2:
                                System.out.println("Cuantas tapas esta reciclando");
                                canti = entrada.nextInt();
                                suma = canti * 2;
                                break;
                            case 3:
                                System.out.println("Cuantas embolturas esta reciclando");
                                canti = entrada.nextInt();
                                suma = canti * 1;
                                break;
                        }

                        break;
                    case 3:
                        menu_vidrio();
                        System.out.println("Digite el objeto ");
                        ob = entrada.nextInt();
                        switch (ob) {
                            case 1:
                                System.out.println("Cuantas botellas esta reciclando");
                                canti = entrada.nextInt();
                                suma = canti * 3;
                                break;
                            case 2:
                                System.out.println("Cuantos frascos esta reciclando");
                                canti = entrada.nextInt();
                                suma = canti * 3;
                                break;
                        }
                }
            } catch (Exception e) {
                System.out.println("Error: Ingrese una opcion valida");
                entrada.next();
            }
        } while (op != 5);
        entrada.close();
    }

    public static void menu_principal() {
        System.out.println("--------Material reciclado--------");
        System.out.println("1.Papel o carton");
        System.out.println("2.Plastico");
        System.out.println("3.Vidrio");
        System.out.println("4.Aluminio");
    }

    public static void menu_papel() {
        System.out.println("-----Papel o carton-----");
        System.out.println("1.Periodico o hojas");
        System.out.println("2.Cuadernos o libros");
        System.out.println("3.Cajas");
    }

    public static void menu_plastico() {
        System.out.println("-----Plasticos-----");
        System.out.println("1.Botellas");
        System.out.println("2.Tapas");
        System.out.println("3.Embolturas o polipropileno");
    }

    public static void menu_vidrio() {
        System.out.println("-----Vidrios-----");
        System.out.println("1.Botellas");
        System.out.println("2.Frascos");
    }

}