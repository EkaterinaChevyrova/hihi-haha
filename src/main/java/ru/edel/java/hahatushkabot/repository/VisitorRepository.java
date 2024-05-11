package ru.edel.java.hahatushkabot.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.edel.java.hahatushkabot.model.Visitor;

import java.util.List;

@Repository
public interface VisitorRepository extends PagingAndSortingRepository<Visitor, Long> {

    void save(Visitor visitor);

    List<Visitor> findAll();
}
