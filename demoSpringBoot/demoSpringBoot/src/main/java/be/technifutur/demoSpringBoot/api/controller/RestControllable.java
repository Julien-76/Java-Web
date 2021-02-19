package be.technifutur.demoSpringBoot.api.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RestControllable<ENTITY, DTO, ID> {

    ResponseEntity<List<DTO>> getAll();

    ResponseEntity<DTO> geetOne(ID id);

    ResponseEntity<Boolean> insert(ENTITY entity);
    ResponseEntity<Boolean> update(ENTITY entity, ID id);

    ResponseEntity<Boolean> delete (ID id);
}
