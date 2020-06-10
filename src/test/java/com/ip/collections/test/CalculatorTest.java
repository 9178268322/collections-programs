package com.ip.collections.test;

import com.ip.collections.programs.Calculator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class test calculator class functions.
 */
public class CalculatorTest {

    private static Calculator calculator;

    @BeforeTest
    public void init() {
        calculator = new Calculator();
    }

    @Test
    public void shouldEvaluateConstants() {
        assertThat(calculator.evalute("1")).isEqualTo(1);
    }

    @Test
    public void shouldSupportAdding() {
        assertThat(calculator.evalute("1 + 2")).isEqualTo(3);
    }

    @Test
    public void shouldSupportSubtraction() {
        assertThat(calculator.evalute("1 - 2")).isEqualTo(-1);
    }

    @Test
    public void shouldComplexStatements() {
        assertThat(calculator.evalute("1 - 3 + 2 + 4")).isEqualTo(4);
    }
}
