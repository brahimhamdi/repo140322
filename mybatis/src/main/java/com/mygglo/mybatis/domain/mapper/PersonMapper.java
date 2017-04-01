package com.mygglo.mybatis.domain.mapper;

import com.mygglo.mybatis.domain.model.Car;
import com.mygglo.mybatis.domain.model.Person;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by jgaglo on 01/04/17.
 */
@Mapper
public interface PersonMapper {
  String INSERT_PERSON = "INSERT INTO person( first_name,last_name,telephone)     VALUES(#{firstName},#{lastName},#{telephone})";

  String UPDATE = "UPDATE person " +
      "SET first_name=#{firstName}, last_name=#{lastName}, telephone=#{telephone}  WHERE id=#{id}";

  String SELECT_ALL ="SELECT * FROM person";
  String FIND_BY_ID ="SELECT * FROM person WHERE id=#{id}";
  String DELETE ="DELETE FROM person WHERE id=#{id}";
  String SELECT_PERSON_CARS ="SELECT * FROM car WHERE person_id=#{id}";

  @Insert(INSERT_PERSON)
  @Options(useGeneratedKeys = true)
  int insert(Person person);

  @Select(FIND_BY_ID)
  @Results(id = "person-cars",
      value = {
          @Result(property = "id",column = "id"),
          @Result(property = "firstName",column = "first_name"),
          @Result(property = "lastName",column = "last_name"),
          @Result(property = "cars",column = "id",
              javaType = List.class,many = @Many(select = "getPersonCars"))
      }
  )

  Person findById(Long id);

  @Select(SELECT_PERSON_CARS)
  List<Car> getPersonCars(Long id);

  @Select(SELECT_ALL)
  @ResultMap("person-cars")
  List<Person> selectAll();

  @Update(UPDATE)
  int update(Person person);

  @Delete(DELETE)
  int delete(Long id);


}
