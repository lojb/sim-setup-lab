package com.simsetuplab.backend.model.setupValidator;

import com.simsetuplab.backend.enumeration.carsetup.TyreType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidateFuelStrategyTest {
    ValidateFuelStrategy validateFuelStrategy;

    @BeforeEach
    void setUp() {
        validateFuelStrategy = ValidateFuelStrategy.builder()
                .id(1L)
                .fuelMin(2)
                .fuelMax(120)
                .tyreType(TyreType.DRY)
                .brakesMin(1)
                .brakesMax(4)
                .fuelPerLap(3)
                .errorList(new ArrayList<>())
                .build();
    }

    @Test
    public void validateFuelValidTest() {
        validateFuelStrategy.validateFuel(50);

        assertEquals(0, validateFuelStrategy.getErrorList().size());
    }

    @Test
    public void validateFuelMinValueTest() {
        validateFuelStrategy.validateFuel(2);

        assertEquals(0, validateFuelStrategy.getErrorList().size());
    }

    @Test
    public void validateFuelMaxValueTest() {
        validateFuelStrategy.validateFuel(120);

        assertEquals(0, validateFuelStrategy.getErrorList().size());
    }

    @Test
    public void validateFuelInvalidTest() {
        validateFuelStrategy.validateFuel(121);

        assertEquals(1, validateFuelStrategy.getErrorList().size());
    }

    @Test
    public void validateFuelErrorTest() {
        validateFuelStrategy.validateFuel(121);

        assert validateFuelStrategy.getErrorList().contains("fuel value");
    }

    @Test
    public void validateBrakesValidTest() {
        validateFuelStrategy.validateBrakes(3);

        assertEquals(0, validateFuelStrategy.getErrorList().size());
    }

    @Test
    public void validateBrakesMinValueTest() {
        validateFuelStrategy.validateBrakes(1);

        assertEquals(0, validateFuelStrategy.getErrorList().size());
    }

    @Test
    public void validateBrakesMaxValueTest() {
        validateFuelStrategy.validateBrakes(4);

        assertEquals(0, validateFuelStrategy.getErrorList().size());
    }

    @Test
    public void validateBrakesInvalidTest() {
        validateFuelStrategy.validateBrakes(5);

        assertEquals(1, validateFuelStrategy.getErrorList().size());
    }

    @Test
    public void validateBrakesErrorTest() {
        validateFuelStrategy.validateBrakes(5);

        assert validateFuelStrategy.getErrorList().contains("brakes values");
    }
}
