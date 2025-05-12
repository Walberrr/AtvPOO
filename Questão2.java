// Classe base Veiculo
abstract class Veiculo {
    private String marca;
    private String modelo;
    private int ano;

    public Veiculo(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public void informacoes() {
        System.out.println("Marca: " + marca + ", Modelo: " + modelo + ", Ano: " + ano);
    }
}

// Subclasse Carro
class Carro extends Veiculo {
    private int numeroDePortas;

    public Carro(String marca, String modelo, int ano, int numeroDePortas) {
        super(marca, modelo, ano);
        this.numeroDePortas = numeroDePortas;
    }

    @Override
    public void informacoes() {
        super.informacoes();
        System.out.println("Número de Portas: " + numeroDePortas);
    }
}

// Subclasse Motocicleta
class Motocicleta extends Veiculo {
    private String tipoDeGuidao;

    public Motocicleta(String marca, String modelo, int ano, String tipoDeGuidao) {
        super(marca, modelo, ano);
        this.tipoDeGuidao = tipoDeGuidao;
    }

    @Override
    public void informacoes() {
        super.informacoes();
        System.out.println("Tipo de Guidão: " + tipoDeGuidao);
    }
}

// Classe principal para testes
public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro("Toyota", "Corolla", 2022, 4);
        Motocicleta moto = new Motocicleta("Honda", "CB 500", 2023, "Esportivo");

        System.out.println("Informações do Carro:");
        carro.informacoes();

        System.out.println("\nInformações da Motocicleta:");
        moto.informacoes();
    }
}
