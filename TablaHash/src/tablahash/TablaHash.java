package tablahash;

import java.util.*;

public class TablaHash {

    public static void main(String[] args) {
        Scanner dato = new Scanner(System.in);
        System.out.println("Ingrese el numero de buckets para la tabla hash:");
        int slots = dato.nextInt();
        dato.nextLine(); // agrega la ultima linea luego del int

        LinkedList<Persona>[] hashTable = new LinkedList[slots];
        for (int i = 0; i < slots; i++) {
            hashTable[i] = new LinkedList<>();
        }

        System.out.println("Ingrese el numero de personas a agregar:");
        int npersonas = dato.nextInt();
        dato.nextLine();

        for (int i = 0; i < npersonas; i++) {
            System.out.println("Persona " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = dato.nextLine();
            System.out.print("Edad: ");
            int edad = dato.nextInt();
            dato.nextLine();

            Persona persona = new Persona(nombre, edad);
            int hash = calcularHash(nombre, slots);
            hashTable[hash].add(persona);
        }

        System.out.println("Tabla:");
        for (int i = 0; i < slots; i++) {
            System.out.println("Bucket " + i + ":");
            System.out.println(hashTable[i]);
        }
        dato.close();
    }

    private static int calcularHash(String nombre, int slots) {
        int hash = 0;
        for (int i = 0; i < nombre.length(); i++) {
            hash += (int) nombre.charAt(i);
        }
        return hash % slots;
    }

    static class Persona {
        private String nombre;
        private int edad;

        public Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        @Override
        public String toString() {
            return "(" + nombre + ", " + edad + ")";
        }
    }
}