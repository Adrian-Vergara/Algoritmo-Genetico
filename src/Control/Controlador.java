
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
   
    private int [] MuestraBinaria(int [] muestra){
        int [][] MatrizBin = ObConvertidor.decimalBinario(muestra, 5);
        int [] VectorBin = new int [muestra.length];
        for (int i = 0; i < MatrizBin.length; i++) {
            String num="";
            for (int j = 0; j < MatrizBin[i].length ; j++) {
             num = num+Integer.toString(MatrizBin[i][j]);
            }
            VectorBin[i]= Integer.parseInt(num);
        }
        return VectorBin;
    }
   
   private double [][] AgruparDatos(int [] muestra, int [] binarioMuestra){
       double [][] Matriz = this.ObEvaluar.EvlauarMuestra(muestra);    
       double [][] data = new double[muestra.length][4];
       
       for (int i = 0; i < muestra.length; i++) {
           for (int j = 0; j < 3 ; j++) {
               if(j<1){
                   data[i][j] = Matriz[i][j];
               }else {
                   data[i][j+1] = Matriz[i][j];
               }
             
           }
           data[i][1] = binarioMuestra[i];
           
       }
       
       return  data;
   }
   
   public double [][] getData(){
       int [] muestra = this.GenerarMuestra();
       int [] binarioMuestra = this.MuestraBinaria(muestra);
       double data[][]= AgruparDatos(this.GenerarMuestra(),binarioMuestra);
       
       return data;
   }
}
