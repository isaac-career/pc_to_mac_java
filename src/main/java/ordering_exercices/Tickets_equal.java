package ordering_exercices;

public class Tickets_equal {

    public void start(int a, int b, int c){
        int response = 0;

        if(a==b){
            if (b==c){

                if(a==2)
                    response= 10;
                else
                    response = 5;
            }

        }else {
            if(c != a){
                response=1;
            }
        }

        System.out.println(response);
    }//close method


    public static void main(String[] args) {
        Tickets_equal ticket = new Tickets_equal();
        ticket.start(1, 0, 0);
    }
}
