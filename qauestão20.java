// Classe abstrata Veiculo
abstract class Veiculo {
    protected String modelo;
    protected int capacidade;

    public Veiculo(String modelo, int capacidade) {
        this.modelo = modelo;
        this.capacidade = capacidade;
    }

    public abstract double calcularTempo(double distancia);
}

// Subclasse Onibus
class Onibus extends Veiculo {
    public Onibus(String modelo, int capacidade) {
        super(modelo, capacidade);
    }

    @Override
    public double calcularTempo(double distancia) {
        return distancia / 60; // Velocidade média de 60 km/h
    }
}

// Subclasse Carro
class Carro extends Veiculo {
    public Carro(String modelo, int capacidade) {
        super(modelo, capacidade);
    }

    @Override
    public double calcularTempo(double distancia) {
        return distancia / 100; // Velocidade média de 100 km/h
    }
}

// Subclasse Moto
class Moto extends Veiculo {
    public Moto(String modelo, int capacidade) {
        super(modelo, capacidade);
    }

    @Override
    public double calcularTempo(double distancia) {
        return distancia / 80; // Velocidade média de 80 km/h
    }
}

// Interface Reservavel
interface Reservavel {
    boolean reservar(String data, Rota rota);
}

// Classe Rota
import java.util.ArrayList;
import java.util.List;

class Rota {
    private String origem;
    private String destino;
    private List<Veiculo> veiculosDisponiveis;

    public Rota(String origem, String destino) {
        this.origem = origem;
        this.destino = destino;
        this.veiculosDisponiveis = new ArrayList<>();
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculosDisponiveis.add(veiculo);
    }

    public String listarVeiculos() {
        StringBuilder lista = new StringBuilder("Veículos disponíveis na rota de " + origem + " para " + destino + ":\n");
        for (Veiculo veiculo : veiculosDisponiveis) {
            lista.append("- ").append(veiculo.modelo).append(" (Capacidade: ").append(veiculo.capacidade).append(")\n");
        }
        return lista.toString();
    }
}

// Classe SistemaReserva
class SistemaReserva {
    public static boolean realizarReserva(Reservavel reservavel, String data, Rota rota) {
        return reservavel.reservar(data, rota);
    }
}

// Classe Principal para Testes
public class Main {
    public static void main(String[] args) {
        Rota rota = new Rota("São Paulo", "Rio de Janeiro");
        Veiculo onibus = new Onibus("Ônibus Executivo", 40);
        Veiculo carro = new Carro("Sedan", 5);
        Veiculo moto = new Moto("Moto Esportiva", 2);

        rota.adicionarVeiculo(onibus);
        rota.adicionarVeiculo(carro);
        rota.adicionarVeiculo(moto);

        System.out.println(rota.listarVeiculos());
    }
}
