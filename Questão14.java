// Interface ExportadorRelatorio
interface ExportadorRelatorio {
    String exportar(String titulo, String conteudo);
}

// Implementação: ExportadorPDF
class ExportadorPDF implements ExportadorRelatorio {
    @Override
    public String exportar(String titulo, String conteudo) {
        return "Relatório '" + titulo + "' exportado como PDF:\n" + conteudo;
    }
}

// Implementação: ExportadorCSV
class ExportadorCSV implements ExportadorRelatorio {
    @Override
    public String exportar(String titulo, String conteudo) {
        return "Relatório '" + titulo + "' exportado como CSV:\nTitulo,Conteudo\n" + titulo + "," + conteudo;
    }
}

// Implementação: ExportadorXML
class ExportadorXML implements ExportadorRelatorio {
    @Override
    public String exportar(String titulo, String conteudo) {
        return "<relatorio>\n  <titulo>" + titulo + "</titulo>\n  <conteudo>" + conteudo + "</conteudo>\n</relatorio>";
    }
}

// Classe utilitária SistemaRelatorios
class SistemaRelatorios {
    public static String exportarRelatorio(ExportadorRelatorio exportador, String titulo, String conteudo) {
        return exportador.exportar(titulo, conteudo);
    }
}

// Classe Principal para testes
public class Main {
    public static void main(String[] args) {
        ExportadorRelatorio pdf = new ExportadorPDF();
        ExportadorRelatorio csv = new ExportadorCSV();
        ExportadorRelatorio xml = new ExportadorXML();

        System.out.println(SistemaRelatorios.exportarRelatorio(pdf, "Vendas 2025", "Relatório de vendas do trimestre."));
        System.out.println(SistemaRelatorios.exportarRelatorio(csv, "Vendas 2025", "Relatório de vendas do trimestre."));
        System.out.println(SistemaRelatorios.exportarRelatorio(xml, "Vendas 2025", "Relatório de vendas do trimestre."));
    }
}
