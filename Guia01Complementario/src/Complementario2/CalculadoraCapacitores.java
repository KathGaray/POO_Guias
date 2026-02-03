package Complementario2;
import javax.swing.JOptionPane;

public class CalculadoraCapacitores {
    public static void main(String[] args) {
        //lectura y entrada de datos
        String valor1 = JOptionPane.showInputDialog( "Ingrese el valor del primer capacitor en (microfaradios):  ");
        String valor2 = JOptionPane.showInputDialog( "Ingrese el valor del segundo capacitor en (microfaradios):  ");
        String valor3 = JOptionPane.showInputDialog( "Ingrese el valor del tercer capacitor en (microfaradios):  ");

        //validacion
        if (valor1 == null || valor1.isEmpty() || valor2 == null || valor3.isEmpty() || valor3 == null || valor3.isEmpty()) {

            JOptionPane.showMessageDialog( null,"No ingresó un valor apropiado. El programa finalizara.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // parseo
        double v1 = Double.parseDouble(valor1);
        double v2 = Double.parseDouble(valor2);
        double v3 = Double.parseDouble(valor3);

        try{
            if (v1 <= 0 || v2 <= 0 || v3 <= 0){
                JOptionPane.showMessageDialog(null, "No ingresó un valor apropiado. El programa finalizará.",
                        "Error", JOptionPane.ERROR_MESSAGE );
                return;
            }

            // Valores ingresados a consola
            System.out.print("=== CALCULADORA DE CAPACITORES ===");
            System.out.println("Valores ingresados:");
            System.out.println("Capacitor 1: " + v1 );
            System.out.println("Capacitor 2: " + v2 );
            System.out.println("Capacitor 3: " + v3 );

            double resultSerie = calcularCapacitorSerie(v1, v2, v3);
            double resultParalelo = calcularCapacitorParalelo(v1, v2, v3);

            //salida a pantalla
            System.out.println("=== RESULTADOS ===");
            System.out.println("Capacitor equivalente en SERIE: " + resultSerie );
            System.out.println("Capacitor equivalente en PARALELO: " + resultParalelo);
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "No ingresó un valor apropiado. El programa finalizará.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Operacion para calcular el capacitor equivalente en conexion en serie
    // sumar 1/capacitores
    public static double calcularCapacitorSerie(double v1, double v2, double v3){
        double Resultsuma = (1.0 / v1) + (1.0 / v2) + (1.0 / v3);
        return 1.0/Resultsuma;
    }

    //Operacion para calcular el capacitor equivalente en conexion en serie
    // sumar cada capacitor
    public static double calcularCapacitorParalelo(double v1, double v2, double v3) {
        return v1 + v2 + v3;
    }
}
