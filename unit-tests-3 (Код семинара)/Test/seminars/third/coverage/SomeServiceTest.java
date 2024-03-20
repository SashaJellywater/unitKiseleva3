package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class SomeServiceTest {
    private SomeService someService;

    @BeforeEach
    void setUp() {
        someService = new SomeService();
    }

    // 3.1.
    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9, 33})
    void multipleThreeNotFiveReturnsFizz(int n) {
        assertEquals("Fizz", someService.fizzBuzz(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20, 55})
    void multipleFiveNotThreeReturnsFizz(int n) {
        assertEquals("Buzz", someService.fizzBuzz(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 225, 3375})
    void multipleThreeAndFiveReturnsFizzBuzz(int n) {
        assertEquals("FizzBuzz", someService.fizzBuzz(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 41, 43})
    void multipleOfThreeOfFiveReturnsNumber(int n) {
        assertEquals(Integer.toString(n), someService.fizzBuzz(n));
    }


    @Test
    void first6arrayShouldReturnTrue() {
        assertTrue(someService.firstLast6(new int[]{6, 3, 5, 3}));
    }

    @Test
    void last6arrayShouldReturnTrue() {
        assertTrue(someService.firstLast6(new int[]{2, 3, 5, 6}));
    }

    @Test
    void noLast6arrayShouldReturnTrue() {
        assertFalse(someService.firstLast6(new int[]{2, 3, 5}));
    }

    @Test
    void insufficientCoverageTest() {
        System.out.println(someService.calculatingDiscount(2000, 10));
        assertThat(someService.calculatingDiscount(2000, 50))
                .isEqualTo(1000);
        assertThat(someService.calculatingDiscount(2000, 100))
                .isEqualTo(0);
        assertThat(someService.calculatingDiscount(2000, 0))
                .isEqualTo(2000);

        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000, 110))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");
        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");
        assertThatThrownBy(() ->
                someService.calculatingDiscount(-2000, 10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Cумма покупки  не может быть отрицательной");
    }

    @Test
    void LuckySumReturnSumWithout13() {
        assertThat(someService.luckySum(2, 3, 13)).isEqualTo(5);
        assertThat(someService.luckySum(2, 13, 3)).isEqualTo(5);
        assertThat(someService.luckySum(13, 3, 6)).isEqualTo(9);
        assertThat(someService.luckySum(2, 2, 2)).isEqualTo(6);
        assertThat(someService.luckySum(13, 13, 13)).isEqualTo(0);
    }

    @Test
    public void testEvenNumber() {
        assertTrue(someService.evenOddNumber(10));
    }

    @Test
    public void testOddNumber() {
        assertFalse(someService.evenOddNumber(-7));
    }
    @Test
    public void testNumberInInterval() {
        assertTrue(someService.numberInInterval(100));
    }

    @Test
    public void testNumberNotInInterval() {
        assertFalse(someService.numberInInterval(24));
    }
}

