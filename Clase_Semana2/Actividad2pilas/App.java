public class App {
    public static void main(String[] args) throws Exception{
        Stack<Integer> pila = new Stack<>();

        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        System.out.println(pila.peek()); // 4
        pila.pop(); // 3, 2, 1
        System.out.println(pila.peek()); // 3
        pila.showStack(); // 3, 2, 1

        String caso1 = "(A + B) * (C - D)";
        String caso2 = "((A+B)*C";
        String caso3 = "(A + B)) * (C - D";

        System.out.println("Validador de parentesis");
        System.out.println("Expresion: " + caso1 + " ¿Está correcta?: " + validadorParentesis.validador(caso1));
        System.out.println("Expresion: " + caso2 + " ¿Está correcta?: " + validadorParentesis.validador(caso2));
        System.out.println("Expresion: " + caso3 + " ¿Está correcta?: " + validadorParentesis.validador(caso3));
    }
}
