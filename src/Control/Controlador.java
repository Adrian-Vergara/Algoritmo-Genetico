
package Control;

import Interfaces.AbstCruce;
import ClasesAlgoritmoGenetico.ConvertidorBinarioClass;
import ClasesAlgoritmoGenetico.Crucex2;
import ClasesAlgoritmoGenetico.EvaluarXALa2;
import ClasesAlgoritmoGenetico.SeleccionarMuestraClass;
import Interfaces.IEvaluarMuestra;
import java.util.ArrayList;

/**
 * Esta clase media entre la interfaz y gestiona los pasos del algoritmo genetico
 * @author erley
 */
public class Controlador {
    
    private SeleccionarMuestraClass ObMuestra;
    private ConvertidorBinarioClass ObConvertidor;
    private IEvaluarMuestra ObEvaluar;
    private AbstCruce ObCruce;
    private int bits;
    private int[] Generacion ;
    private int[] poblacion;
    private int[] MuestraInicial;
    private int[][] binarioGeneracion;
    public boolean SujetoOptimo=false;
    
    /**
     * Constructor: Inicializa objetos a utilizar
     */
    public Controlador (){
       this.ObConvertidor = new ConvertidorBinarioClass();
       this.ObEvaluar = new EvaluarXALa2();
       this.ObCruce = new Crucex2();
       
    
    }
    
    /**
     * Metodo que envia la generacion  en una cadena de texto
     * @return String
     */
    public String getMuestra(){
        String muestra="";
        
        for (int i = 0; i < this.MuestraInicial.length; i++) {
            muestra= muestra+" "+this.MuestraInicial[i];
        }
        return muestra;
    }
    
    /**
     * Metodo que selecciona una muestra aleatoria de la poblacion
     * @param poblacion
     * @return 
     */
    private int[] generarMuestra(int[]poblacion,int cantidad){
       
        this.ObMuestra = new SeleccionarMuestraClass(poblacion);
        int muestraDecimal[] = ObMuestra.getMuestra(cantidad);
        return muestraDecimal;
    }
   
    /**
     * Método que en base a una muestra retorna un Objeto con la conversion 
     * a binario de cada sujeto de la muestra
     * @param muestra vector de enteros
     * @return objeto[] 
     */
    private Object [] muestraBinaria(int [] muestra){
        int [][] MatrizBin = ObConvertidor.decimalBinario(muestra,this.bits);
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
     * Funcion que verifica si se encuentra el sujeto mas apto en la 
     * generacion
     * @param MatrizBin Matriz con los binarios de cada sujeto de la generacion
     */
    private void verificarMasApto(int []muestra){
        
        // Encontramos el mas apto de la poblacion
        int apto=0;
        for (int i = 0; i < this.poblacion.length; i++) {
            if (apto< this.poblacion[i]) {
                apto= this.poblacion[i];
            }
        }
                
        // comparamos si el mas apto esta en la generacion        
        for (int i = 0; i < muestra.length; i++) {           
            if(apto==muestra[i]){
            this.SujetoOptimo=true;
            }
        }
        
      
           
    }
   
    /**
     * Metodo que gestiona la evaluacion de la generacion en la funcion objetivo 
     * y arman un Objeto[][] con la informacion requerida para mostrar en la tabla 
     * @param generacion  int [] Vector con la generacion a Evaluar
     * @param binarioMuestra Objeto con los genes de la generacion
     * @return Objeto[][]
     */
    private Object[][] agruparDatos(double [][] Matriz, Object [] binarioMuestra){
       
       Object[][] data = new Object[Matriz.length+1][4];
       for (int i = 0; i < Matriz.length+1; i++) {
            if(i<Matriz.length){
                for (int j = 0; j < 4 ; j++) {
                    switch (j){
                        case 0 :  data[i][j] = binarioMuestra[i]; //Genes del sujeto
                                 break;
                        case 3 :  data[i][j] =  Matriz[i][j-1];  // porcentaje 
                                 break;
                        default : data[i][j] =  (int) Matriz[i][j-1];  //datos que requerien truncamiento
                    }
                }
            }else{
                for (int j = 0; j < 4; j++) {
                  data[i][j] = "*************";   //Separador que indica el final de la generacion
                }
            } 
       }
       return  data;
   }
   
    /**
    * Devulve un objeto con los datos agrupados por cada generacion
    * @return object[][]
    */
    private Object[][] getDataGeneracion(){
       Object [] binarioMuestra = this.muestraBinaria(this.Generacion);
       Object[][] data = agruparDatos(this.evaluarGeneracion(this.Generacion),binarioMuestra);
       
       return data;
   }
   
    /**
    * Funcion publica que gestiona el cruce y asigna a la variable Generacion, la 
    * nueva generacion obtenida en el cruce.
    */
    private void cruzar(){
      this.Generacion = this.ObCruce.recombinacion(this.Generacion,this.bits,this.poblacion);
   }
    
    /**
     * Metodo que evalua la generacion en la funcion objetivo 
     * @param generacion int [] generacion
     * @return double [][] Matriz con datos de la evaluacion
     */
    private double[][] evaluarGeneracion(int[]generacion){
        double [][] Matriz = this.ObEvaluar.EvlauarMuestra(generacion); 
        return Matriz;
    }
    
    /**
     * data Objeto con los datos de las iteraciones+ Muestra inicial + EL mas apto + Numero de iteraciones
     * @param poblacion   int []  Con los individuos 
     * @param cantidadMuestra  int cantidad de sujetos para la muestra
     * @param iteraciones int numero de sujetos
     * @return data Objeto con los datos de las iteraciones+ Muestra inicial + EL mas apto + Numero de iteraciones
     */
    public ArrayList run(int[] poblacion,int cantidadMuestra, int iteraciones){
        this.poblacion=poblacion;
        this.Generacion=this.generarMuestra(poblacion,cantidadMuestra);
        
       //Asignamoc antidad de bits con la que vamos a trabajar.
       this.bits=this.ObConvertidor.numeroBits(this.ObConvertidor.encontrarMayor(this.poblacion)); 
     
        ArrayList data = new ArrayList();
        int contador=0;
        int apto=0;
        Object [][] MatrizAux = new Object [1][1];
        
        for (int i = 0; i < iteraciones; i++) {
             
                if(i==0){
                    this.MuestraInicial=this.Generacion; //guardamos la primera generacion
                }
                
              
                
                MatrizAux =getDataGeneracion();
                data.add(MatrizAux);
                contador=contador+1;
                int[] generacionAux = new int [MatrizAux.length-1];
               /**
                * Seleccion del mas apto
                */  
                for (int j = 0; j < 4; j++) {
                    generacionAux[j]= (int)MatrizAux[j][1]; //guardamos los sujetos de la generacion
                    if(apto <(int)MatrizAux[j][1]){
                          apto=(int)MatrizAux[j][1];
                          
                      }
                }
                
                 /**
                 * Verificamos si el mas apto está en la generacion
                 */
                
                
               
                this.verificarMasApto(generacionAux); //Se verifica si el sujeto mas apto se encontro
                if(this.SujetoOptimo==true){
                      i=iteraciones;  
                } 
                cruzar();
                 
        }
         
         data.add(this.getMuestra());
         data.add(apto);
         data.add(contador);
         
         
         return data;
    }
}
