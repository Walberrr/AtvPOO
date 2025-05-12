// Classe abstrata Material
abstract class Material {
    protected String titulo;

    public Material(String titulo) {
        this.titulo = titulo;
    }

    public abstract String informarMaterial();
}

// Subclasse Livro
class Livro extends Material {
    public Livro(String titulo) {
        super(titulo);
    }

    @Override
    public String informarMaterial() {
        return "Livro: " + titulo;
    }
}

// Subclasse Revista
class Revista extends Material {
    public Revista(String titulo) {
        super(titulo);
    }

    @Override
    public String informarMaterial() {
        return "Revista: " + titulo;
    }
}

// Subclasse DVD
class DVD extends Material {
    public DVD(String titulo) {
        super(titulo);
    }

    @Override
    public String informarMaterial() {
        return "DVD: " + titulo;
    }
}

// Interface Emprestavel
interface Emprestavel {
    boolean emprestar(Usuario usuario);
    boolean devolver(Usuario usuario);
}

// Classe Usuario
import java.util.ArrayList;
import java.util.List;

class Usuario {
    private String nome;
    private List<Material> materiaisEmprestados;

    public Usuario(String nome) {
        this.nome = nome;
        this.materiaisEmprestados = new ArrayList<>();
    }

    public void adicionarMaterial(Material material) {
        materiaisEmprestados.add(material);
    }

    public String listarMateriaisEmprestados() {
        StringBuilder lista = new StringBuilder("Materiais emprestados por " + nome + ":\n");
        for (Material material : materiaisEmprestados) {
            lista.append("- ").append(material.informarMaterial()).append("\n");
        }
        return lista.toString();
    }
}

// Classe Principal para testes
public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Milena");
        
        Material livro = new Livro("Dom Quixote");
        Material revista = new Revista("National Geographic");
        Material dvd = new DVD("Filme Interstellar");

        usuario.adicionarMaterial(livro);
        usuario.adicionarMaterial(revista);
        usuario.adicionarMaterial(dvd);

        System.out.println(usuario.listarMateriaisEmprestados());
    }
}
