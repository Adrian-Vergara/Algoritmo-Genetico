
package Control;

import ClasesAlgoritmoGenetico.ConvertidorBinarioClass;
import ClasesAlgoritmoGenetico.EvaluarXALa2;
import ClasesAlgoritmoGenetico.SeleccionarMuestraClass;

/**
 * Esta clase media entre la interfaz y gestiona los pasos del algoritmo genetico
 * @author erley
 */
public class Controlador {
    
    private SeleccionarMuestraClass ObMuestra;
    private ConvertidorBinarioClass ObConvertidor;
    private EvaluarXALa2 ObEvaluar;
    
    public Controlador (){
       this.ObConvertidor = new ConvertidorBinarioClass();
       this.ObEvaluar = new EvaluarXALa2();
    }
    
   private int[] GenerarMuestra(){
        int poblacion[] = new int[32];
        this.ObMuestra = new SeleccionarMuestraClass(poblacion);
        for (int i = 0; i < poblacion.length; i++) {
            poblacion[i] = i;
        }
        int muestraDecimal[] = ObMuestra.getMuestra(4);
        return muestraDecimal;
    }
   
    private Object [] MuestraBinaria(int [] muestra){
        int [][] MatrizBin = ObConvertidor.decimalBinario(muestra, 5);
        Object[] VectorBin = new Object [muestra.length];
        for (int i = 0; i < MatrizBin.length; i++) {
            String num="";
            for (int j = 0; j < MatrizBin[i].length ; j++) {
             num = num+Integer.toString(MatrizBin[i][j]);
            }
            VectorBin[i]= num;
        }
        return VectorBin;
    }
   
   private Object[][] AgruparDatos(int [] muestra, Object [] binarioMuestra){
       double [][] Matriz = this.ObEvaluar.EvlauarMuestra(muestra);    
       Object[][] d = new Object[muestra.length][4];
       for (int i = 0; i < muestra.length; i++) {
           for (int j = 0; j < 4 ; j++) {
            if (j>0){
                if(j>2)d[i][j] =  Matriz[i][j-1];
                else d[i][j] =  (int) Matriz[i][j-1];         
            }else{
                 d[i][j] = binarioMuestra[i];
            }
           }
          
         
       }
       
       return  d;
   }
   
   public Object[][] getData(){
       int [] muestra = this.GenerarMuestra();
       Object [] binarioMuestra = this.MuestraBinaria(muestra);
       Object[][] data= AgruparDatos(muestra,binarioMuestra);
       
       return data;
   }
}
