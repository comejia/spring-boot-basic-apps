package com.spring.jpa.repositories;

import com.spring.jpa.dto.PersonDto;
import com.spring.jpa.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByLanguage(String language);

    @Query("select p from Person p where p.language = :language")
    List<Person> buscarByLanguage(String language);

    List<Person> findByNameAndLastname(String name, String lastname);

    @Query("select p.name from Person p")
    List<String> obtenerPersonaName();

    @Query("select p from Person p where p.name like :name%")
    Optional<Person> findOneByLikeName(String name);

    Optional<Person> findByNameContaining(String name);

    @Query("select new com.spring.jpa.dto.PersonDto(p.name, p.lastname) from Person p")
    List<PersonDto> findAllPersonDto();

    List<Person> findByIdBetweenOrderByLanguageDesc(Long id1, Long id2);
}
