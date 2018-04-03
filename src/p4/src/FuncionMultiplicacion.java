package p4.src;

public class FuncionMultiplicacion extends Funcion {

    public FuncionMultiplicacion(String operador, int operandos) {
        super(operador, operandos);
    }

    public double calcular() {
        double resultado=1.0;

        for(INodo n : super.getDescendientes()){
            resultado *= n.calcular();
        }

        return resultado;
    }
}
