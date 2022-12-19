package com.bedu.jmsconsumer.service;

import com.bedu.jmsconsumer.model.Persona;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class ConsumerService {
    @Getter public List<Persona> personaList;
    public void saveRecivedList(List<Persona> personaList){
        this.personaList = personaList;
    }
}
