
# Flight Management System

## Overview

This application provides a comprehensive system to manage and schedule flights. It allows users to search for flights, view sorted airport data, and interact with flight schedules through both a graphical and console-based user interface.

## Features

- **Flight Search:** Search for flights based on departure and arrival airports and dates.
- **Airport Management:** View airports sorted by city and name.
- **Interactive Interfaces:**
  - **Graphical Interface:** A user-friendly JavaFX application for intuitive flight management.
  - **Console Interface:** A command-line-based UI for quick and straightforward access.

## Modules

### 1. **Core Functionality**
   - `FlightsApplication`: The main graphical interface using JavaFX.
   - `MainConsoleUI`: The console-based user interface for basic interactions.

### 2. **Controllers**
   - `Controller` (Interface): Defines core operations like fetching sorted airports and searching flights.
   - `MyController`: Implements the `Controller` interface, providing logic for airport sorting and flight searching.

### 3. **Persistence**
   The application includes several classes to handle data reading and storage operations:

   - **Readers:**
     - `MyAircraftsReader`: Reads aircraft data from input files.
     - `MyCitiesReader`: Reads city and airport data from input files.
     - `MyFlightScheduleReader`: Reads flight schedule data from input files.
     - `AircraftsReader`, `CitiesReader`, and `FlightScheduleReader`: Interfaces for implementing custom readers.

   - **Data Manager:**
     - `DataManager`: Coordinates data reading and stores airport, aircraft, and flight schedule information.

   - **Exception Handling:**
     - `BadFileFormatException`: Custom exception to handle file format errors during data loading.

### 4. **Testing**
   - `FlightsApplicationMock`: A mock implementation for testing with predefined datasets.

## Requirements

- **Java Version:** Java 11 or higher
- **Dependencies:** JavaFX for the graphical interface

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/andengine/ManageFlights.git
   cd ManageFlights
   ```
2. Compile the application:
   ```bash
   javac -d bin -sourcepath src src/flights/FlightsApplication.java
   ```
3. Run the graphical interface:
   ```bash
   java -cp bin flights.FlightsApplication
   ```
4. Or run the console interface:
   ```bash
   java -cp bin flights.MainConsoleUI
   ```

## Usage

### Graphical Interface
1. Launch the application (`FlightsApplication`).
2. Navigate through the interface to search for flights, view schedules, and manage data.

### Console Interface
1. Launch the console-based UI (`MainConsoleUI`).
2. Follow on-screen prompts to interact with the application.

## Project Structure

- `flights`: Main package containing application logic and UI entry points.
- `flights.controller`: Contains the controllers implementing business logic.
- `flights.persistence`: Handles data reading and storage operations, including:
  - `DataManager`
  - `MyAircraftsReader`, `MyCitiesReader`, `MyFlightScheduleReader`
  - `AircraftsReader`, `CitiesReader`, `FlightScheduleReader`
- `flights.ui`: Provides UI implementations for graphical and console interfaces.

## Contributing

1. Fork the repository.
2. Create a feature branch:
   ```bash
   git checkout -b feature-name
   ```
3. Commit changes and create a pull request.

## License

This project is licensed under the MIT License. See `LICENSE` for details.
