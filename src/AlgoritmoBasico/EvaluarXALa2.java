
package AlgoritmoBasico;

/**
 * Esta clase se encarga de evaluar un array en la funcion dada y ordenarlo 
 * descendentemente
 * @author erley
 */
public class EvaluarXALa2 implements Interfaces.IEvaluarMuestra {
  
   
    @Override
    public int[][] EvlauarMuestra(int[] muestra) {
       int[][] MEvaluada = new int[muestra.length][3];
       int Total=1;
        for (int i = 0; i < muestra.length; i++) {
           MEvaluada [i][0]= muestra[i];
           MEvaluada [i][1]= FuncionEvaluadora(muestra[i]);
           Total=Total+ MEvaluada [i][1];
        }
        
        for (int i = 0; i < muestra.length; i++) {
             int y = (int)((MEvaluada[i][1] * 100)/Total);
             MEvaluada [i][2]=y;
        }
      return  MEvaluada;
    }
    
    private int FuncionEvaluadora(int x){
       x = (int) Math.pow(x, 2);
       return x;
    }
    
}
