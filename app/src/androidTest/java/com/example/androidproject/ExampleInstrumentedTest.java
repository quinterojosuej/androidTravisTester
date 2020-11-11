package com.example.androidproject;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Test
    public void createUser(){
        User u = new User("My Name", "12345");
        assertEquals("My Name", u.getUsername());
        assertNotEquals("MY Name", u.getUsername());
        assertNotEquals("MyName", u.getUsername());
        assertNotEquals("", u.getUsername());
        assertNotEquals("Jerry", u.getUsername());
        assertEquals("12345", u.getPassword());
        assertNotEquals("1234", u.getPassword());
        assertNotEquals("", u.getPassword());
        assertNotEquals("Jerry", u.getPassword());

        User u2 = new User("Bono", "Vertigo");
        assertNotEquals("My Name", u2.getUsername());
        assertEquals("Bono", u2.getUsername());
        assertNotEquals("12345", u2.getPassword());
        assertEquals("Vertigo", u2.getPassword());
        //Not a U2 fan, just found a joke and went with it
    }

    @Test
    public void testUsernameCheck(){
        User u = new User("Tom", "password");
        assertEquals(true, Factory.checkUsername(u, "Tom"));
        assertEquals(false, Factory.checkUsername(u, "Billy"));
        assertNotEquals(false, Factory.checkUsername(u, "Tom"));
        assertNotEquals(true, Factory.checkUsername(u, "Bob"));
    }

    @Test
    public void testPasswordCheck(){
        User u = new User("Frank", "PattysPub");
        assertEquals(true, Factory.checkPassword(u, "PattysPub"));
        assertEquals(false, Factory.checkPassword(u, "Patty'sPub"));
    }

    @Test
    public void factoryMakeUserTest(){
        User u = Factory.makeUser();
        assertEquals("din_djarin", u.getUsername());
        assertEquals(true, Factory.checkUsername(u, "din_djarin"));
        assertEquals("baby_yoda_ftw", u.getPassword());
        assertEquals(true, Factory.checkPassword(u, "baby_yoda_ftw"));
    }
}
