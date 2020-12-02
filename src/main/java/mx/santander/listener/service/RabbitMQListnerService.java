package mx.santander.listener.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.santander.listener.model.TycsServiceMessage;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RabbitMQListnerService implements MessageListener {

    private final ITycsServiceMessageService iTycsServiceMessageService;

    public void onMessage(Message message) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            TycsServiceMessage tycsServiceMessage = objectMapper.readValue(new String(message.getBody()), TycsServiceMessage.class);
            log.info("Data in Queue: {}", tycsServiceMessage.toString());

            iTycsServiceMessageService.saveTycsServiceMessage(tycsServiceMessage);
            log.info("Data in DataBase: {}", iTycsServiceMessageService.findTycsByBuc(tycsServiceMessage.getBuc()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

}