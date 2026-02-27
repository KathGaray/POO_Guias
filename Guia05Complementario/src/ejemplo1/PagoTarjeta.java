package ejemplo1;

public class PagoTarjeta implements IPago{
    @Override
    public String ProcesarPago(float monto) {
        String resultado = String.format("Pago con tarjeta del monto recibido es $ %.2f", monto);
        return resultado;
    }
}

