package Complementario1;
import javax.swing.JOptionPane;

public class SumaEnteros {
    public static void main(String[] args) {

        //entrada y lectura de datos
        String primernumero = JOptionPane.showInputDialog("Digite el primer número");
        String segundonumero = JOptionPane.showInputDialog("Digite el segundo número");
        //parseo
        int numero1 = Integer.parseInt(primernumero);
        int numero2 = Integer.parseInt(segundonumero);
        //validacion
        if (numero1 < 0 || numero2 < 0) {
            JOptionPane.showMessageDialog(null,"No se pueden ingresar números negativos");
            return;
        }
        int suma = numero1 + numero2;
        JOptionPane.showMessageDialog(null,"La suma es: " + suma);
        };
}
