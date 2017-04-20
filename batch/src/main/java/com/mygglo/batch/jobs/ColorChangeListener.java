package com.mygglo.batch.jobs;

import com.mygglo.batch.model.Car;
import com.mygglo.batch.model.CarRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by jgaglo on 20/04/17.
 */
@Slf4j
@Component
public class ColorChangeListener extends JobExecutionListenerSupport {
  @Autowired
  JdbcTemplate jdbcTemplate;

  @Override
  public void afterJob(JobExecution jobExecution) {
    if (jobExecution.getStatus() == BatchStatus.COMPLETED){

      List<Car> cars = jdbcTemplate.query("select * from car",
          new CarRowMapper());
      log.info("========== AFTER BATCH ==========");
      log.info(cars.toString());

    }
  }
}
