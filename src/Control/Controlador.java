
package Control;

import Interfaces.AbstCruce;
import ClasesAlgoritmoGenetico.ConvertidorBinarioClass;
import ClasesAlgoritmoGenetico.Crucex2;
import ClasesAlgoritmoGenetico.EvaluarXALa2;
import ClasesAlgoritmoGenetico.SeleccionarMuestraClass;
import Interfaces.IEvaluarMuestra;

/**
 * Esta clase media entre la interfaz y gestiona los pasos del algoritmo genetico
 * @author erley
 */
public class Controlador {
    
    private SeleccionarMuestraClass ObMuestra;
    private ConvertidorBinarioClass ObConvertidor;
    private IEvaluarMuestra ObEvaluar;
    private AbstCruce ObCruce;
    private int[] Generacion;
    
    public Controlador (){
       this.ObConvertidor = new ConvertidorBinarioClass();
       this.ObEvaluar = new EvaluarXALa2();
       this.ObCruce = new Crucex2();
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
   
    /**
     * 
     * @param generacion  int [] Vector con la generacion a Evaluar
     * @param binarioMuestra Objeto con los genes de la generacion
     * @return 
     */
   private Object[][] AgruparDatos(int [] generacion, Object [] binarioMuestra){
       double [][] Matriz = this.ObEvaluar.EvlauarMuestra(generacion);    
       Object[][] d = new Object[generacion.length+1][4];
       for (int i = 0; i < generacion.length+1; i++) {
          
          if(i<generacion.length){
               for (int j = 0; j < 4 ; j++) {
                  if (j>0){
                     if(j>2)d[i][j] =  Matriz[i][j-1];
                     else d[i][j] =  (int) Matriz[i][j-1];         
                  }else{
                     d[i][j] = binarioMuestra[i];
                  }
               }
          }else{
              for (int j = 0; j < 4; j++) {
                  d[i][j] = "*************";
              }

          } 
          
         
       }
       
       return  d;
   }
   
   public Object[][] getData(){
       
       if(this.Generacion==null){
            this.Generacion = this.GenerarMuestra();
       }
      
       Object [] binarioMuestra = this.MuestraBinaria(this.Generacion);
       Object[][] data= AgruparDatos(this.Generacion,binarioMuestra);
       
       return data;
   }
   
   public void cruzar(){
      this.Generacion = this.ObCruce.recombinacion(this.Generacion);
   }
}
