// Classe abstrata MaterialBiblioteca
abstract class MaterialBiblioteca {
    protected String titulo;
    protected int prazoDevolucao;

    public MaterialBiblioteca(String titulo, int prazoDevolucao) {
        this.titulo = titulo;
        this.prazoDevolucao = prazoDevolucao;
    }

    public abstract double calcularMulta(int diasAtraso);

    public void exibirInformacoes() {
        System.out.println("Material: " + titulo + " | Prazo de Devolução: " + prazoDevolucao + " dias");
    }
}

// Subclasse Livro
class Livro extends MaterialBiblioteca {
    public Livro(String titulo, int prazoDevolucao) {
        super(titulo, prazoDevolucao);
    }

    @Override
    public double calcularMulta(int diasAtraso) {
        return diasAtraso * 1.0;
    }
}

// Subclasse Revista
class Revista extends MaterialBiblioteca {
    public Revista(String titulo, int prazoDevolucao) {
        super(titulo, prazoDevolucao);
    }

    @Override
    public double calcularMulta(int diasAtraso) {
        return diasAtraso * 2.0;
    }
}

// Subclasse DVD
class DVD extends MaterialBiblioteca {
    public DVD(String titulo, int prazoDevolucao) {
        super(titulo, prazoDevolucao);
    }

    @Override
    public double calcularMulta(int diasAtraso) {
        return diasAtraso * 5.0;
    }
}

// Classe SistemaBiblioteca
class SistemaBiblioteca {
    public static void registrarEmprestimo(MaterialBiblioteca material) {
        material.exibirInformacoes();
    }

    public static double calcularMulta(MaterialBiblioteca material, int diasAtraso) {
        return material.calcularMulta(diasAtraso);
    }
}

// Classe Principal para testes
public class Main {
    public static void main(String[] args) {
        MaterialBiblioteca livro = new Livro("Dom Quixote", 14);
        MaterialBiblioteca revista = new Revista("National Geographic", 7);
        MaterialBiblioteca dvd = new DVD("Filme Inception", 3);

        SistemaBiblioteca.registrarEmprestimo(livro);
        SistemaBiblioteca.registrarEmprestimo(revista);
        SistemaBiblioteca.registrarEmprestimo(dvd);

        System.out.println("Multa Livro (5 dias atraso): R$" + SistemaBiblioteca.calcularMulta(livro, 5));
        System.out.println("Multa Revista (3 dias atraso): R$" + SistemaBiblioteca.calcularMulta(revista, 3));
        System.out.println("Multa DVD (2 dias atraso): R$" + SistemaBiblioteca.calcularMulta(dvd, 2));
    }
}
