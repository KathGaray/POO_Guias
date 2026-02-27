package ejemplo1;

public class PagoEfectivo implements IPago{

    @Override
    public String ProcesarPago(float monto) {
        String resultado = String.format("Pago con efectivo del monto recibido es $ %.2f", monto);
        return resultado;
    }
}

