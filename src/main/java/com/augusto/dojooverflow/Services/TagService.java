package com.augusto.dojooverflow.Services;


import org.springframework.stereotype.Service;

import com.augusto.dojooverflow.Models.Tag;
import com.augusto.dojooverflow.Repositories.TagRepository;

@Service
public class TagService extends BaseService<Tag>{

    private final TagRepository tagRepository; 

    public TagService(TagRepository tagRepository) {
        super(tagRepository);
        this.tagRepository = tagRepository;
    }

    // Creando un modelo Tag a partir de un atributo subject
    public Tag setTagSubject(String subject) {
        Tag tag = new Tag();
        tag.setSubject(subject);
        return tag;
    }
    
    // Encontrando un modelo Tag a partir del atributo subject
    public Tag findTagBySubjet(String subject) {
        Tag optionalTag = tagRepository.findBySubject(subject);
        if(optionalTag != null) {
            return optionalTag;
        } else {
            return null;
        }
    }
    
    //Comprobando si un String esta totalmente en minusculas
    public boolean isLowerCase(String subject) {
        // Regresa el resultado de comparar la original con su versión minúscula
        return subject.equals(subject.toLowerCase());
    }
    
}
