package com.mygglo.factory.factory.impl;
import com.mygglo.factory.factory.Shape;

public class Rectangle implements Shape {
  @Override
  public String draw() {
    return "I'm a rectangle";
  }
}