/*
    Prueba Pragma Problema estimacion perdida
 */
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static class Equipo{
        int numeroTareas;
        int horasPromedioDeLasTareas;
        int horasDeTareaMasCorta;

        public Equipo(int numeroTareas, int horasPromedioDeLasTareas, int horasDeTareaMasCorta) {
            this.numeroTareas = numeroTareas;
            this.horasPromedioDeLasTareas = horasPromedioDeLasTareas;
            this.horasDeTareaMasCorta = horasDeTareaMasCorta;
        }

        public int getNumeroTareas() {
            return numeroTareas;
        }

        public void setNumeroTareas(int numeroTareas) {
            this.numeroTareas = numeroTareas;
        }

        public int getHorasPromedioDeLasTareas() {
            return horasPromedioDeLasTareas;
        }

        public void setHorasPromedioDeLasTareas(int horasPromedioDeLasTareas) {
            this.horasPromedioDeLasTareas = horasPromedioDeLasTareas;
        }

        public int getHorasDeTareaMasCorta() {
            return horasDeTareaMasCorta;
        }

        public void setHorasDeTareaMasCorta(int horasDeTareaMasPequeña) {
            this.horasDeTareaMasCorta = horasDeTareaMasPequeña;
        }
    }

    public static class Calculo{
        public Calculo(List<Equipo> equipos){
            maximoNumeroHoras(equipos);
        }
        public List<Integer> maximoNumeroHoras(List<Equipo> equipos){
            List<Integer> maximoHorasEquipos = new ArrayList<Integer>();
            for(int h=0; h<equipos.size(); h++){
                int tareaMasCorta = equipos.get(h).getHorasDeTareaMasCorta();
                int horasPromedio = equipos.get(h).getHorasPromedioDeLasTareas();
                int cantidadTareas = equipos.get(h).getNumeroTareas();
                int sumatoriaHorasTareas = horasPromedio*cantidadTareas;
                for(int i=1; i<cantidadTareas; i++){
                    System.out.println("antes: "+sumatoriaHorasTareas);
                    sumatoriaHorasTareas = sumatoriaHorasTareas-tareaMasCorta;
                    System.out.println("despues: "+sumatoriaHorasTareas);
                }
                System.out.println("agregando: "+sumatoriaHorasTareas);
                maximoHorasEquipos.add(sumatoriaHorasTareas);
            }
            System.out.println(maximoHorasEquipos);
            return maximoHorasEquipos;
        }
    }

    public static void main(String[] args) {
        List<Equipo> equipos = new ArrayList<Equipo>();
        equipos.add(new Equipo(2, 4, 2));
        equipos.add(new Equipo(3, 16, 8));
        new Calculo(equipos);
        equipos.clear();
        equipos.add(new Equipo(3, 2, 1));
        equipos.add(new Equipo(4, 1, 1));
        new Calculo(equipos);
    }
}
