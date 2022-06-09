package com.networthcalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.util.ArrayList;
import java.util.Collections;

public class Controller {

    @FXML
    private TextField realEstate;
    @FXML
    private TextField checkingAccounts;
    @FXML
    private TextField savingAccounts;
    @FXML
    private TextField retirementAccounts;
    @FXML
    private TextField autos;
    @FXML
    private TextField other;
    @FXML
    private TextField mortgages;
    @FXML
    private TextField consumerDebt;
    @FXML
    private TextField personalLoans;
    @FXML
    private TextField studentLoans;
    @FXML
    private TextField autoLoans;
    @FXML
    private TextField otherDebt;
    @FXML
    private Text result;
    @FXML
    private Button submitButton;

    private float netWorth;
    private ArrayList<TextField> assetTextFields = new ArrayList<>();
    private ArrayList<TextField> liabilitiesTextFieldsB = new ArrayList<>();
    private float assets;
    private float liabilities;

    @FXML
    public void initialize(){
        // Add all TextFields to ArrayLists
        Collections.addAll(assetTextFields, realEstate, checkingAccounts, savingAccounts, retirementAccounts, autos, other);
        Collections.addAll(liabilitiesTextFieldsB, mortgages, consumerDebt, personalLoans, studentLoans, autoLoans, otherDebt);
    }

    // Submit button ActionEvent - calculates and displays net worth
    @FXML
    private void submit(ActionEvent event){

        // Reset stored assets and liabilities
        assets = 0;
        liabilities = 0;

        // Calculate net worth
        netWorth = calculateAssets()- calculateLiabilities();
        // Display net worth
        result.setText(String.valueOf(netWorth));
    }


    // Calculates assets
    private float calculateAssets(){
        for (TextField textField : assetTextFields) {
            // Adds TextField content to asset total if not empty
            try{
                if(!textField.getText().isEmpty()){
                    assets += Float.parseFloat(textField.getText());
                }
                else{
                }
                // Catches NumberFormatException - ignores non-numeric characters
            } catch(NumberFormatException e){

            }
        }
        return assets;
    }

    // Calculates Liabilities
    private float calculateLiabilities(){
        for (TextField textField : liabilitiesTextFieldsB) {
            try{
                if(!textField.getText().isEmpty()){
                    liabilities += Float.parseFloat(textField.getText());
                }
                else{
                }
            } catch(NumberFormatException e){
            }
        }
        return liabilities;
    }

}