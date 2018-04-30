package com.example.tdddemo.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class GreetingsServiceTest {

    @Configuration
    public static class Config{
        @Bean
        public GreetingsService greetingsService(){
            return new GreetingsService();
        }
    }

    @Autowired
    GreetingsService greetingsService;

    // if the gender is male, return Mr.
    @Test
    public void whenGenderMaleReturnMrTest(){
        String salute = greetingsService.getGreetingByGender("male");
        Assert.assertEquals("Mr.", salute);
    }

    // if the gender is female, return Mrs.
    @Test
    public void whenGenderFemaleReturnMrsTest(){
        String salute = greetingsService.getGreetingByGender("female");
        Assert.assertEquals("Mrs.", salute);
    }

    // if the gender is garbage, throw runtime exception
    @Test(expected = RuntimeException.class)
    public void whenGenderGarbageThrowExceptionTest(){
        String salute = greetingsService.getGreetingByGender("sdfsd");
    }
}