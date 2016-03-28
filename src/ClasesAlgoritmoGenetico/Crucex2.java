
package ClasesAlgoritmoGenetico;

import Interfaces.AbstCruce;

/**
 * Esta clase se encarga de realizar el cruce basandose en el punto fijo de particion 
 * @author erley
 */
public class Crucex2 extends AbstCruce {
   
    /**
     * Método que cruce elitista 
     * @param muestraDecimal
     * @param bits
     * @param poblacion
     * @return int[] Nueva generacion
     */
    @Override
   public int[] recombinacion(int[] muestraDecimal, int bits, int [] poblacion) {
         ConvertidorBinarioClass c = new ConvertidorBinarioClass();
        int nuevaGeneracion[] = new int[muestraDecimal.length];
        int aptos[] = this.seleccionarAptos(Ordenar(muestraDecimal));
        int contador = 0;
        for (int i = 0; i < aptos.length; i++) {
            for (int j = 0; j < aptos.length; j++) {
                   
                    int []  padre = c.decimalBinario(aptos[i],bits);
                    int []  madre = c.decimalBinario(aptos[j],bits);
                    
                    int x = this.cruce(c, padre, madre)[0];
                    if(this.verificarSujetoEnPoblacion(x, poblacion)){
                        nuevaGeneracion[contador] = x;
                    }else{
                          j--;
                    }
                  
                    
                    if(contador == muestraDecimal.length-1)
                    {
                        j = aptos.length;
                        i = aptos.length;
                    }
                    contador++;
             
            }
        }
        return nuevaGeneracion;
    }
    
    /**
     * Asiganacion genes del padre y madre al hijo.
     * @param c    objeto clase ConvertidorBinarioClass
     * @param padre int[] genes padre
     * @param madre  int[] genes madre
     * @return  int [] genes hijo
     */
    private int[] cruce(ConvertidorBinarioClass c, int[]padre , int[]madre){

            int [][] binarioHijo = new int [1][padre.length];
            int puntoDeCruce = this.puntoDeCruce(1, padre.length-1);
       
            
            //Agregamos la genetica del padre
            for (int k = 0; k < puntoDeCruce; k++) {
                binarioHijo[0][k] = padre[k];
            }
            // Agregamos la genetica de la madre
            for (int i = puntoDeCruce; i < madre.length; i++) {
                 binarioHijo[0][i] = madre[i];
            }
            int data[] = c.binarioDecimal(binarioHijo);
            
            return data;
    }

    @Override
    public int[] seleccionarAptos(int[] muestraDecimal) {
         int aptos[] = new int[3];
        for (int i = 0; i < aptos.length; i++) {
            aptos[i] = muestraDecimal[i];
        }
        return aptos;
    }
    
    
    /**
     * Ordena el vector de la generacion
     * @param generacion vector con los sujetos a ordenar
     * @return vector ordenado
     */
    private int[] Ordenar(int lista[]){
 
        //Usamos un bucle anidado
        for(int i=0;i<(lista.length-1);i++){
            for(int j=i+1;j<lista.length;j++){
                if(lista[i]<lista[j]){
                    //Intercambiamos valores
                    int variableauxiliar=lista[i];
                    lista[i]=lista[j];
                    lista[j]=variableauxiliar;
 
                }
            }
        }
        
        return lista;
    }

    /**
     * Verifica si el nuevo sujeto pertenece a la poblacion
     * @param x  sujeto
     * @param poblacion  poblacion 
     * @return Boolean
     */
    private boolean verificarSujetoEnPoblacion(int x, int[]poblacion){
        
        for (int i = 0; i < poblacion.length; i++) {
            if(x==poblacion[i]){
                return true;
            }
        }
        return false;
    }
}

 