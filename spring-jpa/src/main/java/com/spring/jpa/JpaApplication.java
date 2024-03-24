package com.spring.jpa;

import com.spring.jpa.dto.PersonDto;
import com.spring.jpa.entities.Person;
import com.spring.jpa.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

    @Autowired
    private PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        System.out.println("PERSONS");
        List<Person> persons = (List<Person>) repository.findAll();
        persons.forEach(System.out::println);

        System.out.println("PERSONS BY LANGUAGE");
        List<Person> personsByLanguage = (List<Person>) repository.findByLanguage("Python");
        List<Person> personsByLanguage2 = (List<Person>) repository.buscarByLanguage("Java");
        personsByLanguage.forEach(System.out::println);
        personsByLanguage2.forEach(System.out::println);

        System.out.println("PERSONS BY NAME AND LASTNAME");
        List<Person> personsByNameAndLastname = (List<Person>) repository.findByNameAndLastname("Maria", "Roe");
        personsByNameAndLastname.forEach(System.out::println);

        System.out.println("PERSONS NAMES");
        List<String> personNames = (List<String>) repository.obtenerPersonaName();
        personNames.forEach(System.out::println);

        System.out.println("PERSON");
        Optional<Person> person = repository.findById(3L);
        person.ifPresent(System.out::println);

        System.out.println("PERSON BY LIKE");
        Optional<Person> personLike = repository.findOneByLikeName("Ma");
        personLike.ifPresent(System.out::println);

        Optional<Person> personContains = repository.findByNameContaining("se");
        personContains.ifPresent(System.out::println);

        create();
        update();
//        delete();
//
//        dto();
//
//        order();
    }

    @Transactional
    public void create() {
        Person person = new Person(null, "Lalo", "Thor", "C");

        Person personNew = repository.save(person);
        System.out.println(personNew);
    }

    @Transactional
    public void update() {
        Optional<Person> person = repository.findById(7L);

        person.ifPresent(p -> {
            p.setLanguage("C");
            p.setName("Cesar");
            repository.save(p);
        });
    }

    @Transactional
    public void delete() {
        Optional<Person> person = repository.findById(6L);

        person.ifPresent(repository::delete);
    }

    @Transactional(readOnly = true)
    public void dto() {
        List<PersonDto> persons = repository.findAllPersonDto();

        persons.forEach(System.out::println);
    }

    @Transactional(readOnly = true)
    public void order() {
        List<Person> persons = repository.findByIdBetweenOrderByLanguageDesc(2L, 7L);

        persons.forEach(System.out::println);
    }
}
