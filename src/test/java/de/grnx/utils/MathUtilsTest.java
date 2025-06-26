package de.grnx.utils;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathUtilsTest {


    private static final String METHOD_TO_TEST = "countWordsPre"; // "countWordsPre" or "countWordsPost"

    private final Function<String, Integer> methodUnderTest = input -> {
        try {
            Method method = MathUtils.class.getMethod(METHOD_TO_TEST, String.class);
            return (int) method.invoke(null, input);
        } catch (Exception e) {
            throw new RuntimeException("Reflection failed: " + e.getMessage(), e);
        }
    };

    @Test
    public void testNormalSentence() {
        assertEquals(5, methodUnderTest.apply("The quick brown fox jumps"));
    }

    @Test
    public void testMultipleSpaces() {
        assertEquals(5, methodUnderTest.apply("The   quick   brown fox   jumps"));
    }

    @Test
    public void testTabsAndNewlines() {
        assertEquals(4, methodUnderTest.apply("One\tTwo\nThree  Four"));
    }

    @Test
    public void testEmptyString() {
        assertEquals(0, methodUnderTest.apply(""));
    }

    @Test
    public void testOnlySpaces() {
        assertEquals(0, methodUnderTest.apply("     "));
    }

    @Test
    public void testNullInput() {
        assertEquals(0, methodUnderTest.apply(null));
    }
}

/*
    @Test
    public void testOnlyPositiveNumbers() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        assertEquals(6, MathUtils.sumPositivePre(input));
        assertEquals(6, MathUtils.sumPositivePost(input));
    }

    @Test
    public void testMixedNumbers() {
        List<Integer> input = Arrays.asList(-1, 2, 0, 4, -3);
        assertEquals(6, MathUtils.sumPositivePre(input));
        assertEquals(6, MathUtils.sumPositivePost(input)); // should fail
    }

    @Test
    public void testAllNonPositive() {
        List<Integer> input = Arrays.asList(-5, 0, -3);
        assertEquals(0, MathUtils.sumPositivePre(input));
        assertEquals(0, MathUtils.sumPositivePost(input)); // may pass
    }

    @Test
    public void testEmptyList() {
        List<Integer> input = Collections.emptyList();
        assertEquals(0, MathUtils.sumPositivePre(input));
        assertEquals(0, MathUtils.sumPositivePost(input));
    }*/
