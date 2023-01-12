package flights.ui;

import java.time.LocalDate;
import java.util.List;

import flights.controller.Controller;
import flights.model.Airport;
import flights.model.FlightSchedule;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MainPane extends BorderPane {

	private Controller controller;
	private ComboBox<Airport> departureAirportComboBox;
	private ComboBox<Airport> arrivalAirportComboBox;
	private DatePicker departureDatePicker;
	private FlightScheduleListPanel flightScheduleListPanel;

	public MainPane(Controller controller) {
		this.controller = controller;
		initPane();
	}

	private void initPane() {
		VBox leftPane = new VBox();
		{
			leftPane.setSpacing(10);
			leftPane.setPadding(new Insets(0, 20, 10, 20));

			Label label = new Label("Departure Airport");
			leftPane.getChildren().add(label);

			List<Airport> airports = controller.getSortedAirports();
			ObservableList<Airport> observableAirports = FXCollections.observableArrayList(airports);
			
			departureAirportComboBox = new ComboBox<Airport>(observableAirports);
			departureAirportComboBox.setEditable(false);
			departureAirportComboBox.setValue(observableAirports.get(0));
			leftPane.getChildren().add(departureAirportComboBox);

			label = new Label("Arrival Airport");
			leftPane.getChildren().add(label);

			arrivalAirportComboBox = new ComboBox<Airport>(observableAirports);
			arrivalAirportComboBox.setEditable(false);
			arrivalAirportComboBox.setValue(observableAirports.get(0));
			leftPane.getChildren().add(arrivalAirportComboBox);

			label = new Label("Departure Date");
			leftPane.getChildren().add(label);

			departureDatePicker = new DatePicker(LocalDate.now());
			departureDatePicker.setValue(LocalDate.now());
			leftPane.getChildren().add(departureDatePicker);

			Button searchButton = new Button("Find");
			searchButton.setOnAction(this::myHandle);
			leftPane.getChildren().add(searchButton);
		}
		leftPane.setAlignment(Pos.BASELINE_RIGHT);
		setLeft(leftPane);

//		BorderPane.setMargin(leftPane, new Insets(15, 0, 0, 10));

		flightScheduleListPanel = new FlightScheduleListPanel();
		setCenter(flightScheduleListPanel);
	}

	private void myHandle(ActionEvent event) {
		Airport departureAirport = departureAirportComboBox.getValue();
		Airport arrivalAirport = arrivalAirportComboBox.getValue();
		LocalDate localDate = departureDatePicker.getValue();
		
		List<FlightSchedule> flightSchedules = controller.searchFlights(departureAirport, arrivalAirport, localDate);
		flightScheduleListPanel.setFlightSchedules(flightSchedules);
	}

}
