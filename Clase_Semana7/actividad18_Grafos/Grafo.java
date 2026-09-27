import java.util.*;

public class Grafo {

    // Usamos un mapa para relacionar cada nodo con su lista de vecinos
    // Qro -> [Corregidora, Celaya, Jalpan]
    // Corregidora -> [Marques, Qro]
    // Celaya -> []
    private Map<String, List<String>> listaAdyacencia = new HashMap<>();

    // Metodo para agregar un vertice(nodo)
    public void agregarVertice(String vertice) {
        // Metodo que permite agregar elementos a un mapa, donde si no existe la llave, la crea, y si existe no la altera
        listaAdyacencia.putIfAbsent(vertice, new ArrayList<>());
    }

    // Metodo para agregar una arista
    public void agregarArista(String origen, String destino) {
        agregarVertice(origen);
        agregarVertice(destino);

        listaAdyacencia.get(origen).add(destino);
        listaAdyacencia.get(destino).add(origen);
    }

    public void mostrarGrafo() {
        for(String vertice : listaAdyacencia.keySet()) {
            System.out.println(vertice + " -> " + listaAdyacencia.get(vertice));
        }
    }

    private void dfaRecursivo(String actual, Set<String> visitados) {
        visitados.add(actual);
        System.out.println(actual + " ");
        // Visitar recursivamente a todos los vecinos no visitados
        for(String vecino : listaAdyacencia.get(actual)) {
            if (!visitados.contains(vecino)) {
               dfaRecursivo(vecino, visitados);
            } 
        }
    }

    // Busqueda en profundidad
    public void dfs(String inicio) {
        Set<String> visitados = new HashSet<>();
        System.out.println("DFS (Profundidad): ");
        //metodo recursivo de busqueda
        dfaRecursivo(inicio, visitados);
        System.out.println();
    }

    // Busqueda en Anchura
    public void bfs(String inicio) {
        Set<String> visitados = new HashSet<>();
        Queue<String> cola = new LinkedList<>();

        visitados.add(inicio);
        cola.add(inicio);

        System.out.println("BFS (Anchura): ");

        while (!cola.isEmpty()) {
            String actual = cola.poll(); // Enqueue - Extraer el elemento del frente de la cola
            System.out.println(actual + " ");

            // Recorrer los vecinos del nodo actual
            for(String vecino : listaAdyacencia.get(actual)) {
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        Grafo grafo = new Grafo();
        grafo.agregarArista("Enchiladas Queretanas", "Gorditas de maiz quebrado");
        grafo.agregarArista("Maiz quebrado", "Nopal de penca");
        grafo.agregarArista("Enchiladas Queretanas", "Barbacoa en hoyo");
        grafo.agregarArista("Barbacoa en hoyo", "Pequeño Lil");
        grafo.agregarArista("Quesadillas de Tamal", "Nieve de mantecado");

        System.out.println("REPRESENTACION DE EL GRAFO");
        grafo.mostrarGrafo();

        System.out.println("RECORRIDO EN PROFUNDIDAD");
        grafo.dfs("Enchiladas Queretanas");

        System.out.println("RECORRIDO EN ANCHURA");
        grafo.bfs("Enchiladas Queretanas");
    }
}
