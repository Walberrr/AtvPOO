// Interface EnvioMensagem
interface EnvioMensagem {
    boolean enviar(String mensagem);
    String obterStatus();
}

// Implementação para envio por E-mail
class EnvioEmail implements EnvioMensagem {
    private String status;

    @Override
    public boolean enviar(String mensagem) {
        System.out.println("Enviando e-mail: " + mensagem);
        status = "E-mail enviado com sucesso!";
        return true;
    }

    @Override
    public String obterStatus() {
        return status;
    }
}

// Implementação para envio de SMS
class EnvioSMS implements EnvioMensagem {
    private String status;

    @Override
    public boolean enviar(String mensagem) {
        System.out.println("Enviando SMS: " + mensagem);
        status = "SMS enviado!";
        return true;
    }

    @Override
    public String obterStatus() {
        return status;
    }
}

// Implementação para envio via WhatsApp
class EnvioWhatsApp implements EnvioMensagem {
    private String status;

    @Override
    public boolean enviar(String mensagem) {
        System.out.println("Enviando mensagem via WhatsApp: " + mensagem);
        status = "WhatsApp enviado!";
        return true;
    }

    @Override
    public String obterStatus() {
        return status;
    }
}

// Classe utilitária GestorMensagens
class GestorMensagens {
    public static void enviarMensagem(EnvioMensagem envio, String mensagem) {
        if (envio.enviar(mensagem)) {
            System.out.println("Status: " + envio.obterStatus());
        } else {
            System.out.println("Erro no envio da mensagem.");
        }
    }
}

// Classe principal para testes
public class Main {
    public static void main(String[] args) {
        EnvioMensagem email = new EnvioEmail();
        EnvioMensagem sms = new EnvioSMS();
        EnvioMensagem whatsapp = new EnvioWhatsApp();

        GestorMensagens.enviarMensagem(email, "Olá! Como vai?");
        GestorMensagens.enviarMensagem(sms, "Promoção especial para você!");
        GestorMensagens.enviarMensagem(whatsapp, "Encontro marcado para amanhã.");
    }
}
