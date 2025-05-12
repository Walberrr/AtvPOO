// Classe abstrata Ingrediente
abstract class Ingrediente {
    protected String nome;
    protected double quantidade;

    public Ingrediente(String nome, double quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public abstract String informar();
}

// Subclasse Proteína
class Proteina extends Ingrediente {
    public Proteina(String nome, double quantidade) {
        super(nome, quantidade);
    }

    @Override
    public String informar() {
        return nome + ": " + quantidade + "g de proteína.";
    }
}

// Subclasse Carboidrato
class Carboidrato extends Ingrediente {
    public Carboidrato(String nome, double quantidade) {
        super(nome, quantidade);
    }

    @Override
    public String informar() {
        return nome + ": " + quantidade + "g de carboidratos.";
    }
}

// Subclasse Tempero
class Tempero extends Ingrediente {
    public Tempero(String nome) {
        super(nome, 0);
    }

    @Override
    public String informar() {
        return nome + ": tempero utilizado na receita.";
    }
}

// Classe Prato
import java.util.ArrayList;
import java.util.List;

class Prato {
    private String nome;
    private List<Ingrediente> ingredientes;

    public Prato(String nome) {
        this.nome = nome;
        this.ingredientes = new ArrayList<>();
    }

    public void adicionarIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    public String listarIngredientes() {
        StringBuilder lista = new StringBuilder("Ingredientes do prato " + nome + ":\n");
        for (Ingrediente ingrediente : ingredientes) {
            lista.append("- ").append(ingrediente.informar()).append("\n");
        }
        return lista.toString();
    }
}

// Classe Principal para testes
public class Main {
    public static void main(String[] args) {
        Prato prato = new Prato("Frango ao Curry");
        prato.adicionarIngrediente(new Proteina("Frango", 150));
        prato.adicionarIngrediente(new Carboidrato("Arroz", 200));
        prato.adicionarIngrediente(new Tempero("Curry"));

        System.out.println(prato.listarIngredientes());
    }
}
