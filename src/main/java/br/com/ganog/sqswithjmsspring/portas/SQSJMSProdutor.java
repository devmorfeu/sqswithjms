package br.com.ganog.sqswithjmsspring.portas;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SQSJMSProdutor {

    private final JmsTemplate jmsTemplate;

    public void enviarMensagem(String mensagem) {

        jmsTemplate.convertAndSend("teste-envio", mensagem);

        System.out.println("Mensagem enviada: " + mensagem);
    }
}
