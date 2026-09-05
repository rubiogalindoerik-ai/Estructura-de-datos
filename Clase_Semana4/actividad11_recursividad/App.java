public class App {
    public static void resolverTorreHanoi(int n, char origen, char auxiliar, char destino) {
        // Caso Base: si solo queda un disco lo movemos directamente
        if (n == 1) {
            System.out.println("Mover disco 1: " + origen + " -> " + destino);
            return;
        }
        // Mover n-1 discos del origen al auxiliar
        resolverTorreHanoi(n-1, origen, destino, auxiliar);
        // Mover el disco grande del origen al destino
        System.out.println("Mover disco " + n + ": " + origen + " -> " + destino);
        // Mover los discos del auxiliar al destino
        resolverTorreHanoi(n-1, auxiliar, origen, destino);
    }
    public static void main(String[] args) throws Exception{
    /* 
            * 
           ***
          *****
         *******
        *********
           | |
           | |
        int altura = 5;
        System.out.println("Arbol de navidad(Faltan 16 viernes)");
        // i es el contador de la fila actual
        for(int i = 1; i <= altura; i++ ){
            // Imprimir los espacios en blanco(Centrar el arbol)
            for(int j = 0; j< altura-i; j++) {
                System.out.print(" ");
            }
            // Imprimir los asteriscos
            for(int k = 0; k < (2*i-1); k++){
                System.out.print("*");
            }
            // Salto de linea
            System.out.println();
        }

        for(int l = 0; l < 2; l++) {
            for(int m = 0; m < altura - 2; m++) {
                System.out.println(" ");
            }
            System.out.println("| |");
        }
    */
        int numDiscos = 13;
        resolverTorreHanoi(numDiscos, 'A', 'B', 'C');
    }
}
