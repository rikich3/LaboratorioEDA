import java.util.*;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Double> coinTypes = new ArrayList<>();
        Double vuelto;
        System.out.print("Ingrese la cantidad de vuelto a regresaar en monedas: ");
        vuelto = sc.nextDouble();
        do{
            Double valorMoneda = sc.nextDouble();
            if(valorMoneda <= 0.0)
                break;
            coinTypes.add(valorMoneda);
        }
        while(true);
        HashMap<Double, CoinCount> trackOptimal = new HashMap<Double, CoinCount>();

        System.out.println(algoritmoB(coinTypes, vuelto, trackOptimal).getCoinCount());
    }
    private static CoinCount algoritmoB(List<Double> coinTypeList, Double vuelto, HashMap<Double, CoinCount> trackOptimal){
        if(vuelto == 0){
            HashMap<Double, Integer> hm = new HashMap<>();
            for(Double d: coinTypeList)
                hm.put(d, 0);
            return new CoinCount(hm);
        }
        if(vuelto < 0)
            return null;
            
        List<CoinCount> contenders = new ArrayList<>();
        for(Double coinValue : coinTypeList){
            Double diff = vuelto - coinValue;
            if(trackOptimal.containsKey(diff)){
                if(trackOptimal.get(diff) != null)
                    contenders.add(trackOptimal.get(diff).addCoin(coinValue));
            }else{
                trackOptimal.put(diff, algoritmoB(coinTypeList, diff, trackOptimal));
                if(trackOptimal.get(diff) != null)
                    contenders.add(trackOptimal.get(diff).addCoin(coinValue));
            }
        }
        if(contenders.size() == 0)
            return null;
        Collections.sort(contenders);
        return contenders.get(0);
    }
}
