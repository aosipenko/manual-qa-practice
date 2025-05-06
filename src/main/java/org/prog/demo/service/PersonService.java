package org.prog.demo.service;

import org.prog.demo.db.PersonJpa;
import org.prog.demo.db.PersonTable;
import org.prog.demo.dto.NameDto;
import org.prog.demo.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PersonService {

    @Autowired
    private PersonJpa personJpa;

    public String registerUser(PersonDto personDto) {
        if (!isValid(personDto.getNationatlity()) ||
                !isValid(personDto.getGender()) ||
                !isGenderValid(personDto.getGender()) ||
                !isValid(personDto.getName().getFirstName()) ||
                !isValid(personDto.getName().getLastName())
        ) {
            throw new IllegalArgumentException("Invalid input");
        }
        personJpa.save(PersonTable.builder()
                .firstName(personDto.getName().getFirstName())
                .lastName(personDto.getName().getLastName())
                .title(personDto.getName().getTitle())
                .gender(personDto.getGender())
                .nat(personDto.getNationatlity())
                .build());
        return "OK";
    }

    public PersonDto getPerson(long id) {
        Optional<PersonTable> personTable = personJpa.findById(id);
        if (personTable.isEmpty()) {
            throw new IllegalArgumentException("No person with such id present in database.");
        } else {
            return personJpa.findById(id).map(this::fromBd).get();
        }
    }

    public List<PersonDto> listPersons() {
        return personJpa.findAll().stream().map(this::fromBd).collect(Collectors.toList());
    }

    private PersonDto fromBd(PersonTable personTable) {
        return PersonDto.builder()
                .name(
                        NameDto.builder()
                                .firstName(personTable.getFirstName())
                                .lastName(personTable.getLastName())
                                .title(personTable.getTitle())
                                .build()
                )
                .gender(personTable.getGender())
                .nationatlity(personTable.getNat())
                .id(personTable.getPersonId())
                .build();
    }

    public String updateUser(PersonDto dto) {
        if (
                !isValid(dto.getNationatlity()) ||
                        !isValid(dto.getGender()) ||
                        !isValid(dto.getName().getTitle()) ||
                        !isValid(dto.getName().getFirstName()) ||
                        !isValid(dto.getName().getLastName())
        ) {
            throw new IllegalArgumentException("Invalid name");
        }
        PersonTable entry = personJpa.findById(dto.getId()).orElseThrow();
        entry.setFirstName(dto.getName().getFirstName());
        entry.setLastName(dto.getName().getLastName());
        entry.setTitle(dto.getName().getTitle());
        entry.setGender(dto.getGender());
        entry.setNat(dto.getNationatlity());
        personJpa.save(entry);
        return "OK";
    }

    public String deleteUser(long id) {
        personJpa.deleteById(id);
        return "OK";
    }

    private boolean isValid(String value) {
        return value.length() < 30 && value.matches("[A-Za-z]+");
    }

    private boolean isGenderValid(String gender) {
        return gender.equals("male") || gender.equals("female");
    }
}
