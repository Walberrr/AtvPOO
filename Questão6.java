// Classe abstrata MetodoPagamento
abstract class MetodoPagamento {
    protected double taxa;

    public MetodoPagamento(double taxa) {
        this.taxa = taxa;
    }

    public double calcularTaxa(double valor) {
        return valor * taxa;
    }

    public abstract boolean processarPagamento(double valor);
}

// Subclasse CartaoCredito
class CartaoCredito extends MetodoPagamento {
    public CartaoCredito(double taxa) {
        super(taxa);
    }

    @Override
    public boolean processarPagamento(double valor) {
        if (taxa < 0.02) {
            System.out.println("Pagamento de R$" + valor + " realizado via Cartão de Crédito.");
            return true;
        } else {
            System.out.println("Falha no pagamento: Taxa do cartão maior que 0.02.");
            return false;
        }
    }
}

// Subclasse Pix
class Pix extends MetodoPagamento {
    public Pix() {
        super(0.0); // Sem taxa
    }

    @Override
    public boolean processarPagamento(double valor) {
        System.out.println("Pagamento instantâneo de R$" + valor + " via Pix realizado.");
        return true;
    }
}

// Subclasse Boleto
class Boleto extends MetodoPagamento {
    public Boleto() {
        super(0.05); // Taxa fixa de 5%
    }

    @Override
    public boolean processarPagamento(double valor) {
        double valorFinal = valor + calcularTaxa(valor);
        System.out.println("Pagamento via Boleto realizado: Total com taxa: R$" + valorFinal);
        return true;
    }
}

// Classe SistemaPagamento
class SistemaPagamento {
    public static boolean efetuarPagamento(MetodoPagamento metodo, double valor) {
        System.out.println("Taxa aplicada: " + metodo.calcularTaxa(valor));
        return metodo.processarPagamento(valor);
    }
}

// Classe Principal (Main) para testes
public class Main {
    public static void main(String[] args) {
        MetodoPagamento cartao = new CartaoCredito(0.015);
        MetodoPagamento pix = new Pix();
        MetodoPagamento boleto = new Boleto();

        System.out.println("Realizando pagamentos:");
        SistemaPagamento.efetuarPagamento(cartao, 100);
        SistemaPagamento.efetuarPagamento(pix, 200);
        SistemaPagamento.efetuarPagamento(boleto, 300);
    }
}
