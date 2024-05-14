package com.simsetuplab.backend.model.setupValidator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidateElectronicsTest {
    ValidateElectronics validateElectronics;

    @BeforeEach
    void setUp() {
        validateElectronics = ValidateElectronics.builder()
                .id(1L)
                .tractionControlMin(0)
                .tractionControlMax(10)
                .absMin(0)
                .absMax(10)
                .ecuMapMin(1)
                .ecuMapMax(8)
                .telemetryLapsMin(0)
                .telemetryLapsMax(99)
                .errorList(new ArrayList<>())
                .build();
    }

    @Test
    public void validateTractionControlValidTest() {
        validateElectronics.validateTractionControl(5);

        assertEquals(0, validateElectronics.getErrorList().size());
    }

    @Test
    public void validateTractionControlMinValueTest() {
        validateElectronics.validateTractionControl(0);

        assertEquals(0, validateElectronics.getErrorList().size());
    }

    @Test
    public void validateTractionControlMaxValueTest() {
        validateElectronics.validateTractionControl(10);

        assertEquals(0, validateElectronics.getErrorList().size());
    }

    @Test
    public void validateTractionControlInvalidTest() {
        validateElectronics.validateTractionControl(11);

        assertEquals(1, validateElectronics.getErrorList().size());
    }

    @Test
    public void validateTractionControlErrorTest() {
        validateElectronics.validateTractionControl(11);

        assert validateElectronics.getErrorList().contains("traction control");
    }

    @Test
    public void validateAbsValidTest() {
        validateElectronics.validateAbs(5);

        assertEquals(0, validateElectronics.getErrorList().size());
    }

    @Test
    public void validateAbsMinValueTest() {
        validateElectronics.validateAbs(0);

        assertEquals(0, validateElectronics.getErrorList().size());
    }

    @Test
    public void validateAbsMaxValueTest() {
        validateElectronics.validateAbs(10);

        assertEquals(0, validateElectronics.getErrorList().size());
    }

    @Test
    public void validateAbsInvalidTest() {
        validateElectronics.validateAbs(11);

        assertEquals(1, validateElectronics.getErrorList().size());
    }

    @Test
    public void validateAbsErrorTest() {
        validateElectronics.validateAbs(11);

        assert validateElectronics.getErrorList().contains("abs");
    }

    @Test
    public void validateEcuMapValidTest() {
        validateElectronics.validateEcuMap(5);

        assertEquals(0, validateElectronics.getErrorList().size());
    }

    @Test
    public void validateEcuMapMinValueTest() {
        validateElectronics.validateEcuMap(1);

        assertEquals(0, validateElectronics.getErrorList().size());
    }

    @Test
    public void validateEcuMapMaxValueTest() {
        validateElectronics.validateEcuMap(8);

        assertEquals(0, validateElectronics.getErrorList().size());
    }

    @Test
    public void validateEcuMapInvalidTest() {
        validateElectronics.validateEcuMap(9);

        assertEquals(1, validateElectronics.getErrorList().size());
    }

    @Test
    public void validateEcuMapErrorTest() {
        validateElectronics.validateEcuMap(9);

        assert validateElectronics.getErrorList().contains("ECU map");
    }

    @Test
    public void validateTelemetryLapsValidTest() {
        validateElectronics.validateTelemetryLaps(50);

        assertEquals(0, validateElectronics.getErrorList().size());
    }

    @Test
    public void validateTelemetryLapsMinValueTest() {
        validateElectronics.validateTelemetryLaps(0);

        assertEquals(0, validateElectronics.getErrorList().size());
    }

    @Test
    public void validateTelemetryLapsMaxValueTest() {
        validateElectronics.validateTelemetryLaps(99);

        assertEquals(0, validateElectronics.getErrorList().size());
    }

    @Test
    public void validateTelemetryLapsInvalidTest() {
        validateElectronics.validateTelemetryLaps(100);

        assertEquals(1, validateElectronics.getErrorList().size());
    }

    @Test
    public void validateTelemetryLapsErrorTest() {
        validateElectronics.validateTelemetryLaps(100);

        assert validateElectronics.getErrorList().contains("telemetry laps");
    }
}
