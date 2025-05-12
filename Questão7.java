// Classe abstrata Veiculo
abstract class Veiculo {
    protected int capacidade;
    protected double velocidadeMaxima;

    public Veiculo(int capacidade, double velocidadeMaxima) {
        this.capacidade = capacidade;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public double calcularTempo(double distancia) {
        return distancia / velocidadeMaxima;
    }

    public abstract String tipoDeCombustivel();
}

// Subclasse Carro
class Carro extends Veiculo {
    public Carro(int capacidade, double velocidadeMaxima) {
        super(capacidade, velocidadeMaxima);
    }

    @Override
    public String tipoDeCombustivel() {
        return "Gasolina";
    }
}

// Subclasse Aviao
class Aviao extends Veiculo {
    public Aviao(int capacidade, double velocidadeMaxima) {
        super(capacidade, velocidadeMaxima);
    }

    @Override
    public String tipoDeCombustivel() {
        return "Querosene de aviação";
    }
}

// Subclasse Navio
class Navio extends Veiculo {
    public Navio(int capacidade, double velocidadeMaxima) {
        super(capacidade, velocidadeMaxima);
    }

    @Override
    public String tipoDeCombustivel() {
        return "Diesel marítimo";
    }
}

// Classe GestorDeTransporte
class GestorDeTransporte {
    public static String calcularViagem(Veiculo veiculo, double distancia) {
        double tempo = veiculo.calcularTempo(distancia);
        return "Tempo estimado: " + tempo + " horas | Combustível: " + veiculo.tipoDeCombustivel();
    }
}

// Classe Principal para testes
public class Main {
    public static void main(String[] args) {
        Veiculo carro = new Carro(5, 100);
        Veiculo aviao = new Aviao(200, 800);
        Veiculo navio = new Navio(500, 50);

        System.out.println(GestorDeTransporte.calcularViagem(carro, 500));
        System.out.println(GestorDeTransporte.calcularViagem(aviao, 2000));
        System.out.println(GestorDeTransporte.calcularViagem(navio, 1000));
    }
}
