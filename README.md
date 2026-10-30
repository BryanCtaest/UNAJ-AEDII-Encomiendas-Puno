# 📦 Sistema de Encomiendas y Rutas en Puno (ABB + Grafo BFS)

**Universidad Nacional de Juliaca (UNAJ)**  
**Escuela Profesional de Ingeniería de Software y Sistemas — IV Ciclo**  
**Curso:** Algoritmos y Estructuras de Datos II  

* **Estudiante:** Bryan Alexander Perez Quispe
* **Docente:** Ing. Noe Wilber Tipo Mamani
* **Código de Entrega:** `UNAJ-AEDII-PRODUCTO-I-noe_tipo_bryan_perez`

---

## 🌐 Guía Interactiva y Simulador en Vivo
👉 **[Haz clic aquí para abrir el Dashboard de Exposición y Simulador en Vivo](https://bryanctaest.github.io/UNAJ-AEDII-Encomiendas-Puno/)**

---

## 🚀 Descripción del Sistema
Aplicación de escritorio en **Java Swing** diseñada para optimizar el registro de encomiendas y el despacho de rutas interprovinciales entre las 7 provincias conectadas de la región Puno (**Juliaca, Puno, Lampa, Pucará, Ayaviri, Azángaro y Huancané**):

1. **Estructura 1 — Árbol Binario de Búsqueda (`clsArbolAbb.java`):**
   * Almacena y ordena cada paquete por su código de seguimiento (`codTracking`).
   * Operaciones de búsqueda, inserción y eliminación (3 casos: hoja, 1 hijo, 2 hijos con sucesor inorden) en complejidad $O(h)$.
   * Reporte ordenado ascendente mediante recorrido **Inorden** en $O(n)$.

2. **Estructura 2 — Grafo No Dirigido con BFS (`clsGrafoRutas.java`):**
   * Representa las 7 provincias y 8 carreteras mediante una **Lista de Adyacencia**.
   * Calcula la ruta con menor cantidad de paradas intermedias utilizando **Búsqueda en Anchura (BFS)** y una **Cola FIFO (`ArrayDeque`)** en complejidad $O(V + E)$.

---

## 📂 Estructura del Repositorio
* 📁 **`pryAED2Expo/`**: Proyecto completo en Java Swing (Maven) listo para abrir y ejecutar desde `src/main/java/main.java` en IntelliJ IDEA.
* 📊 **`UNAJ-AEDII-PRODUCTO-I-noe_tipo_bryan_perez.pptx`**: Diapositivas de sustentación del Producto Académico I.
* 💻 **`index.html`**: Guía interactiva del código clase por clase y simulador funcional en el navegador.
