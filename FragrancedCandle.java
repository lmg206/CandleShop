public class FragrancedCandle{
    private Candle candle;
    private Fragrance fragrance1;
    private Fragrance fragrance2;

    public FragrancedCandle(Candle c, Fragrance f){
        candle = c;
        fragrance1 = f;
    }

    public void addFragrance(Fragrance a){
        fragrance2 = a;
    }

    public Fragrance getFragrance1(){
        return fragrance1;
    }

    public Fragrance getFragrance2(){
        if (fragrance2 != null){
            return fragrance2;
        } else {
            return null;
        }
    }

    public void printCandle(){
        candle.printWick();
        System.out.println(" ---------------------------------------");
        System.out.println("|\t\t\t\t\t|");
        System.out.println("|\t Laurel's Candle Shop\t\t|");
        for (int i=0;i<3;i++){
            System.out.println("|\t\t\t\t\t|");
        }
        
        if (fragrance2==null){
            System.out.printf("|\t\t%-22s\t|\n",fragrance1);
        } else {
            System.out.printf("|\t%10s and %-10s\t|\n",fragrance1,fragrance2);
        }
        for (int i=0;i<4;i++){
            System.out.println("|\t\t\t\t\t|");
        }
        System.out.println(" ---------------------------------------");
        System.out.println("   ---------------------------------  ");
    }


    public String toString(){
        String r = candle.toString() + " and fragranced with " + fragrance1.getScent() ;
        if (fragrance2 != null){
            r += " and " + fragrance2.getScent();
        }
        return r;
    }
}