package com.example;

import io.opentracing.Span;
import io.opentracing.util.GlobalTracer;

public class WorkTest {
  public void doWork() {
    Span span = GlobalTracer.get().buildSpan("importantWork").start();
    try {
      Thread.sleep(250);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    span.finish();
  }
}
