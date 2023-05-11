package com.bootcamp.api.service;

import com.bootcamp.api.domain.Bootcamp;
import com.bootcamp.api.domain.Dev;
import com.bootcamp.api.dto.DevDTO;
import com.bootcamp.api.repositories.BootcampRepository;
import com.bootcamp.api.repositories.DevRepository;
import com.bootcamp.api.service.exceptions.DataIntegrityException;
import com.bootcamp.api.service.exceptions.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class DevService {

    @Autowired
    private DevRepository repo;

    @Autowired
    private BootcampRepository bootcampRepository;

    public Dev find(Integer id) {
        Optional<Dev> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Dev.class.getName()));
    }

    @Transactional
    public Dev insert(Dev obj) {
        obj.setId(null);
        obj = repo.save(obj);
        bootcampRepository.saveAll(obj.getBootcampInscritos());
        return obj;
    }

    public Dev update(Dev obj) {
        Dev newObj = find(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
        }
    }

    public List<Dev> findAll() {
        return repo.findAll();
    }

    public Page<Dev> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Dev fromDTO(DevDTO objDto) {
        return new Dev(objDto.getId(), objDto.getNome(), objDto.getBootcampInscritos());
    }
}
