package com.implodingduck.batch.demo;

public class Sumandproduct {

  private int id;
  private int v1;
  private int v2;
  private int sum;
  private int product;

  public Sumandproduct() {
  }



  public Sumandproduct(int id, int v1, int v2, int sum, int product) {
    this.id = id;
    this.v1 = v1;
    this.v2 = v2;
    this.sum = sum;
    this.product = product;
  }
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public int getV1() {
    return v1;
  }

  public void setV1(int v1) {
    this.v1 = v1;
  }

  public int getV2() {
    return v2;
  }

  public void setV2(int v2) {
    this.v2 = v2;
  }

  public int getSum() {
    return sum;
  }

  public void setSum(int sum) {
    this.sum = sum;
  }

  public int getProduct() {
    return product;
  }

  public void setProduct(int product) {
    this.product = product;
  }
 

  @Override
  public String toString() {
    return "id: " + id + " v1: " + v1 + ", v2: " + v2 + " sum: " + sum + " product: " + product;
  }

}