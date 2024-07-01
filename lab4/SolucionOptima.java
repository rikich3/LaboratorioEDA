import java.util.*;

public class SolucionOptima {
    private List<Integer> solucion;
    public List<Integer> getSolucion() {
        return solucion;
    }
    public boolean isOdnum() {
        return odnum;
    }
    SolucionOptima(List<Integer> l, boolean b){
        solucion = l;
        odnum = b;
    }
    SolucionOptima add(int p){
        List<Integer> newl = new ArrayList<Integer>();
        for(Integer i: solucion){
            newl.add(i);
        }
        newl.add(p);
        return new SolucionOptima(newl, odnum);
    }
}
