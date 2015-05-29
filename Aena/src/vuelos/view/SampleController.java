package vuelos.view;

import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import application.data.Data;
import application.model.Airport;
import application.model.Flight;

public class SampleController {
	@FXML
    private TextField numAeropuertos;
	@FXML
    private TableView<Flight> tablaSalidas;
    @FXML
    private TableColumn<Flight, String> DestinoSalidas;
    @FXML
    private TableColumn<Flight, String> vueloLlegadas;
    @FXML
    private TableColumn<Flight, String> modeloSalidas;
    @FXML
    private TableColumn<Flight, String> retrasoLlegadas;
    @FXML
    private TableColumn<Flight, String> tipoLlegadas;
    @FXML
    private TableColumn<Flight, String> horaLlegadas;
    @FXML
    private TableColumn<Flight, String> horaSalidas;
    @FXML
    private TableColumn<Flight, String> modeloLlegadas;
    @FXML
    private TableView<Flight> tablaLlegadas;
    @FXML
    private TableColumn<Flight,String> retrasoSalidas;
    @FXML
    private TableColumn<Flight,String> vueloSalidas;
    @FXML
    private TableColumn<Flight, String>origenLlegadas;
    @FXML
    private TableColumn<Flight, String> tipoSalidas;
    @FXML
    private TableColumn<Flight, String> companiaLlegadas;
    @FXML
    private TableColumn<Flight, String> fechaSalidas;
    @FXML
    private TableColumn<Flight, String> fechaLlegadas;
    @FXML
    private TableColumn<Flight, String> companiaSalidas;
	@FXML
	private TableView<Airport> tabla;
	@FXML
	private TableColumn<Airport, String> c1, c2;
	@FXML
	private LineChart<LocalDate,Integer> vuelosPorDia;
	@FXML
	private BarChart<String, Number> retrasoAeropuertos;
	@FXML
	private PieChart vuelosAeropuertos;
	@FXML
	private ScatterChart<String,Number> compania;
	@FXML
	private Label numeros, numeros1, numeros2;
	@FXML
	private DatePicker fechaInicio, fechaFin;
	@FXML
	private CheckBox conFechas;
	LocalDate fecha1, fecha2;
	
	public void rellenaTabla(Airport aeropuerto){
		Data datos = Data.getInstance();
		
		ObservableList<Flight> salidas = FXCollections.observableArrayList(datos.getAirportFlights(aeropuerto).getDepartures().getFlights().values());
		ObservableList<Flight> llegadas = FXCollections.observableArrayList(datos.getAirportFlights(aeropuerto).getArrivals().getFlights().values());
		
		tablaSalidas.setItems(salidas);
		vueloSalidas.setCellValueFactory((e)->new SimpleStringProperty(e.getValue().getFlightNumber()));
		fechaSalidas.setCellValueFactory((e)->new SimpleStringProperty(e.getValue().getDate().toString()));
		horaSalidas.setCellValueFactory(e->new SimpleStringProperty(e.getValue().getTime().toString()));
		retrasoSalidas.setCellValueFactory(e->new SimpleStringProperty(String.valueOf(e.getValue().getDelay())));
		companiaSalidas.setCellValueFactory(e->new SimpleStringProperty(e.getValue().getCompany()));
		tipoSalidas.setCellValueFactory(e->new SimpleStringProperty(e.getValue().getFlightDomain().toString()));
		DestinoSalidas.setCellValueFactory((e)->new SimpleStringProperty(e.getValue().getDestiny()));
		modeloSalidas.setCellValueFactory((e)->new SimpleStringProperty(e.getValue().getPlane()));
		
		tablaLlegadas.setItems(llegadas);
		vueloLlegadas.setCellValueFactory((e)->new SimpleStringProperty(e.getValue().getFlightNumber()));
		fechaLlegadas.setCellValueFactory((e)->new SimpleStringProperty(e.getValue().getDate().toString()));
		horaLlegadas.setCellValueFactory(e->new SimpleStringProperty(e.getValue().getTime().toString()));
		retrasoLlegadas.setCellValueFactory(e->new SimpleStringProperty(String.valueOf(e.getValue().getDelay())));
		companiaLlegadas.setCellValueFactory(e->new SimpleStringProperty(e.getValue().getCompany()));
		tipoLlegadas.setCellValueFactory(e->new SimpleStringProperty(e.getValue().getFlightDomain().toString()));
		origenLlegadas.setCellValueFactory((e)->new SimpleStringProperty(e.getValue().getOrigin()));
		modeloLlegadas.setCellValueFactory((e)->new SimpleStringProperty(e.getValue().getPlane()));
	}
	public void rellenaTabla(Airport aeropuerto, LocalDate fechaInicio, LocalDate fechaFinal){
		System.out.println("Inicio: "+fechaInicio);
		System.out.println("fin: "+fechaFin);
		Data datos = Data.getInstance();
		
		ObservableList<Flight> salidas = FXCollections.observableArrayList();
		ObservableList<Flight> llegadas = FXCollections.observableArrayList();
		
		for(LocalDate i=fechaInicio;i.isBefore(fechaFinal.plusDays(1));){
			
			System.out.println(i);
			System.out.println(i.isBefore(fechaFinal));
			System.out.println(i.plusDays(1));
		
		
		salidas.addAll(datos.getAirportFlights(aeropuerto,i).getDepartures().getFlights().values());
		llegadas.addAll(datos.getAirportFlights(aeropuerto,i).getArrivals().getFlights().values());
		
		
		tablaSalidas.setItems(salidas);
		vueloSalidas.setCellValueFactory((e)->new SimpleStringProperty(e.getValue().getFlightNumber()));
		fechaSalidas.setCellValueFactory((e)->new SimpleStringProperty(e.getValue().getDate().toString()));
		horaSalidas.setCellValueFactory(e->new SimpleStringProperty(e.getValue().getTime().toString()));
		retrasoSalidas.setCellValueFactory(e->new SimpleStringProperty(String.valueOf(e.getValue().getDelay())));
		companiaSalidas.setCellValueFactory(e->new SimpleStringProperty(e.getValue().getCompany()));
		tipoSalidas.setCellValueFactory(e->new SimpleStringProperty(e.getValue().getFlightDomain().toString()));
		DestinoSalidas.setCellValueFactory((e)->new SimpleStringProperty(e.getValue().getDestiny()));
		modeloSalidas.setCellValueFactory((e)->new SimpleStringProperty(e.getValue().getPlane()));
		
		tablaLlegadas.setItems(llegadas);
		vueloLlegadas.setCellValueFactory((e)->new SimpleStringProperty(e.getValue().getFlightNumber()));
		fechaLlegadas.setCellValueFactory((e)->new SimpleStringProperty(e.getValue().getDate().toString()));
		horaLlegadas.setCellValueFactory(e->new SimpleStringProperty(e.getValue().getTime().toString()));
		retrasoLlegadas.setCellValueFactory(e->new SimpleStringProperty(String.valueOf(e.getValue().getDelay())));
		companiaLlegadas.setCellValueFactory(e->new SimpleStringProperty(e.getValue().getCompany()));
		tipoLlegadas.setCellValueFactory(e->new SimpleStringProperty(e.getValue().getFlightDomain().toString()));
		origenLlegadas.setCellValueFactory((e)->new SimpleStringProperty(e.getValue().getOrigin()));
		modeloLlegadas.setCellValueFactory((e)->new SimpleStringProperty(e.getValue().getPlane()));
		i=i.plusDays(1);
		}
	}
}
