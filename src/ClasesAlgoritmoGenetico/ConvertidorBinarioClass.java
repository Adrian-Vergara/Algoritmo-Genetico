
package ClasesAlgoritmoGenetico;


/*
 * Esta clase se encarga de la conversion de decimal a binario y de binario a decimal
 * @author erley
 */
public class ConvertidorBinarioClass {
        
    public int[][] decimalBinario(int muestraDecimal[], int  bits)
    {
    
        int muestraBinario[][] = new int[muestraDecimal.length][bits];
        for (int i = 0; i < muestraDecimal.length; i++) {
            int decimal = muestraDecimal[i];
            int k = bits-1;
            for (int j = 0; j < bits; j++) {
                if(decimal == 1)
                {
                    muestraBinario[i][k] = decimal;
                    decimal = 0;
                }
                if(decimal >= 2)
                {
                    muestraBinario[i][k] = decimal%2;
                    decimal = (int)decimal/2;
                }
                k--;
            }
        }
        return muestraBinario;
    }
    
    //@Override
    public int[][] decimalBinario(int muestraDecimal[])
    {
        int bits = this.numeroBits(this.encontrarMayor(muestraDecimal));
        int muestraBinario[][] = new int[muestraDecimal.length][bits];
        for (int i = 0; i < muestraDecimal.length; i++) {
            int decimal = muestraDecimal[i];
            int k = bits-1;
            for (int j = 0; j < bits; j++) {
                if(decimal == 1)
                {
                    muestraBinario[i][k] = decimal;
                    decimal = 0;
                }
                if(decimal >= 2)
                {
                    muestraBinario[i][k] = decimal%2;
                    decimal = (int)decimal/2;
                }
                k--;
            }
        }
        return muestraBinario;
    }
    
    /**
     * Metodo que convierte un entero a binario
     * @param num   numero entero
     * @param bits  numero de bits para codificar
     * @return int [] con los binarios
     */
    public int[] decimalBinario(int num, int bits){
            int[] binarioNum = new int [bits];
            int decimal = num;
            int k = bits-1;
            for (int j = 0; j < bits; j++) {
                if(decimal == 1)
                {
                    binarioNum[k] = decimal;
                    decimal = 0;
                }
                if(decimal >= 2)
                {
                    binarioNum[k] = decimal%2;
                    decimal = (int)decimal/2;
                }
                k--;
            }
            
            return binarioNum;
    }
    /**
     * Este metodo convierte de Binarios a Decimales
     * @param muestraBinario recibe una matriz de binarios
     * @return un vector de enteros de decimales
     */
    public int[] binarioDecimal(int muestraBinario[][])
    {
        int muestraDecimal[] = new int[muestraBinario.length];
        for (int i = 0; i < muestraBinario.length; i++) {
            int decimal = 0;
            int k = muestraBinario[i].length - 1;
            for (int j = 0; j < muestraBinario[i].length; j++) {
                decimal = (int)(decimal + (muestraBinario[i][j] * Math.pow(2, k)));
                k--;
            }
            muestraDecimal[i] = decimal;
        }
        return muestraDecimal;
    }
    
    /**
     * Calcula el numero de bits necesarios para codificar un numero en binario
     * @param x 
     * @return numero de bits 
     */
    public int numeroBits(int x){
       int num = (int) ((Math.log(x))/(Math.log(2)));
       return num+1;
    }
    
    public int encontrarMayor(int [] generacion){
       int x=0;
       
        for (int i = 0; i < generacion.length; i++) {
            if(x<generacion[i]){
                x=generacion[i];
            }
        }
 
       return x;
        
    }
}
