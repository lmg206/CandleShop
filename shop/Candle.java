public abstract class Candle{
    private String design;

    public Candle(){
        design = "square";
    }

    public abstract void printWick();

    public abstract int getNumWicks();

    public abstract String toString();

}