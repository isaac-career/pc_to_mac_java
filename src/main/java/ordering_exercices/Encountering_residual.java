package ordering_exercices;

public class Encountering_residual {

    public Encountering_residual(){

    }

    public boolean start(int n1, int n2){
        boolean response = false;
        int residual = (n1+n2)%20;

        if (residual >0 && residual < 3)
            response = true;

        return response;
    }

    public boolean start2(int n1, int n2){
        boolean response = false;
        int residual = (n1+n2)%20;

        if (residual >17)
            response = true;

        return response;
    }

    public static void main(String[] args) {

        Encountering_residual residual = new Encountering_residual();
        System.out.println(residual.start2(35, 1));
    }
}
