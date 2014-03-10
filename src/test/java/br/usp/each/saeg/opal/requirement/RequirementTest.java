package br.usp.each.saeg.opal.requirement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RequirementTest {

    private Requirement requirement;

    @Before
    public void setUp() {
        requirement = new Requirement();
    }

    @Test
    public void testNewlyCreatedRequirementIsNotCovered() {
        Assert.assertFalse(requirement.isCovered());
    }

    @Test
    public void testCover() {
        requirement.cover();
        Assert.assertTrue(requirement.isCovered());
    }

}
