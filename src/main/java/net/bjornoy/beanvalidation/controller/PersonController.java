package net.bjornoy.beanvalidation.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@RestController
public class PersonController {

    @PostMapping(value = "/persons")
    public ResponseEntity<Person> create(@RequestBody @Valid Person person) {
        return ResponseEntity.ok(Person.builder()
                .birthDate(person.getBirthDate())
                .name(person.getName())
                .build());
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Person {

        @PastOrPresent(message = "{person.birthDate}")
        private LocalDate birthDate;

        @NotBlank(message = "{person.name}")
        private String name;
    }
}
