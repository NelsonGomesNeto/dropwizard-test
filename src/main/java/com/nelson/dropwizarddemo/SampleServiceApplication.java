package com.nelson.dropwizarddemo;

/**
 * Created by ngome on 10/07/2017.
 */

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class SampleServiceApplication extends Application<SampleServiceConfiguration> {

  public static void main(String[] args) throws Exception {
    new SampleServiceApplication().run(args);
  }

  @Override
  public String getName() {
    return "hello-world";
  }

  @Override
  public void initialize(Bootstrap<SampleServiceConfiguration> bootstrap) {

  }

  @Override
  public void run(SampleServiceConfiguration configuration, Environment environment) {

  }
}
