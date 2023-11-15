package com.simsetuplab.backend.service;

import com.simsetuplab.backend.enumeration.carsetup.CarType;
import com.simsetuplab.backend.enumeration.carsetup.SetupType;
import com.simsetuplab.backend.enumeration.carsetup.Tracks;
import com.simsetuplab.backend.enumeration.user.Role;
import com.simsetuplab.backend.model.setup.EnumData;
import com.simsetuplab.backend.model.setup.Setup;
import com.simsetuplab.backend.model.setup.SetupDto;
import com.simsetuplab.backend.model.setup.setupvalues.*;
import com.simsetuplab.backend.model.user.User;
import com.simsetuplab.backend.repository.SetupRepository;
import com.simsetuplab.backend.repository.UserRepository;
import com.simsetuplab.backend.repository.ValidateSetupRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

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

    private final User testUser = User.builder()
            .username("test1")
            .email("test1@test.com")
            .role(Role.USER)
            .password("asd")
            .id(22L)
            .build();

    private final SetupDto testDto = SetupDto.builder()
            .name("testDto")
            .userId(55L)
            .carType("MERCEDES_AMG_GT3_EVO")
            .track("BARCELONA")
            .setupType("CUSTOM")
            .aero(new Aero())
            .dampers(new Dampers())
            .electronics(new Electronics())
            .fuelStrategy(new FuelStrategy())
            .mechanicalGrip(new MechanicalGrip())
            .tyres(new Tyres())
            .build();
    private final Setup testSetup = Setup.builder()
            .id(55L)
            .name("testSetup")
            .user(testUser)
            .carType(CarType.MERCEDES_AMG_GT3_EVO)
            .track(Tracks.BARCELONA)
            .setupType(SetupType.CUSTOM)
            .aero(new Aero())
            .dampers(new Dampers())
            .electronics(new Electronics())
            .fuelStrategy(new FuelStrategy())
            .mechanicalGrip(new MechanicalGrip())
            .tyres(new Tyres())
            .build();

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
    void addOrUpdateSetupInvokesSave() {
        /*
        SetupDto setupDto = new SetupDto();

        Setup setup = new Setup(setupDto);
        ValidateSetup validateSetup = new ValidateSetup();
        when(validateSetupRepository.getValidatorByCarType(setup.getCarType())).thenReturn(validateSetup);
        when(userRepository.findUserById(setupDto.getUserId())).thenReturn(Optional.of(testUser));
        when(validateSetup.validate(setup)).thenReturn(new ArrayList<>());

        setupService.addOrUpdateSetup(setupDto);
        */
        /*
        SetupDto setupDto = new SetupDto();
        setupDto.setUserId(24L);
        when(userRepository.findUserById(any(Long.class))).thenReturn(Optional.of(testUser));
        when(setupService.convertDtoToSetup(setupDto)).thenReturn(testSetup);

        setupService.addOrUpdateSetup(setupDto);
         */
    }

    @Test
    void addOrUpdateSetupReturnsSetup() {
        /*
        SetupDto setupDto = new SetupDto();
        Setup setup = new Setup();
        when(setupService.convertDtoToSetup(setupDto)).thenReturn(setup);

        setupService.addOrUpdateSetup(setupDto);

        verify(setupRepository).save(setup);
         */
    }

    @Test
    void deleteSetupInvokesDelete() {
        setupService.deleteSetup(testSetup);

        verify(setupRepository).delete(testSetup);
    }

    @Test
    void getEnumDataNotNull() {
        EnumData result = setupService.getEnumData();

        assertNotNull(result);
    }

    @Test
    void getEnumDataCarsListSizeCorrect() {
        EnumData result = setupService.getEnumData();

        assertEquals(CarType.values().length, result.cars.size());
    }

    @Test
    void getEnumDataTracksListSizeCorrect() {
        EnumData result = setupService.getEnumData();

        assertEquals(Tracks.values().length, result.tracks.size());
    }

    @Test
    void getDefaultSetupConvertsTrack() {
        String track = testDto.getTrack();
        String car = testDto.getCarType();

        when(setupRepository.findSetupBySetupTypeAndTrackAndCarType(SetupType.DEFAULT, Tracks.valueOf(track), CarType.valueOf(car))).thenReturn(testSetup);
        Setup result = setupService.getDefaultSetup(track, car);

        assertEquals(result.getTrack(), Tracks.valueOf(track));
    }

    @Test
    void getDefaultSetupConvertsCar() {
        String track = testDto.getTrack();
        String car = testDto.getCarType();

        when(setupRepository.findSetupBySetupTypeAndTrackAndCarType(SetupType.DEFAULT, Tracks.valueOf(track), CarType.valueOf(car))).thenReturn(testSetup);
        Setup result = setupService.getDefaultSetup(track, car);

        assertEquals(result.getCarType(), CarType.valueOf(car));
    }

    @Test
    void convertDtoToSetupUserEqualsTestUser() {
        when(userRepository.findUserById(testDto.getUserId())).thenReturn(Optional.of(testUser));
        Setup result = setupService.convertDtoToSetup(testDto);

        assertEquals(testSetup.getUser(), result.getUser());
    }

    @Test
    void convertDtoToSetupCarTypeEqualsCarType() {
        when(userRepository.findUserById(testDto.getUserId())).thenReturn(Optional.of(testUser));
        Setup result = setupService.convertDtoToSetup(testDto);

        assertEquals(testSetup.getCarType(), result.getCarType());
    }
}