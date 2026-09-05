public class App {

    public static void cuentaregresiva(int n){
        // CASO BASE: Cuando n llega a 0, detenemos la recursividad
        if (n == 0){
            System.out.println("Depegue!!!!");
            return;
        }
        System.out.println("Numero: " + n);
        // Recursividad
        cuentaregresiva(n - 1);

    }

    // n! = 4! = 4 * 3 * 2 * 1 = 24
    public static int calcularFactorial(int n) {
        // Caso Base
        if (n == 0 || n == 1) return 1;
        return n * calcularFactorial(n-1);
    }

    public static int sumar(int[] arreglo, int indice) {
        // Caso Base
        if (indice == arreglo.length) {
            return 0;
        }
        return arreglo[indice] + sumar(arreglo, indice + 1);
    }

    public static int calcularPotencia(int base, int exponente) {
        // Caso Base
        if (exponente == 0) return 1;
        return base * calcularPotencia(base, exponente-1);
    }

    public static String invertirPalabra(String palabra) {
        // Caso Base
        if (palabra == null || palabra.length() <=1) return palabra;
        // Tom el ultimo caracter e invierte el resto de la cadena
        // Palabra.substring(1) quita la primera letra
        // Palabra.charAt(0) toma la primera palabra para llevarla al final
        return invertirPalabra(palabra.substring(1)) + palabra.charAt(0);
    }

    // Lista recursiva
    public static class Nodo {
        public int dato;
        public Nodo next;

        public Nodo(int dato){
            this.dato = dato;
            this.next = null;
        }
    }

    public static void imprimirListaRecursiva(Nodo actual) {
        // Caso Base
        if (actual == null) {
            System.out.println("null");
            return;
        }

        System.out.print(actual.dato + " ->");
        imprimirListaRecursiva(actual.next);
    }

    public static void imprimirAlReves(Nodo actual) {
        if (actual == null) {
            return;
        }
        imprimirAlReves(actual.next);
        System.out.print(actual.dato + " -> ");
    }

    // Algoritmos de divide y venceras
    // Busqueda binaria recursiva
    public static int busquedaBinaria(int[] arreglo, int objetivo, int izquierda, int derecha) {
        // Caso Base
        if (izquierda > derecha) {
            return -1;
        }
        int medio = izquierda + (derecha - izquierda) / 2;
        // Comprobacion: verificar si el elemento buscado esta justo en medio
        if (arreglo[medio] == objetivo) {
            return medio;
        }

        if (objetivo < arreglo[medio]) {
            return busquedaBinaria(arreglo, objetivo, izquierda, medio-1);
        } else {
            return busquedaBinaria(arreglo, objetivo, medio+1, derecha);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Iniciando cuenta regresiva");
        cuentaregresiva(10);

        int numero = 4;
        int resultado = calcularFactorial(numero);
        System.out.println("El factorial de: " + numero + " es: " + resultado);

        int[] numeros = {2,4,5,8};
        int resultadoSuma = sumar(numeros, 0);
        System.out.println("La suma de los numeros es: " + resultadoSuma);

        int base = 2;
        int exponente = 4;
        int resultadoP = calcularPotencia(base, exponente);
        System.out.println("El resultado es: " + resultadoP);

        String texto = "Hola";
        String textoInvertido = invertirPalabra(texto);
        System.out.println("Palabra original: " + texto);
        System.out.println("Palabra invertida: " + textoInvertido);

        Nodo head = new Nodo(6);
        head.next = new Nodo(7);
        head.next.next = new Nodo(6);
        System.out.println("Imprimiendo lista de manera recursiva:");
        imprimirListaRecursiva(head);

        int[] datos = {2,5,8,12,16,23,29,30};
        int buscar = 29;
        int resultadoB = busquedaBinaria(datos, buscar, 0, datos.length);
        if (resultadoB != 1) {
            System.out.println("Elemento encontrado, esta en el indice: " + resultado);
        } else {
            System.out.println("Elemento no encontrado");
        }
    }
}