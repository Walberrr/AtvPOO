// Interface EstrategiaDesconto
interface EstrategiaDesconto {
    double calcularDesconto(double preco);
}

// Implementação: Desconto para clientes fiéis
class DescontoFidelidade implements EstrategiaDesconto {
    @Override
    public double calcularDesconto(double preco) {
        return preco * 0.95; // 5% de desconto
    }
}

// Implementação: Desconto sazonal
class DescontoSazonal implements EstrategiaDesconto {
    @Override
    public double calcularDesconto(double preco) {
        return preco * 0.90; // 10% de desconto
    }
}

// Implementação: Desconto promocional fixo
class DescontoPromocional implements EstrategiaDesconto {
    @Override
    public double calcularDesconto(double preco) {
        return preco - 20.00; // Desconto fixo de R$20,00
    }
}

// Classe utilitária: Gestor de Descontos
class GestorDeDescontos {
    public static double aplicarDesconto(EstrategiaDesconto estrategia, double preco) {
        return estrategia.calcularDesconto(preco);
    }
}

// Classe Principal (Main)
public class Main {
    public static void main(String[] args) {
        double precoOriginal = 100.00;

        EstrategiaDesconto fidelidade = new DescontoFidelidade();
        EstrategiaDesconto sazonal = new DescontoSazonal();
        EstrategiaDesconto promocional = new DescontoPromocional();

        System.out.println("Preço original: R$" + precoOriginal);
        System.out.println("Com Desconto Fidelidade: R$" + GestorDeDescontos.aplicarDesconto(fidelidade, precoOriginal));
        System.out.println("Com Desconto Sazonal: R$" + GestorDeDescontos.aplicarDesconto(sazonal, precoOriginal));
        System.out.println("Com Desconto Promocional: R$" + GestorDeDescontos.aplicarDesconto(promocional, precoOriginal));
    }
}
