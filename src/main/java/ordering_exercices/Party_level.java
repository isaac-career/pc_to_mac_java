package ordering_exercices;

public class Party_level {


    public Party_level(){

    }


    public int get_party_level(int die1, int die2){
        int result = 0;

        if(die1 >5 && die2 >5)

            if(die1 != die2){
                if(die1>=die2*2 || die2>=die1*2)
                    result = 2;
                else result =1;

            }




        return result;
    }


    public static void main(String[] args) {

        Party_level party = new Party_level();
        System.out.println(party.get_party_level(20, 6));


    }
}
