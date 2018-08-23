package com.anoyi.user.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceTest {

    @Autowired
    private TestService testService;

    @Test
    public void sqlTest() {
        while (true){
            try{
                testService.printAll();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    @Test
    @Transactional
    public void translationTest() {
        testService.add();
        int x = 1 / 0;
    }

}
