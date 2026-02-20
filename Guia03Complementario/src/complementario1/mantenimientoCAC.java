package complementario1;
import operacionesbanco.*;

import java.util.ArrayList;
import java.util.*;

public class mantenimientoCAC {


    static ArrayList<Cliente> listaClientes = new ArrayList<>();
    //Objeto de lectura
    static Scanner teclado = new Scanner(System.in);


    public static void main(String[] args) {
       String opcion = "";

       while(!opcion.equals("C")){
           System.out.println("\n ===== MENU PRINCIPAL =====");
           System.out.println("A) Registrar CLiente");
           System.out.println("B) Abrir cuenta de ahorro");
           System.out.println("C) Salir");
           System.out.println("Elija una opcion");
           opcion = teclado.nextLine().toUpperCase();

           switch (opcion){
               case "A" : registrarCliente();
                   break;
               case "B": abrirCuenta();
                   break;
               case "C":
                   System.out.println("Cerrando programa...");
                   break;
               default:
                   System.out.printf("Funcion no valida");
                    break;

           }
       }
    }

    public static void registrarCliente(){

        //Ingreso y lectura de datos de usuario
        System.out.println("Nombre: ");
        String nom = teclado.nextLine();
        System.out.println("Apellido: ");
        String apell = teclado.nextLine();
        System.out.println("DUI: ");
        String dui = teclado.nextLine();

        Cliente nuevo = new Cliente(nom,apell,dui);
        listaClientes.add(nuevo);

        //mostrar la lista con los nuevos ingresos
        mostrarCliente();
        System.out.println("Presione enter para continuar");
        teclado.nextLine();
    }

    public static void mostrarCliente(){
        System.out.printf("\n Listado de clientes registrados (%d):\n ", listaClientes.size());
        System.out.println("Datos del cliente");
        for (int i=0; i< listaClientes.size(); i++){
            System.out.printf("%d.%s \n ", i+1, listaClientes.get(i).DatosCliente());
        }

    }

    public static void abrirCuenta(){
        if (listaClientes.isEmpty()){
            System.out.println("No hay clientes registrados aun");
            return;
        }

        mostrarCliente();
        System.out.println("Elija el numero del cliente: ");
        int indice = Integer.parseInt(teclado.nextLine()) -1;

        if (indice < 0 || indice >= listaClientes.size()){
            System.out.println("Numero invalido");
            return;
        }

        System.out.println("Saldo inicial de la cuenta: $ ");
        double saldo = Double.parseDouble(teclado.nextLine());

        Cliente elegido = listaClientes.get(indice);
        CuentaBancaria nuevaCuenta = new CuentaBancaria(elegido, saldo);

        nuevaCuenta.vertransacciones();
        System.out.println(" Presione enter para continuar ...");
        teclado.nextLine();
    }











}