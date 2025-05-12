// Interface para definir animais que fazem som
interface FazSom {
    void som();
}

// Classe abstrata Animal
abstract class Animal implements FazSom {
    private String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    // Método abstrato que será sobrescrito
    public abstract void som();
}

// Subclasse Cachorro
class Cachorro extends Animal {
    public Cachorro(String nome) {
        super(nome);
    }

    @Override
    public void som() {
        System.out.println(getNome() + " faz: Au Au!");
    }
}

// Subclasse Gato
class Gato extends Animal {
    public Gato(String nome) {
        super(nome);
    }

    @Override
    public void som() {
        System.out.println(getNome() + " faz: Miau!");
    }
}

// Classe Zoologico
class Zoologico {
    private Animal[] animais;

    public Zoologico() {
        this.animais = new Animal[]{new Cachorro("Rex"), new Gato("Mimi")};
    }

    public void emitirSons() {
        for (Animal animal : animais) {
            try {
                animal.som();
            } catch (Exception e) {
                System.out.println("Erro ao emitir som: " + e.getMessage());
            }
        }
    }
}

// Classe Principal (Main)
public class Main {
    public static void main(String[] args) {
        Zoologico zoologico = new Zoologico();
        zoologico.emitirSons();
    }
}
