
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
}
