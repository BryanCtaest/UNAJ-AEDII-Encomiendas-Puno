public class clsEncomienda {
    // Atributos en camelCase que representan los datos reales del paquete
    private int codTracking;
    private String nomDestinatario;
    private String ciudadOrigen;
    private String ciudadDestino;

    // Constructor: recibe los 4 datos desde las cajas de texto y combos del panel
    public clsEncomienda(int codigoTracking, String nombreDestinatario, String ciudadOrigen, String ciudadDestino) {
        this.codTracking = codigoTracking;
        this.nomDestinatario = nombreDestinatario;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
    }

    // Métodos getter y setter para leer o actualizar los datos desde el Árbol
    public int getCodTracking() {
        return codTracking;
    }

    public void setCodTracking(int codTracking) {
        this.codTracking = codTracking;
    }

    public String getNomDestinatario() {
        return nomDestinatario;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    // Método para mostrar el paquete resumido en una sola línea cuando hagamos el recorrido Inorden
    public String obtenerResumenTexto() {
        return "[" + codTracking + " | Cliente: " + nomDestinatario
                + " | Ruta: " + ciudadOrigen + " -> " + ciudadDestino + "]";
    }
}
