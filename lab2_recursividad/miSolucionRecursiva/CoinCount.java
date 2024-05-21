import java.util.*;

public final class CoinCount implements Comparable<CoinCount>{
    private final HashMap<Double, Integer> coinCount;
    private final int items;

    public int getNumberOfCoins(){
        return items;
    }

    public HashMap<Double, Integer> getCoinCount(){
        HashMap<Double, Integer> hm = new HashMap<>();
        for(Double d : coinCount.keySet()){
            hm.put(d, coinCount.get(d));
        }
        return hm;
    }

    public CoinCount addCoin(Double coin){
        HashMap<Double, Integer> hm = getCoinCount();
        if(hm.containsKey(coin)){
            hm.put(coin, hm.get(coin)+1);
        }
        else{
            hm.put(coin, 1);
        }
        return new CoinCount(hm);
    }

    public CoinCount(HashMap<Double, Integer> hm){
        HashMap<Double, Integer> cc = new HashMap<>();
        for(Double d : hm.keySet()){
            cc.put(d, hm.get(d));
        }
        coinCount = cc;
        int conteo = 0;
        for(Integer i : coinCount.values()){
            conteo += i;
        }
        items = conteo;
    }

    @Override
    public int compareTo(CoinCount cc) {
        return items - cc.getNumberOfCoins();
    }
    
}