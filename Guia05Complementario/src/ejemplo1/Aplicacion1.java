package ejemplo1;
import java.util.*;

public class Aplicacion1 {
    public static void main(String[] args) {
        IPago metodopago= null;

        Scanner sc = new Scanner(System.in);
        //variables
        float monto;
        int tipopago;

        String resultado;
        System.out.println("Tienda\n");
        System.out.println("Ingrese valor del monto a realizar: $ ");
        monto = sc.nextFloat();
        System.out.println("Metodo de pago: ");
        System.out.println("\t 1. Tarjeta de credito\n\t 2.Bitcoin \n\t 3.Efectivo ");
        System.out.println("Seleccione el número de método de pago: ");
        tipopago=sc.nextInt();

        switch (tipopago){
            case 1:
                metodopago=new PagoTarjeta();
                break;
            case 2:
                metodopago=new PagoBitcoin();
                break;
            case 3:
                metodopago=new PagoEfectivo();
                break;
        }
        if(metodopago == null)
            System.out.println("ERROR: No eligio un metodo de pago valido");
        else{
            resultado = metodopago.ProcesarPago(monto);
            System.out.println(resultado);
        }

    }
}
