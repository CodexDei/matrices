import javax.swing.*;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Matriz {

    public static String[][] matriz = new String[0][0]; // Inicializa matriz con tamaño 0x0
    public static int numeroFilas;
    public static int numeroColumnas;
    public static int copiaNumeroFilas;
    public static int copiaNumeroColumnas;
    public static String[][] copiaMatriz = new String[0][0]; // Inicializa matriz con tamaño 0x0
    public static boolean estado = false;
    public static void main(String[] args) {

        do {

            try {

                int menu = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion que desee:\n\n"
                        + "1. Rellenar matriz\n"
                        + "2. Imprimir matriz\n"
                        + "3. Ordenar matriz(solo se ordena cada fila de forma individual)\n"
                        + "4. Copiar matriz\n"
                        + "5. Comparacion general de matrices\n"
                        + "6. Comparacion profunda de matrices\n"
                        + "7. Verificar si la matriz es simetrica\n"
                        + "8. Salir\n"));

                switch (menu) {

                    case 1:

                        matriz = rellenarMatriz();
                        break;

                    case 2:

                        matriz = imprimirMatriz();
                        break;

                    case 3:

                        matriz = ordenarMatriz();
                        matriz = imprimirMatriz();
                        break;

                    case 4:

                        copiaMatriz = copiarMatriz();
                        imprimirOriginalCopia();
                        break;

                    case 5:

                        comparacionGeneral();
                        break;

                    case 6:

                        comparacionProfunda();
                        break;

                    case 7:

                        simetriaMatriz();
                        break;

                    case 8:

                        estado = true;
                        break;

                    default:

                        throw new IllegalArgumentException("INGRESE UN VALOR VALIDO");
                }

            } catch (InputMismatchException e) {
                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
            }

        } while (!estado);

    }

    public static String[][] rellenarMatriz() {

        StringBuilder mensaje = new StringBuilder("RELLENAR MATRIZ\n");

        numeroFilas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de filas para la matriz"));
        numeroColumnas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de columnas para la matriz"));

        String[][] matrizRellenar = new String[numeroFilas][numeroColumnas];

        //El for tambien podria ser: for(int fila = 0; fila < numeroFilas; fila++)
        for (int fila = 0; fila < matrizRellenar.length; fila++) {

            //El for tambien podria ser: for(int columna = 0; fila < numeroColumnas; columna++)
            for (int columna = 0; columna < matrizRellenar[fila].length; columna++) {
                matrizRellenar[fila][columna] = JOptionPane.showInputDialog(
                        "Ingrese el dato para la fila " + (fila + 1) + " y columna " + (columna + 1) + ":");
            }
        }
        return matrizRellenar;
    }

    public static String[][] imprimirMatriz() {

        if (matriz != null){

           String[][] matrizImprimir = new String[numeroFilas][numeroColumnas];

            System.arraycopy(matriz,0,matrizImprimir,0,matriz.length);

            StringBuilder mensaje = new StringBuilder("IMPRIMIR MATRIZ\n\n");

            for (int i = 0; i < matrizImprimir.length; i++) {

                for (int j = 0; j < matrizImprimir[i].length; j++) {

                    mensaje.append(String.format("%-15s",matrizImprimir[i][j]));
                }
                mensaje.append("\n");
            }
            JOptionPane.showMessageDialog(null, mensaje);

            return matrizImprimir;

        }else{

            JOptionPane.showMessageDialog(
null,"Ingrese primero los datos de la matriz","RECUERDE",JOptionPane.WARNING_MESSAGE);

            return matriz = rellenarMatriz();        }
    }

    public static String[][] ordenarMatriz(){

        String[][] matrizOrdenar = new String[numeroFilas][numeroColumnas];

        System.arraycopy(matriz,0,matrizOrdenar,0,matriz.length);

        if (matrizOrdenar != null){

                for (int i = 0 ; i < matrizOrdenar.length ; i++){

                    Arrays.sort(matrizOrdenar[i]);
                }

                return matrizOrdenar;

            }else{

                JOptionPane.showMessageDialog(
                        null,"Ingrese primero los datos de la matriz","RECUERDE",JOptionPane.WARNING_MESSAGE);
             return matriz = rellenarMatriz();
        }

    }

      public static String[][] copiarMatriz(){

        String [][]matrizCopia = new String[numeroFilas][numeroColumnas];

        for (int fila = 0 ; fila < matriz.length ; fila++)
            for (int columna = 0; columna < matriz[fila].length; columna++) {

                matrizCopia[fila][columna] = matriz[fila][columna];
            }
        return matrizCopia;
      }

      public static void imprimirOriginalCopia(){

          StringBuilder mensaje = new StringBuilder("COPIAR MATRIZ\n\n");

          mensaje.append("MATRIZ ORIGINAL\n\n");

          for (int i = 0 ; i < matriz.length ; i++){

              for (int j = 0 ; j < matriz[i].length ; j++){

                  mensaje.append(String.format("%-15s",matriz[i][j]));
              }
              mensaje.append("\n");
          }

          mensaje.append("\nCOPIA MATRIZ\n\n");

          for (int i = 0 ; i < copiaMatriz.length ; i++){

              for (int j = 0 ; j < copiaMatriz[i].length ; j++){

                  mensaje.append(String.format("%-15s", copiaMatriz[i][j]));
              }
              mensaje.append("\n");
          }

          JOptionPane.showMessageDialog(null,mensaje);
      }


    public static void comparacionGeneral() {

        StringBuilder mensaje = new StringBuilder("Comparar matrices\n\n");

        mensaje.append("MATRIZ ORIGINAL\n\n");

        for (int i = 0 ; i < matriz.length ; i++){

            for (int j = 0 ; j < matriz[i].length ; j++){

                mensaje.append(String.format("%-15s",matriz[i][j]));
            }
            mensaje.append("\n");
        }

        mensaje.append("\n\nRellene la matriz copia\n");

        copiaNumeroFilas = Integer.parseInt(JOptionPane.showInputDialog(mensaje.append("\nIngrese el numero de filas\n")));
        mensaje.append(copiaNumeroFilas);
        copiaNumeroColumnas = Integer.parseInt(JOptionPane.showInputDialog(mensaje.append("\nIngrese el numero de columnas\n")));
        mensaje.append(copiaNumeroColumnas);
        copiaMatriz = new String[copiaNumeroFilas][copiaNumeroColumnas];

        for (int i = 0 ; i < copiaMatriz.length ; i++){
            for (int j = 0 ; j < copiaMatriz[i].length ; j++){

                copiaMatriz[i][j] = JOptionPane.showInputDialog(mensaje.append("\nIngrese el valor para la fila "
                        + (i + 1) + " Colunmna " + (j+ 1) + ":") );
                mensaje.append(copiaMatriz[i][j]);
            }
        }

        mensaje.append("\n\nMATRIZ ORIGINAL\n\n");

        for (int i = 0 ; i < matriz.length ; i++){

            for (int j = 0 ; j < matriz[i].length ; j++){

                mensaje.append(String.format("%-15s",matriz[i][j]));
            }
            mensaje.append("\n");
        }

        mensaje.append("\nCOPIA MATRIZ\n\n");

        for (int i = 0 ; i < copiaMatriz.length ; i++){

            for (int j = 0 ; j < copiaMatriz[i].length ; j++){

                mensaje.append(String.format("%-15s", copiaMatriz[i][j]));
            }
            mensaje.append("\n");
        }

        if (copiaMatriz != null) {

            boolean comparacionMatrices = true;

            for (int i = 0; i < matriz.length; i++) {

                for (int j = 0; j < matriz[i].length; j++) {

                    if (!matriz[i][j].equals(copiaMatriz[i][j])) {
                        comparacionMatrices = false;
                        break;
                    }
                }
            }
            if (comparacionMatrices) {
                mensaje.append("\nLas matrices son IGUALES");
            }else{
                mensaje.append("\nlas matrices son DIFERENTES");
            }
            JOptionPane.showMessageDialog(null,mensaje);

        } else {

            JOptionPane.showMessageDialog(
                    null, "\"Ingrese datos a la otra matriz para comparar", "Recuerde", JOptionPane.WARNING_MESSAGE
            );
        }
    }

    public static void comparacionProfunda(){

        StringBuilder mensaje = new StringBuilder("Comparar matrices\n\n");

        mensaje.append("MATRIZ ORIGINAL\n\n");

        for (int i = 0 ; i < matriz.length ; i++){

            for (int j = 0 ; j < matriz[i].length ; j++){

                mensaje.append(String.format("%-15s",matriz[i][j]));
            }
            mensaje.append("\n");
        }

        mensaje.append("\n\nRellene la matriz copia\n");

        copiaNumeroFilas = Integer.parseInt(JOptionPane.showInputDialog(mensaje.append("\nIngrese el numero de filas\n")));
        mensaje.append(copiaNumeroFilas);
        copiaNumeroColumnas = Integer.parseInt(JOptionPane.showInputDialog(mensaje.append("\nIngrese el numero de columnas\n")));
        mensaje.append(copiaNumeroColumnas);
        copiaMatriz = new String[copiaNumeroFilas][copiaNumeroColumnas];

        for (int i = 0 ; i < copiaMatriz.length ; i++){
            for (int j = 0 ; j < copiaMatriz[i].length ; j++){

                copiaMatriz[i][j] = JOptionPane.showInputDialog(mensaje.append("\nIngrese el valor para la fila "
                        + (i + 1) + " Colunmna " + (j+ 1) + ":") );
                mensaje.append(copiaMatriz[i][j]);
            }
        }

        mensaje.append("\n\nMATRIZ ORIGINAL\n\n");

        for (int i = 0 ; i < matriz.length ; i++){

            for (int j = 0 ; j < matriz[i].length ; j++){

                mensaje.append(String.format("%-15s",matriz[i][j]));
            }
            mensaje.append("\n");
        }

        mensaje.append("\nCOPIA MATRIZ\n\n");

        for (int i = 0 ; i < copiaMatriz.length ; i++){

            for (int j = 0 ; j < copiaMatriz[i].length ; j++){

                mensaje.append(String.format("%-15s", copiaMatriz[i][j]));
            }
            mensaje.append("\n");
        }

        if (copiaMatriz != null) {

            if (Arrays.deepEquals(matriz,copiaMatriz)){

                mensaje.append("\nLas matrices son IGUALES");

            }else {

                mensaje.append("\nLas matrices son DIFERENTES");
            }
            JOptionPane.showMessageDialog(null,mensaje);

        } else {

            JOptionPane.showMessageDialog(
                    null, "\"Ingrese datos a la otra matriz para comparar", "Recuerde", JOptionPane.WARNING_MESSAGE
            );
          }

    }

    public static void simetriaMatriz(){

        StringBuilder mensaje = new StringBuilder("VERIFICAR SIMETRIA DE LA MATRIZ\n");

        if (numeroFilas != numeroColumnas){

            JOptionPane.showMessageDialog(null,mensaje.append("La matriz NO es simetrica"));

        }else{

            JOptionPane.showMessageDialog(null,mensaje.append("La matriz ES simetrica"));

        }


    }

}
