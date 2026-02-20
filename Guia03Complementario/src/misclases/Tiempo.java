package misclases;
import java.text.DecimalFormat;


public class Tiempo {
    // Declaración de clase Tiempo: almacena hora en formato de 24 horas
    //Atributos/Campos
    private int hora; // rango aceptado: 0 - 23
    private int minuto; // 0 - 59
    private int segundo; // 0 - 59
    //metodo para inicializar campos de los objetos
    private void InicializarCampos(){
        setHora(0);
        setMinuto(0);
        setSegundo(0);
    }
    // El constructor de Tiempo1 inicializa cada variable de instancia en cero;
// se asegura de que cada objeto Tiempo1 inicie en un estado consistente
    public Tiempo()
    {
        InicializarCampos(); //fija hora predeterminada (00:00:00 h)
    }
    // Establecer un nuevo valor de hora utilizando hora universal;
    public void establecerHora( int h, int m, int s )
    {
        //actualiza elementos de hora segun parametros recibidos
        setHora(h);
        setMinuto(m);
        setSegundo(s);
    }
    // Convierte hora (en formato de Hora universal) y lo retorna como String
    public String aStringUniversal()
    {
        DecimalFormat dosDigitos = new DecimalFormat( "00" );
        return dosDigitos.format(getHora()) + ":" +
                dosDigitos.format(getMinuto()) + ":" + dosDigitos.format(getSegundo());
    }
    // convertir a String en formato de hora estándar
    public String aStringEstandar()
    {
        DecimalFormat dosDigitos = new DecimalFormat( "00" );
        return ( (getHora() == 12 || getHora() == 0) ? 12 : getHora() % 12 ) + ":" +
                dosDigitos.format(getMinuto()) + ":" + dosDigitos.format(getSegundo()) +
                ( getHora() <12 ? " AM" : " PM" );
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        //verifica que nuevo valor sea apropiado (solo 0 y 23 h)
        if(hora>=0 && hora<24)
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        if(minuto>=0 && minuto<60)
            this.minuto = minuto;
        this.minuto = minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        if(segundo>=0 && segundo<60)
            this.segundo = segundo;
        this.segundo = segundo;
    }
}
