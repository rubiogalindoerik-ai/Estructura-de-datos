/*
VALIDADOR DE PARENTESIS BALANCEADOS
Verificaar si una expresion matematica como (A + B) * (C - D) tiene
sus parentesis correctamente abiertos y cerrados.

Pistas:
Cada vez que se encuentra un (, hacen un push.
Cada vez que se encuentra un ), hacen un pop. Si al final la pila
queda vacia, la expresion es correcta.
*/

public class validadorParentesis {
    public static boolean validador(String texto) {
        // Usar nuestra estructura Stack(pila)
        Stack<Character> pila = new Stack<>();
        for(int i = 0; i < texto.length(); i++) {
            char Character = texto.charAt(i);

            if (Character == '(' || Character == '[' || Character == '{') {
                pila.push(Character);
            } else if (Character == ')' || Character == ')' || Character == ')') {
                if (pila.isEmpty()) {
                    return false;
                }
                pila.pop();
            } 
        }

        return pila.isEmpty();
    }
}
