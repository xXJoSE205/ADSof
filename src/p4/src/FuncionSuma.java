package p4.src;

public class FuncionSuma extends Funcion {

    public FuncionSuma(String operador, int operandos) {
        super(operador, operandos);
    }

    @Override
    public double calcular() {
        double resultado=0.0;

        for(INodo n : super.getDescendientes()){
            resultado += n.calcular();
        }

        return resultado;
    }

    @Override
    public INodo copy() {
        Funcion funcionCopy = new FuncionSuma(this.getRaiz(), this.getNumOperandos());
        for(INodo n: getDescendientes()){
            funcionCopy.incluirDescendiente(n);
        }
        return funcionCopy;
    }
}
