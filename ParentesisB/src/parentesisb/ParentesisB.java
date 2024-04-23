
package parentesisb;
import java.util.*;

public class ParentesisB {

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa una expresion matematica:");
        String expresion = scanner.nextLine();

        if (validarExpresion(expresion)) {
            System.out.println("La expresion es valida.");
        } else {
            System.out.println("La expresion contiene caracteres no permitidos o los parentesis no estan balanceados.");
        }

        scanner.close();

    }

    public static boolean validarExpresion(String expresion) {
        // Expresion regular para permitir solo letras, numeros, signos matematicos y parentesis
        String regex = "^[a-zA-Z0-9\\Q+-*/%^()\\E]+$";

        // Verificar la expresion con la expresion regular
        if (!expresion.matches(regex)) {
            return false; // La expresion contiene caracteres no permitidos
        }

        // Verificar si la expresion contiene tanto letras como numeros
        boolean contieneLetras = false;
        boolean contieneNumeros = false;

        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);
            if (Character.isLetter(caracter)) {
                contieneLetras = true;
            } else if (Character.isDigit(caracter)) {
                contieneNumeros = true;
            }
        }

        if (!contieneLetras || !contieneNumeros) {
            return false; // La expresion debe contener tanto letras como numeros
        }

        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);
            if (caracter == '(') {
                pila.push(caracter);
            } else if (caracter == ')') {
                if (pila.isEmpty()) {
                    return false; // Hay un cierre sin su correspondiente apertura
                }
                pila.pop();
            }
        }

        return pila.isEmpty(); // La pila debe estar vacía al final si los paréntesis están balanceados
    }
}
