package ordering_exercices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ordering_strings_words {

    String first = "This is my best year";
    String newFirst = "Bunch of new ideas";
    String second;
    int third;
    ArrayList <String> myList;

    public ordering_strings_words(){
        myList = new ArrayList<>();
    }

    public void start() {


        do {
            third = first.indexOf(' ');
            if(third == -1)
                third=first.length();
            second = first.substring(0, third);
            first = first.substring(third);
            first = first.trim();
            System.out.println(second);

            myList.add(second);
            System.out.println(myList);

        } while (!first.isEmpty() );

        //normal_print(myList);
        reorder_print(myList);
    }

    public void Continue() {


        String [] newString = newFirst.split(" ");

        List<String > string_to_list = Arrays.asList(newString);
        reorder_print(string_to_list);
        //List<String> string_to_list = new ArrayList<>();

//        for (String ele:newString)
//            System.out.println(ele);

    }

    public void normal_print(List<String> myList){
        String result = "";
        for (String ele:myList)
            result+=ele+" ";

        result= result.trim();
        System.out.println(result);
    }
    public void reorder_print(List<String> myList){
        String result = "";
        for (int i = 1; i < myList.size(); i++) {
            result = result + " "+myList.get(i);

            if (i==myList.size()-1)
                result = result + " "+myList.get(0);
        }
        result=result.trim();
        System.out.println(result);

//        for (String ele:myList)
//            System.out.println(ele);




    }
    public static void main(String[] args) {
        ordering_strings_words os1 = new ordering_strings_words();
        //os1.start();
        os1.Continue();
    }
}
