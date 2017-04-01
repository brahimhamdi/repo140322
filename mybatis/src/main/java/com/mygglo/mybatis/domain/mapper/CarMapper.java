package com.mygglo.mybatis.domain.mapper;

import com.mygglo.mybatis.domain.model.Car;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by jgaglo on 01/04/17.
 */
@Mapper
public interface CarMapper {
  String INSERT = "INSERT INTO car( model,color,person_id)     " +
      "VALUES(#{model},#{color},#{person.id})";

  String FIND_ALL ="SELECT * FROM car ";

  String SELECT_BY_ID ="SELECT * FROM car WHERE id=#{id}";

  String DELETE ="DELETE FROM car WHERE id=#{id}";


  String UPDATE = "UPDATE car " +
      " SET model=#{model}, color=#{color}  " +
      " WHERE id=#{id}" ;

  @Insert(INSERT)
  @Options(useGeneratedKeys = true)
  void insert(Car car);

  @Select(FIND_ALL)
  List<Car> findAll();


  @Select(SELECT_BY_ID)
  Car findById(Long id);

  @Delete(DELETE)
  void delete(Long id);

  @Update(UPDATE)
  void update(Car car);


}
