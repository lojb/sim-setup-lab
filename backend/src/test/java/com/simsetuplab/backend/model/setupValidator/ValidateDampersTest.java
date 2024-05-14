package com.simsetuplab.backend.model.setupValidator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidateDampersTest {

    ValidateDampers validateDampers;

    @BeforeEach
    void setUp() {
        validateDampers = ValidateDampers.builder()
                .id(1L)
                .frontBumpMin(0)
                .frontBumpMax(11)
                .frontFastBumpMin(0)
                .frontFastBumpMax(11)
                .frontReboundMin(0)
                .frontReboundMax(11)
                .frontFastReboundMin(0)
                .frontFastReboundMax(11)
                .rearBumpMin(0)
                .rearBumpMax(11)
                .rearFastBumpMin(0)
                .rearFastBumpMax(11)
                .rearReboundMin(0)
                .rearReboundMax(11)
                .rearFastReboundMin(0)
                .rearFastReboundMax(11)
                .errorList(new ArrayList<>())
                .build();
    }

    @Test
    public void validateFrontBumpValidTest() {
        validateDampers.validateFrontBump(5, 5);

        assertEquals(0, validateDampers.getErrorList().size());
    }

    @Test
    public void validateFrontBumpMinValueTest() {
        validateDampers.validateFrontBump(0, 0);

        assertEquals(0, validateDampers.getErrorList().size());
    }

    @Test
    public void validateFrontBumpMaxValueTest() {
        validateDampers.validateFrontBump(11, 11);

        assertEquals(0, validateDampers.getErrorList().size());
    }

    @Test
    public void validateFrontBumpInvalidTest() {
        validateDampers.validateFrontBump(99, 99);

        assertEquals(1, validateDampers.getErrorList().size());
    }

    @Test
    public void validateFrontBumpErrorTest() {
        validateDampers.validateFrontBump(99, 99);

        assert validateDampers.getErrorList().contains("front bump");
    }

    @Test
    public void validateFrontFastBumpValidTest() {
        validateDampers.validateFrontFastBump(6, 6);

        assertEquals(0, validateDampers.getErrorList().size());
    }

    @Test
    public void validateFrontFastBumpMinValueTest() {
        validateDampers.validateFrontFastBump(0, 0);

        assertEquals(0, validateDampers.getErrorList().size());
    }

    @Test
    public void validateFrontFastBumpMaxValueTest() {
        validateDampers.validateFrontFastBump(11, 11);

        assertEquals(0, validateDampers.getErrorList().size());
    }

    @Test
    public void validateFrontFastBumpInvalidTest() {
        validateDampers.validateFrontFastBump(99, 99);

        assertEquals(1, validateDampers.getErrorList().size());
    }

    @Test
    public void validateFrontFastBumpErrorTest() {
        validateDampers.validateFrontFastBump(99, 99);

        assert validateDampers.getErrorList().contains("front fast bump");
    }

    @Test
    public void validateFrontReboundValidTest() {
        validateDampers.validateFrontRebound(3, 3);

        assertEquals(0, validateDampers.getErrorList().size());
    }

    @Test
    public void validateFrontReboundMinValueTest() {
        validateDampers.validateFrontRebound(0, 0);

        assertEquals(0, validateDampers.getErrorList().size());
    }

    @Test
    public void validateFrontReboundMaxValueTest() {
        validateDampers.validateFrontRebound(11, 11);

        assertEquals(0, validateDampers.getErrorList().size());
    }

    @Test
    public void validateFrontReboundInvalidTest() {
        validateDampers.validateFrontRebound(99, 99);

        assertEquals(1, validateDampers.getErrorList().size());
    }

    @Test
    public void validateFrontReboundErrorTest() {
        validateDampers.validateFrontRebound(99, 99);

        assert validateDampers.getErrorList().contains("front rebound");
    }

    @Test
    public void validateFrontFastReboundValidTest() {
        validateDampers.validateFrontFastRebound(5, 5);

        assertEquals(0, validateDampers.getErrorList().size());
    }

    @Test
    public void validateFrontFastReboundMinValueTest() {
        validateDampers.validateFrontFastRebound(0, 0);

        assertEquals(0, validateDampers.getErrorList().size());
    }

    @Test
    public void validateFrontFastReboundMaxValueTest() {
        validateDampers.validateFrontFastRebound(11, 11);

        assertEquals(0, validateDampers.getErrorList().size());
    }

    @Test
    public void validateFrontFastReboundInvalidTest() {
        validateDampers.validateFrontFastRebound(12, 12);

        assertEquals(1, validateDampers.getErrorList().size());
    }

    @Test
    public void validateFrontFastReboundErrorTest() {
        validateDampers.validateFrontFastRebound(12, 12);

        assert validateDampers.getErrorList().contains("front fast rebound");
    }

    @Test
    public void validateRearBumpValidTest() {
        validateDampers.validateRearBump(5, 5);

        assertEquals(0, validateDampers.getErrorList().size());
    }

    @Test
    public void validateRearBumpMinValueTest() {
        validateDampers.validateRearBump(0, 0);

        assertEquals(0, validateDampers.getErrorList().size());
    }

    @Test
    public void validateRearBumpMaxValueTest() {
        validateDampers.validateRearBump(11, 11);

        assertEquals(0, validateDampers.getErrorList().size());
    }

    @Test
    public void validateRearBumpInvalidTest() {
        validateDampers.validateRearBump(12, 12);

        assertEquals(1, validateDampers.getErrorList().size());
    }

    @Test
    public void validateRearBumpErrorTest() {
        validateDampers.validateRearBump(12, 12);

        assert validateDampers.getErrorList().contains("rear bump");
    }

    @Test
    public void validateRearFastBumpValidTest() {
        validateDampers.validateRearFastBump(5, 5);

        assertEquals(0, validateDampers.getErrorList().size());
    }

    @Test
    public void validateRearFastBumpMinValueTest() {
        validateDampers.validateRearFastBump(0, 0);

        assertEquals(0, validateDampers.getErrorList().size());
    }

    @Test
    public void validateRearFastBumpMaxValueTest() {
        validateDampers.validateRearFastBump(11, 11);

        assertEquals(0, validateDampers.getErrorList().size());
    }

    @Test
    public void validateRearFastBumpInvalidTest() {
        validateDampers.validateRearFastBump(12, 12);

        assertEquals(1, validateDampers.getErrorList().size());
    }

    @Test
    public void validateRearFastBumpErrorTest() {
        validateDampers.validateRearFastBump(12, 12);

        assert validateDampers.getErrorList().contains("rear fast bump");
    }

    @Test
    public void validateRearReboundValidTest() {
        validateDampers.validateRearRebound(5, 5);

        assertEquals(0, validateDampers.getErrorList().size());
    }

    @Test
    public void validateRearReboundMinValueTest() {
        validateDampers.validateRearRebound(0, 0);

        assertEquals(0, validateDampers.getErrorList().size());
    }

    @Test
    public void validateRearReboundMaxValueTest() {
        validateDampers.validateRearRebound(11, 11);

        assertEquals(0, validateDampers.getErrorList().size());
    }

    @Test
    public void validateRearReboundInvalidTest() {
        validateDampers.validateRearRebound(12, 12);

        assertEquals(1, validateDampers.getErrorList().size());
    }

    @Test
    public void validateRearReboundErrorTest() {
        validateDampers.validateRearRebound(12, 12);

        assert validateDampers.getErrorList().contains("rear rebound");
    }

    @Test
    public void validateRearFastReboundValidTest() {
        validateDampers.validateRearFastRebound(5, 5);

        assertEquals(0, validateDampers.getErrorList().size());
    }

    @Test
    public void validateRearFastReboundMinValueTest() {
        validateDampers.validateRearFastRebound(0, 0);

        assertEquals(0, validateDampers.getErrorList().size());
    }

    @Test
    public void validateRearFastReboundMaxValueTest() {
        validateDampers.validateRearFastRebound(11, 11);

        assertEquals(0, validateDampers.getErrorList().size());
    }

    @Test
    public void validateRearFastReboundInvalidTest() {
        validateDampers.validateRearFastRebound(12, 12);

        assertEquals(1, validateDampers.getErrorList().size());
    }

    @Test
    public void validateRearFastReboundErrorTest() {
        validateDampers.validateRearFastRebound(12, 12);

        assert validateDampers.getErrorList().contains("rear fast rebound");
    }
}
