/*
 main class to test candle shop
*/

import java.util.*;

public class CandleShop {

    private static final HashMap<Integer, FragranceState> fStates = new HashMap<>();
    private static final HashMap<Integer, Fragrance> scents = new HashMap<>();
    private static Fragrance fragrance1;
    private static Fragrance fragrance2;
    private static int numWicks;
    private static int numScents;
	public static void main(String[] args) {

        initHM();

        // introduce store
        delayedPrint(10,"\nHello, welcome to Laurel's Candle Shop!");
        delayedPrint(10,"\nOur store lets you design your own candle, based on desired scents and aesthetics\n");

        Scanner usrInput = new Scanner(System.in);

        // run candle shop instructions
        DesignCandle(usrInput);

        // ask if want to design another or exit
        boolean exit = true;
        while (exit){
            delayedPrint(10, "\n\nWould you like to create another candle or exit?\nReply '1' to create another candle or '2' to exit the shop:  ");
            int exit_choice = getInput(usrInput, 2);
            if (exit_choice==1){
                DesignCandle(usrInput);
            } else {
                exit = false;
            }
        }
        
        // exit message
        delayedPrint(10,"\nThank you for coming to Laurel's Candle Shop! Come again soon.");  
    }

    // method to lead the user in designing their candle and prints out the final Candle object
    private static void DesignCandle(Scanner usrInput){
       // choose num of fragrances
       fragrance2 = null;
       delayedPrint(10,"\nLet's start with fragrances. Would you like to choose your own fragrances or pick our signature house scent?\nReply '1' to choose own fragrances or '2' for our signature house scent:  ");
       int choice = getInputMax(usrInput,2);
       if (choice == 2) {
           // initialize with house scents
           fragrance1 = scents.get(14);;
           fragrance2 = scents.get(9);
       } else {
           delayedPrint(10,"\nWould you like to pick one fragrance or mix two fragrances?\nReply '1' to pick one fragrances or '2' to mix two fragrances:    ");
           numScents = getInput(usrInput, 2);
           showScents(usrInput);
       }

       // ask user for number of wicks
       delayedPrint(10,"\nNow let's choose your number of wicks:\n1 or 3?  ");
       numWicks = getInput(usrInput, 3);
       
       // make candle object using inputs
       FragrancedCandle candle = new FragrancedCandle(CandleFactory.makeCandle(numWicks),fragrance1);
       if (fragrance2 != null){
           candle.addFragrance(fragrance2);
       }
       // print out candle
       delayedPrint(10, "\nNow printing your candle...\n\n\n");
       candle.printCandle();
       System.out.println("\n"+candle); 

       

    }

    // method to change between FragranceStates to help the user choose their final scents
    private static void showScents(Scanner sc){
        delayedPrint(10,"\nAwesome! Now let's select your desired fragrances. Would you like to view all or by category?\nReply '1' for all or '2' for categories:  ");
        int choice = getInput(sc, 2);
        FragranceState state;
        if (choice == 1){
            state = new AllFragrances();
        } else {
            state = new Categories();
        }
        FragranceJourney j = new FragranceJourney(state);
        System.out.println(j.getInfo());
        boolean exit = true;
        while (exit){
            //choose scents if they've chosen to view all scents
            if (j.getState().equals("AllFragrances")){
                pickFragrances(sc);
                break;    
            // switch through categories until they choose to pick or view all            
            } else if (j.getState().equals("Categories")){
                delayedPrint(10,"\nWhich Category would you like to view?  ");
                int categoryChoice = getInputMax(sc,5);
                state = fStates.get(categoryChoice);
                j = new FragranceJourney(state);
                System.out.println(j.getInfo());
            } else {
                delayedPrint(10,"\nWould you like to view another category (1), view all scents (2), or pick your scents (3) ?:  ");
                int c3 = getInputMax(sc,3);
                if (c3==1){
                    state = new Categories();
                } else if (c3==2){
                    state = new AllFragrances();
                } else{
                    pickFragrances(sc);
                    break;
                }
                j = new FragranceJourney(state);
                System.out.println(j.getInfo());
            }   
        } 
    }

    // method to help user pick their fragrances and initialized the instance variables w the picks
    private static void pickFragrances(Scanner sc){
        String first = "";
        String second = "";
        if (numScents==2){
            first = " first";
            second = " second";
        }
        delayedPrint(10,"\nType the number of the" + first + " scent you choose for your candle:  ");
        fragrance1 = scents.get(getInputMax(sc,19));
        if (numScents==2){
            delayedPrint(10,"\nType the number of the" + second + " scent you choose for your candle:  ");
            fragrance2 = scents.get(getInputMax(sc,19));
        }
    }

    // method to help shop get user input within a specific range 
    private static int getInputMax(Scanner sc, int max){
        int num = 0;
        while(sc.hasNext()){
            if(!sc.hasNextInt()){
                System.out.print("Please enter a valid number:  ");
                sc.next();
                continue;
            }
            num = sc.nextInt();
            if (num<1 | num > max){
                System.out.print("Please enter a number in between 1 and " + Integer.toString(max) + ":  ");
            } else {break;}
        }
        return num;
    } 

    // method to help shop get user input that can only be two options 
    private static int getInput(Scanner sc, int option){
        int num = 0;
        while(sc.hasNext()){
            if(!sc.hasNextInt()){
                System.out.print("Please enter a valid number:  ");
                sc.next();
                continue;
            }
            num = sc.nextInt();
            if (num!=1 & num !=option){
                System.out.print("Please enter 1 or " + Integer.toString(option) + ":  ");
            } else {break;}
        }
        return num;
    } 

    // method to slow down printing
    private static void delayedPrint(int delay, String s){
        try{
            for (char c : s.toCharArray()) {
                System.out.print(c);  
                Thread.sleep(delay);  
            }
        } catch (InterruptedException e) {
        }
        
    }

    // initializes fStates HashMap with various states and scents HashMap with all fragrances
    private static void  initHM(){
        // initialize Fragrance States
        fStates.put(1, new Floral());
        fStates.put(2, new Citrus());
        fStates.put(3, new Fruity());
        fStates.put(4, new Woody());
        fStates.put(5, new Earthy());
        // initialize scents
        scents.put(1, new Fragrance("Apple","Fruity"));
        scents.put(2, new Fragrance("Blood Orange","Citrus"));
        scents.put(3, new Fragrance("Cedarwood","Woody"));
        scents.put(4, new Fragrance("Cherry","Fruity"));
        scents.put(5, new Fragrance("Eucalyptus","Earthy"));
        scents.put(6, new Fragrance("Ginger","Earthy"));
        scents.put(7, new Fragrance("Jasmine","Floral"));
        scents.put(8, new Fragrance("Juniper","Woody"));
        scents.put(9, new Fragrance("Lavender","Floral"));
        scents.put(10, new Fragrance("Lemon","Citrus"));
        scents.put(11, new Fragrance("Lemongrass","Citrus"));
        scents.put(12, new Fragrance("Orange","Citrus"));
        scents.put(13, new Fragrance("Pear","Fruity"));
        scents.put(14, new Fragrance("Pine","Woody"));
        scents.put(15, new Fragrance("Rose","Floral"));
        scents.put(16, new Fragrance("Rosewood","Earthy"));
        scents.put(17, new Fragrance("Sage","Earthy"));
        scents.put(18, new Fragrance("Sandalwood","Woody"));
        scents.put(19, new Fragrance("Strawberry","Fruity"));

    }

}
