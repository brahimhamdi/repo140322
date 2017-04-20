package com.mygglo.batch.jobs;

import com.mygglo.batch.model.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by jgaglo on 20/04/17.
 */
@Slf4j
public class CarProcessor implements ItemProcessor<Car,Car> {
  @Override
  public Car process(Car car) throws Exception {
    log.info("Changing color for  "+car);
    car.setColor("Magenta");
    return car;
  }
}
