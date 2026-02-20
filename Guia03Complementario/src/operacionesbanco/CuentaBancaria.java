package operacionesbanco;
import java.util.ArrayList;
import java.time.LocalDate;

public class CuentaBancaria {
    // campos
    private Cliente titularcuenta;
    private double saldoactual;
    private int numtransac;
    //coleccion de tipo ArrayList de objeto de la clase TransaccionCuenta
    private ArrayList<TransaccionCuenta> transacciones;
    //metodos
    private void inicializarcampos() {
        titularcuenta = null;
        numtransac = 0;
        saldoactual = 0;
        transacciones = new ArrayList();
    }
    //metodo constructor
    public CuentaBancaria(Cliente propietario, double saldoinicial) {
        //en parametro 1, recibe a objeto de clase Cliente, que sera su Titular
        inicializarcampos();
        this.titularcuenta = propietario;
        //crea instancia de la clase TransaccionCuenta
        TransaccionCuenta transacTemp = new TransaccionCuenta(++numtransac, 0);
        //Para abrir la cuenta de banco, ejecuta transaccion (deposito)
        //con el saldo inicial
        transacTemp.Ejecutar('d', saldoinicial, "apertura de cuenta");
        this.saldoactual = transacTemp.nuevosaldo;
        transacciones.add(transacTemp); //registra transaccion correcta
    }
    public void realizaroperacion(char tipooperac, double monto, String descrip)
    {
        //prepara transaccion
        TransaccionCuenta transacTemp =
                new TransaccionCuenta(numtransac +1, saldoactual);
        transacTemp.Ejecutar(tipooperac,monto,descrip);
        switch (transacTemp.estado)
        {
            case 1:
                System.out.printf(
                        "ERROR: Saldo de cuenta insuficiente para retirar $ %.2f%n", monto);
                break;
            case 2:
                System.out.printf(
                        "ERROR: Monto $ %.2f requerido no puede ser negativo%n", monto);
                break;
            default:
                numtransac++;
                this.saldoactual = transacTemp.nuevosaldo;
                transacciones.add(transacTemp); //registra transaccion correcta
                System.out.println("Transaccion ejecutada con exito ");
                break;
        }
    }
    public void vertransacciones(){
        //imprime lista de transacciones realizadas sobre la cuenta actual
        String titulos;
        System.out.printf("\n* Titular de Cuenta: %s\n",
                titularcuenta.DatosCliente());
        System.out.printf("* Saldo actual: $ %.2f\n",saldoactual);
        if(transacciones.size()==0)
            System.out.println("Aun sin transacciones realizadas");
        else{
            titulos = String.format(
                    "%4s.|%-20s| %-16s |%-25s |%-10s |%-11s|",
                    "id","fecha","Tipo transaccion","Descripcion","Monto",
                    "Saldo");
            System.out.println(titulos);
            //muestra registro de transacciones sobre la cuenta
            for(TransaccionCuenta cuenta:transacciones){
                //recorre colección ArrayList con todos los objetos
                //de transacciones realizadas sobre la Cuenta
                System.out.println(cuenta.getRegistro());
            }
        }
    }
    public double getSaldoactual() {
        return saldoactual;
    }
}