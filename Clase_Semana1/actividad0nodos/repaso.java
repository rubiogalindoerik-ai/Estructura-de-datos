//este es un comentario de una sola linea
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        System.out.println("Hola Mundo");
        //numeros enteros
        int edad = 19;
        //numeros reales
        float altura = 1.74f;
        double peso = 100.5;
        //caracteres
        String nombre = "sarai";
        char grupo = 'A';
        // logico
        boolean esEstudiante = true;
        System.out.println("\n -Datos del alumno");
        System.out.println("nombre: " + nombre);
        System.out.println("edad: " + edad + " anios");
        
        //operaciones.
        int a =10;
        int b = 5;
        int suma = a + b;
        System.out.println("suma = " + suma);
        //entrada de datos
        Scanner scan = new Scanner(System.in);
        System.out.println("De que estado eres?");
        String estado = scan.nextLine();
        System.out.println("Eres de " + estado);
        //Estructuras condicionales
        System.out.println("Ingresa la calificion");
        int calif = scan.nextInt();
        if(calif >= 90 && calif <= 100){
          System.out.println("Excelente");  
        }else if(calif >= 80 && calif <= 90){
          System.out.println("Aprobado");  
        }else if(calif >= 70 && calif <= 80){
          System.out.println("De pansazo");  
        }else if(calif >= 70 && calif <= 0){
            System.out.println("Reprobado");
        }else{
            System.out.println("Calificacion no valida, intenta de nuevo");
        }
        //Estructuras de repeticion(ciclos)
        //for
        System.out.println("Que tabla de multiplicar deseas generar:");
        int numTabla = scan.nextInt();
        for(int i=1; i <= 10; i++){
            int resultado = numTabla * i;
            System.out.println(numTabla + "*" + i + "=" + resultado);
        }   
        //while
        int contador = 5;
        while(contador > 0){
            System.out.println("Despegue en: " + contador);
            contador --;
        }
        System.out.println("Despegue !!!! ");
        //do-while swicht-case
        int opcion;
        do{
           System.out.println("-Menu");
           System.out.println("1.Saludar");
           System.out.println("2.Mostrar hora");
           System.out.println("3.Salir");
           System.out.println("Elije una opcion(1-3)");
           opcion = scan.nextInt();
           switch(opcion){
               case 1:
                   System.out.println("Hola");
                   break;
                case 2:
                    System.out.println("Hora: 09:07");
                    break;
                case 3:
                    System.out.println("Gracias, vuelva pronto");
                    break;
                default:
                System.out.println("Opcion no valida");
           }
        }while(opcion != 3);
        scan.close();
    }
}
