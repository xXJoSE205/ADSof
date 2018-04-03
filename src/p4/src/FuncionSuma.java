package p4.src;

public class FuncionSuma extends Funcion {

    public FuncionSuma(String operador, int operandos) {
        super(operador, operandos);
    }

    public double calcular() {
        double resultado=0.0;

        for(INodo n : super.getDescendientes()){
            resultado += n.calcular();
        }

        return resultado;
    }
}
