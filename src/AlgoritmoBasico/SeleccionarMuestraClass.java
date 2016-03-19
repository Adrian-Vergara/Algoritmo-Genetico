
package AlgoritmoBasico;

/**
 * Seleccion la muestra de la poblacion 
 * @author erley
 */
public class SeleccionarMuestraClass {
    private int muestra[];
    private int poblacion[];
    
    public SeleccionarMuestraClass(int poblacion[]){
        this.poblacion = poblacion;
    }
    
    /**
     * Funcion que genera una muestra aletoria de la poblacion
     * @param cantidad numero de sujetos requeridos en la muestra
     * @return muestra, array con el numero total de sujetos escogidos 
     */
    public int [] getMuestra(int cantidad){
       
        for (int i = 0; i < cantidad; i++) {                      
            int x = poblacion[(int) (Math.random()* poblacion.length+0)];
            if(VerificarRepeticion(x)){
                i--; //repetimos el ciclo para seleccionar un nuevo sujeto
            }else{
                muestra[i] =  poblacion[(int) (Math.random()* poblacion.length+0)];
            }         
        }
    
     return muestra;
    
    }
    
    /**
     * Se encarga de verificar la existencia del sujeto en la muestra
     * @param x
     * @return false, si no está en la muestra
     *         true, si está en la muestra
     */
    private boolean VerificarRepeticion(int x){
        int cont=0;
        for (int i = 0; i < muestra.length; i++) {
            if(muestra[i]==x){
                cont=cont++;
            }
        }   
        if(cont==0) return false;
        else return true;
        
    }
}
