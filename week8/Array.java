package week8;
import java.util.ArrayList;
public class Array {
    
    public static void main(String[] args) {
        //Array only
        int size = 3;
        String[] name_array = new String[size];
        name_array[0] = "Max";
        name_array[1] = "Ball";
        name_array[2] = "Flip";
        size = size-1;
        String[] name_array_02 = new String[size];
        for(int i=0; i<size; i++){
            name_array_02[i] = name_array[i];
            System.out.println(name_array);
        }

        System.out.println(name_array_02.length);


        //ArrayList
        ArrayList<String> names = new ArrayList<>();
        names.add("Flukie");
        names.add("Mannie"); 
        names.add("Omini");

        names.set(1, "manie pakiew");


        //print array
        //System.out.println(name_array[0]);
        //System.out.println(name_array[1]);
        //System.out.println(name_array[2]);

        //print arraylist
        
        System.out.println(names); //before
        names.remove(2);
        System.out.println(names); //after
        System.out.println(names.size());






        //C->OK   R=>OK   U   D
    }
}
