package be.technifutur.demoSpringBoot.model.services;

import java.util.*;

public interface Crudable<ENTITY, DTO, ID> {
    List<DTO> getAll();
    DTO getById(ID id);
    boolean insert(ENTITY entity);
    boolean update(ENTITY entity, ID id);
    boolean delete(ID id);
}