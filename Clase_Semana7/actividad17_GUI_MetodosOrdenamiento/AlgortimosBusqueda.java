public class AlgortimosBusqueda {
    public static int buscarLineal(int[] arreglo, int objetivo) {
        for(int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == objetivo) {
                return i;
            }
        }
        return -1;
    }

    // Busqueda binaria recursiva 0 (Log n)
    public static int busquedaBinaria(int[] arreglo, int izquierda, int derecha, int objetivo){
        if (izquierda > derecha) {
            return -1;
        }
        int medio = izquierda + (derecha - izquierda)/2;
        if (arreglo[medio] == objetivo) {
            return medio;
        }
        if (objetivo < arreglo[medio]) {
            return busquedaBinaria(arreglo, izquierda, medio-1, objetivo);
        }

        return busquedaBinaria(arreglo, medio+1, derecha, objetivo);
    }
}