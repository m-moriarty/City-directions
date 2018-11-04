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


//Forget the complex go simple

import jdk.internal.cmm.SystemResourcePressureImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class city_nav_v2_2 {

    public static ArrayList<Integer> trip_input(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> input_start_end = new ArrayList<Integer>();

        //Getting starting and ending location//
        //-----------------------------------------------
        //Starting Street Location
        System.out.println("What street are you starting from?");
        if (sc.hasNextInt()) {
            int value = sc.nextInt();
            if (value <= 0 || value > 100) {
                System.out.println("Input was not a valid integer(1-100).");
                System.exit(0);
            }
            input_start_end.add(value);
        }
        else {
            System.out.println("Input was not an integer.");
            System.exit(0);
        }

        System.out.println("What avenue are you starting from?");
        if(sc.hasNextInt()){
            int value = sc.nextInt();
            if (value <= 0 || value > 10) {
                System.out.println("Input was not a valid integer(1-10).");
                System.exit(0);
            }
            input_start_end.add(value);
        }
        else{
            System.out.println("Input was not an integer.");
            System.exit(0);
        }



        //Ending Location

        System.out.println("What street are you going to?");
        if (sc.hasNextInt()) {
            int value = sc.nextInt();
            if (value <= 0 || value > 100) {
                System.out.println("Input was not a valid integer(1-100).");
                System.exit(0);
            }
            input_start_end.add(value);
        }
        else {
            System.out.println("Input was not an integer.");
            System.exit(0);
        }

        System.out.println("What avenue are you going to?");
        if(sc.hasNextInt()){
            int value = sc.nextInt();
            if (value <= 0 || value > 10) {
                System.out.println("Input was not a valid integer(1-10).");
                System.exit(0);
            }
            input_start_end.add(value);
        }
        else{
            System.out.println("Input was not an integer.");
            System.exit(0);
        }
        return input_start_end;
    }

    public static void main(String[] args) {
        ArrayList<Integer> start_end_data = trip_input();
       int pos_s = start_end_data.get(0);
       int pos_a =  start_end_data.get(1);
       int e_pos_s = start_end_data.get(2);
       int e_pos_a = start_end_data.get(3);
       int max_st = 100;
       int max_ave = 10;

        boolean west = false;
        boolean east = false;
        boolean north = false;
        boolean south = false;

        boolean e_west = false;
        boolean e_east = false;
        boolean e_north = false;
        boolean e_south = false;

        //Test if starting Street is even or odd.
        if(start_end_data.get(0)%2 == 0){
            //System.out.println("Even Street");
            west = true;
        }
        else{
            //System.out.println("Odd Street");
            east = true;
        }

        //Test if starting Avenue is even or odd.
        if (start_end_data.get(1) % 2 == 0){
            //System.out.println("Avenue is even");
            south = true;
        }
        else{
            //System.out.println("Avenue is odd");
            north = true;
        }

        //Test if destination street is even or odd.
        if(start_end_data.get(2)%2 == 0){
            //System.out.println("Even Street");
            e_west = true;
        }
        else{
            //System.out.println("Odd Street");
            e_east = true;
        }
        //Test if destination Avenue is even or odd.
        if (start_end_data.get(3) % 2 == 0){
            //System.out.println("Avenue is even");
            e_south = true;
        }
        else{
            //System.out.println("Avenue is odd");
            e_north = true;
        }

        //------------------------------------------------
        //get the distance and direction which needs to be moved
        int st_dist  = start_end_data.get(2) - start_end_data.get(0);
        int ave_dist = start_end_data.get(3) - start_end_data.get(1);
        //-------------------------------------------------

        if (west && e_west){
            if (south && e_south){
                if (st_dist < 0){
                    if (ave_dist < 0){
                        //directions are:
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a +" Avenue.");
                        System.out.println("Head South on " + pos_a +" Avenue for " + (ab_st_dist - 1) + " block(s).");
                        pos_s = pos_s - (ab_st_dist - 1);
                        System.out.println("Head East on "+ pos_s + " Street for "+ (ab_ave_dist) + " blocks.");
                        pos_a = pos_a - (ab_ave_dist);
                        System.out.println("Head South on " + pos_a + " Avenue for 1 block.");
                        System.out.println("You drove "+ (ab_ave_dist + ab_st_dist) + " blocks.");
                    }
                    else if (ave_dist > 0){
                        //directions are:
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a +" Avenue.");
                        System.out.println("Head South on " + pos_a +" Street for " + (ab_st_dist) + " blocks.");
                        pos_s = pos_s - (ab_st_dist);
                        System.out.println("Head West on "+ pos_s + " Avenue for "+ (ab_ave_dist) + " blocks.");
                        System.out.println("You drove "+ (ab_ave_dist + ab_st_dist) + " blocks.");
                    }
                    else if ( ave_dist == 0){
                        //directions are:
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a +" Avenue.");
                        System.out.println("Head South on " + pos_a +" Avenue for " + (ab_st_dist) + " blocks.");
                        System.out.println("you drove "+ (ab_ave_dist + ab_st_dist) + " blocks.");
                    }

                }
                else if (st_dist > 0){
                    if (ave_dist < 0){
                        if (pos_a < max_ave){
                            //directions are:
                            int ab_st_dist = java.lang.Math.abs(st_dist);
                            int ab_ave_dist = java.lang.Math.abs(ave_dist);
                            System.out.println("Start at " + pos_s + " Street and " + pos_a +" Avenue.");
                            System.out.println("Head West on " + pos_s +" Street for 1 block.");
                            pos_a = pos_a +1;
                            System.out.println("Head North on "+ pos_a + " Avenue for "+ (ab_st_dist - 1) + " block(s).");
                            pos_s = pos_s + (ab_st_dist - 1);
                            System.out.println("Head East on " + pos_s + " Street for " + (ab_ave_dist + 2) +" block.");
                            pos_a = pos_a - (ab_ave_dist + 2);
                            System.out.println("Head North on "+ pos_a + " Avenue for 1 block.");
                            pos_s = pos_s + 1;
                            System.out.println("Head West on " + pos_s +" Street for 1 block.");
                            System.out.println("You drove "+ (ab_ave_dist + ab_st_dist + 2) + " blocks.");

                        }
                        //Special Case if starting at max ave
                        else if (pos_a == max_ave){
                            int ab_st_dist = java.lang.Math.abs(st_dist);
                            int ab_ave_dist = java.lang.Math.abs(ave_dist);
                            System.out.println("Start at " + pos_s + " Street and " + pos_a +" Avenue.");
                            System.out.println("Head South on " + pos_a + " Avenue for 1 block.");
                            pos_s = pos_s - 1;
                            System.out.println("Head East on " + pos_s + " Street for 1 block.");
                            pos_a = pos_a - 1;
                            System.out.println("Head North on " + pos_a + " Avenue for "+ ab_st_dist +" blocks.");
                            pos_s = pos_s + ab_st_dist;
                            System.out.println("Head East on " + pos_s + " Street for " + ab_ave_dist +" blocks.");
                            pos_a = pos_a + ab_ave_dist;
                            System.out.println("Head North on " + pos_a + " Avenue for 1 block.");
                            pos_s = e_pos_s + 1;
                            System.out.println("Head West on " + pos_s + " Street for 1 block.");
                            System.out.println("You drove " + (ab_ave_dist + ab_st_dist + 4) +" blocks.");
                        }
                    }
                    else if (ave_dist > 0){
                        //directions are:
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a +" Avenue.");
                        System.out.println("Head West on " + pos_s + " Street for " + (ab_ave_dist - 1) + "block(s).");
                        pos_a = pos_a + (ab_ave_dist - 1);
                        System.out.println("Head North on " + pos_a + "Avenue for " + ab_st_dist + " blocks.");
                        pos_s = pos_s + ab_st_dist;
                        System.out.println("Head West on " + pos_s + " For 1 block.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist) + " blocks");
                        }
                    else if ( ave_dist == 0){
                        //directions are:
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " street and " + pos_a +" avenue.");
                        System.out.println("Head South on " + pos_a + " Avenue for 1 block.");
                        pos_s = pos_s - 1;
                        System.out.println("Head East on " + pos_s + " Street for 1 block.");
                        pos_a = pos_a - 1;
                        System.out.println("Head North on " + pos_a + " Avenue for " + (ab_st_dist + 1) + " blocks.");
                        pos_s = pos_s + (ab_ave_dist + 1);
                        System.out.println("Head West on " + pos_s + " Street for 1 block.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist + 4) + " blocks");
                   }
                }
                else if (st_dist == 0){
                    if (ave_dist < 0){
                        //directions are:
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a +" Avenue.");
                        System.out.println("Head South on " + pos_a + " Avenue for 1 block.");
                        pos_s = pos_s - 1;
                        System.out.println("Head east on " + pos_s + " Street for " + (ab_ave_dist + 1) + " blocks.");
                        pos_a = pos_a - (ab_ave_dist + 1);
                        System.out.println("Head North on " + pos_a + " Avenue for 1 block.");
                        pos_s = pos_s + 1;
                        System.out.println("Head West on " + pos_s + " Street for 1 block.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist + 4) + " blocks.");
                    }
                    else if (st_dist > 0){
                        //directions are:
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a +" Avenue.");
                        System.out.println("Head West on " + pos_s + "Street for " + ab_ave_dist + " blocks.");
                        System.out.println("you drove " + ab_ave_dist + " blocks");
                    }
                }
            }
            else if(north && e_north){
                if (st_dist < 0){
                    if (ave_dist < 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a +" Avenue.");
                        System.out.println("Head West on " + pos_s + " Street for 1 block.");
                        pos_a = pos_a + 1;
                        System.out.println("Head South on " + pos_a + " Avenue for " + (ab_st_dist + 1) + " blocks");
                        pos_s = pos_s - (ab_st_dist + 1);
                        System.out.println("Head East on " + pos_s + " Street for " + (ab_ave_dist +1) + " blocks");
                        pos_a = pos_a - (ab_ave_dist + 1);
                        System.out.println("Head North on " + pos_a + " Avenue for 1 block");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist + 4) + " blocks");
                    }
                    else if(ave_dist > 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a +" Avenue.");
                        System.out.println("Head West on " + pos_s + " Street for " + (ab_ave_dist - 1) + " block(s)");
                        pos_a = pos_a + (ab_ave_dist - 1);
                        System.out.println("Head South on " + pos_a +" Avenue for " + ab_st_dist + " blocks.");
                        pos_s = pos_s + ab_st_dist;
                        System.out.println("Head West on " + pos_s + " for 1 block.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist) + " blocks.");
                    }
                    else if (ave_dist == 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a +" Avenue.");
                        System.out.println("Head West on" + pos_s + " Street for 1 block.");
                        pos_a = pos_a + 1;
                        System.out.println("Head South on " + pos_a + " Street for " + (ab_st_dist + 1) + "blocks.");
                        pos_s = pos_s + (ab_st_dist + 1);
                        System.out.println("Head East on" + pos_s + " Avenue for 1 block.");
                        pos_a = pos_a - 1;
                        System.out.println("Head North on" + pos_a + " Street for 1 block.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist + 4) + " blocks.");
                    }
                }
                else if (st_dist > 0){
                    if (ave_dist < 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a +" Avenue.");
                        System.out.println("Head North on " + pos_a + " Avenue for " + (ab_st_dist - 1) + " block(s)");
                        pos_s = pos_s + (ab_st_dist - 1);
                        System.out.println("Head East on " + pos_s + " Street for " + ab_ave_dist + " blocks.");
                        pos_a = pos_a - ab_ave_dist;
                        System.out.println("Head North on " + pos_a + " Avenue for 1 block.");
                        System.out.println("You drove" + (ab_ave_dist + ab_st_dist) + " blocks");
                    }
                    else if (ave_dist > 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a +" Avenue.");
                        System.out.println("Head North on " + pos_a + " Avenue for " + ab_st_dist + " blocks.");
                        pos_s = pos_s + ab_st_dist;
                        System.out.println("Head West on " + pos_s + " Street for " + ab_ave_dist + " blocks.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist) + " blocks.");
                    }
                    else if (ave_dist == 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a +" Avenue.");
                        System.out.println("Head North on " + pos_a + " Avenue for " + (ab_st_dist) + " blocks");
                        System.out.println("You drove " +  ab_st_dist + " block(s).");
                    }
                }
                else if (st_dist == 0){
                    if (ave_dist < 0){
                        if (pos_s < max_st){
                            int ab_st_dist = java.lang.Math.abs(st_dist);
                            int ab_ave_dist = java.lang.Math.abs(ave_dist);
                            System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                            System.out.println("Head North on " + pos_a + " Avenue for 1 block.");
                            pos_s = pos_s + 1;
                            System.out.println("Head East on " + pos_s + " Street for " + ab_ave_dist + " blocks.");
                            pos_a = pos_a - ab_ave_dist;
                            System.out.println("Head South on " + pos_a + " Avenue for 1 block.");
                            System.out.println("Your drove " + (ab_ave_dist + ab_st_dist + 2) + " blocks");
                        }
                        else if (pos_s == max_st){
                            int ab_st_dist = java.lang.Math.abs(st_dist);
                            int ab_ave_dist = java.lang.Math.abs(ave_dist);
                            System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                            System.out.println("Head West on " + pos_s + " Street for 1 block.");
                            pos_a = pos_a + 1;
                            System.out.println("Head South on " + pos_a + " Avenue for 1 block");
                            pos_s = pos_s - 1;
                            System.out.println("Head East on " + pos_s + " Street for " + (ab_ave_dist + 2) + " blocks.");
                            pos_a = pos_a -(ab_ave_dist + 2);
                            System.out.println("Head North on " + pos_a + " Avenue for 1 block.");
                            pos_s = pos_s + 1;
                            System.out.println("Head West on " + pos_s + " Street for 1 block.");
                            System.out.println("You drove " + (ab_ave_dist + ab_st_dist + 4) + " blocks.");
                        }
                    }
                    else if (ave_dist > 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head West on " + pos_s + " Street for " + ab_ave_dist + " block.");
                        System.out.println("You drove " + ab_ave_dist + " block(s)");
                    }

                }
            }
            else if (north && e_south){
                if (st_dist < 0){
                    if (ave_dist < 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head South on " + pos_a + " Avenue for " + ab_st_dist + " block(s).");
                        pos_s = pos_s + ab_st_dist;
                        System.out.println("Head West on " + pos_s + " Avenue for " + ab_ave_dist + " block(s).");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist) + " blocks.");
                    }
                    else if (ave_dist > 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head South on " + pos_a + " Avenue for " + (ab_st_dist + 1) + " blocks.");
                        pos_s = pos_s - (ab_st_dist + 1);
                        System.out.println("Head East on " + pos_s + " Street for " + ab_ave_dist + "block(s).");
                        pos_a = pos_a - ab_ave_dist;
                        System.out.println("Head North on " + pos_a + " Avenue for 1 block.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist + 2) + " blocks.");
                    }
                }
                else if (st_dist > 0)
                    if (ave_dist < 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head West on " + pos_s + " Street for " + ab_ave_dist + " block(s).");
                        pos_a = pos_a + ab_ave_dist;
                        System.out.println("Head North on " + pos_a + " Avenue for " + ab_st_dist + " blocks.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist) + " blocks");
                    }
                    else if (ave_dist > 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head South on " + pos_a + " Avenue for 1 block.");
                        pos_s = pos_s - 1;
                        System.out.println("Head East on " + pos_s + " Street for " + ab_ave_dist + " block(s).");
                        pos_a = pos_a - ab_ave_dist;
                        System.out.println("Head North on " + pos_a + " Avenue for " + (ab_st_dist + 1) + " blocks.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist + 2) + " blocks.");
                    }
            }
            else if (south && e_north){
                if (st_dist < 0){
                    if (ave_dist < 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head West on " + pos_s + " Street for " + ab_st_dist + " block(s).");
                        pos_a = pos_a + ab_ave_dist;
                        System.out.println("Head South on " + pos_a + " Avenue for " + ab_st_dist + " blocks.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist) + " blocks");
                    }
                    else if (ave_dist > 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head West on " + pos_s + " Street for 1 block.");
                        pos_a = pos_a + 1;
                        System.out.println("Head South on " + pos_a + " Avenue for " + (ab_st_dist - 1) + " blocks.");
                        pos_s = pos_s - (ab_st_dist - 1);
                        System.out.println("Head East on " + pos_s + " Street for " + (ab_ave_dist + 1) + " blocks.");
                        pos_a = pos_a - (ab_ave_dist +1);
                        System.out.println("Head South on " + pos_a +  " Avenue for 1 block.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist + 2) + " blocks.");
                    }
                }
                else if (st_dist > 0)
                    if (ave_dist < 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head North on " + pos_a + " Avenue for " + ab_st_dist + " blocks.");
                        pos_s = pos_s + ab_st_dist;
                        System.out.println("Head West on " + pos_s + " Street for " + ab_ave_dist + " block(s).");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist) + " blocks.");
                    }
                    else if (ave_dist > 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head North on " + pos_a + " Avenue for " + (ab_st_dist - 1) + " block(s)." );
                        pos_s = pos_s + (ab_st_dist -1);
                        System.out.println("Head East on " + pos_s + " Street for " + (ab_ave_dist + 1) + " blocks.");
                        pos_a = pos_a - (ab_ave_dist + 1);
                        System.out.println("Head North on " + pos_a + " Avenue for 1 block.");
                        pos_s = pos_s + 1;
                        System.out.println("Head West on " + pos_s + " Street for 1 block.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist + 2) + " blocks.");
                    }
            }
        }
        else if (east && e_east){
            if (north && e_north){
                if(st_dist < 0){
                    if (ave_dist < 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head East on " + pos_s + " Street for " + (ab_ave_dist - 1) + " block(s)");
                        pos_a = pos_a - (ab_ave_dist - 1);
                        System.out.println("Head South on " + pos_a + " Avenue for " + ab_st_dist + " blocks");
                        pos_s = pos_s - ab_st_dist;
                        System.out.println("Head East on " + pos_s + " Street for 1 block.");
                        System.out.println("you drove " + (ab_ave_dist + ab_st_dist) + " blocks.");
                    }
                    else if (ave_dist > 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head North on " + pos_a + " Avenue for 1 block.");
                        pos_s = pos_s + 1;
                        System.out.println("Head West on " + pos_s + " Street for " + (ab_ave_dist-1) + " block(s)");
                        pos_a = pos_a + (ab_ave_dist -1);
                        System.out.println("Head South on " + pos_a + " Avenue for" + ab_st_dist + " blocks");
                        pos_s = pos_s - ab_st_dist;
                        System.out.println("Head West on " + pos_s + " Street for " + ab_ave_dist + " blocks.");
                        pos_a = pos_a + ab_ave_dist;
                        System.out.println("Head South on " + pos_a + " Avenue for 1 block.");
                        pos_s =pos_s - 1;
                        System.out.println("Head East on " + pos_s + " Street for 1 block.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist + 4) + " blocks.");
                    }
                    else if (ave_dist == 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head North on " + pos_a + " Avenue for 1 block.");
                        pos_s = pos_s + 1;
                        System.out.println("Head West on " + pos_s + " for 1 block");
                        pos_a = pos_a + 1;
                        System.out.println("Head South on " + pos_a + " for " + (ab_st_dist + 1) + "  blocks.");
                        pos_s = pos_s + (ab_st_dist +1);
                        System.out.println("Head East on " + pos_s + " for 1 block.");
                        System.out.println("you went " + (ab_st_dist + 4) + " blocks");
                    }
                }
                else if(st_dist > 0){
                    if (ave_dist < 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head North on " + pos_a + " Avenue for " + ab_st_dist + " blocks.");
                        pos_s = pos_s + ab_st_dist;
                        System.out.println("Head East on " + pos_s + " Street for " + ab_ave_dist + " blocks.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist) + " blocks.");
                    }
                    else if (ave_dist < 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head North on " + pos_a + " Avenue for " + (ab_st_dist-1) + " block(s).");
                        pos_s = pos_s + (ab_st_dist -1);
                        System.out.println(" Head West on " + pos_s + " Street for " + ab_ave_dist  + " blocks.");
                        pos_a = pos_a + ab_ave_dist;
                        System.out.println("Head North on " + pos_a + " Avenue for 1 block.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist) + " blocks.");
                    }
                    else if(ave_dist == 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head North on " + pos_a + " Avenue for " + ab_st_dist + " blocks." );
                        System.out.println("You drove " + ab_st_dist + " blocks.");
                    }
                }
                else if(st_dist == 0){
                    if (ave_dist < 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head East on " + pos_s + " Street for " + ab_ave_dist + " blocks.");
                        System.out.println("You drove " + ab_ave_dist + " blocks");
                    }
                    else if (ave_dist > 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head North on " + pos_a + " Avenue for 1 block.");
                        pos_s = pos_s + 1;
                        System.out.println("head West on " + pos_s + " Street for " + (ab_ave_dist + 1) + " blocks.");
                        pos_a = pos_a + (ab_ave_dist + 1);
                        System.out.println("Head South on " + pos_a + " Avenue for 1 block.");
                        pos_s = pos_a - 1;
                        System.out.println("Head East on " + pos_s + " Street for 1 block.");
                        System.out.println("You drove " + (ab_ave_dist + 4) + " blocks.");
                    }
                }
            }
            else if(south && e_south){
                if (st_dist < 0){
                    if (ave_dist < 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head South on " + pos_a + " Avenue for " + ab_st_dist + " blocks.");
                        pos_s = pos_s + ab_st_dist;
                        System.out.println("Head East on " + pos_s + " Street for " + ab_ave_dist + " blocks.");
                        System.out.println("You drove " + (ab_st_dist + ab_ave_dist) + " blocks.");
                    }
                    else if(ave_dist > 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head South on " + pos_a + " Avenue for " + (ab_st_dist - 1) + " block(s).");
                        pos_s = pos_s + (ab_st_dist - 1);
                        System.out.println("head West on " + pos_s + "Street for " + ab_ave_dist + " blocks.");
                        pos_a = pos_a + ab_ave_dist;
                        System.out.println("head South on " + pos_a + "Avenue for 1 block.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist) + " blocks.");
                    }
                    else if (ave_dist == 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head South on " + pos_a + " Avenue for " + ab_st_dist + " blocks.");
                        System.out.println("You drove " + ab_st_dist + " blocks.");
                    }
                }
                else if (st_dist > 0){
                    if (ave_dist < 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head East on " + pos_s + " Street for " + (ab_ave_dist - 1) + "block(s). ");
                        pos_a = pos_a - (ab_ave_dist - 1);
                        System.out.println("Head North on " + pos_a + " Avenue for " + ab_st_dist + " blocks.");
                        pos_s = pos_s + ab_st_dist;
                        System.out.println("Head East on " + pos_s + " Street for 1 block.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist) + " blocks.");
                    }
                    else if (ave_dist > 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head East on " + pos_s + " Street for 1 block.");
                        pos_a = pos_a - 1;
                        System.out.println("Head North on " + pos_a + "Avenue for " + (ab_st_dist + 1) + " blocks.");
                        pos_s = pos_s + (ab_st_dist + 1);
                        System.out.println("Head East on " + pos_s + " Street for " + (ab_ave_dist + 1) + " blocks.");
                        pos_a = pos_a + (ab_ave_dist + 1);
                        System.out.println("Head South on " + pos_a + " Avenue for 1 block.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist + 2) + " blocks.");
                    }
                    else if (ave_dist == 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head East on " + pos_s + " Street for 1 block.");
                        pos_a = pos_a - 1;
                        System.out.println("Head North on " + pos_s + " Avenue For " + (ab_st_dist + 1) + " blocks.");
                        pos_s = pos_s + (ab_st_dist + 1);
                        System.out.println(" Head West on " + pos_s + " Street for 1 block.");
                        pos_a = pos_a + 1;
                        System.out.println("Head South on " + pos_a + " Avenue for 1 block.");
                        System.out.println("You drove " + (ab_st_dist + 4) + " blocks.");
                    }
                }else if (st_dist == 0){
                    if (ave_dist > 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head North on " + pos_a + " Avenue for 1 block.");
                        pos_s = pos_s + 1;
                        System.out.println("Head West on " + pos_s + " Street for " + ab_ave_dist + " blocks.");
                        pos_a = pos_a + ab_ave_dist;
                        System.out.println("Head South on " + pos_a + " Avenue for 1 block.");
                        System.out.println("You drove " + (ab_ave_dist + 2) + " blocks.");
                    }
                    else if (ave_dist < 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head East on " + pos_s + " Street for " + ab_ave_dist + " blocks.");
                        System.out.println("You drove " + ab_ave_dist + " blocks.");
                    }
                }
            }
            else if (south && e_north){
                if (st_dist < 0){
                    if (ave_dist < 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head South on " + pos_a + " Avenue for " + (ab_st_dist - 1) +" block(s).");
                        pos_s = pos_s - (ab_st_dist -1);
                        System.out.println(" Head West on " + pos_s + " Street for " + ab_ave_dist + " block(s).");
                        pos_a = pos_a + ab_ave_dist;
                        System.out.println("Head South on " + pos_a + " Avenue for 1 block.");
                        System.out.println("You drove " + (ab_ave_dist +ab_st_dist) + " blocks");
                    }
                    else if (ave_dist > 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head South on " + pos_a + " Avenue for " + ab_st_dist + " blocks.");
                        pos_s = pos_s - ab_st_dist;
                        System.out.println("Head East on " + pos_s + " Street for " + ab_ave_dist + " block(s).");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist) + " blocks.");
                    }
                }
                else if (st_dist > 0){
                    if (ave_dist < 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head East on " + pos_s + " Street for 1 block.");
                        pos_a = pos_a - 1;
                        System.out.println("Head North on " + pos_a + " Avenue for " + (ab_st_dist - 1) + " block(s).");
                        pos_s = pos_s + (ab_st_dist -1);
                        System.out.println("Head West on " + pos_s + " Street for " + (ab_ave_dist + 1) + " blocks");
                        pos_a = pos_a + (ab_ave_dist + 1);
                        System.out.println("Head North on " + pos_a + " for 1 block.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist + 2) + " blocks.");
                    }
                    else if (ave_dist > 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head East on " + pos_s + " Street for " + ab_ave_dist + " block(s).");
                        pos_a = pos_a - ab_ave_dist;
                        System.out.println("Head North on " + pos_a + " Avenue for " + ab_st_dist + " blocks.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist) + " blocks.");
                    }
                }
            }else if (north && e_south){
                if (st_dist <0){
                    if (ave_dist < 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head North on " + pos_a + " Avenue for 1 block.");
                        pos_s = pos_s + 1;
                        System.out.println("hea West on " + pos_s + " Street for " + ab_ave_dist + " block(s).");
                        pos_a = pos_a + ab_ave_dist;
                        System.out.println("Hea Sout on South on " + pos_a + " Avenue for " + (ab_st_dist + 1) + " blocks");
                        System.out.println("You drove " + (ab_ave_dist +ab_st_dist + 2) + "blocks.");
                    }
                    else if (ave_dist > 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head East on " + pos_s + " Street for " + ab_ave_dist + " block(s).");
                        pos_a = pos_a - ab_st_dist;
                        System.out.println("Head South on " + pos_a + " Avenue for " + ab_st_dist + " blocks.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist) + " blocks.");
                    }
                }
                else if(st_dist > 0){
                    if (ave_dist < 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head North on " + pos_a + " Avenue or " + (ab_st_dist - 1) + " block(s).");
                        pos_s = pos_s + (ab_ave_dist - 1);
                        System.out.println("Head West on " + pos_s + " Street for " + ab_ave_dist + " block(s).");
                        pos_a = pos_s + ab_ave_dist;
                        System.out.println("Head North on " + pos_a + " Avenue for 1 block.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist) + " blocks.");
                    }
                    else if (ave_dist > 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head North on " + pos_a + " Avenue for " + ab_st_dist + " blocks.");
                        pos_s = pos_s + ab_st_dist;
                        System.out.println("Head East on " + pos_s + " Street for " + ab_ave_dist + " block(s).");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist) + " blocks.");
                    }
                }
            }
        }
        else if(west && e_east){
            if (south && e_north){
                if (st_dist < 0){
                    if (ave_dist < 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head West on " + pos_s + " for +" + (ab_ave_dist + 1) + "block(s).");
                        pos_a = pos_a + (ab_ave_dist +1);
                        System.out.println("Head South on " + pos_a + " Street for " + ab_st_dist + " block(s).");
                        pos_s = pos_s - ab_st_dist;
                        System.out.println("Head East on " + pos_s + " Street for 1 block.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist + 2) + " blocks");
                    }
                    else if (ave_dist > 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head South on " + pos_a + " Avenue for " + ab_st_dist + " block(s).");
                        pos_s = pos_s - ab_st_dist;
                        System.out.println(" Head East on " + pos_s + " Street for  " + ab_ave_dist + " block(s).");
                        System.out.println("Your drove " + (ab_ave_dist + ab_st_dist) + " blocks.");
                    }
                }
                else if (st_dist > 0){
                    if (ave_dist < 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head East on " + pos_s + " Street for " + ab_ave_dist + " block(s).");
                        pos_a = pos_a + ab_ave_dist;
                        System.out.println("Head Norht on " + pos_a + " Avenue for " + ab_st_dist + " block(s).");
                        System.out.println("You drove " + (ab_ave_dist +ab_st_dist) + " blocks.");
                    }
                    else if (ave_dist > 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head West on " + pos_s + " Street for 1 block.");
                        pos_a = pos_a + 1;
                        System.out.println("Head North on " + pos_a + " Avenue for " + ab_st_dist + " block(s).");
                        pos_s = pos_s + ab_st_dist;
                        System.out.println("Head East on " + pos_s + " Street for " + (ab_ave_dist + 1) + " blocks.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist + 2) + " blocks.");
                    }

                }
                else if (st_dist == 0){
                    if (ave_dist > 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head West on " + pos_s + " Strete for block(s).");
                        System.out.println("You drove " + ab_ave_dist + " block(s).");
                    }
                    else if (ave_dist < 0 ){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head South on " + pos_a + " Avenue for 1 block.");
                        pos_s = pos_s - 1;
                        System.out.println("Head East on " + pos_s + " Street for "  + ab_ave_dist + " block(s).");
                        pos_a = pos_a - ab_ave_dist;
                        System.out.println("Head North on " + pos_a + " Avenue for 1 block.");
                        System.out.println("You drove " +(ab_ave_dist + 2) + " blocks.");
                    }
                }
            }
            else if (north && e_south){
                if (st_dist < 0){
                    if (ave_dist < 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head West on " + pos_s + " Street for " + ab_ave_dist + " block(s).");
                        pos_a = pos_a + ab_ave_dist;
                        System.out.println("Head South on " + pos_a + " Avenue for " + ab_st_dist + " block(s).");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist) + " blocks");
                    }
                    else if (ave_dist > 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head North on " + pos_a + " Avenue for 1 block.");
                        pos_s = pos_s + 1;
                        System.out.println("Head East on " + pos_s + " Street for " + ab_ave_dist + "block(s).");
                        pos_a = pos_a - ab_ave_dist;
                        System.out.println("Head South on " + pos_a + " Avenue for " + (ab_st_dist + 1) + "blocks.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist + 2) + " blocks.");
                    }
                }
                else if (st_dist > 0){
                    if (ave_dist < 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head North on " + pos_a + " Avenue for " + (ab_ave_dist + 1) + " blocks.");
                        pos_s = pos_s + (ab_st_dist + 1);
                        System.out.println("Head West on " + pos_s + " Street for " + ab_ave_dist + " block(s).");
                        pos_a = pos_a + ab_ave_dist;
                        System.out.println("Head South on " + pos_a + " Avenue for 1 block.");
                        System.out.println("You drove " + (ab_ave_dist +ab_st_dist + 2) + " blocks.");
                    }
                    else if (ave_dist > 0) {
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head North on " + pos_a + " Avenue for " + ab_st_dist + " block(s).");
                        pos_s = pos_s + ab_st_dist;
                        System.out.println("Head East on " + pos_s + " Street for " + ab_ave_dist + " block(s).");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist) + " blocks.");
                    }
                }
                else if (st_dist == 0){
                    if (ave_dist > 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head West on " + pos_s + " Street for " + ab_ave_dist + " block(s).");
                        System.out.println("You drove " + ab_ave_dist + " block(s).");
                    }
                    else if (ave_dist < 0){
                        if (pos_s == max_st){
                            int ab_st_dist = java.lang.Math.abs(st_dist);
                            int ab_ave_dist = java.lang.Math.abs(ave_dist);
                            System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                            System.out.println("Head West on " + pos_s + " Street for 1 block.");
                            pos_a = pos_a + 1;
                            System.out.println("Head South on " + pos_a + " Avenue for 1 block.");
                            pos_s = pos_s - 1;
                            System.out.println("Head East on " + pos_s + " Street for " + (ab_ave_dist + 2) + " blocks.");
                            pos_a = pos_a + (ab_ave_dist + 2);
                            System.out.println("Head North on " + pos_a + " Avenue for 1 block.");
                            pos_s = pos_s + 1;
                            System.out.println("Head West on " + pos_s + " Street for 1 block.");
                            System.out.println("You drove " +(ab_ave_dist + 4) + " blocks.");
                        }
                        else if (pos_s < max_st){
                            int ab_st_dist = java.lang.Math.abs(st_dist);
                            int ab_ave_dist = java.lang.Math.abs(ave_dist);
                            System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                            System.out.println("Head North on " + pos_a + " Avenue for 1 block.");
                            pos_s = pos_s + 1;
                            System.out.println("Head East on " + pos_s + " Street for " + ab_ave_dist + " block(s).");
                            pos_a = pos_a - ab_ave_dist;
                            System.out.println("Head South on " + pos_a + " Avenue for 1 block.");
                            System.out.println("You drove " + (ab_ave_dist + 2) + " blocks.");
                        }
                    }
                }
            }
            else if(north && e_north){
                if(ave_dist == 0){
                    if(st_dist < 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head East on " + pos_s + " Street for 1 block.");
                        pos_a = pos_a + 1;
                        System.out.println("Head South on " + pos_a + " Avenue for " + ab_st_dist + " block(s).");
                        pos_s = pos_s - ab_st_dist;
                        System.out.println("Head East on " + pos_s + " Street for 1 block.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist + 2) + " blocks.");
                    }
                    else if(st_dist > 0){
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head North on " + pos_a + " Avenue for " + ab_st_dist + " block(s).");
                        System.out.println("You drove " + ab_st_dist + " block(s)");
                    }
                }

            }
            else if (south && e_north){
                if (st_dist > 0){
                    if (ave_dist == 0){
                            if (pos_a == max_ave){
                                int ab_st_dist = java.lang.Math.abs(st_dist);
                                int ab_ave_dist = java.lang.Math.abs(ave_dist);
                                System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                                System.out.println("Head South on " +pos_a+ " Avenue for 1 block.");
                                pos_s = pos_s - 1;
                                System.out.println("Head East on " + pos_s + " Street for 1 block.");
                                pos_a = pos_a - 1;
                                System.out.println("Head North on " + pos_a + " Avenue for " + (ab_st_dist + 2 ) + " blocks.");
                                pos_s = pos_s + (ab_st_dist + 2);
                                System.out.println("Head West on " + pos_s + " Street for 1 block.");
                                pos_a = pos_a + 1;
                                System.out.println("Head souith on " +pos_a + " Avenue for 1 block.");
                                System.out.println(" You drove " + (ab_st_dist + 4) + " blocks.");
                            }
                            else if (pos_a < max_ave){
                                int ab_st_dist = java.lang.Math.abs(st_dist);
                                int ab_ave_dist = java.lang.Math.abs(ave_dist);
                                System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                                System.out.println("Head West on " + pos_s + " Street for 1 block.");
                                pos_a = pos_a + 1;
                                System.out.println(" Head North on " + pos_a + "Avenue for " +ab_st_dist+ " block(s).");
                                pos_s = pos_s + ab_st_dist;
                                System.out.println("Head Est on " + pos_s + " Street for 1 block");
                                System.out.println(" You drove " + (ab_st_dist + 2) + " blocks.");
                            }
                    }
                }
            }
        }
        else if (east && e_west) {
            if (south && e_north) {
                if (st_dist < 0) {
                    if (ave_dist < 0) {
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head South on " + pos_a + " Avenue for " + ab_st_dist + " block(s).");
                        pos_s = pos_s - ab_st_dist;
                        System.out.println("Head West on " + pos_s + " Street for " + ab_ave_dist + " block(s).");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist) + " blocks.");
                    } else if (ave_dist > 0) {
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head South on " + pos_a + " Avenue for " + (ab_st_dist + 1) + " blocks.");
                        pos_s = pos_s - (ab_st_dist + 1);
                        System.out.println("Head East on  " + pos_s + " Street for 1 " + ab_ave_dist + " block(s).");
                        pos_a = pos_a - ab_ave_dist;
                        System.out.println("Head North on " + pos_a + " Avenue for 1 block.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist + 2) + " blocks.");
                    }
                } else if (st_dist > 0) {
                    if (ave_dist < 0) {
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head East on " + pos_s + " Street for 1 block,");
                        pos_a = pos_a - 1;
                        System.out.println("Head North on " + pos_a + " Avenue for " + ab_st_dist + " block(s).");
                        pos_s = pos_s + ab_st_dist;
                        System.out.println("Head West on " + pos_s + " Street for " + (ab_ave_dist + 1) + " blocks.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist + 2) + " blocks.");
                    } else if (ave_dist > 0) {
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head East on " + pos_s + " Street for " + ab_ave_dist + " block(s).");
                        pos_a = pos_a - ab_ave_dist;
                        System.out.println("Head North on " + pos_a + " Avenue for " + ab_st_dist + " block(s).");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist) + " blocks.");
                    }
                }
            } else if (north && e_south)
                if (st_dist < 0) {
                    if (ave_dist < 0) {
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head North on " + pos_a + " Avenue for 1 block.");
                        pos_s = pos_s + 1;
                        System.out.println("Head West on " + pos_s + " Street for " + ab_ave_dist + " block(s).");
                        pos_a = pos_a + ab_ave_dist;
                        System.out.println("Head South on " + pos_a + " Avenue for " + (ab_st_dist + 1) + " blocks.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist + 2) + " blocks.");
                    } else if (ave_dist > 0) {
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head East on " + pos_s + " Street for " + ab_ave_dist + " block(s).");
                        pos_a = pos_a - ab_ave_dist;
                        System.out.println("Head South on " + pos_a + " Avenue for " + ab_st_dist + " block(s).");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist) + " blocks.");
                    }
                } else if (st_dist > 0) {
                    if (ave_dist < 0) {
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head North on " + pos_a + " Avenue for " + ab_st_dist + " block(s).");
                        pos_s = pos_s + ab_st_dist;
                        System.out.println("Head West on " + pos_s + " Street for " + ab_ave_dist + " block(s).");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist) + " blocks.");
                    } else if (ave_dist > 0) {
                        int ab_st_dist = java.lang.Math.abs(st_dist);
                        int ab_ave_dist = java.lang.Math.abs(ave_dist);
                        System.out.println("Start at " + pos_s + " Street and " + pos_a + " Avenue.");
                        System.out.println("Head Head East on " + pos_s + " Street for " + (ab_ave_dist + 1) + " blocks.");
                        pos_a = pos_a - (ab_ave_dist + 1);
                        System.out.println("Head North on " + pos_a + " Avenue for " + ab_st_dist + " block(s).");
                        pos_s = pos_s + ab_st_dist;
                        System.out.println("Heaad West on " + pos_s + " Street for 1 block.");
                        System.out.println("You drove " + (ab_ave_dist + ab_st_dist + 2) + " blocks.");
                    }
                }
            }
        }
    }


