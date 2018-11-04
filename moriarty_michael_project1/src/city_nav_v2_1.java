//--------------------------------------------------------
//“Streets” run East/West
//"Avenues” run North/South
//
//lower-numbered streets are furthest south(100).
//Odd streets run west to east(→).
//Even streets run east to west(←).
//
//lower-numbered avenues are furthest east(10).
//Odd avenues run south to north(↑).
//Even avenues run north to south(↓).
//-------------------------------------------------------

//-------------------------------------------------------
//input_Start_end Array:
//0 - Starting Street
//1 - Starting Avenue
//2 - Destination Street
//3 - Destination Avenue
//-------------------------------------------------------


import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class city_nav_v2_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] road = {"street", "avenue"};
        int[] input_Start_end = new int[4];

        //Getting starting and ending location//
        //-----------------------------------------------
        //Starting Location
        for (int i = 0;i < 2;i++) {
            System.out.printf("What %s are you starting from?\n", road[i]);
            if (sc.hasNextInt()) {
                input_Start_end[i] = sc.nextInt();
            }
        }
        //Ending Location
        for (int j = 0; j < 2; j++) {
            System.out.printf("What %s are you going to?\n", road[j]);
            if (sc.hasNextInt()) {
                input_Start_end[j+2] = sc.nextInt();
            }
        }

        boolean Cont_mvmt = true;
        if (input_Start_end[0] == input_Start_end[2] && input_Start_end[1] == input_Start_end[3])
            Cont_mvmt = false;

        //Direction orientation//
        //-----------------------------------------------

        boolean s_west = false;
        boolean s_east = false;
        boolean s_north = false;
        boolean s_south = false;

        boolean e_west = false;
        boolean e_east = false;
        boolean e_north = false;
        boolean e_south = false;

        String pos_dir [] = new String[4];

        //Test if starting Street is even or odd.
        if(input_Start_end[0]%2 == 0){
            //System.out.println("Even Street");
            s_west = true;
            pos_dir[0] = "west";
        }
        else{
            //System.out.println("Odd Street");
            s_east = true;
            pos_dir[0] = "east";
        }

        //Test if starting Avenue is even or odd.
        if (input_Start_end[1] % 2 == 0){
            //System.out.println("Avenue is even");
            s_south = true;
            pos_dir[1] = "south";
        }
        else{
            //System.out.println("Avenue is odd");
            s_north = true;
            pos_dir[1] = "north";
        }


        //Test if ending Street is even or odd
        if(input_Start_end[2]%2 == 0){
            //System.out.println("Even Street");
            e_west = true;
            pos_dir[2] = "west";
        }
        else{
            //System.out.println("Odd Street");
            e_east = true;
            pos_dir[2] = "east";
        }

        //Test if ending Avenue is even or odd.
        if (input_Start_end[3] % 2 == 0){
            //System.out.println("Avenue is even");
            e_south = true;
            pos_dir[3] = "south";
        }
        else{
            //System.out.println("Avenue is odd");
            e_north = true;
            pos_dir[3] = "north";
        }



        // Movement Logic//
        //-----------------------------------------------
        List Steps = new ArrayList();

        //look for min distance w/o direction restriction
        int ns_dist = input_Start_end[2] - input_Start_end[0];
        int ew_dist = input_Start_end[3] = input_Start_end[1];


        while (Cont_mvmt){
            for (int k = 0;k<20;k++){

            }

        }

        // test print statements//
        //-----------------------------------------------

        //Printing input_Start_end//
//        for(int k = 0;k<input_Start_end.length;k++){
//            System.out.println(input_Start_end[k]);
//        }

        // Print boolean directions values//
//        System.out.println(west);
//        System.out.println(east);
//        System.out.println(north);
//        System.out.println(south);

    }
}

