// Classe base Conta
abstract class Conta {
    private String titular;
    protected double saldo;

    public Conta(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado para " + titular);
    }

    public abstract boolean sacar(double valor);

    public void exibirInformacoes() {
        System.out.println("Titular: " + titular + " | Saldo: R$" + saldo);
    }
}

// Subclasse ContaCorrente
class ContaCorrente extends Conta {
    private static final double TAXA_SAQUE = 5.00;

    public ContaCorrente(String titular, double saldoInicial) {
        super(titular, saldoInicial);
    }

    @Override
    public boolean sacar(double valor) {
        double valorFinal = valor + TAXA_SAQUE;
        if (valorFinal <= saldo) {
            saldo -= valorFinal;
            System.out.println("Saque de R$" + valor + " realizado com taxa de R$" + TAXA_SAQUE);
            return true;
        } else {
            System.out.println("Saldo insuficiente para saque em Conta Corrente.");
            return false;
        }
    }
}

// Subclasse ContaPoupanca
class ContaPoupanca extends Conta {
    private static final double TAXA_RENDIMENTO = 0.02;

    public ContaPoupanca(String titular, double saldoInicial) {
        super(titular, saldoInicial);
    }

    public void adicionarRendimento() {
        saldo += saldo * TAXA_RENDIMENTO;
        System.out.println("Rendimento aplicado! Novo saldo de " + getTitular() + ": R$" + saldo);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado da Conta Poupança.");
            return true;
        } else {
            System.out.println("Saldo insuficiente na Conta Poupança.");
            return false;
        }
    }
}

// Subclasse ContaSalario
class ContaSalario extends Conta {
    private int saquesRestantes = 3;

    public ContaSalario(String titular, double saldoInicial) {
        super(titular, saldoInicial);
    }

    @Override
    public boolean sacar(double valor) {
        if (saquesRestantes > 0 && valor <= saldo) {
            saldo -= valor;
            saquesRestantes--;
            System.out.println("Saque de R$" + valor + " realizado na Conta Salário. Saques restantes: " + saquesRestantes);
            return true;
        } else {
            System.out.println("Limite de saques atingido ou saldo insuficiente.");
            return false;
        }
    }
}

// Classe Banco
import java.util.ArrayList;
import java.util.List;

class Banco {
    private List<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void gerarRelatorio() {
        System.out.println("\n=== Relatório de Contas ===");
        for (Conta conta : contas) {
            conta.exibirInformacoes();
        }
    }
}

// Classe Principal para Testes
public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        ContaCorrente cc = new ContaCorrente("Alice", 1000);
        ContaPoupanca cp = new ContaPoupanca("Bruno", 2000);
        ContaSalario cs = new ContaSalario("Carla", 1500);

        banco.adicionarConta(cc);
        banco.adicionarConta(cp);
        banco.adicionarConta(cs);

        cc.sacar(200);
        cp.adicionarRendimento();
        cs.sacar(500);
        cs.sacar(500);
        cs.sacar(500);
        cs.sacar(500); // Esse saque não será permitido

        banco.gerarRelatorio();
    }
}
