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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConvertidorBinarioClass c = new ConvertidorBinarioClass();
        int muestra[] = new int[4];
        for (int i = 0; i < muestra.length; i++) {
            muestra[i] = (int) (Math.random()*31+0);
        }
        int muestraBinarios[][] = c.decimalBinario(muestra, 5);
                
        for (int i = 0; i < muestra.length; i++) {
            System.out.println(muestra[i] + ":     ");
            for (int j = 0; j < muestraBinarios[i].length; j++) {
                System.out.print(muestraBinarios[i][j]);
            }
            System.out.println(" ");
        }
    }
    
    
    
    
}
