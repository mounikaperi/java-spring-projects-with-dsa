package com.springpractice.springcore.games;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Eliminate verbosity in creating Java Beans
//Public accessor methods, constructor,
//equals, hashcode and toString are automatically created.
//Released in JDK 16.
record Person(String name, int age, Address address) {};
record Address(String firstLine, String city) {};
@Configuration
public class GamingConfiguration {
    @Bean
    public String name() {
        return "sampleName";
    }
    @Bean
    public int age() {
        return 21;
    }
    @Bean
    public Person person() {
        return new Person("John", 21, new Address("Main Street", "London"));
    }
    @Bean(name="myAddress") // custom bean
    public Address address() {
        return new Address("Bankers Street", "London");
    }
    @Bean
    public Person person1() {
        return new Person(name(), age(), address());
    }
    @Bean // as parameters
    public Person person2(String name, int age, Address address) {
        return new Person(name, age, address);
    }
}
