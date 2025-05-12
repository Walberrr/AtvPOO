// Classe base Funcionário
abstract class Funcionario {
    private String nome;
    protected double salarioBase;

    public Funcionario(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public String getNome() {
        return nome;
    }

    public abstract double calcularSalario();

    public void exibirInformacoes() {
        System.out.println("Funcionário: " + nome + " - Salário: " + calcularSalario());
    }
}

// Subclasse Gerente
class Gerente extends Funcionario {
    private double bonus;

    public Gerente(String nome, double salarioBase, double bonus) {
        super(nome, salarioBase);
        this.bonus = bonus;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + bonus;
    }
}

// Subclasse Desenvolvedor
class Desenvolvedor extends Funcionario {
    private double fatorProdutividade;

    public Desenvolvedor(String nome, double salarioBase, double fatorProdutividade) {
        super(nome, salarioBase);
        this.fatorProdutividade = fatorProdutividade;
    }

    @Override
    public double calcularSalario() {
        return salarioBase * fatorProdutividade;
    }
}

// Subclasse Estagiário
class Estagiario extends Funcionario {
    public Estagiario(String nome, double salarioBase) {
        super(nome, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return salarioBase;
    }
}

// Classe Empresa
import java.util.ArrayList;
import java.util.List;

class Empresa {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void calcularFolhaDePagamento() {
        double total = 0;
        System.out.println("Folha de Pagamento:");
        for (Funcionario funcionario : funcionarios) {
            funcionario.exibirInformacoes();
            total += funcionario.calcularSalario();
        }
        System.out.println("Total da Folha: " + total);
    }
}

// Classe Principal para teste
public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        empresa.adicionarFuncionario(new Gerente("Alice", 5000, 2000));
        empresa.adicionarFuncionario(new Desenvolvedor("Carlos", 4000, 1.2));
        empresa.adicionarFuncionario(new Estagiario("Bruno", 1500));

        empresa.calcularFolhaDePagamento();
    }
}
