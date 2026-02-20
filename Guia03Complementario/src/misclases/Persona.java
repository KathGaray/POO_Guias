package misclases;
import javax.swing.*;

public class Persona {
    //declaracion de Atributos
    private String nombre;
    private String apellido;
    private int edad;
    //definicion de Metodos
    //Metodos Constructores: Se utiliza al instanciar el objeto
    public Persona(){ //Constructor por defecto (sin parametros)
        nombre="Rafael";
        apellido="Torres";
        edad=23;
    }
    //Sobrecarga de Metodo Constructor: Constructor con parametros
    public Persona(String nom,String apell,int edad){
        this.nombre=nom;
        this.apellido=apell;
        this.edad=edad;
    }
    //Permite definir datos a los atributos
    public void ingresoDatos()
    {
        //utiliza cuadros de dialogo para solicitar valores de campos
        nombre=JOptionPane.showInputDialog("Ingrese el Nombre");
        apellido=JOptionPane.showInputDialog("Ingrese el Apellido");
        edad=Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad"));
    }
    //Permite imprimir los valores de los atributos
    public void mostrarDatos(){
        System.out.println("Su nombre es: "+nombre);
        System.out.println("Su Apellido es: "+apellido);
        System.out.println("Su edad es: "+edad);
        System.out.println("****************************");
    }


}
