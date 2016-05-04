package br.com.lojaadesivo.entidades.observe;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Aluísio
 */
public class NotificacaoPorEmail implements Observador<Object> {

    /**
     * Método busca dado atributo da classe a ser retornado
     *
     * @param destinatario
     * @param mensagem
     */
    public static void sendEmail(String destinatario, String mensagem) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("vendaadesivoifcz@gmail.com", "ifcz123654");
            }
        });
        session.setDebug(true);
        try {
            Message message = new MimeMessage(session);
            message.setContent(mensagem, "text/plain; charset=UTF-8");
            message.setFrom(new InternetAddress("vendaadesivoifcz@gmail.com"));
            Address[] toUser = InternetAddress
                    .parse(destinatario);
            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("(Venda Adesivos Ltda)");
            Transport.send(message);
            System.out.println("- Seu cadastro foi concluido!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Método busca dado atributo da classe a ser retornado
     *
     * @param object
     */
    @Override
    public void update(Object object) {

    }

}
