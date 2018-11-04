//import java.util.Scanner;
//
//public class city_nav {
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("What Street are you starting from?");
//        if(sc.hasNextInt()){
//            int i_strt_street = sc.nextInt();
//            if(i_strt_street <0 || i_strt_street > 100){
//                System.out.println("Value input was either less than 0 or greater than 100.");
//            }
//            else{
//                System.out.println("What Avenue are you starting from?");
//                if (sc.nextInt()){
//                    int i_strt_avenue = sc.nextInt();
//                    if(i_strt_avenue<0 || i_strt_avenue>10){
//                        System.out.println("Value input was either less than 0 or greater than 10.");
//                    }
//                    else{
//                        System.out.println("What Street are you going to?");
//                        if(sc.hasNextInt()) {
//                            int i_end_street = sc.nextInt();
//                            if (i_end_street < 0 || i_end_street > 100) {
//                                System.out.println("Value input was either less than 0 or greater than 100.");
//                            } else {
//                                System.out.println("What Avenue are you going to?");
//                                if (sc.nextInt()) {
//                                    int i_end_avenue = sc.nextInt();
//                                    if (i_end_avenue < 0 || i_end_avenue > 10) {
//                                        System.out.println("Value input was either less than 0 or greater than 10.");
//                                    }
//                                    else{
//                                        System.out.println("Good inpput");
//                                        exit();
//                                    }
//                                }
//                                else{
//                                    System.out.println("INTEGER not submitted!");
//                                }
//                            }
//                        }
//                        else{
//                            System.out.println("INTEGER not submitted!");
//                        }
//                    }
//                }
//                else{
//                    System.out.println("INTEGER not submitted!");
//                }
//            }
//        }
//        else {
//            System.out.println("INTEGER not submitted!");
//        }
//    }
//}
