
package Control;

import javax.swing.table.DefaultTableModel;


public class Utilitario {
    
    //Se utilizará para comparar dos valores numericos
    public static boolean compararValores(int busqueda, int buscado) {

        String busquedaS = Integer.toString(busqueda);
        String buscadoS = Integer.toString(buscado);
        int contador = 0;
        if (busqueda < 0) {
            return true;
        } else {
            try {

                for (int i = 0; i < busquedaS.length(); i++) {

                    if (buscadoS.charAt(i) == busquedaS.charAt(i)) {
                        contador++;
                    }
                }

                if (contador == busquedaS.length()) {

                    return true;

                } else {

                    return false;

                }

            } catch (ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException e) {
                return false;
            }

        }

    }

    //Se utilizará para comparar dos valores de texto
    public static boolean compararValores(String busqueda, String buscado) {

        String busquedaS = busqueda;
        String buscadoS = buscado;
        int contador = 0;

        try {

            for (int i = 0; i < busquedaS.length(); i++) {

                if (buscadoS.charAt(i) == busquedaS.charAt(i) || Character.toUpperCase(busquedaS.charAt(i)) == buscadoS.charAt(i)) {
                    contador++;
                }
            }

            if (contador == busquedaS.length()) {

                return true;

            } else {

                return false;

            }

        } catch (ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException e) {
            return false;
        }

    }
    
    //Limpia la tabla
    public static void limpiarTabla(DefaultTableModel modeloTabla) {

        int f = modeloTabla.getRowCount() - 1; //total de filas (-1 para recorrer for)
        for (int i = f; i >= 0; i--) {
            modeloTabla.removeRow(i);
        }
    }
    
    //Se crea un string en base al estado del objeto, para mostrarlo en la tabla
    public static String estadoParaTabla(boolean estado) {

        if (estado) {
            return "activo";
        } else {
            return "inactivo";
        }
    }
    
}
