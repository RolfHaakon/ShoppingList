package com.example.shoppinglist;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {

    @Test
    public void preferredCase() {
        String actual = MainActivity.preferredCase("hElLO");
        String expected = "Hello";
        assertEquals("failed", expected, actual);
    }
}