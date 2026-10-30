import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class clsGrafoRutas {

    private String[] nomCiudades = {"JULIACA", "PUNO", "LAMPA", "PUCARA", "AYAVIRI", "AZANGARO", "HUANCANE"};
    private List<List<Integer>> lista; // Lista de adyacencia

    public clsGrafoRutas() {
        lista = new ArrayList<>();
        for (int i = 0; i < nomCiudades.length; i++) {
            lista.add(new ArrayList<>());
        }
    }

    public String[] getNomCiudades() {
        return nomCiudades;
    }

    public int indice(String nombre) {
        for (int i = 0; i < nomCiudades.length; i++) {
            if (nomCiudades[i].equals(nombre)) return i;
        }
        return -1;
    }

    // Agrega una carretera en doble sentido (No dirigido)
    public void agregarArista(String a, String b) {
        int i = indice(a);
        int j = indice(b);
        lista.get(i).add(j);
        lista.get(j).add(i);
    }

    // BFS con Cola para hallar el camino más corto con flechas: LAM -> JUL -> PUC -> AYA
    public String caminoMasCortoBfs(String origen, String destino) {
        if (origen.equals(destino)) return origen + " -> " + destino + " (0 tramos)";

        int s = indice(origen);
        int t = indice(destino);
        int[] padre = new int[nomCiudades.length];
        boolean[] visitado = new boolean[nomCiudades.length];
        for (int i = 0; i < padre.length; i++) padre[i] = -1;

        Queue<Integer> cola = new ArrayDeque<>();
        visitado[s] = true;
        cola.add(s);

        while (!cola.isEmpty()) {
            int v = cola.poll();
            if (v == t) break;
            for (int w : lista.get(v)) {
                if (!visitado[w]) {
                    visitado[w] = true;
                    padre[w] = v;
                    cola.add(w);
                }
            }
        }

        List<String> camino = new ArrayList<>();
        for (int v = t; v != -1; v = padre[v]) {
            camino.add(0, nomCiudades[v]);
        }
        return String.join(" -> ", camino) + " (" + (camino.size() - 1) + " tramos)";
    }

    // Imprime la lista de adyacencia con flechas igual que en el HTML de la Semana 4
    public String imprimirListaFlechas() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nomCiudades.length; i++) {
            sb.append("  ").append(nomCiudades[i]).append(" -> ");
            List<Integer> vecinos = lista.get(i);
            for (int k = 0; k < vecinos.size(); k++) {
                if (k > 0) sb.append(", ");
                sb.append(nomCiudades[vecinos.get(k)]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}