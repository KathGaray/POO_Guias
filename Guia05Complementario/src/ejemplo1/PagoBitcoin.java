package ejemplo1;

public class PagoBitcoin implements IPago{
    @Override
    public String ProcesarPago(float monto) {
        String resultado = String.format("Pago con bitcoin del monto recibido es $ %.2f", monto);
        return resultado;
    }
}
