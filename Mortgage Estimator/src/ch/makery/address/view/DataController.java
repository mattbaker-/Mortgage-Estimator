package ch.makery.address.view;
import java.text.DecimalFormat;

import org.apache.poi.ss.formula.functions.FinanceLib;

import ch.makery.address.MainApp;
import ch.makery.address.model.Data;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import org.apache.poi.ss.formula.functions.FinanceLib;;

public class DataController {
	@FXML
	private TextField TotalGrossIncome;
	@FXML
	private TextField TotalMonthlyDebt;
	@FXML
	private TextField MortgageInterestRate;
	@FXML
	private ComboBox<String> Term = new ComboBox<String>();
	@FXML
	private TextField DownPayment;
	
	@FXML
	private Button OK;
	@FXML
	private Label Label1;
	@FXML
	private Label Label2;
	@FXML
	private Label Label3;
	@FXML
	private Label Label4;
	@FXML
	private Label Message1;
	@FXML
	private Label Message2;
	@FXML
	private Label Message3;
	@FXML
	private Label Message4;
	
	// Reference to the main application.
    private MainApp mainApp;
    
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public DataController() {
    }
    
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	
    	TotalGrossIncome.setText("56000");
    	TotalMonthlyDebt.setText("10000");
    	MortgageInterestRate.setText("0.06");
    	Term.getItems().addAll("10", "15", "30");
    	DownPayment.setText("0");
    	
    	Label1.setText("Housing Payment:");
    	Label2.setText("Payment w/ Obligations:");
    	Label3.setText("Max Payment Allowed:");
    	Label4.setText("Finaciable Mortgage:");
    	
    	Message1.setText("");
    	Message2.setText("");
    	Message3.setText("");
    	Message4.setText("");
    }
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    @FXML
    private void handleTotalGrossIncome() {
    	double grossIncome = Double.parseDouble(TotalGrossIncome.getText());
    }
    /*
    @FXML
    private void handleTotalMonthlyDebt() {
    }
    
    @FXML
    private void handleMortgageInterestRate() {
    }
    */
    @FXML
    private void handleTerm() {
    	Term.getSelectionModel().getSelectedItem().toString();
    }
    /*
    @FXML
    private void handleDownPayment() {
    }
    */
    @FXML
    private void handleOK() {
    	
    	double totalGrossIncome = Double.parseDouble(TotalGrossIncome.getText());
    	double totalMonthlyDebt = Double.parseDouble(TotalMonthlyDebt.getText());
    	double mortgageInterestRate = Double.parseDouble(MortgageInterestRate.getText());
    	double term = Double.parseDouble(Term.getValue());
    	double downPayment = Double.parseDouble(DownPayment.getText());
    	
    	double housingPayment = (totalGrossIncome/12)*0.18;
    	double paymentWithObligations = (totalGrossIncome/12)*0.36 - 300;
    	double maxPaymentAllowed;
    	if(housingPayment < paymentWithObligations) {
    		maxPaymentAllowed = housingPayment;
    	}
    	else{
    		maxPaymentAllowed = paymentWithObligations;
    	}
    	
    	double pv = -FinanceLib.pv(mortgageInterestRate/12, term*12, maxPaymentAllowed, 0, false);
//    	String pvString = String.format("%.2f", Double.toString(pv));
//    	pv = Double.parseDouble(pvString);
    	
    	Message1.setText("$ " + Double.toString(housingPayment) + " a month.");
    	Message2.setText("$ " + Double.toString(paymentWithObligations) + " a month.");
    	Message3.setText("$ " + Double.toString(maxPaymentAllowed));
    	Message4.setText("$ " + Double.toString(pv));
    	
    }
}
