package ejemplo2;

import ejemplo2.Interfaces.IComparable;
import ejemplo2.Interfaces.INumero;

public class NumFraccionario implements INumero, IComparable {

    private int deno;
    private  int num;


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDeno() {
        return deno;
    }

    public void setDeno(int deno) {
        if (deno != 0){
            this.deno =deno;
        }
    }

    //metodo constructor
    public NumFraccionario(){
        setNum(0);
        setDeno(1);
    }

    public NumFraccionario(int num, int deno) {
        setDeno(1);
        setNum(num);
        setDeno(deno);
    }
    public NumFraccionario(int entero){
        setNum(entero);
        setDeno(1);
    }

    //Sobre escribir
    @Override
    public String toString(){
        if (deno ==1){
            return String.valueOf(num);
        }
        return num + "/" + deno;
    }

    //metodo para calcular maximo comun divisor
    public int calcularMCD (int a, int b){
        int temp;
        while (b != 0){
            temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }

    //metodo para calcular minimo comun divisor
    public int calcularMCM(int a, int b){
        int mcm;
        if(a == 0 || b ==0){
            return  0;
        }
        mcm = (a * b)/ calcularMCD(a,b);
        return mcm;
    }


    public int calcularMCM(NumFraccionario a, NumFraccionario b){ //(sobrecarga)
        //extrae denominadores para invocar a sobrecarga que recibe solo denominadores
        return calcularMCM(a.getDeno(), b.getDeno());
    }

    public int calcularMCD(NumFraccionario a, NumFraccionario b){ //(sobrecarga)
        //extrae denominadores para invocar a sobrecarga que recibe solo denominadores
        return calcularMCD(a.getDeno(), b.getDeno());
    }

    public NumFraccionario Simplificar(){
        int mcd = calcularMCD(getNum(), getDeno());
        setNum(getNum()/mcd);
        setDeno(getDeno()/mcd);
        setDeno(getDeno()/mcd);
        //de manera opcional, retorna una nueva isntancia de fraccion simplificada
        return new NumFraccionario(getNum(), getDeno());
    }

    //(sobrecarga)
    // simplifica fraccion recibida con numerador y denominador recibidos
    public NumFraccionario Simplificar(int num, int deno){
        NumFraccionario r = new NumFraccionario();
        int mcd = calcularMCD(num, deno);

        r.setNum(num/mcd);
        r.setDeno(deno/mcd);
        return r;
    }

    private boolean Esnegativa(){
        //retorna true si el numerador de fraccion interna es negativa
        if (this.getNum()<0) return true;
        return false;
    }

    public double aDecimal(){
        //retorna valor de cociente de dividir numerador y denominador
        return (double)this.getNum()/(double)this.getDeno();
    }



    @Override
    public boolean EsMayorQue(IComparable valor) {
        if(valor instanceof NumFraccionario){
            //compara la fraccion interna con fraccion recibida en objeto
            NumFraccionario p1,p2;

            p1 = new NumFraccionario(getNum(), getDeno());
            p2 = (NumFraccionario) valor;

            if(!p1.Esnegativa() && !p2.Esnegativa())//Si ambas son positivas
            {
                if(p1.aDecimal()>p2.aDecimal()) return true;
            }
            else
            if(p1.Esnegativa() && p2.Esnegativa()) //si ambas son negativas
            {
                //cambia sentido de prueba
                if(p2.aDecimal()>p1.aDecimal()) return true;
            }
            else
                //tienen signos distintos, si fraccion   interna tiene un signo positivo, sera mayor
                if (!this.Esnegativa()) return true;
       }
        return false; // fraccion local es menor que fraccion recibida

    }

    @Override
    public INumero Sumarle(INumero valor) {
        //define la fraccion con valor 0 (0/1), en caso que no pueda hacer la operacion
        NumFraccionario s = new NumFraccionario();
        //prueba si instancia recibida es de este mismo tipo de clase NumFraccionario
        if(valor instanceof NumFraccionario ){
            NumFraccionario a, b;
            a = new NumFraccionario(getNum(), getDeno()); //valor de fraccion interna
            b = (NumFraccionario) valor; //convierte parametro a objeto de clase NumFraccionario
            //Calcula suma de fraccion interna de esta instancia con objeto recibido en parametros
            //y actualiza valor de fraccion interna con este resultado
            int mcm = calcularMCM(a.getDeno(), b.getDeno());

            s.setNum(mcm/getDeno()*getNum()+ mcm/b.getDeno()*b.getNum());
            s.setDeno(mcm);
            //simplifica fraccion obtenida
            s =Simplificar(s.getNum(), s.getDeno());
        }
        return s;
    }

    public INumero Dividir(INumero valor) {

        NumFraccionario s = new NumFraccionario();
                if(valor instanceof NumFraccionario ){
            NumFraccionario a, b;
            a = new NumFraccionario(getNum(), getDeno()); //valor de fraccion interna
            b = (NumFraccionario) valor;


            int mcm = calcularMCM(a.getDeno(), b.getDeno());
            //calcular la division, utilizando multiplicacion (dividir es multiplicar a la inversa)
            //ejemplo (a/b) / (c/d) = (a*d) / (b*c)
            s.setNum(a.getNum() *b.getDeno());
            s.setDeno(a.getDeno()* b.getNum());
            //simplifica fraccion obtenida
            s =Simplificar(s.getNum(), s.getDeno());
        }
        return s;
    }
}