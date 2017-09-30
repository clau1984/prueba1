package inacaptemuco.cl.carseguro1;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Claudia on 22-09-2017.
 */

public class Calculos {

    public String Antiguo(int anioAntiguedad) {

        int anio = 2017 - anioAntiguedad;
        String antiguedad;
        if (anio == 0) {
            antiguedad = "Vehículo del año";

        } else if (anio == 1) {
            antiguedad = "El vehiculo tiene un año";
        } else {
            antiguedad = "El vehiculo tiene " + anio + " años";

        }return antiguedad;
    }

    public String estado(int asegurable){
        String seguro;

        if(asegurable>=2007){
            seguro="El vehículo es asegurable";
             }   else{
            seguro="El vehículo No es asegurable";
        }return seguro;

    }
    public String ValorSeguro(int Resultado_seguro, int anio_ingresado){
        Calendar fecha_ingresada =new GregorianCalendar();
         int anio = fecha_ingresada.get(Calendar.YEAR);
        int antiguedad = anio - anio_ingresado;
        int total = (int) ((Resultado_seguro * (0.1 * antiguedad)));
        int total2= (anio_ingresado+1)-anio;
        int igual=(int) (Resultado_seguro * (0.1 * total2));

        String muestra;

        if (anio_ingresado == anio) {
            muestra = "El valor del seguro es " + igual;

        }else  if (anio_ingresado >= anio - 10){
            muestra = "El valor del seguro es " + total;
        } else {
            muestra="Mayor de 10 años no tiene seguro" ;


        }    return muestra;


    }
}

