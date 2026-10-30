import javax.swing.*;

public class frmEncomiendas extends JFrame {

    private JPanel jpPrin;
    private JPanel jpTexto;
    private JPanel jpBoton;
    private JScrollPane jsScroll; // Si borraste jsScroll del form, borra también esta línea
    private JTextField txtCodigo;
    private JTextField txtDest;
    private JComboBox<String> cbxOrigen;
    private JComboBox<String> cbxDestino;
    private JButton btnIns;
    private JButton btnBuscar;
    private JButton btnEli;
    private JButton btnMos;
    private JTextArea txtResul;

    // Recibe el Árbol y el Grafo ya creados desde clsMain
    public frmEncomiendas(clsArbolAbb arbol, clsGrafoRutas grafo) {
        setTitle("Sistema de Encomiendas (ABB + Grafo BFS)");
        setContentPane(jpPrin);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 520);
        setLocationRelativeTo(null);

        // Llenamos los combos con las ciudades del grafo
        for (String c : grafo.getNomCiudades()) {
            cbxOrigen.addItem(c);
            cbxDestino.addItem(c);
        }

        // Mostramos los datos iniciales al abrir
        mostrarResumen(arbol, grafo, "Datos iniciales cargados desde clsMain.");

        // 1. BOTÓN INSERTAR
        btnIns.addActionListener(e -> {
            int cod = Integer.parseInt(txtCodigo.getText().trim());
            String dest = txtDest.getText().trim();
            String ori = cbxOrigen.getSelectedItem().toString();
            String fin = cbxDestino.getSelectedItem().toString();

            arbol.insertar(new clsEncomienda(cod, dest, ori, fin));
            String ruta = grafo.caminoMasCortoBfs(ori, fin);
            mostrarResumen(arbol, grafo, "Insertado código " + cod + " | Ruta BFS: " + ruta);
        });

        // 2. BOTÓN BUSCAR
        btnBuscar.addActionListener(e -> {
            int cod = Integer.parseInt(txtCodigo.getText().trim());
            clsEncomienda enc = arbol.buscar(cod);

            if (enc != null) {
                String caminoArbol = arbol.obtenerCaminoBusqueda(cod);
                String rutaGrafo = grafo.caminoMasCortoBfs(enc.getCiudadOrigen(), enc.getCiudadDestino());

                txtResul.setText(
                        "ENCOMIENDA ENCONTRADA:\n" +
                                "  Datos        : " + enc.obtenerResumenTexto() + "\n" +
                                "  Saltos en ABB: " + caminoArbol + "\n" +
                                "  Ruta en Grafo: " + rutaGrafo
                );
            } else {
                txtResul.setText("El código " + cod + " NO existe en el árbol.");
            }
        });

        // 3. BOTÓN ELIMINAR
        btnEli.addActionListener(e -> {
            int cod = Integer.parseInt(txtCodigo.getText().trim());
            arbol.eliminar(cod);
            mostrarResumen(arbol, grafo, "Se eliminó el código " + cod);
        });

        // 4. BOTÓN MOSTRAR TODO
        btnMos.addActionListener(e -> {
            mostrarResumen(arbol, grafo, "Listado completo actualizado:");
        });
    }

    private void mostrarResumen(clsArbolAbb arbol, clsGrafoRutas grafo, String aviso) {
        txtResul.setText(
                aviso + "\n\n" +
                        "1. ÁRBOL ABB EN ORDEN (INORDEN CON FLECHAS):\n" +
                        arbol.obtenerInordenFlechas() + "\n" +
                        "2. LISTA DE ADYACENCIA DEL GRAFO (CONEXIONES):\n" +
                        grafo.imprimirListaFlechas()
        );
    }
}