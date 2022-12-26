package com.example.DynamicFilterDemo;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PersonService {

    List<Person> peopleList;

    PersonService(){
        peopleList = new LinkedList<>();
    }

    public void addPerson(Person person){
        peopleList.add(person);
    }

    public List<Person> getAddresses(){
        return peopleList;
    }

    public List<Person> getEmploymentInformation(){
        return peopleList;
    }
}
