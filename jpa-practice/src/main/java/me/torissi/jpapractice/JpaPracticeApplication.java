package me.torissi.jpapractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JpaPracticeApplication {

  public static void main(String[] args) {
    SpringApplication.run(JpaPracticeApplication.class, args);
  }

}
