package br.com.ganog.sqswithjmsspring.portas;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SQSJMSConsumidor {

    private final SQSJMSProdutor sqsjmsProdutor;

    @JmsListener(destination = "teste-envio", concurrency = "3-10")
    public void consumirMensagem(String mensagem) {
        System.out.println("Mensagem recebida: " + mensagem);

        sqsjmsProdutor.enviarMensagem(mensagem);
    }
}
