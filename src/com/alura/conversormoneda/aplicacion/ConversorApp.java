package com.alura.conversormoneda.aplicacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConversorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0; // Variable para controlar la elección del usuario

        System.out.println("******************************************");
        System.out.println("** Bienvenido(a) al Conversor de Moneda **");
        System.out.println("******************************************");

        boolean primeraVez = true; // Control para evitar demasiados separadores

        // Bucle para continuar hasta que el usuario elija salir
        while (opcion != 8) {
            if (!primeraVez) {
                System.out.println("\n===========================================================");
            }
            primeraVez = false;

            try {
                mostrarMenu(); // Muestra el menú
                System.out.print("Elija una opción válida: ");
                opcion = scanner.nextInt(); // Captura la opción ingresada por el usuario
                procesarOpcion(opcion, scanner); // Procesa la opción
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entre 1 y 8.");
                pausar(scanner);
            }
        }

        System.out.println("Gracias por usar el conversor de moneda. ¡Hasta luego!");
    }

    // Array con las opciones del menú
    private static final String[] opcionesMenu = {
            "Dólar => Peso argentino",
            "Peso argentino => Dólar",
            "Dólar => Real brasileño",
            "Real brasileño => Dólar",
            "Dólar => Peso colombiano",
            "Peso colombiano => Dólar",
            "Mostrar historial",
            "Salir"
    };

    // Lista para guardar el historial de conversiones
    private static final List<String> historial = new ArrayList<>();

    public static void mostrarMenu() {
        System.out.println("\n===========================================================");
        for (int i = 0; i < opcionesMenu.length; i++) {
            System.out.println((i + 1) + ") " + opcionesMenu[i]);
        }
    }

    public static void guardarEnHistorial(String conversion) {
        historial.add(conversion);
    }

    public static void mostrarHistorial() {
        System.out.println("Historial de conversiones:");
        if (historial.isEmpty()) {
            System.out.println("Aún no se han realizado conversiones en esta sesión.");
        } else {
            for (String conversion : historial) {
                System.out.println(conversion);
            }
        }
    }

    public static void realizarConversion(String base, String objetivo, double monto) {
        System.out.println("-----------------------------------------------------------"); // Separador antes de la conversión
        try {
            double tasa = ConversorAPI.obtenerTasaDeCambio(base, objetivo);
            double resultado = monto * tasa;
            String conversion = String.format("El valor %.2f [%s] corresponde a %.2f [%s]", monto, base, resultado, objetivo);
            System.out.println(conversion);
            // Guardar en el historial
            guardarEnHistorial(conversion);
        } catch (IOException e) {
            System.out.println("Error al realizar la conversión: " + e.getMessage());
        } catch (RuntimeException e) { // Manejar RuntimeException
            System.out.println("Error: La clave de API es inválida o no tiene permisos (Código 403).");
        }
        System.out.println("-----------------------------------------------------------"); // Separador después de la conversión
    }

    public static void pausar(Scanner scanner) {
        System.out.println("\nPresione ENTER para continuar...");
        scanner.nextLine(); // Consumir el salto de línea pendiente
        scanner.nextLine(); // Esperar a que el usuario presione ENTER
    }

    public static double solicitarMonto(Scanner scanner, String mensaje) {
        double monto = 0.0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print(mensaje);
            try {
                monto = scanner.nextDouble();
                entradaValida = true; // Salir del bucle si la entrada es válida
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un monto válido (solo números).");
                scanner.nextLine(); // Limpiar el buffer para evitar bucles infinitos
            }
        }

        return monto;
    }

    public static void procesarOpcion(int opcion, Scanner scanner) {
        System.out.println("\n==========================================================="); // Separador antes de cada opción
        switch (opcion) {
            case 1:
                double dolares = solicitarMonto(scanner, "Ingrese el monto en Dólares: ");
                realizarConversion("USD", "ARS", dolares);
                pausar(scanner); // Llamada a la pausa para poder tiempo de visualizar el resultado
                break;
            case 2:
                double pesosArgentinos = solicitarMonto(scanner, "Ingrese el monto en Pesos Argentinos: ");
                realizarConversion("ARS", "USD", pesosArgentinos);
                pausar(scanner); // Llamada a la pausa para poder tiempo de visualizar el resultado
                break;
            case 3:
                double dolaresABr = solicitarMonto(scanner, "Ingrese el monto en Dólares: ");
                realizarConversion("USD", "BRL", dolaresABr);
                pausar(scanner); // Llamada a la pausa para poder tiempo de visualizar el resultado
                break;
            case 4:
                double realesBrasileños = solicitarMonto(scanner, "Ingrese el monto en Reales Brasileños: ");
                realizarConversion("BRL", "USD", realesBrasileños);
                pausar(scanner); // Llamada a la pausa para poder tiempo de visualizar el resultado
                break;
            case 5:
                double dolaresACol = solicitarMonto(scanner, "Ingrese el monto en Dólares: ");
                realizarConversion("USD", "COP", dolaresACol);
                pausar(scanner); // Llamada a la pausa para poder tiempo de visualizar el resultado
                break;
            case 6:
                double pesosColombianos = solicitarMonto(scanner, "Ingrese el monto en Pesos Colombianos: ");
                realizarConversion("COP", "USD", pesosColombianos);
                pausar(scanner); // Llamada a la pausa para poder tiempo de visualizar el resultado
                break;
            case 7:
                mostrarHistorial();
                pausar(scanner);
                break;
            case 8:
                System.out.println("Saliendo del conversor...");
                break;
            default:
                System.out.println("Opción inválida. Por favor, elija un número entre 1 y 8.");
                pausar(scanner); // Pausa para opciones inválidas también
        }
        System.out.println("===========================================================\n"); // Separador después de cada opción
    }


}
