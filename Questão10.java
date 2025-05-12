// Classe abstrata MembroEquipe
abstract class MembroEquipe {
    protected String nome;
    protected String projeto;

    public MembroEquipe(String nome, String projeto) {
        this.nome = nome;
        this.projeto = projeto;
    }

    public abstract String trabalhar();

    public void exibirInformacoes() {
        System.out.println(nome + " trabalha no projeto '" + projeto + "'.");
    }
}

// Subclasse Desenvolvedor
class Desenvolvedor extends MembroEquipe {
    public Desenvolvedor(String nome, String projeto) {
        super(nome, projeto);
    }

    @Override
    public String trabalhar() {
        return "Escrevendo código para o projeto '" + projeto + "'.";
    }
}

// Subclasse Designer
class Designer extends MembroEquipe {
    public Designer(String nome, String projeto) {
        super(nome, projeto);
    }

    @Override
    public String trabalhar() {
        return "Criando designs para o projeto '" + projeto + "'.";
    }
}

// Subclasse GerenteDeProjetos
class GerenteDeProjetos extends MembroEquipe {
    public GerenteDeProjetos(String nome, String projeto) {
        super(nome, projeto);
    }

    @Override
    public String trabalhar() {
        return "Coordenando o progresso do projeto '" + projeto + "'.";
    }
}

// Classe GestorProjeto
import java.util.ArrayList;
import java.util.List;

class GestorProjeto {
    private List<MembroEquipe> equipe = new ArrayList<>();

    public void adicionarMembro(MembroEquipe membro) {
        equipe.add(membro);
        System.out.println(membro.nome + " foi adicionado ao projeto '" + membro.projeto + "'.");
    }

    public void exibirTarefa(MembroEquipe membro) {
        System.out.println(membro.trabalhar());
    }

    public List<MembroEquipe> listarEquipePorProjeto(String projeto) {
        List<MembroEquipe> membrosProjeto = new ArrayList<>();
        for (MembroEquipe membro : equipe) {
            if (membro.projeto.equals(projeto)) {
                membrosProjeto.add(membro);
            }
        }
        return membrosProjeto;
    }
}

// Classe Principal para testes
public class Main {
    public static void main(String[] args) {
        GestorProjeto gestor = new GestorProjeto();
        
        MembroEquipe dev = new Desenvolvedor("Alice", "App Mobile");
        MembroEquipe designer = new Designer("Carlos", "App Mobile");
        MembroEquipe gerente = new GerenteDeProjetos("Bruno", "Sistema ERP");

        gestor.adicionarMembro(dev);
        gestor.adicionarMembro(designer);
        gestor.adicionarMembro(gerente);

        System.out.println("\nTarefas dos membros:");
        gestor.exibirTarefa(dev);
        gestor.exibirTarefa(designer);
        gestor.exibirTarefa(gerente);

        System.out.println("\nMembros do projeto 'App Mobile':");
        for (MembroEquipe membro : gestor.listarEquipePorProjeto("App Mobile")) {
            membro.exibirInformacoes();
        }
    }
}
