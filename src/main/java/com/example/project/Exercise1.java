package com.example.project;

public class Exercise1 {

    public HashLinearProbing tb;

    public static void main(String[] args) {
        Exercise1 obj = new Exercise1();

        obj.tb = new HashLinearProbing(100);

        obj.insertarPersona(new Persona("12345678", "Jorge Chamby"));
        obj.insertarPersona(new Persona("12345679", "Juan Perez"));

        System.out.println(obj.encontrarPersona("12345678"));

        obj.eliminarPersona("12345678");

        System.out.println(obj.encontrarPersona("12345678"));
    }

  public void insertarPersona(Persona obj) {
        int indiceArray = Integer.parseInt(obj.DNI);
        tb.insertHash(indiceArray);
        // Llamar al metodo 'insertHash' modificado
    }

    public void eliminarPersona(String dni) {
        // Llamar al metodo 'deleteHash' modificado
        int indiceArray1 = Integer.parseInt(dni);
        tb.deleteHash(indiceArray1);
    }

    // Retorna NULL quando no se encontro el dni, y el nombre de la persona si lo encontro
    public String encontrarPersona(String dni) {
        int indiceArray = Integer.parseInt(dni);
        int cont = 0;
      
        return tb.findHash(indiceArray);
    }
}
