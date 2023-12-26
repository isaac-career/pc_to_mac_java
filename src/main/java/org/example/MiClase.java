package org.example;

public class MiClase {
    int i = 10;
    int suma;
    int suma_nueva;

    public MiClase() {
        //i = 10;
    }
    public void Suma_a_i( int j ) {

        suma = i + j;
        System.out.println(suma);
    }

    public String main (){

        suma_nueva = suma + 33;

        return (suma_nueva+"");

    }

    public static void main (String []args){
        MiClase m = new MiClase();
        m.Suma_a_i(5);
        System.out.println(m.main());

    }
}