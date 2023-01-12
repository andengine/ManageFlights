package flights.persistence;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import flights.model.*;

public class DataManager {
	private CitiesReader citiesReader;
	private AircraftsReader aircraftsReader;
	private FlightScheduleReader flightScheduleReader;

	private HashMap<String, Airport> airportMap;
	private HashMap<String, Aircraft> aircraftMap;
	private Collection<FlightSchedule> flightSchedules;

	public DataManager(CitiesReader citiesReader,
			AircraftsReader aircraftsReader,
			FlightScheduleReader flightScheduleReader) {
		this.citiesReader = citiesReader;
		this.aircraftsReader = aircraftsReader;
		this.flightScheduleReader = flightScheduleReader;

		airportMap = new HashMap<String, Airport>();
		aircraftMap = new HashMap<String, Aircraft>();
	}

	public Map<String, Airport> getAirportMap() {
		return airportMap;
	}

	public Map<String, Aircraft> getAircraftMap() {
		return aircraftMap;
	}

	public Collection<FlightSchedule> getFlightSchedules() {
		return flightSchedules;
	}

	public void readAll() throws IOException, BadFileFormatException {
		try (FileReader reader = new FileReader("Cities.txt")) {
			Collection<City> cities = citiesReader.read(reader);
			airportMap.clear();
			for (City city : cities) {
				for (Airport airport : city.getAirports()) {
					airportMap.put(airport.getCode(), airport);
				}
			}
		};

		try (FileReader reader = new FileReader("Aircrafts.txt")) {
			Collection<Aircraft> aircrafts = aircraftsReader.read(reader);
			aircraftMap.clear();
			for (Aircraft aircraft : aircrafts) {
				aircraftMap.put(aircraft.getCode(), aircraft);
			}
		};

		try (FileReader reader = new FileReader("FlightSchedule.txt")) {
			flightSchedules = flightScheduleReader.read(reader, airportMap,
					aircraftMap);
		};
	}
}
