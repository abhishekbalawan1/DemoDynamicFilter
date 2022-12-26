package com.example.DynamicFilterDemo;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService service;

    @PostMapping("/createPerson")
    public String createPerson(@RequestBody Person person){
        service.addPerson(person);
        return "Person was added to the list.";
    }

    @GetMapping("/getAddresses")
    public MappingJacksonValue getAddresses(){

        List<Person> list= service.getAddresses();
        //invoking static method filterOutAllExcept()
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("name", "address");
        FilterProvider filters=new SimpleFilterProvider().addFilter("PersonFilter",filter);
        //constructor of MappingJacksonValue class that has list as constructor argument
        MappingJacksonValue mapping = new MappingJacksonValue(list);
        //configuring filter
        mapping.setFilters(filters);
        return mapping;
    }

    @GetMapping("/getEmploymentInfo")
    public MappingJacksonValue getEmpInfo(){
        List<Person> list= service.getEmploymentInformation();
        //invoking static method filterOutAllExcept()
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("name", "company");
        FilterProvider filters=new SimpleFilterProvider().addFilter("PersonFilter",filter);
        //constructor of MappingJacksonValue class that has list as constructor argument
        MappingJacksonValue mapping = new MappingJacksonValue(list);
        //configuring filter
        mapping.setFilters(filters);
        return mapping;
    }

}
