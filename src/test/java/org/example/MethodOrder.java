package org.example;

import org.junit.jupiter.api.*;


@TestMethodOrder(MethodOrderer.Random.class) // Random, DisplayName, MethodName, OrderAnnotation, None (default), Random (org.junit.jupiter.api.MethodOrderer.R
@Order(2)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MethodOrder {

    StringBuilder sb = new StringBuilder();

    @BeforeAll
    public void beforeAll() {
        System.out.println("Before all");
    }

    @AfterEach
    public void afterEach() {
        System.out.println(sb.toString());
    }

    @Test
    public void testA() {
        System.out.println("Test A");
        sb.append("A");
    }

    @Test
    public void testB() {
        System.out.println("Test B");
        sb.append("B");
    }

    @Test
    public void testC() {
        System.out.println("Test C");
        sb.append("C");
    }

    @Test
    public void testD() {
        System.out.println("Test D");
        sb.append("D");
    }
}
