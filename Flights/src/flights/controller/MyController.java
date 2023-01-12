package flights.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import flights.model.Airport;
import flights.model.FlightSchedule;
import flights.persistence.DataManager;

public class MyController implements Controller {
	private DataManager dataManager;
	private List<Airport> sortedAirports;

	public MyController(DataManager dataManager) {
		this.dataManager = dataManager;

		sortedAirports = new ArrayList<Airport>(dataManager.getAirportMap().values());
		
		/* SOLUZIONE 1: SPEZZARE I PASSAGGI*/
		Comparator<Airport> comparator = Comparator.comparing(a -> a.getCity().getName());
		Comparator<Airport> completeComparator = comparator.thenComparing(aa -> aa.getName());
		sortedAirports.sort(completeComparator);
		
		/* SOLUZIONE 2: CAST*/
		//sortedAirports.sort(Comparator.comparing((Airport a) -> a.getCity().getName()).thenComparing(aa -> aa.getName()));

		
		/* SE AVESSI SOLO UNA CONDIZIONE CE LA FAREBBE -------- NON E' IL NOSTRO CASO*/
		//sortedAirports.sort(Comparator.comparing((a) -> a.getCity().getName()));
		
		/* METHOD REFERENCE se avessi solo un metodo da chiamare e non oggetti innestati -------- NON E' IL NOSTRO CASO*/
		//NON PASSA sortedAirports.sort(Comparator.comparing(a -> a.getCode()).thenComparing(aa -> aa.getName()));
		//sortedAirports.sort(Comparator.comparing(Airport::getCode).thenComparing(aa -> aa.getName()));
	
	}

	@Override
	public List<Airport> getSortedAirports() {
		return sortedAirports;
	}

	@Override
	public List<FlightSchedule> searchFlights(Airport departureAirport, Airport arrivalAirport, LocalDate date) {
		DayOfWeek dayOfWeek = date.getDayOfWeek();

		/*SOLUZIONE SENZA STREAM */
		/*ArrayList<FlightSchedule> availableSchedules = new ArrayList<FlightSchedule>();
		for (FlightSchedule flightSchedule : dataManager.getFlightSchedules()) {
			if (flightSchedule.getDepartureAirport().equals(departureAirport) && 
				flightSchedule.getArrivalAirport().equals(arrivalAirport) &&
				flightSchedule.getDaysOfWeek().contains(dayOfWeek)) {
						availableSchedules.add(flightSchedule);
			}
		}*/
		
		List<FlightSchedule> availableSchedules = dataManager.getFlightSchedules().stream()
				.filter(fs -> fs.getDepartureAirport().equals(departureAirport) &&
						      fs.getArrivalAirport().equals(arrivalAirport) &&
						      fs.getDaysOfWeek().contains(dayOfWeek))
				.collect(Collectors.toList());
		return availableSchedules;
	}
}
