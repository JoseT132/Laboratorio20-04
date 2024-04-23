
package parentesisb;
import java.util.*;

public class ParentesisB {


    public static void main(String[] args) {
       Scanner dato= new Scanner (System.in);
       System.out.println("Ingrese la expresion a evaluar");
       String expresion= dato.nextLine();
       
       if(balanceo(expresion)){
           System.out.println("La expresion esta balanceada");
       }else{
           System.out.println("La expresion no esta balanceada");
       }
    }
    
    public static boolean balanceo(String expresion){
        Stack<Character> pila= new Stack<>();
        
         for (char caracter : expresion.toCharArray()) {
            if (caracter == '(' || caracter == '[' || caracter == '{') {
                pila.push(caracter);
            } else if (caracter == ')' || caracter == ']' || caracter == '}') {
                if (pila.isEmpty()) {
                    return false; 
                }
                char caracterTope = pila.pop();
                if ((caracter == ')' && caracterTope != '(') ||
                    (caracter == ']' && caracterTope != '[') ||
                    (caracter == '}' && caracterTope != '{')) {
                    return false; // Los paréntesis no están balanceados
                }
            }
        }

        return pila.isEmpty(); // La pila debe estar vacía al final para que estén balanceados
    }
}
