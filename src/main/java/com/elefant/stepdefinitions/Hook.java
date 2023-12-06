package com.elefant.stepdefinitions;

import com.elefant.managers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hook {
    private static final Logger logger = LogManager.getLogger(Hook.class);


    @BeforeAll
    public static void theMethodExecutedBeforeAllTest(){
        logger.log(Level.INFO, "The test execution started");
    }


    @Before
    public void beforeEachTest(){
        logger.log(Level.INFO, "A new test execution started");
    }

    @After
    public void afterEachTest(){
        DriverManager.getInstance().deleteCookies();
        logger.log(Level.INFO, "A test execution just finished");
    }

    @AfterAll
    public static void afterAll(){
        DriverManager.getInstance().tearDown();
        logger.log(Level.INFO, "The test execution has been finished");
    }


}
