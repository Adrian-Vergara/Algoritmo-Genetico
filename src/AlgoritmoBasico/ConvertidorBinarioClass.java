
package AlgoritmoBasico;


/*
 * Esta clase se encarga de la conversion de decimal a binario y de binario a decimal
 * @author erley
 */
public class ConvertidorBinarioClass {
    
    public String[] decimal_binario(int muestra_decimal[], int bits)
    {
        String muestra_binario[] = new String[muestra_decimal.length]; //se declara la longitud del array
        for (int i = 0; i < muestra_decimal.length; i++) { //se recorre el array para tomar cada numero y convertirlo
            int decimal = muestra_decimal[i]; //asignamos el primer numero a una variable decimal
            boolean bandera = false; //creamos variable bandera para romper bucle while
            String binario = ""; //declaramos variable binario, que se encargara de armar el numero binario (concatenando)
            while(bandera != true){ //se hace ciclo while para la división repetitiva y obtener binario
                if(decimal >= 2){ //validacion para la convercion
                    int residuo = decimal%2; //tomamos el residuo que será 1 o 0
                    decimal = (int)decimal/2;
                    binario = Integer.toString(residuo) + binario; //lo concatenamos inverso, puesto que así se hace esta monda
                }
                else{
                    binario = Integer.toString(decimal) + binario; //en esta parte decimal = 1 y simplemente concatenamos
                    bandera = true; //asiganción para romper while
                }
            }
            int bits_restantes = bits - binario.length(); //Calculamos los bits restantes para agregar los ceros restantes
            //if(bits_restantes != 0)
            //{
                for (int j = 0; j < bits_restantes; j++) { //recorremos bits restantes para agregar ceros
                    binario = "0" + binario; //agregamos ceros para cumplir con la condición del numero de bits
                }
            //}
            muestra_binario[i] = binario;
        }
        return muestra_binario;
    }
}
