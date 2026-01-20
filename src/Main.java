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
                case 2:
                    comer();
                    break;
                case 3:
                    jugar();
                    break;
                case 4:
                    dormir();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
            }

        } while (opcion != 0);
    }

    // ===== MENÚ =====
    private static int menuPrincipal() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n1. Estado");
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
                System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (opcion < 0 || opcion > 4);

        return opcion;
    }

    // ===== OPCIÓN 1: ESTADO =====
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

    // ===== OPCIÓN 2: COMER =====
    private static void comer() {
        if (saciedad >= 10) {
            System.out.println("No tengo hambre");
        } else {
            saciedad += 3;
            if (saciedad > 10) {
                saciedad = 10;
            }
            diversion -= 1;
            if (diversion < 0) {
                diversion = 0;
            }
        }
        mostrarEstado();
    }

    // ===== OPCIÓN 3: JUGAR =====
    private static void jugar() {
        if (diversion >= 10) {
            System.out.println("Ahora no me apetece jugar");
        } else {
            diversion += 3;
            if (diversion > 10) {
                diversion = 10;
            }
            saciedad -= 1;
            energia -= 1;

            if (saciedad < 0) saciedad = 0;
            if (energia < 0) energia = 0;
        }
        mostrarEstado();
    }

    // ===== OPCIÓN 4: DORMIR =====
    private static void dormir() {
        if (energia >= 10) {
            System.out.println("No tengo sueño");
        } else {
            energia += 3;
            if (energia > 10) {
                energia = 10;
            }
            saciedad -= 3;
            diversion -= 2;

            if (saciedad < 0) saciedad = 0;
            if (diversion < 0) diversion = 0;
        }
        mostrarEstado();
    }
}
