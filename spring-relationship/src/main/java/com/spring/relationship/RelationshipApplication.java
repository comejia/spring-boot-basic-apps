package com.spring.relationship;

import com.spring.relationship.entities.*;
import com.spring.relationship.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class RelationshipApplication implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private DetailsRepository detailsRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    public static void main(String[] args) {
        SpringApplication.run(RelationshipApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        removeManyToMany();
    }

    @Transactional
    public void manyToOne() {
        Client client = new Client("John", "Doe");
        clientRepository.save(client);

        Invoice invoice = new Invoice("Compras de oficina", 2000d);
        invoice.setClient(client);
        invoiceRepository.save(invoice);
    }

    @Transactional
    public void oneToMany() {
        Client client = new Client("Fran", "Moras");
        Address address1 = new Address("Suarez", 1234);
        Address address2 = new Address("Mirave", 123);
        client.getAddresses().add(address1);
        client.getAddresses().add(address2);

        clientRepository.save(client);
    }

    @Transactional
    public void removeAddress() {
        Client client = new Client("Fran", "Moras");
        Address address1 = new Address("Suarez", 1234);
        Address address2 = new Address("Mirave", 123);
        client.getAddresses().add(address1);
        client.getAddresses().add(address2);

        clientRepository.save(client);
        System.out.println(client);

        Optional<Client> oc = clientRepository.findById(3L);

        oc.ifPresent(c -> {
            c.getAddresses().remove(address1);
            clientRepository.save(c);
            System.out.println(c);
        });
    }

    @Transactional
    public void oneToOne() {
        Details details = new Details(false, 2001);
        detailsRepository.save(details);

        Client client = new Client("John", "Doe");
        client.setDetails(details);
        clientRepository.save(client);
    }

    @Transactional
    public void manyToMany() {
        Student student1 = new Student("Cesar", "Pura");
        Student student2 = new Student("Erba", "Doe");

        Course course1 = new Course("Spring boot", "Andres");
        Course course2 = new Course("Angular", "Andres");

        student1.setCourses(Set.of(course1, course2));
        student2.setCourses(Set.of(course2));

        studentRepository.saveAll(Set.of(student1, student2));

        System.out.println(student1);
        System.out.println(student2);
    }

    @Transactional
    public void removeManyToMany() {
        Optional<Student> oStudent = studentRepository.findById(4L);

        oStudent.ifPresent(student -> {
            Optional<Course> oCourse = courseRepository.findById(2L);
            oCourse.ifPresent(course -> {
                student.getCourses().remove(course);

                studentRepository.save(student);
                System.out.println(student);
            });
        });
    }
}
