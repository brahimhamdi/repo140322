package me.dovea.factory.factory.impl;

import me.dovea.factory.factory.Shape;

public class Rectangle implements Shape {
  @Override
  public String draw() {
    return "I'm a rectangle";
  }
}