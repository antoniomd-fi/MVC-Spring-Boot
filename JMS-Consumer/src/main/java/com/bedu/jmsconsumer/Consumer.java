package com.bedu.jmsconsumer;

import com.bedu.jmsconsumer.model.Persona;
import com.bedu.jmsconsumer.service.ConsumerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class Consumer {
 @Autowired
 ConsumerService consumerService;
    @RabbitListener (queues = {"${proyecto2.queue}"})
    public void consume (List<Persona> listaPersonas){
        log.info("Mensaje Recibido...");
        consumerService.saveRecivedList(listaPersonas);
    }
}
