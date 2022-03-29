package com.cenfotec.lab5.lab5.service;

import com.cenfotec.lab5.lab5.domain.Persona;
import com.cenfotec.lab5.lab5.repository.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {
    @Autowired
    PersonalRepository personalRepository;
    public void savePersona(Persona persona){
        personalRepository.save(persona);
    }
    public List<Persona> getAll(){
        return personalRepository.findAll();
    }
    public void deletePersona(Persona persona) {personalRepository.delete(persona);}

}
