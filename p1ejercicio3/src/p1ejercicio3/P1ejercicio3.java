package p1ejercicio3;

/**
 *
 * @author juanj
 */
public class P1ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
               
        Fecha f = new Fecha();
        f.calculaEdad(03, 01, 1981);
        // dias con fecha igual o superior
        System.out.printf("Faltan: "+ f.diasQueFaltan(24, 8, 2019) +" días\n");
        //  dias con fecha pasada
        System.out.printf("Faltan: "+ f.diasQueFaltan(14, 8, 2017) +" días\n");
        f.diasVividos(3, 1, 1981);
    }
    
}
