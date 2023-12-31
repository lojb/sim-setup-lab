package com.simsetuplab.backend.service;

import com.simsetuplab.backend.enumeration.carsetup.CarType;
import com.simsetuplab.backend.enumeration.carsetup.SetupType;
import com.simsetuplab.backend.enumeration.carsetup.Tracks;
import com.simsetuplab.backend.exception.ApiRequestException;
import com.simsetuplab.backend.model.setup.EnumData;
import com.simsetuplab.backend.model.setup.Setup;
import com.simsetuplab.backend.model.setup.SetupDto;
import com.simsetuplab.backend.model.setupValidator.ValidateSetup;
import com.simsetuplab.backend.model.user.User;
import com.simsetuplab.backend.repository.SetupRepository;
import com.simsetuplab.backend.repository.UserRepository;
import com.simsetuplab.backend.repository.ValidateSetupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class SetupService {
    private final SetupRepository setupRepository;
    private final UserRepository userRepository;

    private final ValidateSetupRepository validateSetupRepository;

    @Autowired
    public SetupService(SetupRepository setupRepository, UserRepository userRepository, ValidateSetupRepository validateSetupRepository) {
        this.setupRepository = setupRepository;
        this.userRepository = userRepository;
        this.validateSetupRepository = validateSetupRepository;
    }

    public List<Setup> getAllSetups() {
        return setupRepository.findAll();
    }

    public Setup getSetupById(Long id) {
        return setupRepository.findSetupById(id);
    }

    public List<Setup> getSetupsByUserId(Long id) {
        return setupRepository.findAllByUserId(id);
    }

    public List<Setup> getCustomSetupsByUserId(Long id) {
        return setupRepository.findAllByUserIdAndSetupType(id, SetupType.CUSTOM);
    }

    public Setup addOrUpdateSetup(SetupDto setupDto) {
        Setup setup = convertDtoToSetup(setupDto);

        ValidateSetup validator = this.validateSetupRepository.getValidatorByCarType(setup.getCarType());

        List<String> errorList = validator.validate(setup);

        if (errorList.isEmpty()) {
            return setupRepository.save(setup);
        } else {
            throw new ApiRequestException("The following fields are invalid: " + errorList);
        }

    }

    public void deleteSetup(Setup setup) {
        setupRepository.delete(setup);
    }

    public EnumData getEnumData() {
        List<CarType> cars = Arrays.asList(CarType.values());
        List<Tracks> tracks = Arrays.asList(Tracks.values());

        return new EnumData(cars, tracks);
    }

    public Setup getDefaultSetup(String trackString, String carString) {
        Tracks track = Tracks.valueOf(trackString);
        CarType carType = CarType.valueOf(carString);

        return setupRepository.findSetupBySetupTypeAndTrackAndCarType(SetupType.DEFAULT, track, carType);
    }

    public Setup convertDtoToSetup(SetupDto setupDto) {
        Optional<User> user = userRepository.findUserById(setupDto.getUserId());

        if (user.isPresent()) {
            return new Setup().convertDtoToSetup(setupDto, user.get());
        } else {
            throw new ApiRequestException("User does not exist");
        }
    }

    public List<SetupDto> mapSetupListToSetupDtoList(List<Setup> setupList) {
        return setupList.stream().map(Setup::convertSetupToDto).toList();
    }
}
