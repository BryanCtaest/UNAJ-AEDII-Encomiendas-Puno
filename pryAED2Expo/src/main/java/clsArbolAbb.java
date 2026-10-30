public class clsArbolAbb {

    // Igual que en el HTML del profesor: el Nodo va adentro del árbol
    static class Nodo {
        clsEncomienda dato;
        Nodo izquierdo, derecho;

        Nodo(clsEncomienda dato) {
            this.dato = dato;
        }
    }

    private Nodo raiz; // El árbol solo guarda la raíz

    // 1. BUSCAR POR CÓDIGO (Con flechas del camino recorrido)
    public clsEncomienda buscar(int cod) {
        return buscarRec(raiz, cod);
    }

    private clsEncomienda buscarRec(Nodo n, int cod) {
        if (n == null) return null; // Caso base: no está
        if (cod == n.dato.getCodTracking()) return n.dato; // Encontrado
        if (cod < n.dato.getCodTracking()) {
            return buscarRec(n.izquierdo, cod); // Menor: va a la izquierda
        }
        return buscarRec(n.derecho, cod); // Mayor: va a la derecha
    }

    // Muestra el camino con flechas: 50 -> 30 -> 20
    public String obtenerCaminoBusqueda(int cod) {
        StringBuilder camino = new StringBuilder("Raíz ");
        Nodo actual = raiz;
        while (actual != null) {
            camino.append(actual.dato.getCodTracking());
            if (cod == actual.dato.getCodTracking()) break;
            camino.append(" -> ");
            actual = (cod < actual.dato.getCodTracking()) ? actual.izquierdo : actual.derecho;
        }
        return camino.toString();
    }

    // 2. INSERTAR ENCOMIENDA
    public void insertar(clsEncomienda enc) {
        raiz = insertarRec(raiz, enc);
    }

    private Nodo insertarRec(Nodo n, clsEncomienda enc) {
        if (n == null) return new Nodo(enc); // Hueco encontrado: crea el nodo
        if (enc.getCodTracking() < n.dato.getCodTracking()) {
            n.izquierdo = insertarRec(n.izquierdo, enc);
        } else if (enc.getCodTracking() > n.dato.getCodTracking()) {
            n.derecho = insertarRec(n.derecho, enc);
        }
        return n;
    }

    // 3. ELIMINAR POR CÓDIGO (Los 3 casos del HTML)
    public void eliminar(int cod) {
        raiz = eliminarRec(raiz, cod);
    }

    private Nodo eliminarRec(Nodo n, int cod) {
        if (n == null) return null;
        if (cod < n.dato.getCodTracking()) {
            n.izquierdo = eliminarRec(n.izquierdo, cod);
        } else if (cod > n.dato.getCodTracking()) {
            n.derecho = eliminarRec(n.derecho, cod);
        } else {
            // Casos 1 y 2: hoja o un solo hijo
            if (n.izquierdo == null) return n.derecho;
            if (n.derecho == null) return n.izquierdo;
            // Caso 3: dos hijos -> reemplaza con el menor de la derecha (sucesor)
            Nodo sucesor = minimo(n.derecho);
            n.dato = sucesor.dato;
            n.derecho = eliminarRec(n.derecho, sucesor.dato.getCodTracking());
        }
        return n;
    }

    private Nodo minimo(Nodo n) {
        while (n.izquierdo != null) n = n.izquierdo;
        return n;
    }

    // 4. RECORRIDO INORDEN CON FLECHAS (Sale ordenado de menor a mayor)
    public String obtenerInordenFlechas() {
        if (raiz == null) return "(Árbol vacío)";
        StringBuilder sb = new StringBuilder();
        inordenRec(raiz, sb);
        return sb.toString();
    }

    private void inordenRec(Nodo n, StringBuilder sb) {
        if (n == null) return;
        inordenRec(n.izquierdo, sb); // 1. Izquierda
        sb.append(" -> ").append(n.dato.obtenerResumenTexto()).append("\n"); // 2. Raíz
        inordenRec(n.derecho, sb);   // 3. Derecha
    }
}