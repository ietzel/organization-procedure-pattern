import java.io.*;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
public class Main extends Application {

    /*
    public static int minIndex(double[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int maxIndex(double[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    */
 
    private static final TableView<Viewpoint> table = new TableView<>();
    private final ObservableList<Viewpoint> data = FXCollections.observableArrayList(
        new Viewpoint("honesty/integrity/transparency", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "", ""),
        new Viewpoint("compassion/respect", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "", ""),
        new Viewpoint("responsibility/accountability", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "", ""),
        new Viewpoint("loyalty/trustworthiness", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "", ""),
        new Viewpoint("law-abiding", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "", ""),
        new Viewpoint("fairness", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "", ""),
        new Viewpoint("leadership", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "", ""),
        new Viewpoint("anti-discrimination", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "", ""),
        new Viewpoint("workplace health/safety/security", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "", ""),
        new Viewpoint("employee code of conduct & anti-harassment", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "", ""),
        new Viewpoint("attendance & vacation & time-off", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "", ""),
        new Viewpoint("employee complaint", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "", ""),
        new Viewpoint("work schedule & rest period", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "", ""),
        new Viewpoint("substance abuse", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "", ""),
        new Viewpoint("mobile device management", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "", ""),
        new Viewpoint("compensation and benefits", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "", ""),
        new Viewpoint("travel", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "", ""),
        new Viewpoint("inclement weather", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "", ""),
        new Viewpoint("remote work", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "", ""),
        new Viewpoint("conflict of interest", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "", ""),
        new Viewpoint("acceptable use", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "", ""),
        new Viewpoint("compensation", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "", ""),
        new Viewpoint("safety", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "", ""),
        new Viewpoint("relationships", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "", ""),
        new Viewpoint("skill discretion", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "", ""),
        new Viewpoint("prospects", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "", "")
    );
    final HBox hb = new HBox();
 
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Organization Procedure Pattern");
        stage.setWidth(960);
        stage.setHeight(720);
 
        final Label label = new Label("Cognitive-Affective-Instinctual-Miscellaneous Empathy Matrix");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(true);
 
