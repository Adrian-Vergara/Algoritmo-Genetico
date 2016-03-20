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

<<<<<<< HEAD
    public void pruebaDecimalBinario(){
        ConvertidorBinarioClass c = new ConvertidorBinarioClass();
        int muestra[] = new int[4];
=======
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int poblacion[] = new int[32];
        for (int i = 0; i < poblacion.length; i++) {
            poblacion[i]=i;
        } 
        
        
        SeleccionarMuestraClass p=new SeleccionarMuestraClass(poblacion);
        int [] muestra = p.getMuestra(4);
>>>>>>> 1b303132004fc0dc6d0cad0c08ec2b928a52b5a0
        for (int i = 0; i < muestra.length; i++) {
            System.out.println(muestra[i]+" ");
        }
    }
    
    public void pruebaBinarioDecimal(){
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewMain pDecimalBinario = new NewMain();
        pDecimalBinario.pruebaDecimalBinario();
    }
    
    
    
    
}
