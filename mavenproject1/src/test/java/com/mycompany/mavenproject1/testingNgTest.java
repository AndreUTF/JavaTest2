package com.mycompany.mavenproject1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.Assert;

@DisplayName("JUnit and TestNG Comparison Tests")
public class testingNgTest {

    private String testData;

    @BeforeEach
    @BeforeMethod
    public void setUp() {
        testData = "TestData";
        System.out.println("Setup: Initializing test data");
    }

    @AfterEach
    @AfterMethod
    public void tearDown() {
        testData = null;
        System.out.println("Teardown: Cleaning up test data");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("JUnit Simple Assertion Test")
    public void junitSimpleTest() {
        assertEquals("TestData", testData, "Test data should match");
        assertNotNull(testData, "Test data should not be null");
        assertTrue(testData.length() > 0, "Test data should have length > 0");
        System.out.println("JUnit simple test passed");
    }

    @org.testng.annotations.Test
    public void testngSimpleTest() {
        Assert.assertEquals(testData, "TestData", "Test data should match");
        Assert.assertNotNull(testData, "Test data should not be null");
        Assert.assertTrue(testData.length() > 0, "Test data should have length > 0");
        System.out.println("TestNG simple test passed");
    }

    @org.testng.annotations.Test(dataProvider = "numberProvider", description = "Parametrized TestNG test")
    public void testngParametrizedTest(int number) {
        Assert.assertTrue(number > 0, "Number should be positive");
        System.out.println("TestNG parametrized test with number: " + number);
    }

    @DataProvider(name = "numberProvider")
    public Object[][] provideNumbers() {
        return new Object[][] {
            {1},
            {5},
            {10}
        };
    }

    @org.junit.jupiter.api.Test
    public void junitExceptionTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("Test exception");
        });
        assertEquals("Test exception", exception.getMessage());
        System.out.println("JUnit exception test passed");
    }

    @org.testng.annotations.Test(expectedExceptions = IllegalArgumentException.class, description = "TestNG exception test")
    public void testngExceptionTest() {
        throw new IllegalArgumentException("Test exception");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("JUnit Timeout Test")
    public void junitTimeoutTest() throws InterruptedException {
        assertTimeout(java.time.Duration.ofSeconds(1), () -> {
            Thread.sleep(500);
        });
        System.out.println("JUnit timeout test passed");
    }
}
