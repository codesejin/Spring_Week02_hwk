package com.sparta.spring_week02_hwk.service;

import com.sparta.spring_week02_hwk.domain.Person;
import com.sparta.spring_week02_hwk.domain.PersonRepository;
import com.sparta.spring_week02_hwk.domain.PersonRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@RequiredArgsConstructor//PersonRepository매개변수 받는 생성자를 대신하는 annotation
@Service
public class PersonService {
    // final: 서비스에게 꼭 필요한 녀석임을 명시
    private final PersonRepository personRepository;

    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, PersonRequestDto requestDto) {
        Person person1 = personRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        person1.update(requestDto);
        return person1.getId();
    }
}
