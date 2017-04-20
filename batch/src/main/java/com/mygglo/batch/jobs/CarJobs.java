package com.mygglo.batch.jobs;

import com.mygglo.batch.model.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;

/**
 * Created by jgaglo on 20/04/17.
 */
@Slf4j
@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing
public class CarJobs {
  @Autowired
  DataSource dataSource;

  @Autowired
  public JobBuilderFactory jobBuilderFactory;

  @Autowired
  public StepBuilderFactory stepBuilderFactory;

  static String GET_ALL = "SELECT * FROM car";
  static String UPDATE_CARS = "UPDATE car SET color=:color WHERE id=:id";

  @Bean
  public ItemReader<Car> getAllReader(){
    JdbcCursorItemReader<Car> reader = new JdbcCursorItemReader<>();
    reader.setDataSource(dataSource);
    reader.setSql(GET_ALL);
    reader.setRowMapper(new BeanPropertyRowMapper<>(Car.class));
    return  reader;
  }

  @Bean
  public ItemProcessor<Car,Car> changeColorProcessor(){
    return new CarProcessor();
  }

  @Bean
  public ItemWriter<Car> carColorWriter(){
    JdbcBatchItemWriter<Car> writer = new JdbcBatchItemWriter<>();
    writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
    writer.setDataSource(dataSource);
    writer.setSql(UPDATE_CARS);
    return writer;

  }

  @Bean
  public Step stepChangeColor() {
    return stepBuilderFactory.get("stepChangeColor")
        .<Car, Car>chunk(10)
        .reader(getAllReader())
        .processor(changeColorProcessor())
        .writer(carColorWriter())
        .build();

  }


  @Bean
  public Job coloChangeJob(ColorChangeListener listener){
    return jobBuilderFactory.get("coloChangeJob")
        .incrementer(new RunIdIncrementer())
        .listener(listener)
        .flow(stepChangeColor())
        .end()
        .build();
  }
}
