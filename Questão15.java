// Interface ControleAutonomo
interface ControleAutonomo {
    String iniciarRota(String destino);
    String ajustarVelocidade(double velocidade);
}

// Implementação: ControleCarro
class ControleCarro implements ControleAutonomo {
    @Override
    public String iniciarRota(String destino) {
        return "Carro autônomo iniciando viagem para " + destino;
    }

    @Override
    public String ajustarVelocidade(double velocidade) {
        return "Velocidade do carro ajustada para " + velocidade + " km/h";
    }
}

// Implementação: ControleDrone
class ControleDrone implements ControleAutonomo {
    @Override
    public String iniciarRota(String destino) {
        return "Drone autônomo iniciando voo para " + destino;
    }

    @Override
    public String ajustarVelocidade(double velocidade) {
        return "Velocidade do drone ajustada para " + velocidade + " m/s";
    }
}

// Implementação: ControleNavio
class ControleNavio implements ControleAutonomo {
    @Override
    public String iniciarRota(String destino) {
        return "Navio autônomo navegando para " + destino;
    }

    @Override
    public String ajustarVelocidade(double velocidade) {
        return "Velocidade do navio ajustada para " + velocidade + " nós";
    }
}

// Classe SistemaAutonomo
class SistemaAutonomo {
    public static void navegar(ControleAutonomo controle, String destino, double velocidade) {
        System.out.println(controle.iniciarRota(destino));
        System.out.println(controle.ajustarVelocidade(velocidade));
    }
}

// Classe Principal para Testes
public class Main {
    public static void main(String[] args) {
        ControleAutonomo carro = new ControleCarro();
        ControleAutonomo drone = new ControleDrone();
        ControleAutonomo navio = new ControleNavio();

        SistemaAutonomo.navegar(carro, "São Paulo", 80);
        SistemaAutonomo.navegar(drone, "Zona de entrega A", 15);
        SistemaAutonomo.navegar(navio, "Porto de Santos", 25);
    }
}
