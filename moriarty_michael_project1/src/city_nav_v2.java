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



import java.util.Scanner;

public class city_nav_v2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] road = {"street", "avenue"};
        int[] input_Start_end = new int[4];

        //Getting starting and ending location//
        //-----------------------------------------------
        //Starting Location
        for (int i = 0; i < 2; i++) {
            System.out.printf("What %s are you starting from?\n", road[i]);
            if (sc.hasNextInt()) {
                input_Start_end[i] = sc.nextInt();
            }
            else{
                System.out.println("Input was not a valid integer.");
                System.exit(0);
            }
        }
        //Ending Location
        for (int j = 0; j < 2; j++) {
            System.out.printf("What %s are you going to?\n", road[j]);
            if (sc.hasNextInt()) {
                input_Start_end[j+2] = sc.nextInt();
            }
            else{
                System.out.println("Input was not a valid integer.");
                System.exit(0);
            }
        }

        //Logic//
        //-----------------------------------------------

        boolean west = false;
        boolean east = false;
        boolean north = false;
        boolean south = false;

        //Test if starting Street is even or odd.
        if(input_Start_end[0]%2 == 0){
            //System.out.println("Even Street");
            west = true;
        }
        else{
            //System.out.println("Odd Street");
            east = true;
        }

        //Test if starting Avenue is even or odd.
        if (input_Start_end[1] % 2 == 0){
            //System.out.println("Avenue is even");
            south = true;
        }
        else{
            //System.out.println("Avenue is odd");
            north = true;
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

