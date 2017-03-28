package me.dovea.factory.factory.impl;

import me.dovea.factory.factory.Shape;

public class Circle implements Shape {

  @Override
  public String sayHello() {
    return "I'm a circle";
  }
}