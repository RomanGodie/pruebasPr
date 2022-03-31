import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main3 {
    public static List<Boolean> podraCumplir(List<List<Integer>> caso){
        List<Boolean> metas = new ArrayList<Boolean>();
        for(int h=0; h<caso.size();h++){
            boolean metaAlcanzada;
            int diasDeadline = caso.get(h).get(0);
            int lineasRequeridas = caso.get(h).get(1);
            int lineasEscritasDiarias = caso.get(h).get(2);
            int lineasBorradasDiarias = caso.get(h).get(3);
            int lineasEscritasNetas = 0;
            for(int i=1; i<diasDeadline;i++){
                lineasEscritasNetas += lineasEscritasDiarias-lineasBorradasDiarias;
                System.out.println("Lineas dia "+i+": "+lineasEscritasNetas);
            }
            lineasEscritasNetas += lineasEscritasDiarias;
            System.out.println("Lineas dia "+diasDeadline+": "+lineasEscritasNetas);
            if(lineasEscritasNetas>=lineasRequeridas){
                metaAlcanzada = true;
            }else{
                metaAlcanzada = false;
            }
            metas.add(metaAlcanzada);
        }
        return metas;
    }
    public static void cumplioSiONo(List<Boolean> meta){
        for(int j = 0; j < meta.size(); j++){
            boolean cumplimiento = meta.get(j);
            if(cumplimiento==true){
                System.out.println(1);
            }else {
                System.out.println(0);
            }
        }
    }
    public static void main(String[] args){
        List<List<Integer>> casos = new ArrayList<List<Integer>>();
        casos.add(new ArrayList<Integer>(Arrays.asList(5, 110, 30, 10)));
        cumplioSiONo(podraCumplir(casos));
        casos.clear();
        casos.add(new ArrayList<Integer>(){{ add(2); add(40); add(20); add(5);}});
        casos.add(new ArrayList<Integer>(List.of(5,110,30,10)));
        cumplioSiONo(podraCumplir(casos));
    }
}
