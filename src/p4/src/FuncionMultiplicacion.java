package p4.src;

public class FuncionMultiplicacion extends Funcion {

    public FuncionMultiplicacion(String operador, int operandos) {
        super(operador, operandos);
    }

    @Override
    public double calcular() {
        double resultado=1.0;

        for(INodo n : super.getDescendientes()){
            resultado *= n.calcular();
        }

        return resultado;
    }

    @Override
    public INodo copy() {
        Funcion funcionCopy = new FuncionMultiplicacion(this.getRaiz(), this.getNumOperandos());
        for(INodo n: getDescendientes()){
            funcionCopy.incluirDescendiente(n);
        }
        return funcionCopy;
    }
}
