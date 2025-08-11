package com.app.Assertions;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

public class Assertions 
{
	public static void assertTrue(boolean condition, ExtentTest test, String message) {
        if (condition) {
            test.pass("✅ " + message);
        } else {
            test.fail("❌ " + message);
            Assert.fail(message);
        }
    }

    public static void assertFalse(boolean condition, ExtentTest test, String message) {
        if (!condition) {
            test.pass("✅ " + message);
        } else {
            test.fail("❌ " + message);
            Assert.fail(message);
        }
    }

    public static void assertEquals(String expected, String actual, ExtentTest test, String message) {
        if (expected.equals(actual)) {
            test.pass("✅ " + message + "<br>Expected: <b>" + expected + "</b><br>Actual: <b>" + actual + "</b>");
        } else {
            test.fail("❌ " + message + "<br>Expected: <b>" + expected + "</b><br>Actual: <b>" + actual + "</b>");
            Assert.fail(message + " | Expected: " + expected + ", Actual: " + actual);
        }
    }

    public static void assertNotEquals(String expected, String actual, ExtentTest test, String message) {
        if (!expected.equals(actual)) {
            test.pass("✅ " + message + "<br>Expected not to match Actual.<br>Expected: <b>" + expected + "</b><br>Actual: <b>" + actual + "</b>");
        } else {
            test.fail("❌ " + message + "<br>Expected not to match Actual.<br>But both are: <b>" + actual + "</b>");
            Assert.fail(message + " | Both values are equal: " + actual);
        }
    }

    public static void assertNull(Object obj, ExtentTest test, String message) {
        if (obj == null) {
            test.pass("✅ " + message + "<br>Value is <b>null</b> as expected.");
        } else {
            test.fail("❌ " + message + "<br>Expected <b>null</b> but found <b>" + obj + "</b>");
            Assert.fail(message + " | Value is not null.");
        }
    }

    public static void assertNotNull(Object obj, ExtentTest test, String message) {
        if (obj != null) {
            test.pass("✅ " + message + "<br>Value is <b>not null</b> as expected.");
        } else {
            test.fail("❌ " + message + "<br>Expected non-null value but found <b>null</b>");
            Assert.fail(message + " | Value is null.");
        }
    }

}
