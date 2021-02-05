package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.launchcode.techjobs_oo.*;


public class JobTest {

    Job testJobOne;
    Job testJobTwo;
    Job testJobFullConstructor;
    Job testJobForEqualityTest;
    Job testJobForEmptyField;

    @Before
    public void createJobObject() {
        testJobOne = new Job();
        testJobTwo = new Job();
        testJobFullConstructor = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJobForEqualityTest = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJobForEmptyField = new Job("", new Employer(""), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        assertFalse(testJobOne.getId() == testJobTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(testJobFullConstructor instanceof Job);
        assertEquals("Product tester", testJobFullConstructor.getName());
        assertEquals("ACME", testJobFullConstructor.getEmployer().toString());
        assertEquals("Desert", testJobFullConstructor.getLocation().toString());
        assertEquals("Quality control", testJobFullConstructor.getPositionType().toString());
        assertEquals("Persistence", testJobFullConstructor.getCoreCompetency().toString());
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(testJobFullConstructor.equals(testJobForEqualityTest));
    }

    @Test
    public void testJobForBlankLine() {
        assertTrue(testJobFullConstructor.toString().startsWith("     "));
        assertTrue(testJobFullConstructor.toString().endsWith("     "));
    }

    @Test
    public void testJobForLabelAndData() {
        assertTrue(testJobFullConstructor.toString().contains("ID: 13" + "\n"));
        assertTrue(testJobFullConstructor.toString().contains("Name: Product tester" + "\n"));
        assertTrue(testJobFullConstructor.toString().contains("Employer: ACME" + "\n"));
        assertTrue(testJobFullConstructor.toString().contains("Location: Desert" + "\n"));
        assertTrue(testJobFullConstructor.toString().contains("Position Type: Quality control" + "\n"));
        assertTrue(testJobFullConstructor.toString().contains("Core Competency: Persistence" + "\n"));
    }

    @Test
    public void testJobForResponseToEmptyField() {
        assertTrue(testJobForEmptyField.toString().contains("Name: Data not available"));
        assertTrue(testJobForEmptyField.toString().contains("Employer: Data not available"));
        assertTrue(testJobForEmptyField.toString().contains("Location: Data not available"));
    }

    @Test
    public void testJobForResp0nseToOnlyID() {
        assertTrue(testJobOne.toString().contains("OOPS! This job does not seem to exist."));
    }


}
