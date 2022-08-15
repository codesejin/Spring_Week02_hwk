package com.sparta.spring_week02_hwk;

import com.sparta.spring_week02_hwk.domain.Person;
import com.sparta.spring_week02_hwk.domain.PersonRepository;
import com.sparta.spring_week02_hwk.domain.PersonRequestDto;
import com.sparta.spring_week02_hwk.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;
@EnableJpaAuditing
@SpringBootApplication
public class SpringWeek02HwkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWeek02HwkApplication.class, args);
    }
    // Week02Application.java 의 main 함수 아래에 붙여주세요.
    @Bean
    public CommandLineRunner demo(PersonRepository personRepository, PersonService personService) {
        return (args) -> {
            //객체 생성
            Person person1 = new Person("박세진",30,"일산","개발자");
            //데이터 저장하기
            personRepository.save(person1);

            System.out.println("데이터 인쇄");
            //전체조회하기
            List<Person> personList = personRepository.findAll();
            for (int i = 0; i < personList.size(); i++) {
                Person p = personList.get(i);
                System.out.println(p.getId());
                System.out.println(p.getName());
                System.out.println(p.getAge());
                System.out.println(p.getAddress());
                System.out.println(p.getJob());
            }
            //업데이트하기
            PersonRequestDto requestDto = new PersonRequestDto("앨리스", 25, "서울", "개발자");
            personService.update(1L, requestDto);
            personList = personRepository.findAll();
            for (int i = 0; i <personList.size() ; i++) {
                Person person = personList.get(i);
                System.out.println(person.getId());
                System.out.println(person.getName());
                System.out.println(person.getAge());
                System.out.println(person.getAddress());
                System.out.println(person.getJob());
            }
//            personRepository.deleteAll(); 전체삭제
        };
    }
}
