import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
public class ClasePrincipal {
    public static void main(String[] args) {
            Scanner teclado = new Scanner(System.in);
            String menuDeOpciones = """
                ******************************************************
                                 CONVERSOR DE MONEDAS
                ******************************************************
                1) Convertir Dolares (USD) a Pesos Argentinos (ARS)
                2) Convertir Pesos Argentinos (ARS) a Dolares (USD)
                3) Convertir Dolares (USD) a Pesos Colombianos (COP)
                4) Convertir Pesos Colombianos (COP) a Dolares (USD)
                5) Convertir Dolares (USD) a Reales Brasileños (BRL)
                6) Convertir Reales Brasileños (BRL) a Dolares (USD)
                7) Convertir Dolares (USD) a Euros (EUR)
                8) Convertir Euros (EUR) a Dolares (USD)
                9) SALIR DEL PROGRAMA
                ******************************************************
                """;


            String opcion;
            String continuar;


            int contador = 0;
            boolean salir = false; //para entrar por primera vez al while
            while (!salir){
                System.out.println(menuDeOpciones);
                opcion = teclado.nextLine();

                switch (opcion) {

                    case "1":
                        System.out.println("Ingrese el monto de Dolares a convertir en Pesos Argentinos: ");
                        convertirMoneda("USD", "ARS", teclado);
                        continuar = teclado.nextLine();
                        break;

                    case "2":
                        System.out.println("Ingrese el monto de Pesos Argentinos a convertir en Dolares: ");
                        convertirMoneda("ARS", "USD", teclado);
                        continuar = teclado.nextLine();
                        break;

                    case "3":
                        System.out.println("Ingrese el monto de Dolares a convertir en Pesos Colombianos: ");
                        convertirMoneda("USD", "COP", teclado);
                        continuar = teclado.nextLine();
                        break;

                    case "4":
                        System.out.println("Ingrese el monto de Pesos Colombianos a convertir en Dolares: ");
                        convertirMoneda("COP", "USD", teclado);
                        continuar = teclado.nextLine();
                        break;

                    case "5":
                        System.out.println("Ingrese el monto de Dolares a convertir en Reales Brasileños: ");
                        convertirMoneda("USD", "BRL", teclado);
                        continuar = teclado.nextLine();
                        break;

                    case "6":
                        System.out.println("Ingrese el monto de Reales Brasileños a convertir en Dolares: ");
                        //convertirMoneda("BRL", "USD", teclado);
                        break;

                    case "7":
                        System.out.println("Ingrese el monto de Dolares a convertir en Euros: ");
                        convertirMoneda("USD", "EUR", teclado);
                        continuar = teclado.nextLine();
                        contador = contador + 1;
                        break;

                    case "8":
                        System.out.println("Ingrese el monto de Euros a convertir en Dolares: ");
                        convertirMoneda("EUR", "USD", teclado);
                        continuar = teclado.nextLine();
                        break;

                    case "9":
                        salir = true;
                        System.out.println("**********************************************************");
                        System.out.println("Saliendo del programa... GRACIAS!!!");
                        System.out.println("**********************************************************");
                        break;

                    default:
                        System.out.println("OPCIÓN NO VÁLIDA!!! Vuelve a intentarlo");

                }







            }
        }

        private static void convertirMoneda(String baseCode, String targetCode, Scanner teclado) {
            double amount = teclado.nextDouble();
            ClaseConversion conversion = new ClaseConversion(baseCode, targetCode, amount);
            try {
                double result = conversion.convert();
                System.out.println(amount + " " + baseCode + " equivale a " + result + " " + targetCode);
                System.out.println("Vuelve a realizar una conversión o elige la opción de SALIR");

            } catch (IOException | InterruptedException e) {
                System.out.println("Ocurrió un error: ");
                System.out.println(e.getMessage());
            }
        }
}
