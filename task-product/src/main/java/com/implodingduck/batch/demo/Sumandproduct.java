package com.implodingduck.batch.demo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sumandproduct")
public class Sumandproduct {

  @Id
  @GeneratedValue
  private Long id;

  @Column
  private Long v1;

  @Column
  private Long v2;

  @Column
  private Long sum;

  @Column
  private Long product;


  
  public Sumandproduct() {
  }



  public Sumandproduct(Long id, Long v1, Long v2, Long sum, Long product) {
    this.id = id;
    this.v1 = v1;
    this.v2 = v2;
    this.sum = sum;
    this.product = product;
  }
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public Long getV1() {
    return v1;
  }

  public void setV1(Long v1) {
    this.v1 = v1;
  }

  public Long getV2() {
    return v2;
  }

  public void setV2(Long v2) {
    this.v2 = v2;
  }

  public Long getSum() {
    return sum;
  }

  public void setSum(Long sum) {
    this.sum = sum;
  }

  public Long getProduct() {
    return product;
  }

  public void setProduct(Long product) {
    this.product = product;
  }
 

  @Override
  public String toString() {
    return "id: " + id + " v1: " + v1 + ", v2: " + v2 + " sum: " + sum + " product: " + product;
  }

}