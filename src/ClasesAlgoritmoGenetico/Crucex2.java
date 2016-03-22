
package ClasesAlgoritmoGenetico;

import Interfaces.AbstCruce;
import ClasesAlgoritmoGenetico.ConvertidorBinarioClass;

/**
 * Esta clase se encarga de realizar el cruce basandose en el punto fijo de particion 
 * @author erley
 */
public class Crucex2 extends AbstCruce {

    @Override
   public int[] recombinacion(int[] muestraDecimal) {
         ConvertidorBinarioClass c = new ConvertidorBinarioClass();
        int nuevaGeneracion[] = new int[4];
        int aptos[] = this.seleccionarAptos(Ordenar(muestraDecimal));
        int binarioHijo[][] = new int[1][5];
        int contador = 0;
        for (int i = 0; i < aptos.length; i++) {
            for (int j = 0; j < aptos.length; j++) {
                //if(aptos[i] == aptos[j]){
//                    nuevaGeneracion[contador] = aptos[i];
//                    contador++;
                //} 
                //else{
                    int binariosAptos[][] = c.decimalBinario(aptos, 5);
                    int puntoDeCruce = this.puntoDeCruce(1, 4);
                    boolean bandera = true;
                    for (int k = 0; k < puntoDeCruce; k++) {
                        binarioHijo[0][k] = binariosAptos[i][k];
                    }
                    while(bandera != false)
                    {
                        binarioHijo[0][puntoDeCruce] = binariosAptos[j][puntoDeCruce];
                        if(puntoDeCruce == binariosAptos[i].length - 1){
                            bandera = false;
                        }
                        else{
                            puntoDeCruce++;
                        }
                    }
                    int auxiliar[] = c.binarioDecimal(binarioHijo);
                    nuevaGeneracion[contador] = auxiliar[0];
                    if(contador == 3)
                    {
                        j = aptos.length;
                        i = aptos.length;
                    }
                    contador++;
                //}
            }
        }
        return nuevaGeneracion;
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

    
}

 