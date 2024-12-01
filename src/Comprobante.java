import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Comprobante {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nombre, apellido, email;
        int edad;
        LocalDate fecha = LocalDate.now();
        float[] precios = {0, 18900, 28900};

        String[] descripcion = {
                "Todos los planes:",
                "1. Plan Rookie: Plan básico. Incluye anuncios.",
                "2. Plan Élite: Sin anuncios y acceso a Lives.",
                "3. Plan Titán: Todo el Élite más entrenadores personalizados."
        };

        System.out.print("Digite su nombre: ");
        nombre = sc.nextLine();

        System.out.print("Digite su apellido: ");
        apellido = sc.nextLine();

        do {
            System.out.print("Indique su edad (Debe ser mayor de 18): ");
            while (!sc.hasNextInt()) {
                System.out.print("Por favor, ingrese un número válido para la edad: ");
                sc.next();
            }
            edad = sc.nextInt();
        } while (edad < 18);

        System.out.print("Correo: ");
        email = sc.next();

        while (!Pattern.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}", email)) {
            System.out.print("Por favor, ingresa un correo electrónico válido: ");
            email = sc.next();
        }

        System.out.println("\n¿Te gustaría ver los planes? (y/n)");
        String opcion = sc.next();

        if (opcion.equalsIgnoreCase("y")) {
            for (String plan : descripcion) {
                System.out.println(plan);
            }
            System.out.print("\n¿Qué plan deseas? (1, 2, 3): ");
            int seleccion = sc.nextInt();

            if (seleccion >= 1 && seleccion <= 3) {
                mostrarResumen(seleccion, precios[seleccion - 1], fecha, sc);
            } else {
                System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        } else {
            System.out.println("Gracias por tu atención, " + nombre + ". ¡Nos vemos!");
        }
    }

    public static void mostrarResumen(int plan, float precio, LocalDate fecha, Scanner sc) {
        System.out.println("\n/////////// FitJourney ///////////");
        System.out.println("RESUMEN DEL PAGO");
        System.out.println("Descripción de compra:");
        System.out.println("Depósito suscripción FitJourney - Plan " + plan);
        System.out.println("Estado de la transacción: En espera");
        System.out.println("Fecha de la transacción: " + fecha);
        int cus = (int) (Math.random() * 153350);
        System.out.println("CUS: " + cus);
        System.out.println("Valor a pagar: $ " + precio);
        int fdc = (int) (Math.random() * 11);
        System.out.println("Factura de comercio: " + fdc);

        System.out.println("\n1. Pagar");
        System.out.println("2. Cancelar");
        int pago = sc.nextInt();

        if (pago == 1) {
            System.out.println("Has pagado el Plan " + plan + ". ¡Gracias por tu compra!");
            System.out.println("Te enviaremos un mensaje a tu correo con toda la información.");
        } else if (pago == 2) {
            System.out.println("Gracias. Esperamos que pronto cambies de opinión.");
        } else {
            System.out.println("Opción inválida.");
        }
    }
}
