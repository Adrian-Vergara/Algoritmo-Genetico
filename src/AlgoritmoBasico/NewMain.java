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
        int poblacion = 31;
        ConvertidorBinarioClass c = new ConvertidorBinarioClass();
        int muestra[] = new int[4];
        String muestra_binarios[];
        for (int i = 0; i < muestra.length; i++) {
            muestra[i] = (int) (Math.random()* poblacion+0);
            //System.out.println((int) (Math.random()* poblacion+0));
            //i--;
        }
        muestra_binarios = c.decimal_binario(muestra, 5);
        for (int i = 0; i < muestra_binarios.length; i++) {
            System.out.println(muestra[i] + " = " +muestra_binarios[i]);
        }
    }
    
    
    
    
}
