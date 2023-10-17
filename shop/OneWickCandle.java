public class OneWickCandle extends Candle{

    private int numWicks;

    public OneWickCandle(){
        numWicks = 1;
    }

    public int getNumWicks(){
        return numWicks;
    }

    public void printWick(){
        System.out.println("\t\t    )");
        System.out.println("\t\t   ((");
        System.out.println("\t\t   ) \\");
        System.out.println("\t\t  ( , )");
        System.out.println("\t\t   '|'");
    }

    public String toString(){
        String r = "Candle with " + Integer.toString(numWicks) + " wick";
        return r;
    }
}