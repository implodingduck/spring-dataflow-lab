package com.implodingduck.batch.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import java.util.concurrent.ThreadLocalRandom;

public class SumandproductItemProcessor implements ItemProcessor<Sumandproduct, Sumandproduct> {

  private static final Logger log = LoggerFactory.getLogger(SumandproductItemProcessor.class);

  @Override
  public Sumandproduct process(final Sumandproduct sumandproduct) throws Exception {
    Sumandproduct transformedSumandproduct = new Sumandproduct();
    transformedSumandproduct.setId(sumandproduct.getId());
    transformedSumandproduct.setV1(sumandproduct.getV1());
    transformedSumandproduct.setV2(sumandproduct.getV2());
    transformedSumandproduct.setSum(sumandproduct.getV1() + sumandproduct.getV2());
    return transformedSumandproduct;
  }

}