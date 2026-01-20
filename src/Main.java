import java.util.Scanner;

public class Main {

    static int saciedad = 6;
    static int energia = 6;
    static int diversion = 6;

    public static void main(String[] args) {
        int opcion;

        do {
            opcion = menuPrincipal();

            switch (opcion) {
                case 1:
                    mostrarEstado();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción aún no implementada.");
            }

        } while (opcion != 0);
    }

    private static int menuPrincipal() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Estado");
            System.out.println("2. Comer");
            System.out.println("3. Jugar");
            System.out.println("4. Dormir");
            System.out.println("----------------");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción del menú: ");

            while (!sc.hasNextInt()) {
                System.out.println("Opción no válida. Introduce un número.");
                sc.next();
                System.out.print("Seleccione una opción del menú: ");
            }

            opcion = sc.nextInt();

            if (opcion < 0 || opcion > 4) {
                System.out.println("Opción no válida. Inténtelo de nuevo.\n");
            }

        } while (opcion < 0 || opcion > 4);

        return opcion;
    }

    private static void mostrarEstado() {

        System.out.println("\n--- ESTADO DEL TAMAGOTCHI ---");

        if (saciedad == 0 || energia == 0 || diversion == 0) {
            System.out.println("FIN DEL JUEGO");
            return;
        }

        if (saciedad > 5 && energia > 5 && diversion > 5) {
            System.out.println("CONTENTO");
        }
        else if (diversion <= 4) {
            System.out.println("TRISTE");
        }
        else if (energia <= 4) {
            System.out.println("CANSADO");
        }
        else if (saciedad <= 4) {
            System.out.println("HAMBRIENTO");
        }

        System.out.println("Saciedad: " + saciedad);
        System.out.println("Energía: " + energia);
        System.out.println("Diversión: " + diversion);
    }
}
