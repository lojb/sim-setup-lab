package com.simsetuplab.backend.model.setup;

import java.util.List;
import com.simsetuplab.backend.enumeration.carsetup.CarType;
import com.simsetuplab.backend.enumeration.carsetup.Tracks;

public class EnumData {
	public List<CarType> cars;
	public List<Tracks> tracks;

	public EnumData(List<CarType> carTypes, List<Tracks> tracks) {
		this.cars = carTypes;
		this.tracks = tracks;
	}
}
