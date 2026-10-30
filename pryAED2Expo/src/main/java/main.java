import javax.swing.*;

public class main {

    public static void main(String[] args) {
        // 1. Ponemos el diseño limpio de Windows para quitar ese color gris antiguo de Swing
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        // 2. Creamos la Estructura 1: Grafo de Rutas y agregamos las 8 carreteras (Semana 4)
        clsGrafoRutas rutasPuno = new clsGrafoRutas();
        rutasPuno.agregarArista("JULIACA", "PUNO");
        rutasPuno.agregarArista("JULIACA", "LAMPA");
        rutasPuno.agregarArista("JULIACA", "PUCARA");
        rutasPuno.agregarArista("PUCARA", "AYAVIRI");
        rutasPuno.agregarArista("JULIACA", "AZANGARO");
        rutasPuno.agregarArista("AZANGARO", "HUANCANE");
        rutasPuno.agregarArista("JULIACA", "HUANCANE");
        rutasPuno.agregarArista("AZANGARO", "AYAVIRI");

        // 3. Creamos la Estructura 2: Árbol ABB y cargamos 4 encomiendas de prueba (Semana 3)
        clsArbolAbb arbolEncomiendas = new clsArbolAbb();
        arbolEncomiendas.insertar(new clsEncomienda(50, "Carlos Quispe", "JULIACA", "PUNO"));
        arbolEncomiendas.insertar(new clsEncomienda(30, "Ana Mamani", "LAMPA", "AYAVIRI"));
        arbolEncomiendas.insertar(new clsEncomienda(70, "Luis Condori", "PUNO", "HUANCANE"));
        arbolEncomiendas.insertar(new clsEncomienda(20, "Elena Flores", "JULIACA", "AZANGARO"));

        // 4. Abrimos la ventana pasándole el Árbol y el Grafo ya cargados
        SwingUtilities.invokeLater(() -> {
            frmEncomiendas ventana = new frmEncomiendas(arbolEncomiendas, rutasPuno);
            ventana.setVisible(true);
        });
    }
}