package com.example.project;

import java.util.Random;

public class HashLinearProbing {
   private int hsize; // tamano de la tabla hash
    private Persona[] buckets; // array que representa la tabla hash
    private Integer AVAILABLE;
    private int size; // cantidad de elementos en la tabla hash

    public HashLinearProbing(int hsize) {
        this.buckets = new Persona[hsize];
        this.hsize = hsize;
        this.AVAILABLE = Integer.MIN_VALUE;
        this.size = 0;
    }

    public int hashing(int key) {
        int hash = key % hsize;
        if (hash < 0) {
            hash += hsize;
        }
        return hash;
    }

    public void insertHash(Persona persona) {
        Persona wrappedInt = persona;
        String dni = persona.getDni();
        int key = Integer.parseInt(dni);

        int hash = hashing(key);

        if (isFull()) {
            System.out.println("Tabla hash esta llena!");
            return;
        }

        for (int i = 0; i < hsize; i++) { 
            int element = Integer.parseInt(buckets[hash].getDni());
            if (buckets[hash] == null || element == AVAILABLE) {
                buckets[hash] = wrappedInt;
                size++;
                return;
            }

            if (hash + 1 < hsize) {
                hash++;
            } else {
                hash = 0;
            }
        }
    }

    public void deleteHash(String dni) {
        
        int key = Integer.parseInt(dni);
        String wrappedInt = dni;
        int hash = hashing(key);

        if (isEmpty()) {
            System.out.println("Tabla hash esta vacia!");
            return;
        }

        for (int i = 0; i < hsize; i++) {
            if (buckets[hash] != null && buckets[hash].equals(wrappedInt)) {
                buckets[hash] = AVAILABLE;
                size--;
                return;
        }

        for (int i = 0; i < hsize; i++) {
            int element = Integer.parseInt(buckets[hash].getDni());
            if (buckets[hash] != null && buckets[hash].getDni().equals(wrappedInt)) {
                element = AVAILABLE;
                buckets[hash] = null;
                size--;
                return;
            }

            if (hash + 1 < hsize) {
                hash++;
            } else {
                hash = 0;
            }
        }
        System.out.println("Clave " + key + " no encontrada");
    }

    public int findHash(String dni) {

        String wrappedInt = dni;
        int key = Integer.parseInt (dni);
        
        int hash = hashing(key);

        if (isEmpty()) {
            System.out.println("Tabla hash esta vacia!");
            return -1;
        }

        for (int i = 0; i < hsize; i++) {
            try {
                if (buckets[hash].equals(wrappedInt)) {
                    int element = Integer.parseInt(buckets[hash].getDni());
                    element = AVAILABLE;
                    return hash;
                }
            } catch (Exception E) {
            }

            if (hash + 1 < hsize) {
                hash++;
            } else {
                hash = 0;
            }
        }
        System.out.println("Clave " + key + " no encontrada!");
        return -1;
    }    
    public boolean isFull() {        
        return size == hsize;
    }

    public boolean isEmpty() {
        boolean response = true;
        for (int i = 0; i < hsize; i++) {
            if (buckets[i] != null) {
                response = false;
                return response;
                //break;
            }
        }
        return response;
    }


    public static void main (String[] args){
        HashLinearProbing tb = new HashLinearProbing(10);

        Random rd = new Random();

        for(int i = 0; i < 5; i++){
            tb.insertHash(rd.nextInt(100));
        }

        tb.displayHashtable();        
    }
}
