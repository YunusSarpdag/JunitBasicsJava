package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Main class test")
@Order(3)
class MainTest {

    @BeforeAll
    static void setUp() {
        System.out.println("Setting up the test");
    }

    @BeforeEach
    void init() {
        System.out.println("Initializing the test");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("Tearing down the test");
    }

    @AfterEach
    void destroy() {
        System.out.println("Destroying the test");
    }

    @Test
    @DisplayName("2 add 3 should equal 5")
    void add() {
        Main main = new Main();
        int actual = main.add(2, 3);
        assertEquals(5, actual, () -> getErrorMessage());
    }

    @Test
    @DisplayName("2 add 3 should equal 5")
    void add2() {
        Main main = new Main();
        int actual = main.add(2, 3);
      // lazzy initilization with lambda
        assertEquals(5, actual, () -> getErrorMessage());
    }

    @Test
    @DisplayName("2 add 3 should equal 5")
    @Disabled("TODO: fix this test later")
    void disabled() {
        Main main = new Main();
        int actual = main.add(2, 3);
        assertEquals(5, actual, () -> getErrorMessage());
    }

    private String getErrorMessage() {
        System.out.println("2 + 3 should equal 5");
        return "2 + 3 should equal 5";
    }

   @Test
   @DisplayName("10 divide 0 should ArithmeticException 5")
    void testDivide() {
        Main main = new Main();
        assertThrows(ArithmeticException.class, () -> main.divide(10, 0),  "Divide by zero should throw ArithmeticException");
    }

    @ParameterizedTest
    @DisplayName("2 add 3 should equal 5")
    @MethodSource("sourceMethod")
    void methodSource(int one, int two ,int result) {
        Main main = new Main();
        int actual = main.add(one, two);
        assertEquals(result, actual, () -> getErrorMessage());
    }

    public static Stream<Arguments> sourceMethod() {
        return Stream.of(
                Arguments.of(2, 3, 5),
                Arguments.of(3, 4, 7)
        );
    }

    @ParameterizedTest
    @DisplayName("2 add 3 should equal 5")
    @CsvSource({"1,2,3", "2,3,5"})
    void csvSource(int one, int two ,int result) {
        Main main = new Main();
        int actual = main.add(one, two);
        assertEquals(result, actual, () -> getErrorMessage());
    }

    @ParameterizedTest
    @DisplayName("2 add 3 should equal 5")
    @CsvFileSource(resources = "/csvFileSource.csv")
    void csvFileSource(int one, int two ,int result) {
        Main main = new Main();
        int actual = main.add(one, two);
        assertEquals(result, actual, () -> getErrorMessage());
    }

    @ParameterizedTest
    @DisplayName("2 add 3 should equal 5")
    @ValueSource(strings = {"John" , "Doe"})
    void valueSource(String name) {
        assertNotNull(name);
    }

    @RepeatedTest(5)
    @DisplayName("10 divide 0 should ArithmeticException 5")
    void repeatedTest(RepetitionInfo info, TestInfo testInfo) {
        System.out.println("Current repetition: " + info.getCurrentRepetition());
        System.out.println("Test name: " + testInfo.getDisplayName());
        Main main = new Main();
        assertThrows(ArithmeticException.class, () -> main.divide(10, 0),  "Divide by zero should throw ArithmeticException");
    }
}