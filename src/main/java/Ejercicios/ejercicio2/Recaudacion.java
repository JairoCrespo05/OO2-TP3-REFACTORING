package Ejercicios.ejercicio2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Recaudacion {

    public static final String COMPANY_NAME = "company_name";
    public static final String CITY = "city";
    public static final String STATE = "state";
    public static final String ROUND = "round";
    public static final String PERMALINK = "permalink";
    public static final String NUMBER_EMPLOYEES = "number_employees";
    public static final String CATEGORY = "category";
    public static final String FUNDED_DATE = "funded_date";
    public static final String RAISED_AMOUNT = "raised_amount";
    public static final String RAISED_CURRENCY = "raised_currency";
    public static final int INDICE_COMPANY_NAME = 1;
    public static final int INDICE_CITY = 4;
    public static final int INDICE_STATE = 5;
    public static final int INDICE_ROUND = 9;
    private List<String[]> csvData;
    private Map<String, String> filtrosDeBusqueda;
    private Map<String, Integer> mapaNombreIndice;

    public Recaudacion (FuenteDeDatos fuenteDeDatos){
        this.csvData = fuenteDeDatos.toList();
        this.filtrosDeBusqueda = new HashMap<String, String>();

        //Un Mapa INMUTABLE de Clave valor entre el nombre de la columna y el numero de indice donde se encuentra la columna de ese nombre
        this.mapaNombreIndice = Map.of(COMPANY_NAME, INDICE_COMPANY_NAME,
                CITY, INDICE_CITY,
                STATE, INDICE_STATE,
                ROUND, INDICE_ROUND);

    }

    public List<Map<String, String>> ejecutarQuery()
            throws IOException {

        for(String nombreColumna: this.filtrosDeBusqueda.keySet()){

            List<String[]> results = csvData.stream().filter(csvDatum ->

                            csvDatum[this.mapaNombreIndice.get(nombreColumna)]
                                    .equals(filtrosDeBusqueda.get(nombreColumna)))
                                    .collect(Collectors.toList());

                csvData = results;
        }
//
//        filtrarPor(COMPANY_NAME);
//        filtrarPor(CITY);
//        filtrarPor(STATE);
//        filtrarPor(ROUND);

        return crearResultado();
    }


    public Recaudacion filtrarPor(String nombreColumna, String valor) {
        this.filtrosDeBusqueda.put(nombreColumna, valor);
        return this;
    }


    private List<Map<String, String>> crearResultado() {
        List<Map<String, String>> output = new ArrayList<Map<String, String>>();

        for (int i = 0; i < csvData.size(); i++) {
            Map<String, String> mapped = new HashMap<String, String>();
            mapped.put(PERMALINK, csvData.get(i)[0]);
            mapped.put(COMPANY_NAME, csvData.get(i)[INDICE_COMPANY_NAME]);
            mapped.put(NUMBER_EMPLOYEES, csvData.get(i)[2]);
            mapped.put(CATEGORY, csvData.get(i)[3]);
            mapped.put(CITY, csvData.get(i)[INDICE_CITY]);
            mapped.put(STATE, csvData.get(i)[INDICE_STATE]);
            mapped.put(FUNDED_DATE, csvData.get(i)[6]);
            mapped.put(RAISED_AMOUNT, csvData.get(i)[7]);
            mapped.put(RAISED_CURRENCY, csvData.get(i)[8]);
            mapped.put(ROUND, csvData.get(i)[INDICE_ROUND]);
            output.add(mapped);
        }
        return output;
    }


//    private void filtrarPor(String nombreColumna) {
//        if (filtrosDeBusqueda.containsKey(nombreColumna)) {
//            List<String[]> results = new ArrayList<String[]>();
//
//            for (String[] csvDatum : csvData) {
//                if (csvDatum[this.mapaNombreIndice.get(nombreColumna)]
//                        .equals(filtrosDeBusqueda.get(nombreColumna))) {
//
//                    results.add(csvDatum);
//                }
//            }
//            csvData = results;
//        }
//    }


}
