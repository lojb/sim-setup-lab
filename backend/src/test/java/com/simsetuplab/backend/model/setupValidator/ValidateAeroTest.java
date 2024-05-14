package com.simsetuplab.backend.model.setupValidator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ValidateAeroTest {

    ValidateAero validateAero;
    @BeforeEach
    void setUp() {
        validateAero = ValidateAero.builder()
                .id(1L)
                .frontRideHeightMin(0)
                .frontRideHeightMax(50)
                .rearRideHeightMin(10)
                .rearRideHeightMax(60)
                .splitterMin(0)
                .splitterMax(5)
                .rearWingMin(0)
                .rearWingMax(10)
                .frontBrakeDuctsMin(0)
                .frontBrakeDuctsMax(4)
                .rearBrakeDuctsMin(0)
                .rearBrakeDuctsMax(4)
                .errorList(new ArrayList<>())
                .build();
    }

    @Test
    public void validateFrontRideHeightValidTest() {
        validateAero.validateFrontRideHeight(20);

        assertEquals(0, validateAero.getErrorList().size());
    }
    @Test
    public void validateFrontRideHeightMinValueTest() {
        validateAero.validateFrontRideHeight(0);

        assertEquals(0, validateAero.getErrorList().size());
    }
    @Test
    public void validateFrontRideHeightMaxValueTest() {
        validateAero.validateFrontRideHeight(50);

        assertEquals(0, validateAero.getErrorList().size());
    }

    @Test
    public void validateFrontRideHeightInvalidTest() {
        validateAero.validateFrontRideHeight(99);

        assertEquals(1, validateAero.getErrorList().size());
    }
    @Test
    public void validateFrontRideHeightErrorTest() {
        validateAero.validateFrontRideHeight(99);

        assert validateAero.getErrorList().contains("front ride height");
    }
    @Test
    public void validateRearRideHeightValidTest() {
        validateAero.validateRearRideHeight(20);

        assertEquals(0, validateAero.getErrorList().size());
    }
    @Test
    public void validateRearRideHeightMinValueTest() {
        validateAero.validateRearRideHeight(10);

        assertEquals(0, validateAero.getErrorList().size());
    }
    @Test
    public void validateRearRideHeightMaxValueTest() {
        validateAero.validateRearRideHeight(60);

        assertEquals(0, validateAero.getErrorList().size());
    }

    @Test
    public void validateRearRideHeightInvalidTest() {
        validateAero.validateRearRideHeight(99);

        assertEquals(1, validateAero.getErrorList().size());
    }
    @Test
    public void validateRearRideHeightErrorTest() {
        validateAero.validateRearRideHeight(99);

        assert validateAero.getErrorList().contains("rear ride height");
    }

    @Test
    public void validateSplitterValidTest() {
        validateAero.validateSplitter(3);

        assertEquals(0, validateAero.getErrorList().size());
    }
    @Test
    public void validateSplitterMinValueTest() {
        validateAero.validateSplitter(0);

        assertEquals(0, validateAero.getErrorList().size());
    }
    @Test
    public void validateSplitterMaxValueTest() {
        validateAero.validateSplitter(5);

        assertEquals(0, validateAero.getErrorList().size());
    }

    @Test
    public void validateSplitterInvalidTest() {
        validateAero.validateSplitter(99);

        assertEquals(1, validateAero.getErrorList().size());
    }
    @Test
    public void validateSplitterErrorTest() {
        validateAero.validateSplitter(99);

        assert validateAero.getErrorList().contains("splitter");
    }

    @Test
    public void validateRearWingValidTest() {
        validateAero.validateRearWing(3);

        assertEquals(0, validateAero.getErrorList().size());
    }
    @Test
    public void validateRearWingMinValueTest() {
        validateAero.validateRearWing(0);

        assertEquals(0, validateAero.getErrorList().size());
    }
    @Test
    public void validateRearWingMaxValueTest() {
        validateAero.validateRearWing(10);

        assertEquals(0, validateAero.getErrorList().size());
    }

    @Test
    public void validateRearWingInvalidTest() {
        validateAero.validateRearWing(99);

        assertEquals(1, validateAero.getErrorList().size());
    }
    @Test
    public void validateRearWingErrorTest() {
        validateAero.validateRearWing(99);

        assert validateAero.getErrorList().contains("rear wing");
    }

    @Test
    public void validateFrontBrakeDuctsValidTest() {
        validateAero.validateFrontBrakeDucts(3);

        assertEquals(0, validateAero.getErrorList().size());
    }
    @Test
    public void validateFrontBrakeDuctsMinValueTest() {
        validateAero.validateFrontBrakeDucts(0);

        assertEquals(0, validateAero.getErrorList().size());
    }
    @Test
    public void validateFrontBrakeDuctsMaxValueTest() {
        validateAero.validateFrontBrakeDucts(4);

        assertEquals(0, validateAero.getErrorList().size());
    }

    @Test
    public void validateFrontBrakeDuctsInvalidTest() {
        validateAero.validateFrontBrakeDucts(99);

        assertEquals(1, validateAero.getErrorList().size());
    }
    @Test
    public void validateFrontBrakeDuctsErrorTest() {
        validateAero.validateFrontBrakeDucts(99);

        assert validateAero.getErrorList().contains("front brake ducts");
    }

    @Test
    public void validateRearBrakeDuctsValidTest() {
        validateAero.validateRearBrakeDucts(3);

        assertEquals(0, validateAero.getErrorList().size());
    }
    @Test
    public void validateRearBrakeDuctsMinValueTest() {
        validateAero.validateRearBrakeDucts(0);

        assertEquals(0, validateAero.getErrorList().size());
    }
    @Test
    public void validateRearBrakeDuctsMaxValueTest() {
        validateAero.validateRearBrakeDucts(4);

        assertEquals(0, validateAero.getErrorList().size());
    }

    @Test
    public void validateRearBrakeDuctsInvalidTest() {
        validateAero.validateRearBrakeDucts(99);

        assertEquals(1, validateAero.getErrorList().size());
    }
    @Test
    public void validateRearBrakeDuctsErrorTest() {
        validateAero.validateRearBrakeDucts(99);

        assert validateAero.getErrorList().contains("rear brake ducts");
    }
}
