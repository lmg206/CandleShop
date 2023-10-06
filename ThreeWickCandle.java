import java.util.*;

public class ThreeWickCandle extends Candle{

    private int numWicks;

    public ThreeWickCandle(){
        numWicks = 3;
    }

    public int getNumWicks(){
        return numWicks;
    }

    public void printWick(){
        String[] spaces = {"  ","\t\t","\t\t"};
        String[] lines = {"","","","","",""};
 
        for (int i=0; i < 3; i++){
            String space = spaces[i];
            lines[0]=lines[0]+space+" .";
            lines[1]=lines[1]+space+"  )";
            lines[2]=lines[2]+space+" ((";
            lines[3]=lines[3]+space+" ) \\";
            lines[4]=lines[4]+space+"( , )";
            lines[5]=lines[5]+space+" '|'";
        }
 
        for (int i=0; i< lines.length; i++){
            System.out.println(lines[i]);
        }
    }

    public String toString(){
        String r = "Candle with " + Integer.toString(numWicks) + " wicks";
        return r;
    }
    
}