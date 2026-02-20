package operacionesbanco;
import java.time.LocalDateTime;

public class Cliente {
        //Campos
        public String dui;
        public String nombre;
        public String apellido;

        //Metodos
        //metodo constructor
        public Cliente(String nom, String apell, String dui){
            this.nombre = nom;
            this.apellido = apell;
            this.dui=dui;
        }
        public String DatosCliente(){
            //ej. de cadena que retorna:
            // Alfredo Ruiz (dui: 4175838-6)
            String datoscliente = String.format("%s %s (dui: %s)",
                    this.nombre,this.apellido, this.dui);
            return datoscliente;
        }
}