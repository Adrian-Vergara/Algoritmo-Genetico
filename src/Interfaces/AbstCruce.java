/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author erley
 */
public abstract class AbstCruce {
    
   public abstract int [] recombinacion(int muestraDecimal[]);
   public abstract int [] seleccionarAptos(int muestraDecimal[]);
    
    public int puntoDeCruce(int limiteInferior, int limiteSuperior){
        int punto = (int) (Math.random() * limiteSuperior + limiteInferior);
        return punto;
    }
}
