// Classe abstrata Tarefa
abstract class Tarefa {
    protected String descricao;

    public Tarefa(String descricao) {
        this.descricao = descricao;
    }

    public abstract String realizarTarefa();
}

// Subclasse Desenvolvimento
class Desenvolvimento extends Tarefa {
    public Desenvolvimento(String descricao) {
        super(descricao);
    }

    @Override
    public String realizarTarefa() {
        return "Desenvolvendo código: " + descricao;
    }
}

// Subclasse Design
class Design extends Tarefa {
    public Design(String descricao) {
        super(descricao);
    }

    @Override
    public String realizarTarefa() {
        return "Criando design: " + descricao;
    }
}

// Subclasse Teste
class Teste extends Tarefa {
    public Teste(String descricao) {
        super(descricao);
    }

    @Override
    public String realizarTarefa() {
        return "Realizando testes: " + descricao;
    }
}

// Interface Papel
interface Papel {
    String executarPapel();
}

// Implementações de Papel
class Desenvolvedor implements Papel {
    @Override
    public String executarPapel() {
        return "Atuando como desenvolvedor.";
    }
}

class Designer implements Papel {
    @Override
    public String executarPapel() {
        return "Atuando como designer.";
    }
}

class Testador implements Papel {
    @Override
    public String executarPapel() {
        return "Atuando como testador.";
    }
}

// Classe MembroEquipe
import java.util.ArrayList;
import java.util.List;

class MembroEquipe {
    private String nome;
    private Papel papel;
    private List<Tarefa> tarefas;

    public MembroEquipe(String nome, Papel papel) {
        this.nome = nome;
        this.papel = papel;
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public String listarTarefas() {
        StringBuilder lista = new StringBuilder(nome + " - " + papel.executarPapel() + "\nTarefas:\n");
        for (Tarefa tarefa : tarefas) {
            lista.append("- ").append(tarefa.realizarTarefa()).append("\n");
        }
        return lista.toString();
    }
}

// Classe Principal para Testes
public class Main {
    public static void main(String[] args) {
        MembroEquipe alice = new MembroEquipe("Alice", new Desenvolvedor());
        MembroEquipe bruno = new MembroEquipe("Bruno", new Designer());
        MembroEquipe carlos = new MembroEquipe("Carlos", new Testador());

        alice.adicionarTarefa(new Desenvolvimento("Implementação de API"));
        bruno.adicionarTarefa(new Design("Criação de interface gráfica"));
        carlos.adicionarTarefa(new Teste("Testes funcionais"));

        System.out.println(alice.listarTarefas());
        System.out.println(bruno.listarTarefas());
        System.out.println(carlos.listarTarefas());
    }
}
