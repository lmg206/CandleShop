import java.util.HashMap;

public class CandleFactory{
    private static final HashMap<Integer, Candle> candles = new HashMap();

    public static Candle makeCandle(int type){
        Candle c = null;
        if (!candles.containsKey(type)){
            if (type==1){
                c = new OneWickCandle();
            } else {
                c = new ThreeWickCandle();
            }
            candles.put(type,c);
        }
        return candles.get(type);
    }
}