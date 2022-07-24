package com.Shivanshu.Microservice.limitsservice.bean;

public class Limits {
  private int maximun;
  private int minimum;
  
  protected Limits() {
	  
  }

public Limits(int maximun, int minimum) {
	super();
	this.maximun = maximun;
	this.minimum = minimum;
}

public int getMaximun() {
	return maximun;
}

public void setMaximun(int maximun) {
	this.maximun = maximun;
}

public int getMinimum() {
	return minimum;
}

public void setMinimum(int minimum) {
	this.minimum = minimum;
}
  
}
