package com.mycompany.mavenproject1;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Mavenproject1Test {

    /**
     * Bubble sort implementation for testing
     */
    private int[] bubbleSort(int[] arr) {
        int[] sortedArr = arr.clone();
        for (int i = 0; i < sortedArr.length - 1; i++) {
            for (int j = 0; j < sortedArr.length - 1 - i; j++) {
                if (sortedArr[j] >= sortedArr[j + 1]) {
                    int temp = sortedArr[j];
                    sortedArr[j] = sortedArr[j + 1];
                    sortedArr[j + 1] = temp;
                }
            }
        }
        return sortedArr;
    }

    /**
     * Helper method to verify if array is sorted in ascending order
     */
    private boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Helper method to verify array contains all same elements
     */
    private boolean containsAllElements(int[] original, int[] sorted) {
        int[] origCopy = original.clone();
        Arrays.sort(origCopy);
        return Arrays.equals(origCopy, sorted);
    }

    @Test
    public void testBubbleSortWithMixedNumbers() {
        int[] input = {4, 1, -10, 40, 60, 80, 55};
        int[] expected = {-10, 1, 4, 40, 55, 60, 80};
        int[] result = bubbleSort(input);
        
        Assert.assertEquals(result, expected, "Arrays should be equal");
        Assert.assertTrue(isSorted(result), "Result should be sorted");
        Assert.assertNotNull(result, "Result should not be null");
        Assert.assertEquals(result.length, input.length, "Length should match");
        Assert.assertTrue(containsAllElements(input, result), "Should contain all original elements");
    }

    @Test
    public void testBubbleSortWithNegativeNumbers() {
        int[] input = {-5, -1, -10, -3};
        int[] expected = {-10, -5, -3, -1};
        int[] result = bubbleSort(input);
        
        Assert.assertEquals(result, expected, "Negative numbers should sort correctly");
        Assert.assertTrue(isSorted(result), "Negative array should be sorted");
        Assert.assertEquals(result[0], -10, "First element should be smallest");
        Assert.assertEquals(result[result.length - 1], -1, "Last element should be largest");
        Assert.assertFalse(Arrays.equals(result, input), "Result should differ from input");
    }

    @Test
    public void testBubbleSortWithPositiveNumbers() {
        int[] input = {5, 2, 8, 1, 9};
        int[] expected = {1, 2, 5, 8, 9};
        int[] result = bubbleSort(input);
        
        Assert.assertEquals(result, expected, "Positive numbers should sort correctly");
        Assert.assertTrue(isSorted(result), "Result should be in ascending order");
        Assert.assertTrue(result[0] < result[result.length - 1], "First element should be less than last");
        Assert.assertTrue(containsAllElements(input, result), "Should preserve all elements");
    }
                       
    @Test
    public void testBubbleSortWithDuplicates() {
        int[] input = {3, 1, 3, 2, 3};
        int[] expected = {1, 2, 3, 3, 3};
        int[] result = bubbleSort(input);
        
        Assert.assertEquals(result, expected, "Duplicates should be preserved");
        Assert.assertTrue(isSorted(result), "Array with duplicates should be sorted");
        Assert.assertEquals(countOccurrences(result, 3), 3, "Should have three 3's");
        Assert.assertTrue(containsAllElements(input, result), "Should maintain count of all elements");
    }

    @Test
    public void testBubbleSortWithSingleElement() {
        int[] input = {42};
        int[] expected = {42};
        int[] result = bubbleSort(input);
        
        Assert.assertEquals(result, expected, "Single element should remain unchanged");
        Assert.assertEquals(result.length, 1, "Length should be 1");
        Assert.assertTrue(isSorted(result), "Single element is trivially sorted");
        Assert.assertNotSame(result, input, "Should return different array object");
    }

    @Test
    public void testBubbleSortWithAlreadySortedArray() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        int[] result = bubbleSort(input);
        
        Assert.assertEquals(result, expected, "Already sorted array should remain unchanged");
        Assert.assertTrue(isSorted(result), "Result should remain sorted");
        Assert.assertTrue(Arrays.equals(result, expected), "Should match expected exactly");
    }

    @Test
    public void testBubbleSortWithReverseSortedArray() {
        int[] input = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        int[] result = bubbleSort(input);
        
        Assert.assertEquals(result, expected, "Reverse sorted should become ascending");
        Assert.assertTrue(isSorted(result), "Should be properly sorted");
        Assert.assertFalse(Arrays.equals(result, input), "Result should differ from reverse input");
        Assert.assertTrue(result[0] == 1 && result[result.length - 1] == 5, "Boundaries should be correct");
    }

    @Test
    public void testBubbleSortWithZeros() {
        int[] input = {0, -1, 1, 0, -2};
        int[] expected = {-2, -1, 0, 0, 1};
        int[] result = bubbleSort(input);
        
        Assert.assertEquals(result, expected, "Zero values should be positioned correctly");
        Assert.assertTrue(isSorted(result), "Should be sorted with zeros");
        Assert.assertEquals(countOccurrences(result, 0), 2, "Should have two zeros");
        Assert.assertTrue(containsAllElements(input, result), "Should preserve zero elements");
    }

    @Test
    public void testBubbleSortWithLargeNumbers() {
        int[] input = {1000, -1000, 500, -500};
        int[] expected = {-1000, -500, 500, 1000};
        int[] result = bubbleSort(input);
        
        Assert.assertEquals(result, expected, "Large numbers should sort correctly");
        Assert.assertTrue(isSorted(result), "Large numbers should be sorted");
        Assert.assertEquals(result[0], -1000, "Smallest large negative should be first");
        Assert.assertEquals(result[result.length - 1], 1000, "Largest positive should be last");
    }

    @Test
    public void testBubbleSortPreservesLength() {
        int[] input = {3, 1, 4, 1, 5, 9, 2, 6};
        int[] result = bubbleSort(input);
        
        Assert.assertEquals(result.length, input.length, "Lengths should match exactly");
        Assert.assertTrue(result.length == 8, "Length should be 8");
        Assert.assertNotNull(result, "Result should not be null");
        Assert.assertTrue(containsAllElements(input, result), "All elements should be preserved");
    }

    @Test
    public void testBubbleSortEmptyArray() {
        int[] input = {};
        int[] result = bubbleSort(input);
        
        Assert.assertEquals(result.length, 0, "Empty array should remain empty");
        Assert.assertNotNull(result, "Result should not be null");
        Assert.assertTrue(isSorted(result), "Empty array is trivially sorted");
    }

    @Test
    public void testBubbleSortTwoElements() {
        int[] input = {2, 1};
        int[] expected = {1, 2};
        int[] result = bubbleSort(input);
        
        Assert.assertEquals(result, expected, "Two elements should sort correctly");
        Assert.assertTrue(isSorted(result), "Two element array should be sorted");
        Assert.assertTrue(result[0] < result[1], "First should be less than second");
    }

    /**
     * Helper method to count occurrences of a value in array
     */
    private int countOccurrences(int[] arr, int value) {
        int count = 0;
        for (int num : arr) {
            if (num == value) count++;
        }
        return count;
    }
}

