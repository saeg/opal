/**
 * OPAL - Open-source Program Analysis Library
 * Copyright (c) 2014, 2015 University of Sao Paulo
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. Neither the name of the copyright holders nor the names of its
 *    contributors may be used to endorse or promote products derived from
 *    this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */
package br.usp.each.saeg.opal.requirement;

import static br.usp.each.saeg.opal.requirement.Util.cdua;
import static br.usp.each.saeg.opal.requirement.Util.contains;
import static br.usp.each.saeg.opal.requirement.Util.pdua;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestMaxProgramDuasShould extends AMaxProgram {

    private Dua[] duas;

    @Before
    public void init() {
        duas = new DepthFirstDuaAnalyzer().analyze(program.getGraph(), program.numOfVariables());
    }

    @Test
    public void haveTwentySixDuas() {
        Assert.assertEquals(23, duas.length);
    }

    @Test
    public void haveAnDefinitionAt0AndUseAt5OfVariableMax() {
        Assert.assertTrue(contains(cdua(0, 5, program.variable("max")), duas));
    }

    @Test
    public void haveAnDefinitionAt4AndUseAt2To3OfVariableI() {
        Assert.assertTrue(contains(pdua(4, 2, 3, program.variable("i")), duas));
    }

    @Test
    public void haveAnDefinitionAt4AndUseAt2To4OfVariableI() {
        Assert.assertTrue(contains(pdua(4, 2, 4, program.variable("i")), duas));
    }

    @Test
    public void haveAnDefinitionAt3AndUseAt2To3OfVariableMax() {
        Assert.assertTrue(contains(pdua(3, 2, 3, program.variable("max")), duas));
    }

    @Test
    public void haveAnDefinitionAt3AndUseAt2To4OfVariableMax() {
        Assert.assertTrue(contains(pdua(3, 2, 4, program.variable("max")), duas));
    }

    @Test
    public void haveAnDefinitionAt0AndUseAt2To4OfVariableMax() {
        Assert.assertTrue(contains(pdua(0, 2, 4, program.variable("max")), duas));
    }

    @Test
    public void haveAnDefinitionAt0AndUseAt2To3OfVariableMax() {
        Assert.assertTrue(contains(pdua(0, 2, 3, program.variable("max")), duas));
    }

    @Test
    public void haveAnDefinitionAt0AndUseAt2To3OfVariableI() {
        Assert.assertTrue(contains(pdua(0, 2, 3, program.variable("i")), duas));
    }

    @Test
    public void haveAnDefinitionAt0AndUseAt2To4OfVariableI() {
        Assert.assertTrue(contains(pdua(0, 2, 4, program.variable("i")), duas));
    }

    @Test
    public void haveAnDefinitionAt0AndUseAt2To4OfVariableArray() {
        Assert.assertTrue(contains(pdua(0, 2, 4, program.variable("array")), duas));
    }

    @Test
    public void haveAnDefinitionAt0AndUseAt2To3OfVariableArray() {
        Assert.assertTrue(contains(pdua(0, 2, 3, program.variable("array")), duas));
    }

    @Test
    public void haveAnDefinitionAt4AndUseAt1To5OfVariableI() {
        Assert.assertTrue(contains(pdua(4, 1, 5, program.variable("i")), duas));
    }

    @Test
    public void haveAnDefinitionAt4AndUseAt1To2OfVariableI() {
        Assert.assertTrue(contains(pdua(4, 1, 2, program.variable("i")), duas));
    }

    @Test
    public void haveAnDefinitionAt0AndUseAt1To5OfVariableI() {
        Assert.assertTrue(contains(pdua(0, 1, 5, program.variable("i")), duas));
    }

    @Test
    public void haveAnDefinitionAt0AndUseAt1To2OfVariableI() {
        Assert.assertTrue(contains(pdua(0, 1, 2, program.variable("i")), duas));
    }

    @Test
    public void haveAnDefinitionAt0AndUseAt1To5OfVariableArray() {
        Assert.assertTrue(contains(pdua(0, 1, 5, program.variable("length")), duas));
    }

    @Test
    public void haveAnDefinitionAt0AndUseAt1To2OfVariableArray() {
        Assert.assertTrue(contains(pdua(0, 1, 2, program.variable("length")), duas));
    }

    @Test
    public void haveAnDefinitionAt4AndUseAt3OfVariableI() {
        Assert.assertTrue(contains(cdua(4, 3, program.variable("i")), duas));
    }

    @Test
    public void haveAnDefinitionAt0AndUseAt4OfVariableI() {
        Assert.assertTrue(contains(cdua(0, 4, program.variable("i")), duas));
    }

    @Test
    public void haveAnDefinitionAt0AndUseAt3OfVariableI() {
        Assert.assertTrue(contains(cdua(0, 3, program.variable("i")), duas));
    }

    @Test
    public void haveAnDefinitionAt0AndUseAt3OfVariableArray() {
        Assert.assertTrue(contains(cdua(0, 3, program.variable("array")), duas));
    }

    @Test
    public void haveAnDefinitionAt3AndUseAt5OfVariableMax() {
        Assert.assertTrue(contains(cdua(3, 5, program.variable("max")), duas));
    }

    @Test
    public void haveAnDefinitionAt4AndUseAt4OfVariableI() {
        Assert.assertTrue(contains(cdua(4, 4, program.variable("i")), duas));
    }

}
