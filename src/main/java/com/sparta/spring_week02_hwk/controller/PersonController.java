package com.sparta.spring_week02_hwk.controller;

import com.sparta.spring_week02_hwk.domain.Person;
import com.sparta.spring_week02_hwk.domain.PersonRepository;
import com.sparta.spring_week02_hwk.domain.PersonRequestDto;
import com.sparta.spring_week02_hwk.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PersonController {
    public final PersonService personService;
    private final PersonRepository personRepository;

    @PostMapping("/api/persons")
    public Person createPerson(@RequestBody PersonRequestDto requestDto) {
        Person person = new Person(requestDto);
        return personRepository.save(person);
    }

    @GetMapping("/api/persons")
    public List<Person> readPerson(){
        return personRepository.findAll();
    }

    @PutMapping("/api/persons/{id}")
    public Long updatePerson(@PathVariable Long id, @RequestBody PersonRequestDto requestDto){
        // 이렇게하면 Service랑 할일 겹침
//    Person person = personRepository.findById(id).orElseThrow(
//        () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
//                );
        return personService.update(id, requestDto);
    }

    @DeleteMapping("/api/persons/{id}")
    public Long deletePerson(@PathVariable Long id){
        personRepository.deleteById(id);
        return id;
    }


}