package org.prog.demo.controller;

import org.prog.demo.dto.PersonDto;
import org.prog.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/v1/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Test: OK");
    }

    @GetMapping("/v1/person/{id}")
    public ResponseEntity<PersonDto> getPersonById(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(personService.getPerson(id));
    }

    @GetMapping("/v1/person")
    public ResponseEntity<List<PersonDto>> listAllPErsons() {
        return ResponseEntity.ok(personService.listPersons());
    }

    @PutMapping("/v1/person")
    public ResponseEntity<String> updatePerson(@RequestBody PersonDto dto) {
        return ResponseEntity.ok(personService.updateUser(dto));
    }

    @PostMapping("/v1/person")
    public ResponseEntity<String> createPerson(@RequestBody PersonDto dto) {
        return ResponseEntity.ok(personService.registerUser(dto));
    }

    @DeleteMapping("/v1/person/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable (name = "id") long id) {
        return ResponseEntity.ok(personService.deleteUser(id));
    }
}
