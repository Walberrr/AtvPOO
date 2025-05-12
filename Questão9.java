// Classe abstrata Imagem
abstract class Imagem {
    protected int largura;
    protected int altura;

    public Imagem(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public int calcularTamanho() {
        return largura * altura;
    }

    public abstract String processar();
}

// Subclasse ImagemColorida
class ImagemColorida extends Imagem {
    public ImagemColorida(int largura, int altura) {
        super(largura, altura);
    }

    @Override
    public String processar() {
        return "Aplicando filtro de saturação à imagem colorida.";
    }
}

// Subclasse ImagemPretoBranco
class ImagemPretoBranco extends Imagem {
    public ImagemPretoBranco(int largura, int altura) {
        super(largura, altura);
    }

    @Override
    public String processar() {
        return "Convertendo imagem para preto e branco.";
    }
}

// Subclasse ImagemTransparente
class ImagemTransparente extends Imagem {
    public ImagemTransparente(int largura, int altura) {
        super(largura, altura);
    }

    @Override
    public String processar() {
        return "Aplicando máscara de transparência.";
    }
}

// Classe utilitária EditorImagem
class EditorImagem {
    public static void exibirInformacoes(Imagem imagem) {
        System.out.println("Imagem com dimensões: " + imagem.largura + "x" + imagem.altura);
        System.out.println("Tamanho total (pixels): " + imagem.calcularTamanho());
        System.out.println("Processamento: " + imagem.processar());
    }

    public static Imagem ajustarImagem(Imagem imagem, int novaLargura, int novaAltura) {
        if (imagem instanceof ImagemColorida) {
            return new ImagemColorida(novaLargura, novaAltura);
        } else if (imagem instanceof ImagemPretoBranco) {
            return new ImagemPretoBranco(novaLargura, novaAltura);
        } else {
            return new ImagemTransparente(novaLargura, novaAltura);
        }
    }
}

// Classe Principal para testes
public class Main {
    public static void main(String[] args) {
        Imagem img1 = new ImagemColorida(1920, 1080);
        Imagem img2 = new ImagemPretoBranco(800, 600);
        Imagem img3 = new ImagemTransparente(1024, 768);

        System.out.println("=== Informações das imagens ===");
        EditorImagem.exibirInformacoes(img1);
        EditorImagem.exibirInformacoes(img2);
        EditorImagem.exibirInformacoes(img3);

        System.out.println("\n=== Ajustando imagem ===");
        Imagem novaImagem = EditorImagem.ajustarImagem(img1, 1280, 720);
        EditorImagem.exibirInformacoes(novaImagem);
    }
}
