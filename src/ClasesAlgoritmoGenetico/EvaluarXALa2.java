
package ClasesAlgoritmoGenetico;

/**
 * Esta clase se encarga de evaluar un array en la funcion dada y ordenarlo 
 * descendentemente
 * @author erley
 */
public class EvaluarXALa2 implements Interfaces.IEvaluarMuestra {
  
   /**
    * Método para le creacion de una matriz con la informacion de un vector 
    * muestra.
    * 1 Columna, vector a evaluar.
    * 2 Columna, sujeto evaluado en la funcion
    * 3 Columna, porcentaje
    * @param muestra Vector con la muestra
    * @return Matriz de tipo double con el vector evaluado en la funcion X al cuadrado 
    */
    @Override
    public double [][] EvlauarMuestra(int[] muestra) {
       double [][] MEvaluada = new double[muestra.length][3];
       double Total=0;
        for (int i = 0; i < muestra.length; i++) {
           MEvaluada [i][0]=  muestra[i];
           MEvaluada [i][1]= FuncionEvaluadora(muestra[i]);
           Total=Total+ MEvaluada [i][1];
        }
        
        for (int i = 0; i < muestra.length; i++) {
            MEvaluada [i][2] = Math.rint((double)((MEvaluada[i][1] /Total)*100)*100)/100;
        }
      return  MEvaluada;
    }
    
    /**
     * Funcion para evaluar al sujeto en la funcion
     * @param x
     * @return 
     */
    private int FuncionEvaluadora(int x){
       x = (int) Math.pow(x, 2);
       return x;
    }
    
}
