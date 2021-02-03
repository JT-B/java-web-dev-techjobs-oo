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

    @Before
    public void createJobObject() {
        testJobOne = new Job();
        testJobTwo = new Job();
        testJobFullConstructor = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJobForEqualityTest = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
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


}
