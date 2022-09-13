package homework;

import org.junit.Assert;
import org.junit.Test;

public class ComplexExamplesTest {

    @Test
    public void findPairTesting() {

        int[][] matrix = {
                {3, 4, 2, 7},
                {10, 3, 1, 6, 1},
                {9, 9},
                {1, 1, 1, 1}
        };

        int[] sumArray = {10, 7, 18, 2};

        for (int i = 0; i < matrix.length; i++) {
            int[] resultArray = ComplexExamples.findPair(matrix[i], sumArray[i]);
            Assert.assertEquals(resultArray[0] + resultArray[1], sumArray[i]);
        }

    }

    @Test
    public void fuzzySearchTesting() {
        Assert.assertTrue(ComplexExamples.fuzzySearch("cwhl", "cartwheel")); // true
        Assert.assertTrue(ComplexExamples.fuzzySearch("cwhee", "cartwheel")); // true
        Assert.assertTrue(ComplexExamples.fuzzySearch("cartwheel", "cartwheel")); // true
        Assert.assertFalse(ComplexExamples.fuzzySearch("cwheeel", "cartwheel")); // false
        Assert.assertFalse(ComplexExamples.fuzzySearch("lw", "cartwheel")); // false

        Assert.assertTrue(ComplexExamples.fuzzySearch("kkk", "kfdvk ffd k")); //true
        Assert.assertTrue(ComplexExamples.fuzzySearch("ylab", "ylabylab")); //true
        Assert.assertFalse(ComplexExamples.fuzzySearch("123", "132")); //false
    }
}
