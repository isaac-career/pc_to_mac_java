package OOP_exercices;

public class base {

    int first_result, final_result;
    extra ex;
    String chain;
    public base() {

        ex = new extra();

    }

    public void start(){
         first_result= 4;
         final_result= ex.addition(5,first_result);
         ex.printOnConsole(final_result+"");



    }


    public static void main(String[] args) {
        base b= new base();
        b.start();
    }
}
