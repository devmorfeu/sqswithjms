package br.com.ganog.sqswithjmsspring.portas;

import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SQSJMSConsumidor {

    private final SQSJMSProdutor sqsjmsProdutor;

    @SqsListener(value = "teste", acknowledgementMode = "ON_SUCCESS")
    public void consumirMensagem(String mensagem) {
        System.out.println("Mensagem recebida: " + mensagem);

        sqsjmsProdutor.enviarMensagem(mensagem);
    }
}
