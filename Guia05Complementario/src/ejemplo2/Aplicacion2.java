package ejemplo2;
import java.util.*;

public class Aplicacion2  {
    public static void main(String[] args) {
        NumFraccionario f0, f1, f2, f3, f4;
        NumFraccionario r1, r2, r3;
        //para almacenar calculos
        int mcm, mcd;
        System.out.println("Operaciones con Fracciones");

        //inicializa instancias
        f0 = new NumFraccionario();
        f1 = new NumFraccionario(2,5);
        f2 = new NumFraccionario(3,8);
        f3 = new NumFraccionario(-168,210);
        f4 = new NumFraccionario(3);

        System.out.format("Las fracciones para las pruebas sera %s, %s, %s, %s y %s \n \n" , f0,  f1, f2,f3, f4);

        mcm = f0.calcularMCM(630, 1050);
        mcd = f0.calcularMCD(630 ,1050);
        System.out.format("El mcm de 630 y 1050 es %d, el mcd es %d \n" , mcm, mcd);

        mcm = f0.calcularMCM(f1,f2);
        mcd = f0.calcularMCD(f1,f2);
        System.out.format("El mcm de los denominadores de %s y %s es %d, el mcd es %d\n", f1, f2, mcm,mcd);
        System.out.format("La fraccion equivalente y simplificada de %s ", f3);
        r1 = f3.Simplificar();
        System.out.format("es %s \n",r1);

        System.out.format("La fraccion equivalente y simplificada de 300/270 es %s\n", f0.Simplificar(300,270));

        f0 = new NumFraccionario(-23, 125); //fraccionario -23/125
        System.out.format("El valor decimal de la fraccion %s es %.4f\n", f0, f0.aDecimal());


        r2 =(NumFraccionario) f1.Sumarle(f2); //calcula suma de 3er numero con 4to numero
        System.out.format("\nLa suma de %s con %s es %s\n", f1,f2,r2);
        //suma un entero con la fraccion
        f0 = (NumFraccionario) f1.Sumarle(f4);
        System.out.format("Suma de %s y %s es %s\n", f1,f4,f0);
        if(f1.EsMayorQue(f4)) //compara fraccion f1 con f4
            System.out.format("La fraccion * %s es mayor que %s\n",f1,f4);
        else
            System.out.format("La fraccion %s es mayor que %s\n",f4,f1);

        r3 =(NumFraccionario) f1.Dividir(f2); //calcula la divison
        System.out.format("\nLa Division de %s con %s es %s\n", f1,f2,r2);
        //suma un entero con la fraccion
        f0 = (NumFraccionario) f1.Dividir(f4);
        System.out.format("Division de %s y %s es %s\n", f1,f4,f0);
        if(f1.EsMayorQue(f4)) //compara fraccion f1 con f4
            System.out.format("La fraccion * %s es mayor que %s\n",f1,f4);
        else
            System.out.format("La fraccion %s es mayor que %s\n",f4,f1);

    }
}