        TableColumn<Viewpoint, String> factorCol = new TableColumn<>("Factor");
        //factorCol.setMinWidth(200);
        factorCol.setCellValueFactory(new PropertyValueFactory<>("factor"));
        factorCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        factorCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFactor(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> cognitiveSalesCol = new TableColumn<>("Cognitive Sales");
        //cognitiveSalesCol.setMinWidth(100);
        cognitiveSalesCol.setCellValueFactory(new PropertyValueFactory<>("cognitive sales"));
        cognitiveSalesCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        cognitiveSalesCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCognitiveSales(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> affectiveSalesCol = new TableColumn<>("Affective Sales");
        //affectiveSalesCol.setMinWidth(100);
        affectiveSalesCol.setCellValueFactory(new PropertyValueFactory<>("affective sales"));
        affectiveSalesCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        affectiveSalesCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAffectiveSales(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> instinctualSalesCol = new TableColumn<>("Instinctual Sales");
        //instinctualSalesCol.setMinWidth(100);
        instinctualSalesCol.setCellValueFactory(new PropertyValueFactory<>("instinctual sales"));
        instinctualSalesCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        instinctualSalesCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setInstinctualSales(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> miscellaneousSalesCol = new TableColumn<>("Miscellaneous Sales");
        //miscellaneousSalesCol.setMinWidth(100);
        miscellaneousSalesCol.setCellValueFactory(new PropertyValueFactory<>("miscellaneous sales"));
        miscellaneousSalesCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        miscellaneousSalesCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setMiscellaneousSales(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> cognitiveFinanceCol = new TableColumn<>("Cognitive Finance");
        //cognitiveFinanceCol.setMinWidth(100);
        cognitiveFinanceCol.setCellValueFactory(new PropertyValueFactory<>("cognitive finance"));
        cognitiveFinanceCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        cognitiveFinanceCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCognitiveFinance(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> affectiveFinanceCol = new TableColumn<>("Affective Finance");
        //affectiveFinanceCol.setMinWidth(100);
        affectiveFinanceCol.setCellValueFactory(new PropertyValueFactory<>("affective finance"));
        affectiveFinanceCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        affectiveFinanceCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAffectiveFinance(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> instinctualFinanceCol = new TableColumn<>("Instinctual Finance");
        //instinctualFinanceCol.setMinWidth(100);
        instinctualFinanceCol.setCellValueFactory(new PropertyValueFactory<>("instinctual finance"));
        instinctualFinanceCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        instinctualFinanceCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setInstinctualFinance(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> miscellaneousFinanceCol = new TableColumn<>("Miscellaneous Finance");
        //miscellaneousFinanceCol.setMinWidth(100);
        miscellaneousFinanceCol.setCellValueFactory(new PropertyValueFactory<>("miscellaneous finance"));
        miscellaneousFinanceCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        miscellaneousFinanceCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setMiscellaneousFinance(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> cognitiveTechnologyCol = new TableColumn<>("Cognitive Technology");
        //cognitiveTechnologyCol.setMinWidth(100);
        cognitiveTechnologyCol.setCellValueFactory(new PropertyValueFactory<>("cognitive technology"));
        cognitiveTechnologyCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        cognitiveTechnologyCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCognitiveTechnology(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> affectiveTechnologyCol = new TableColumn<>("Affective Technology");
        //affectiveTechnologyCol.setMinWidth(100);
        affectiveTechnologyCol.setCellValueFactory(new PropertyValueFactory<>("affective technology"));
        affectiveTechnologyCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        affectiveTechnologyCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAffectiveTechnology(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> instinctualTechnologyCol = new TableColumn<>("Instinctual Technology");
        //instinctualTechnologyCol.setMinWidth(100);
        instinctualTechnologyCol.setCellValueFactory(new PropertyValueFactory<>("instinctual technology"));
        instinctualTechnologyCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        instinctualTechnologyCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setInstinctualTechnology(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> miscellaneousTechnologyCol = new TableColumn<>("Miscellaneous Technology");
        //miscellaneousTechnologyCol.setMinWidth(100);
        miscellaneousTechnologyCol.setCellValueFactory(new PropertyValueFactory<>("miscellaneous technology"));
        miscellaneousTechnologyCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        miscellaneousTechnologyCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setMiscellaneousTechnology(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> cognitiveOperationsCol = new TableColumn<>("Cognitive Operations");
        //cognitiveOperationsCol.setMinWidth(100);
        cognitiveOperationsCol.setCellValueFactory(new PropertyValueFactory<>("cognitive operations"));
        cognitiveOperationsCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        cognitiveOperationsCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCognitiveOperations(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> affectiveOperationsCol = new TableColumn<>("Affective Operations");
        //affectiveOperationsCol.setMinWidth(100);
        affectiveOperationsCol.setCellValueFactory(new PropertyValueFactory<>("affective operations"));
        affectiveOperationsCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        affectiveOperationsCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAffectiveOperations(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> instinctualOperationsCol = new TableColumn<>("Instinctual Operations");
        //instinctualOperationsCol.setMinWidth(100);
        instinctualOperationsCol.setCellValueFactory(new PropertyValueFactory<>("instinctual operations"));
        instinctualOperationsCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        instinctualOperationsCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setInstinctualOperations(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> miscellaneousOperationsCol = new TableColumn<>("Miscellaneous Operations");
        //miscellaneousOperationsCol.setMinWidth(100);
        miscellaneousOperationsCol.setCellValueFactory(new PropertyValueFactory<>("miscellaneous operations"));
        miscellaneousOperationsCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        miscellaneousOperationsCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setMiscellaneousOperations(t.getNewValue());
            }
        );
     
        TableColumn<Viewpoint, String> valueCol = new TableColumn<>("Portion (%)");
        //valueCol.setMinWidth(100);
        valueCol.setCellValueFactory(new PropertyValueFactory<>("value"));
        valueCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        valueCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setValue(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> antiCol = new TableColumn<>("Anti");
        //antiCol.setMinWidth(400);
        antiCol.setCellValueFactory(new PropertyValueFactory<>("anti"));
        antiCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        antiCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAnti(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> proCol = new TableColumn<>("Pro");
        //proCol.setMinWidth(400);
        proCol.setCellValueFactory(new PropertyValueFactory<>("pro"));
        proCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        proCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPro(t.getNewValue());
            }
        );
 
        table.setItems(data);
        table.getColumns().addAll(factorCol, cognitiveSalesCol, affectiveSalesCol, instinctualSalesCol, miscellaneousSalesCol, cognitiveFinanceCol, affectiveFinanceCol, instinctualFinanceCol, miscellaneousFinanceCol, cognitiveTechnologyCol, affectiveTechnologyCol, instinctualTechnologyCol, miscellaneousTechnologyCol, cognitiveOperationsCol, affectiveOperationsCol, instinctualOperationsCol, miscellaneousOperationsCol, valueCol, antiCol, proCol);
 
        final TextField addFactor = new TextField();
        addFactor.setPromptText("Factor");
        addFactor.setMaxWidth(factorCol.getPrefWidth());
 
        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            data.add(new Viewpoint(
                addFactor.getText(),
                "5",
                "5",
                "5",
                "5",
                "5",
                "5",
                "5",
                "5",
                "5",
                "5",
                "5",
                "5",
                "5",
                "5",
                "5",
                "5",
                "0",
                "",
                ""
            ));
            addFactor.clear();
        });

        final Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction((ActionEvent e) -> {
            Double[] weights = new Double[26];
            Double total = 0.00;
            Viewpoint viewpoint = new Viewpoint("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
            for(int i=0; i<table.getItems().size(); i++) {
                viewpoint = table.getItems().get(i);
                Double weight = (Double.parseDouble(viewpoint.cognitiveSales.get())+Double.parseDouble(viewpoint.affectiveSales.get()));
                weight += (Double.parseDouble(viewpoint.instinctualSales.get())+Double.parseDouble(viewpoint.miscellaneousSales.get()));
                weight += (Double.parseDouble(viewpoint.cognitiveFinance.get())+Double.parseDouble(viewpoint.affectiveFinance.get()));
                weight += (Double.parseDouble(viewpoint.instinctualFinance.get())+Double.parseDouble(viewpoint.miscellaneousFinance.get()));
                weight += (Double.parseDouble(viewpoint.cognitiveTechnology.get())+Double.parseDouble(viewpoint.affectiveTechnology.get()));
                weight += (Double.parseDouble(viewpoint.instinctualTechnology.get())+Double.parseDouble(viewpoint.miscellaneousTechnology.get()));
                weight += (Double.parseDouble(viewpoint.cognitiveOperations.get())+Double.parseDouble(viewpoint.affectiveOperations.get()));
                weight += (Double.parseDouble(viewpoint.instinctualOperations.get())+Double.parseDouble(viewpoint.miscellaneousOperations.get()));
                weights[i] = weight;
                total += weight;
            }
            Viewpoint row = new Viewpoint(
                viewpoint.factor.get(), 
                viewpoint.cognitiveSales.get(), 
                viewpoint.affectiveSales.get(), 
                viewpoint.instinctualSales.get(),
                viewpoint.miscellaneousSales.get(),
                viewpoint.cognitiveFinance.get(), 
                viewpoint.affectiveFinance.get(), 
                viewpoint.instinctualFinance.get(),
                viewpoint.miscellaneousFinance.get(),
                viewpoint.cognitiveTechnology.get(), 
                viewpoint.affectiveTechnology.get(), 
                viewpoint.instinctualTechnology.get(),
                viewpoint.miscellaneousTechnology.get(),
                viewpoint.cognitiveOperations.get(), 
                viewpoint.affectiveOperations.get(), 
                viewpoint.instinctualOperations.get(),
                viewpoint.miscellaneousOperations.get(),
                String.valueOf(0.00), 
                viewpoint.anti.get(),
                viewpoint.pro.get()
            );
            for(int i=0; i<table.getItems().size(); i++) {
                 row = new Viewpoint(
                    viewpoint.factor.get(), 
                    viewpoint.cognitiveSales.get(), 
                    viewpoint.affectiveSales.get(), 
                    viewpoint.instinctualSales.get(),
                    viewpoint.miscellaneousSales.get(),
                    viewpoint.cognitiveFinance.get(), 
                    viewpoint.affectiveFinance.get(), 
                    viewpoint.instinctualFinance.get(),
                    viewpoint.miscellaneousFinance.get(),
                    viewpoint.cognitiveTechnology.get(), 
                    viewpoint.affectiveTechnology.get(), 
                    viewpoint.instinctualTechnology.get(),
                    viewpoint.miscellaneousTechnology.get(),
                    viewpoint.cognitiveOperations.get(), 
                    viewpoint.affectiveOperations.get(), 
                    viewpoint.instinctualOperations.get(),
                    viewpoint.miscellaneousOperations.get(),
                    String.valueOf(100*weights[i]/total), 
                    viewpoint.anti.get(),
                    viewpoint.pro.get()
                );
                table.getItems().set(i, row);
            }
            
            Viewpoint viewpointTwo = new Viewpoint("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
            for(int i=0; i<table.getItems().size(); i++) {
                viewpointTwo = table.getItems().get(i);
                //int anti = findMin(viewpointTwo.cognitiveSales.get(), viewpointTwo.affectiveSales.get(), viewpointTwo.instinctualSales.get(), viewpointTwo.miscellaneousSales.get(), viewpointTwo.cognitiveFinance.get(), viewpointTwo.affectiveFinance.get(), viewpointTwo.instinctualFinance.get(), viewpointTwo.miscellaneousFinance.get(), viewpointTwo.cognitiveTechnology.get(), viewpointTwo.affectiveTechnology.get(), viewpointTwo.instinctualTechnology.get(), viewpointTwo.miscellaneousTechnology.get(), viewpointTwo.cognitiveOperations.get(), viewpointTwo.affectiveOperations.get(), viewpointTwo.instinctualOperations.get(), viewpointTwo.miscellaneousOperations.get());
                //int pro = findMax(viewpointTwo.cognitiveSales.get(), viewpointTwo.affectiveSales.get(), viewpointTwo.instinctualSales.get(), viewpointTwo.miscellaneousSales.get(), viewpointTwo.cognitiveFinance.get(), viewpointTwo.affectiveFinance.get(), viewpointTwo.instinctualFinance.get(), viewpointTwo.miscellaneousFinance.get(), viewpointTwo.cognitiveTechnology.get(), viewpointTwo.affectiveTechnology.get(), viewpointTwo.instinctualTechnology.get(), viewpointTwo.miscellaneousTechnology.get(), viewpointTwo.cognitiveOperations.get(), viewpointTwo.affectiveOperations.get(), viewpointTwo.instinctualOperations.get(), viewpointTwo.miscellaneousOperations.get());
                String[] values = {"Cognitive", "Affective", "Instinctual", "Miscellaneous"};
                viewpointTwo.setAnti(values[(/*anti*/0%4)]);
                viewpointTwo.setPro(values[(/*pro*/0%4)]);
            }           
        });

        //typeface/hierarchy/contrast/consistency/alignment/blankspace/color
        TextArea paragraph = new TextArea("Business modalities may be composed of the following business models: servitisation, platform, social, employee, partner, value, innovation, data, savvy. The overall allocation of resources could be conceived as a long-term survival train trolley problem. In terms of chemical coring, this is considered similar to political coring; the last 2 columns are for coring. Complex typography conversion may allow for many runs to become similar to an encyclopedia.");
        paragraph.setWrapText(true);

        hb.getChildren().addAll(addFactor, addButton, calculateButton);
        hb.setSpacing(3);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, paragraph, hb);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
    }
 
    public static class Viewpoint {
 
        protected final SimpleStringProperty factor;
        protected final SimpleStringProperty cognitiveSales;
        protected final SimpleStringProperty affectiveSales;
        protected final SimpleStringProperty instinctualSales;
        protected final SimpleStringProperty miscellaneousSales;
        protected final SimpleStringProperty cognitiveFinance;
        protected final SimpleStringProperty affectiveFinance;
        protected final SimpleStringProperty instinctualFinance;
        protected final SimpleStringProperty miscellaneousFinance;
        protected final SimpleStringProperty cognitiveTechnology;
        protected final SimpleStringProperty affectiveTechnology;
        protected final SimpleStringProperty instinctualTechnology;
        protected final SimpleStringProperty miscellaneousTechnology;
        protected final SimpleStringProperty cognitiveOperations;
        protected final SimpleStringProperty affectiveOperations;
        protected final SimpleStringProperty instinctualOperations;
        protected final SimpleStringProperty miscellaneousOperations;
        protected final SimpleStringProperty value;
        protected final SimpleStringProperty anti;
        protected final SimpleStringProperty pro;
 
        public Viewpoint(String factor, String cognitiveSales, String affectiveSales, String instinctualSales, String miscellaneousSales, String cognitiveFinance, String affectiveFinance, String instinctualFinance, String miscellaneousFinance, String cognitiveTechnology, String affectiveTechnology, String instinctualTechnology, String miscellaneousTechnology, String cognitiveOperations, String affectiveOperations, String instinctualOperations, String miscellaneousOperations, String value, String anti, String pro) {
            this.factor = new SimpleStringProperty(factor);
            this.cognitiveSales = new SimpleStringProperty(cognitiveSales);
            this.affectiveSales = new SimpleStringProperty(affectiveSales);
            this.instinctualSales = new SimpleStringProperty(instinctualSales);
            this.miscellaneousSales = new SimpleStringProperty(miscellaneousSales);
            this.cognitiveFinance = new SimpleStringProperty(cognitiveFinance);
            this.affectiveFinance = new SimpleStringProperty(affectiveFinance);
            this.instinctualFinance = new SimpleStringProperty(instinctualFinance);
            this.miscellaneousFinance = new SimpleStringProperty(miscellaneousFinance);
            this.cognitiveTechnology = new SimpleStringProperty(cognitiveTechnology);
            this.affectiveTechnology = new SimpleStringProperty(affectiveTechnology);
            this.instinctualTechnology = new SimpleStringProperty(instinctualTechnology);
            this.miscellaneousTechnology = new SimpleStringProperty(miscellaneousTechnology);
            this.cognitiveOperations = new SimpleStringProperty(cognitiveOperations);
            this.affectiveOperations = new SimpleStringProperty(affectiveOperations);
            this.instinctualOperations = new SimpleStringProperty(instinctualOperations);
            this.miscellaneousOperations = new SimpleStringProperty(miscellaneousOperations);
            this.value = new SimpleStringProperty(value);
            this.anti = new SimpleStringProperty(anti);
            this.pro = new SimpleStringProperty(pro);
        }
 
        public String getFactor() {
            return factor.get();
        }
        public void setFactor(String factor) {
            this.factor.set(factor);
        }

        public String getCognitiveSales() {
            return cognitiveSales.get();
        }
        public void setCognitiveSales(String cognitiveSales) {
            this.cognitiveSales.set(cognitiveSales);
        }
 
        public String getAffectiveSales() {
            return affectiveSales.get();
        }
        public void setAffectiveSales(String affectiveSales) {
            this.affectiveSales.set(affectiveSales);
        }

        public String getInstinctualSales() {
            return instinctualSales.get();
        }
        public void setInstinctualSales(String instinctualSales) {
            this.instinctualSales.set(instinctualSales);
        }

        public String getMiscellaneousSales() {
            return miscellaneousSales.get();
        }
        public void setMiscellaneousSales(String miscellaneousSales) {
            this.miscellaneousSales.set(miscellaneousSales);
        }

        public String getCognitiveFinance() {
            return cognitiveFinance.get();
        }
        public void setCognitiveFinance(String cognitiveFinance) {
            this.cognitiveFinance.set(cognitiveFinance);
        }
 
        public String getAffectiveFinance() {
            return affectiveFinance.get();
        }
        public void setAffectiveFinance(String affectiveFinance) {
            this.affectiveFinance.set(affectiveFinance);
        }

        public String getInstinctualFinance() {
            return instinctualFinance.get();
        }
        public void setInstinctualFinance(String instinctualFinance) {
            this.instinctualFinance.set(instinctualFinance);
        }

        public String getMiscellaneousFinance() {
            return miscellaneousFinance.get();
        } 
        public void setMiscellaneousFinance(String miscellaneousFinance) {
            this.miscellaneousFinance.set(miscellaneousFinance);
        }

        public String getCognitiveTechnology() {
            return cognitiveTechnology.get();
        } 
        public void setCognitiveTechnology(String cognitiveTechnology) {
            this.cognitiveTechnology.set(cognitiveTechnology);
        }
 
        public String getAffectiveTechnology() {
            return affectiveTechnology.get();
        }
        public void setAffectiveTechnology(String affectiveTechnology) {
            this.affectiveTechnology.set(affectiveTechnology);
        }

        public String getInstinctualTechnology() {
            return instinctualTechnology.get();
        }
        public void setInstinctualTechnology(String instinctualTechnology) {
            this.instinctualTechnology.set(instinctualTechnology);
        }

        public String getMiscellaneousTechnology() {
            return miscellaneousTechnology.get();
        }
        public void setMiscellaneousTechnology(String miscellaneousTechnology) {
            this.miscellaneousTechnology.set(miscellaneousTechnology);
        }

        public String getCognitiveOperations() {
            return cognitiveOperations.get();
        }
        public void setCognitiveOperations(String cognitiveOperations) {
            this.cognitiveOperations.set(cognitiveOperations);
        }
 
        public String getAffectiveOperations() {
            return affectiveOperations.get();
        }
        public void setAffectiveOperations(String affectiveOperations) {
            this.affectiveOperations.set(affectiveOperations);
        }

        public String getInstinctualOperations() {
            return instinctualOperations.get();
        }
        public void setInstinctualOperations(String instinctualOperations) {
            this.instinctualOperations.set(instinctualOperations);
        }

        public String getMiscellaneousOperations() {
            return miscellaneousOperations.get();
        }
        public void setMiscellaneousOperations(String miscellaneousOperations) {
            this.miscellaneousOperations.set(miscellaneousOperations);
        }
     
        public String getValue() {
            return value.get();
        }
        public void setValue(String value) {
            this.value.set(value);
        }

        public String getAnti() {
            return anti.get();
        }
        public void setAnti(String anti) {
            this.anti.set(anti);
        }

        public String getPro() {
            return pro.get();
        }
        public void setPro(String pro) {
            this.pro.set(pro);
        }    
    }
}