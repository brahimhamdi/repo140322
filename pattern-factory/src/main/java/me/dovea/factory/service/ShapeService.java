package me.dovea.factory.service;

import me.dovea.factory.factory.Shape;
import me.dovea.factory.factory.ShapeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShapeService {

 @Autowired
 private ShapeFactory shapeFactory;

 public String sayHello(String shapeType) {
    Shape shape = shapeFactory.getShape(shapeType);
   return shape.draw();
 }
}