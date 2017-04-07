package com.mygglo.mybatis.spring.data.domain.repository;

import com.mygglo.mybatis.spring.data.domain.mapper.PersonMapper;
import com.mygglo.mybatis.spring.data.domain.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mybatis.repository.support.MybatisRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jgaglo on 01/04/17.
 */
@Repository
public interface PersonRepository extends MybatisRepository<Person,Long>{
}
