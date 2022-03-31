import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static List<Long> calcularDias(List<Long> prestamo){
        List<Long> cantidadDiasPorPrestamo = new ArrayList<Long>();

        for(int h=0; h<prestamo.size();h++){
            int cuota = 1;
            Long deudaInicial = prestamo.get(h)-cuota;
            int dias = 1;
            do{
                cuota*=2;
                deudaInicial = deudaInicial-cuota;
                dias++;
            }while(deudaInicial>0);
            cantidadDiasPorPrestamo.add(Long.valueOf(dias));
        }
        return cantidadDiasPorPrestamo;
    }
    public static void main(String[] args) {
        List<Long> prestamos = new ArrayList<Long>();
        prestamos.add(Long.valueOf(15));
        prestamos.add(Long.valueOf(16));
        prestamos.add(Long.valueOf(45));
        System.out.println(calcularDias(prestamos));
        prestamos.clear();
        prestamos.add(Long.valueOf(15));
        System.out.println(calcularDias(prestamos));
    }
}
