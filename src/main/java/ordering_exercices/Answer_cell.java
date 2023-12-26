package ordering_exercices;

public class Answer_cell {

    public void start(boolean isMorning, boolean isMom, boolean isAsleep){
        boolean response = true;

        if(isMorning){
            response = isMom;
        }else {
            if(isAsleep)
                response = false;

        }


        System.out.println(response);



    }



    public static void main(String[] args) {
        Answer_cell answer = new Answer_cell();
        answer.start(false, false, false);

    }
}
