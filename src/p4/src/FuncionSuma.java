package p4.src;

/**
 * Esta clase contiene la informacion de una FuncionSuma
 *
 * @author Jorge Mateo Segura y José Antonio Muñoz Ortega
 */

public class FuncionSuma extends Funcion {
    /**
     * Constructor de FuncionSuma
     *
     * @param operador Simbolo representativo de la funcion
     * @param operandos Numero de operandos de la funcion
     */
    public FuncionSuma(String operador, int operandos) {
        super(operador, operandos);
    }

    /**
     * Devuelve el resultado de sumar los descendientes
     *
     * @return double, suma de los descendientes
     */
    @Override
    public double calcular() {
        double resultado = 0;

        for(INodo n : super.getDescendientes()){
            resultado += n.calcular();
        }

        return resultado;
    }

    /**
     * Crea una copia de la FuncionSuma
     *
     * @return Nodo nuevo con la misma informacion
     */
    @Override
    public INodo copy() {
        if(getRaiz().equals("x")){
            return new TerminalAritmetico("x");
        }
        Funcion funcionCopy = new FuncionSuma(this.getRaiz(), this.getNumOperandos());
        for(INodo n: getDescendientes()){
            funcionCopy.incluirDescendiente(n);
        }
        return funcionCopy;
    }
}
