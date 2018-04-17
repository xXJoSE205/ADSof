
package p4.src;
/**
 * Esta clase contiene la informacion de una FuncionResta
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
public class FuncionResta extends Funcion {
    /**
     * Constructor de FuncionResta
     *
     * @param operador Simbolo representativo de la funcion
     * @param operandos Numero de operandos de la funcion
     */
    public FuncionResta(String operador, int operandos) {
        super(operador, operandos);
    }

    /**
     * Devuelve el resultado de restar los descendientes
     *
     * @return double, resta de los descendientes
     */
    @Override
    public double calcular() {
        double resultado = 0;

        for(int i=0; i<super.getDescendientes().size(); i++){
            if(i==0){
                resultado = super.getDescendientes().get(0).calcular();
            } else {
                resultado -= super.getDescendientes().get(i).calcular();
            }
        }

        return resultado;
    }

    /**
     * Crea una copia de la FuncionResta
     *
     * @return Nodo nuevo con la misma informacion
     */
    @Override
    public INodo copy() {
        if(getRaiz().equals("x")){
            return new TerminalAritmetico("x");
        }
        Funcion funcionCopy = new FuncionResta(this.getRaiz(), this.getNumOperandos());
        for(INodo n: getDescendientes()){
            funcionCopy.incluirDescendiente(n);
        }
        return funcionCopy;
    }
}
