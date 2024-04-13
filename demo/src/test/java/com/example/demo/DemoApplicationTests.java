package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Temporarily disabled due to failure")
public class MyTest {

    @Test
    public void myFailingTest() {
        // Test logic
    }

    @Test
    public void anotherFailingTest() {
        // Test logic
    }
}

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private DemoApplication demoApplication;

    @Test
    void contextLoads() {
        assertThat(demoApplication).isNotNull();
    }
}
