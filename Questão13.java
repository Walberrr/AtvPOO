// Interface ProcessadorPagamento
interface ProcessadorPagamento {
    boolean autorizarPagamento(double valor);
    boolean processarPagamento(double valor);
}

// Implementação: ProcessadorCartao
class ProcessadorCartao implements ProcessadorPagamento {
    @Override
    public boolean autorizarPagamento(double valor) {
        System.out.println("Autorizando pagamento de R$" + valor + " via Cartão de Crédito...");
        return valor <= 5000; // Autoriza se o valor for menor que R$5000
    }

    @Override
    public boolean processarPagamento(double valor) {
        if (autorizarPagamento(valor)) {
            System.out.println("Pagamento via Cartão aprovado!");
            return true;
        }
        System.out.println("Pagamento via Cartão recusado.");
        return false;
    }
}

// Implementação: ProcessadorPix
class ProcessadorPix implements ProcessadorPagamento {
    @Override
    public boolean autorizarPagamento(double valor) {
        System.out.println("Autorizando pagamento de R$" + valor + " via Pix...");
        return true; // Pix sempre autoriza instantaneamente
    }

    @Override
    public boolean processarPagamento(double valor) {
        if (autorizarPagamento(valor)) {
            System.out.println("Pagamento via Pix realizado com sucesso!");
            return true;
        }
        System.out.println("Falha no pagamento via Pix.");
        return false;
    }
}

// Implementação: ProcessadorBoleto
class ProcessadorBoleto implements ProcessadorPagamento {
    @Override
    public boolean autorizarPagamento(double valor) {
        System.out.println("Gerando boleto no valor de R$" + valor + "...");
        return true; // Boleto sempre é gerado
    }

    @Override
    public boolean processarPagamento(double valor) {
        System.out.println("Pagamento via boleto leva alguns dias para ser confirmado...");
        return true;
    }
}

// Classe utilitária SistemaPagamento
class SistemaPagamento {
    public static boolean realizarPagamento(ProcessadorPagamento processador, double valor) {
        if (processador.autorizarPagamento(valor)) {
            return processador.processarPagamento(valor);
        }
        System.out.println("Autorização falhou.");
        return false;
    }
}

// Classe Principal para Testes
public class Main {
    public static void main(String[] args) {
        ProcessadorPagamento cartao = new ProcessadorCartao();
        ProcessadorPagamento pix = new ProcessadorPix();
        ProcessadorPagamento boleto = new ProcessadorBoleto();

        System.out.println("\nTestando Pagamentos:");
        SistemaPagamento.realizarPagamento(cartao, 4500);
        SistemaPagamento.realizarPagamento(pix, 1500);
        SistemaPagamento.realizarPagamento(boleto, 700);
    }
}
