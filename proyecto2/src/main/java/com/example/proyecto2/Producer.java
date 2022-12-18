package com.example.proyecto2;

import com.example.proyecto2.entity.Persona;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class Producer {

    @Value("${proyecto2.exchange}")
    private String TOPIC_EXCHANGE_NAME;

    @Value("${proyecto2.routing}")
    private String ROUTING_KEY;

    private RabbitTemplate template;

    @Autowired
    public Producer(RabbitTemplate template) {
        this.template = template;
    }

    public void produce(List<Persona> personaList){
        log.info("Enviando Mensaje...");
        template.convertAndSend(TOPIC_EXCHANGE_NAME, ROUTING_KEY, personaList);
    }
}
