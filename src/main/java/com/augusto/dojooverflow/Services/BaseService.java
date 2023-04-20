package com.augusto.dojooverflow.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.augusto.dojooverflow.Repositories.BaseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public abstract class BaseService<T> {
    
    private final BaseRepository <T> baseRepository;

    // Listar Objeto
    public List<T> list() {
        return baseRepository.findAll();
    }

    // Buscar por id
    public T findById(Long id) {
        Optional<T> optional = baseRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    // Guardar Objeto
    public T save(T object) {
        return baseRepository.save(object);
    }

}
