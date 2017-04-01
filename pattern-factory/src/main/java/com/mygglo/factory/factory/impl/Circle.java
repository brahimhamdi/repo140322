package com.mygglo.factory.factory.impl;
import com.mygglo.factory.factory.Shape;

public class Circle implements Shape {
  @Override
  public String draw() {
    return "I'm a circle";
  }
}