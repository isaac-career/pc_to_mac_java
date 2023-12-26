package ordering_exercices;

public class ClassnoDoubles {

    public ClassnoDoubles(){

    }

    public int with_out_Doubles(int die1, int die2, boolean noDoubles){
        int result = die1+die2;

        if(die1 ==die2 && noDoubles){
            result+=1;


            if(result==6) result =1;

        }

        return result;
    }


    public static void main(String[] args) {

        ClassnoDoubles nodouble = new ClassnoDoubles();
        System.out.println(nodouble.with_out_Doubles(3, 3, true));

    }
}
