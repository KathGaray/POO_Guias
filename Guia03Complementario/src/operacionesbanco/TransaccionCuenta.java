package operacionesbanco;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class TransaccionCuenta {
    private int idtransac; //num. correlativo de transaccion
    private double montotransac; //monto de operacion a ejecutar
    // (Año, mes, día) y (hora:minuto) de realizacion de transaccion
    private LocalDateTime fechatransac;
    private double saldoinic; //saldo antes de ejecutar transaccion
    double nuevosaldo; //saldo al completar transaccion
    char tipotransaccion; // 'd': deposito, 'r': retiro
    String descripcion; // resumen corto de transaccion realizada
    //estado de transaccion realizada.
    // 0: exitosa, 1: saldo insuficiente, 2: monto negativo,
    // -1: operacion no reconocida
    int estado;

    //metodo constructor
    public TransaccionCuenta(int numoperac, double saldoinicial){
        idtransac = numoperac;
        this.saldoinic = saldoinicial;
        this.nuevosaldo = saldoinicial;
    }
    public void Ejecutar(char tipooperac, double monto, String descripcion){
        estado = 0; //asume que transaccion se ejecutara con exito
        //del SO obtiene la fecha y hora de transaccion a realizar
        fechatransac = LocalDateTime.now();
        this.tipotransaccion = tipooperac;
        this.descripcion = descripcion;
        //evalua si operacion no puede realizarse
        if(monto<0){
            estado = 2; //monto negativo, no completo transaccion
            return; //cancela transaccion
        }
        //verifica si no hay saldo para retirar monto
        switch (tipooperac){
            case 'r': case 'R': //intenta retirar monto
                if(monto> saldoinic)
                {
                    estado = 1; //no hay saldo para retirar monto solicitado
                    return; //cancela transaccion
                }
                //ejecuta retiro
                this.montotransac = monto;
                nuevosaldo = saldoinic -monto;
                break;
            case 'd': case 'D': //ejecuta deposito en cuenta ahorro
                this.montotransac = monto;
                nuevosaldo = saldoinic +monto;
                break;
            default:
                estado = -1; //no reconoce la operacion solicitada
        } //fin switch tipooperac
    }
    public String getRegistro(){
        String registro, titulooperac = "";
        //define formato elementos de la fecha para registrar transaccion
        DateTimeFormatter formatofecha =
                DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String fecha = fechatransac.format(formatofecha);
        switch (this.tipotransaccion){
            case 'd': case 'D':
                titulooperac = "Deposito";
                break;
            case 'r': case 'R':
                titulooperac = "Retiro";
                break;
        }
        registro =
                String.format(
                        "%4d.|%20s| %-16s |%-25s |$%10.2f |$%10.2f|",
                        idtransac,fecha, titulooperac,descripcion,montotransac,
                        nuevosaldo);
        return registro;
    }
}

