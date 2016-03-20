
package AlgoritmoBasico;


/*
 * Esta clase se encarga de la conversion de decimal a binario y de binario a decimal
 * @author erley
 */
public class ConvertidorBinarioClass {
        
    public int[][] decimalBinario(int muestraDecimal[], int bits)
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
}
