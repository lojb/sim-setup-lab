package com.simsetuplab.backend.service;

import com.simsetuplab.backend.model.setup.Setup;
import com.simsetuplab.backend.model.user.User;
import com.simsetuplab.backend.repository.SetupRepository;
import com.simsetuplab.backend.repository.UserRepository;
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
class SetupServiceTest {

    @Mock
    SetupRepository setupRepository;
    @Mock
    UserRepository userRepository;
    @Mock
    ValidateSetupRepository validateSetupRepository;

    SetupService setupService;

    @BeforeEach
    void setUp() {
        setupService = new SetupService(setupRepository, userRepository, validateSetupRepository);
    }

    @Test
    void getAllSetupsInvokesFindAll() {
        setupService.getAllSetups();

        verify(setupRepository).findAll();
    }

    @Test
    void getAllSetupsNotNull() {
        List<Setup> setups = Arrays.asList(new Setup(), new Setup());
        when(setupRepository.findAll()).thenReturn(setups);

        List<Setup> result = setupService.getAllSetups();

        assertNotNull(result);
    }

    @Test
    void getAllSetupsExpectedSize() {
        List<Setup> setups = Arrays.asList(new Setup(), new Setup());
        when(setupRepository.findAll()).thenReturn(setups);

        List<Setup> result = setupService.getAllSetups();

        assertEquals(setups.size(), result.size());
    }

    @Test
    void getSetupByIdInvokesFindSetupById() {
        Long id = 26L;
        Setup setup = new Setup();
        setup.setId(id);
        when(setupRepository.findSetupById(id)).thenReturn(setup);

        setupService.getSetupById(id);

        verify(setupRepository).findSetupById(id);
    }

    @Test
    void getSetupByIdReturnsSetup() {
        Long id = 26L;
        Setup expected = new Setup();
        expected.setId(id);
        when(setupRepository.findSetupById(id)).thenReturn(expected);

        Setup result = setupService.getSetupById(id);

        assertEquals(expected, result);
    }

    @Test
    void getSetupsByUserIdInvokesFindAllByUserId() {
        Long userId = 33L;
        setupService.getSetupsByUserId(userId);

        verify(setupRepository).findAllByUserId(userId);
    }

    @Test
    void addOrUpdateSetup() {
    }

    @Test
    void deleteSetup() {
    }

    @Test
    void getEnumData() {
    }

    @Test
    void getDefaultSetup() {
    }

    @Test
    void convertDtoToSetup() {
    }
}