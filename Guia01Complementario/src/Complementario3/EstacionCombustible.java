package Complementario3;
import java.util.*;


public class EstacionCombustible {
    //densidad gasolina
    private static final double DENSIDAD_GASOLINA = 0.750; // g/ml

    public static void main(String[] args) {
        // valores de entrada
        double radio = solicitarRadio();
        double altura = solicitarAltura();

        // valores de slida
        double volDieselLts = calcularVolDiesel(radio, altura);
        double masaGasolinaKg = calcularMasaGasolina(radio, altura);

        // Imprimir resultados
        imprimirResultados(volDieselLts, masaGasolinaKg);
    }

    // solicitar datos de entrada
    public static double solicitarRadio() {
        Scanner lecto = new Scanner(System.in);
        lecto.useLocale(Locale.US);
        System.out.print("Ingrese el radio del tanque (en metros): ");
        return lecto.nextDouble();
    }

    public static double solicitarAltura() {
        Scanner lecto = new Scanner(System.in);
        lecto.useLocale(Locale.US);
        System.out.print("Ingrese la altura del tanque (metros): ");
        return lecto.nextDouble();
    }

    // Calcular
    public static double calcularVolCilindro(double radio, double altura) {
        //forumula a usar V = π * r2 * h (en m3)
        return Math.PI * Math.pow(radio, 2) * altura;
    }

    public static double calcularVolDiesel(double radio, double altura) {
        // Volumen en m³
        double volumen = calcularVolCilindro(radio, altura);
        // Conversion a litros
        return volumen * 1000;
    }

    public static double calcularMasaGasolina(double radio, double altura) {
        // Volumen en m3
        double volumen = calcularVolCilindro(radio, altura);
        // Convertir a mL
        double volumenML = volumen * 1_000_000;
        // Masa en gramos (densidad * volumen)
        double masaGramos = DENSIDAD_GASOLINA * volumenML;
        // Conversion a kg
        return masaGramos / 1000;
    }

    // salida de datos
    public static void imprimirResultados(double volumenDiesel, double masaGasolina) {
        System.out.println("=== RESULTADOS ===");
        System.out.printf("Volumen máximo de Diesel: %.2f Litros", volumenDiesel);
        System.out.printf("Masa máxima de Gasolina: %.2f Kilogramos", masaGasolina);
    }
}
