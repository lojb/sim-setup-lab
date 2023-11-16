package com.simsetuplab.backend.service;

import com.simsetuplab.backend.enumeration.carsetup.CarType;
import com.simsetuplab.backend.model.setupValidator.ValidateSetup;
import com.simsetuplab.backend.repository.ValidateSetupRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ValidateSetupServiceTest {
    @Mock
    ValidateSetupRepository validateSetupRepository;

    ValidateSetupService validateSetupService;

    ValidateSetup testValidator = ValidateSetup.builder()
            .id(48L)
            .carType(CarType.PORSCHE_992_GT3_R)
            .build();

    @BeforeEach
    void setUp() {
        validateSetupService = new ValidateSetupService(validateSetupRepository);
    }

    @Test
    void getAllValidatorsInvokesFindAll() {
        validateSetupService.getAllValidators();

        verify(validateSetupRepository).findAll();
    }

    @Test
    void getAllValidatorsNotNull() {
        List<ValidateSetup> list = Arrays.asList(new ValidateSetup(), new ValidateSetup());
        when(validateSetupRepository.findAll()).thenReturn(list);

        List<ValidateSetup> result = validateSetupService.getAllValidators();

        assertNotNull(result);
    }

    @Test
    void getAllValidatorsReturnsExpected() {
        List<ValidateSetup> expected = Arrays.asList(new ValidateSetup(), new ValidateSetup());
        when(validateSetupRepository.findAll()).thenReturn(expected);

        List<ValidateSetup> result = validateSetupService.getAllValidators();

        assertEquals(expected, result);
    }

    @Test
    void getValidatorByCarTypeInvokesGetValidatorByCarType() {
        CarType carType = CarType.PORSCHE_992_GT3_R;

        validateSetupService.getValidatorByCarType(carType);

        verify(validateSetupRepository).getValidatorByCarType(carType);
    }

    @Test
    void getValidatorByCarTypeNotNull() {
        CarType carType = CarType.PORSCHE_992_GT3_R;
        when(validateSetupRepository.getValidatorByCarType(carType)).thenReturn(testValidator);

        ValidateSetup result = validateSetupService.getValidatorByCarType(carType);

        assertNotNull(result);
    }

    @Test
    void getValidatorByCarTypeReturnsTestValidator() {
        CarType carType = CarType.PORSCHE_992_GT3_R;
        when(validateSetupRepository.getValidatorByCarType(carType)).thenReturn(testValidator);

        ValidateSetup result = validateSetupService.getValidatorByCarType(carType);

        assertEquals(testValidator, result);
    }

    @Test
    void addOrUpdateValidatorInvokesSave() {
        validateSetupService.addOrUpdateValidator(testValidator);

        verify(validateSetupRepository).save(testValidator);
    }

    @Test
    void addOrUpdateValidatorReturnsValidator() {
        when(validateSetupRepository.save(testValidator)).thenReturn(testValidator);
        ValidateSetup result = validateSetupService.addOrUpdateValidator(testValidator);

        assertEquals(testValidator, result);
    }

    @Test
    void deleteValidatorInvokesDelete() {
        validateSetupService.deleteValidator(testValidator);

        verify(validateSetupRepository).delete(testValidator);
    }
}