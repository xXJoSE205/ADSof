/**
 * Esta clase contiene la informacion de una FuncionMultiplicacion
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */
package p4.src;

public class FuncionMultiplicacion extends Funcion {
    /**
     * Constructor de FuncionMultiplicacion
     *
     * @param operador Simbolo representativo de la funcion
     * @param operandos Numero de operandos de la funcion
     */
    public FuncionMultiplicacion(String operador, int operandos) {
        super(operador, operandos);
    }

    /**
     * Devuelve el resultado de multiplicar los descendientes
     *
     * @return double, producto de los descendientes
     */
    @Override
    public double calcular() {
        double resultado = 1;

        for(INodo n : super.getDescendientes()){
            resultado *= n.calcular();
        }

        return resultado;
    }

    /**
     * Crea una copia de la FuncionMultiplicacion
     *
     * @return Nodo nuevo con la misma informacion
     */
    @Override
    public INodo copy() {
        Funcion funcionCopy = new FuncionMultiplicacion(this.getRaiz(), this.getNumOperandos());
        for(INodo n: getDescendientes()){
            funcionCopy.incluirDescendiente(n);
        }
        return funcionCopy;
    }
}
