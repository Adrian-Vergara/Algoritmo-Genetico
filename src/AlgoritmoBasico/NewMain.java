/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmoBasico;

/**
 *
 * @author erley
 */
public class NewMain {
    
    public int[] generarMuestraDecimal(){
        int poblacion[] = new int[32];
        SeleccionarMuestraClass m = new SeleccionarMuestraClass(poblacion);
        for (int i = 0; i < poblacion.length; i++) {
            poblacion[i] = i;
        }
        int muestraDecimal[] = m.getMuestra(4);
        return muestraDecimal;
    }
    public void pruebaDecimalBinario(){
        ConvertidorBinarioClass c = new ConvertidorBinarioClass();
        int muestraDecimal[] = this.generarMuestraDecimal();
        int muestraBinario[][] = c.decimalBinario(muestraDecimal, 5);
        for (int i = 0; i < muestraBinario.length; i++) {
            System.out.println(muestraDecimal[i]);
            for (int j = 0; j < muestraBinario[i].length; j++) {
                System.out.print(muestraBinario[i][j]);
            }
            System.out.println(" ");
        }
    }
    
    public void pruebaBinarioDecimal(){
        ConvertidorBinarioClass c = new ConvertidorBinarioClass();
        int muestraDecimal[] = this.generarMuestraDecimal();
        int muestraBinario[][] = c.decimalBinario(muestraDecimal, 5);
        int decimalConvertido[] = c.binarioDecimal(muestraBinario);
        for (int i = 0; i < decimalConvertido.length; i++) {
            System.out.println(decimalConvertido[i]);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    }
    
}
