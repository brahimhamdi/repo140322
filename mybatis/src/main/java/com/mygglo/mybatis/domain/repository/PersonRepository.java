package com.mygglo.mybatis.domain.repository;

import com.mygglo.mybatis.domain.mapper.PersonMapper;
import com.mygglo.mybatis.domain.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jgaglo on 01/04/17.
 */
@Repository
public class PersonRepository {
  @Autowired
  PersonMapper personMapper;

  public Person save(Person person){
    if (person.getId() == null){
      personMapper.insert(person);
    }else{
      personMapper.update(person);
    }

    return person;
  }

  public List<Person> findAll(){
    return personMapper.selectAll();
  }


  public Person findById(Long id){
    return personMapper.findById(id);
  }

  public void delete(Long id){
    personMapper.delete(id);
  }
}
