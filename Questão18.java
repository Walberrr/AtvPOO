// Classe abstrata Produto
abstract class Produto {
    protected String nome;
    protected double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
    }

    public abstract double calcularDesconto();
}

// Subclasse Eletronico
class Eletronico extends Produto {
    public Eletronico(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double calcularDesconto() {
        return preco * 0.90; // 10% de desconto
    }
}

// Subclasse Alimento
class Alimento extends Produto {
    public Alimento(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double calcularDesconto() {
        return preco * 0.95; // 5% de desconto
    }
}

// Subclasse Vestuario
class Vestuario extends Produto {
    public Vestuario(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double calcularDesconto() {
        return preco * 0.85; // 15% de desconto
    }
}

// Interface Fornecimento
interface Fornecimento {
    boolean fornecerProduto(Produto produto);
}

// Classe Fornecedor
import java.util.ArrayList;
import java.util.List;

class Fornecedor implements Fornecimento {
    private String nome;
    private List<Produto> produtosFornecidos;

    public Fornecedor(String nome) {
        this.nome = nome;
        this.produtosFornecidos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtosFornecidos.add(produto);
    }

    @Override
    public boolean fornecerProduto(Produto produto) {
        produtosFornecidos.add(produto);
        System.out.println("Produto " + produto.nome + " fornecido por " + nome);
        return true;
    }

    public String listarProdutos() {
        StringBuilder lista = new StringBuilder("Produtos fornecidos por " + nome + ":\n");
        for (Produto produto : produtosFornecidos) {
            lista.append("- ").append(produto.nome).append("\n");
        }
        return lista.toString();
    }
}

// Classe Principal para Testes
public class Main {
    public static void main(String[] args) {
        Fornecedor fornecedor = new Fornecedor("Tech Supply");

        Produto laptop = new Eletronico("Laptop Dell", 5000);
        Produto arroz = new Alimento("Arroz Integral", 20);
        Produto camiseta = new Vestuario("Camiseta Esportiva", 80);

        fornecedor.fornecerProduto(laptop);
        fornecedor.fornecerProduto(arroz);
        fornecedor.fornecerProduto(camiseta);

        System.out.println(fornecedor.listarProdutos());
    }
}
