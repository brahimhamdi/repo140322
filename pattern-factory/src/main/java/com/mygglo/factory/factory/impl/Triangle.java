package com.mygglo.factory.factory.impl;
import com.mygglo.factory.factory.Shape;
/**
 * Created by jgaglo on 28/03/17.
 */
public class Triangle implements Shape {
  @Override
  public String draw() {
    return "I'm a Triangle";
  }
}
