package p4.src;

public class FuncionResta extends Funcion {

    public FuncionResta(String operador, int operandos) {
        super(operador, operandos);
    }

    public double calcular() {
        double resultado = 0.0;

        for(int i=0; i<super.getDescendientes().size(); i++){
            if(i==0){
                resultado = super.getDescendientes().get(0).calcular();
            } else {
                resultado -= super.getDescendientes().get(i).calcular();
            }
        }

        return resultado;
    }
}
