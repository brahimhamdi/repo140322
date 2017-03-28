package me.dovea.factory.factory.impl;

import me.dovea.factory.factory.Shape;

public class Circle implements Shape {
  @Override
  public String draw() {
    return "I'm a circle";
  }
}