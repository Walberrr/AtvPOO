// Classe base Produto
abstract class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public abstract int calcularGarantia();

    public void exibirInformacoes() {
        System.out.println("Produto: " + nome + " - Preço: R$" + preco + " - Garantia: " + calcularGarantia() + " anos");
    }
}

// Subclasse Computador
class Computador extends Produto {
    public Computador(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public int calcularGarantia() {
        return 3;
    }
}

// Subclasse Smartphone
class Smartphone extends Produto {
    public Smartphone(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public int calcularGarantia() {
        return 2;
    }
}

// Subclasse Tablet
class Tablet extends Produto {
    public Tablet(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public int calcularGarantia() {
        return 1; // Garantia padrão
    }
}

// Classe Loja
import java.util.ArrayList;
import java.util.List;

class Loja {
    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void listarGarantias() {
        System.out.println("Lista de Garantias:");
        for (Produto produto : produtos) {
            produto.exibirInformacoes();
        }
    }
}

// Classe principal para testes
public class Main {
    public static void main(String[] args) {
        Loja loja = new Loja();
        loja.adicionarProduto(new Computador("Dell Inspiron", 3500.00));
        loja.adicionarProduto(new Smartphone("Samsung Galaxy S21", 2500.00));
        loja.adicionarProduto(new Tablet("iPad Air", 4000.00));

        loja.listarGarantias();
    }
}
