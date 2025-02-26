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

        static double mean(double arr[], int n)
    {
        double sum = 0;
         
        for (int i = 0; i < n; i++)
            sum = sum + arr[i];
        return sum / n;
    }
     

    static double standardDeviation(double arr[], int n) {
        double sum = 0;
         
        for (int i = 0; i < n; i++)
            sum = sum + (arr[i] - mean(arr, n)) * (arr[i] - mean(arr, n));
     
        return Math.sqrt(sum / (n - 1));
    }
     
    static double coefficientOfVariation(double arr[], int n) {
    return (standardDeviation(arr, n) / mean(arr, n));
    }
 
    private static final TableView<Viewpoint> table = new TableView<>();
    private final ObservableList<Viewpoint> data = FXCollections.observableArrayList(
        new Viewpoint("honesty/integrity/transparency", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "0", "0", "0", "0"),
        new Viewpoint("compassion/respect", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "0", "0", "0", "0"),
        new Viewpoint("responsibility/accountability", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "0", "0", "0", "0"),
        new Viewpoint("loyalty/trustworthiness", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "0", "0", "0", "0"),
        new Viewpoint("law-abiding", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "0", "0", "0", "0"),
        new Viewpoint("fairness", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "0", "0", "0", "0"),
        new Viewpoint("leadership", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "0", "0", "0", "0"),
        new Viewpoint("anti-discrimination", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "0", "0", "0", "0"),
        new Viewpoint("workplace health/safety/security", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "0", "0", "0", "0"),
        new Viewpoint("employee code of conduct & anti-harassment", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "0", "0", "0", "0"),
        new Viewpoint("attendance & vacation & time-off", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "0", "0", "0", "0"),
        new Viewpoint("employee complaint", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "0", "0", "0", "0"),
        new Viewpoint("work schedule & rest period", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "0", "0", "0", "0"),
        new Viewpoint("substance abuse", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "0", "0", "0", "0"),
        new Viewpoint("mobile device management", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "0", "0", "0", "0"),
        new Viewpoint("compensation and benefits", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "0", "0", "0", "0"),
        new Viewpoint("travel", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "0", "0", "0", "0"),
        new Viewpoint("inclement weather", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "0", "0", "0", "0"),
        new Viewpoint("remote work", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "0", "0", "0", "0"),
        new Viewpoint("conflict of interest", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "0", "0", "0", "0"),
        new Viewpoint("acceptable use", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "0", "0", "0", "0"),
        new Viewpoint("compensation", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "0", "0", "0", "0"),
        new Viewpoint("safety", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "0", "0", "0", "0"),
        new Viewpoint("relationships", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "0", "0", "0", "0"),
        new Viewpoint("skill discretion", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "0", "0", "0", "0"),
        new Viewpoint("prospects", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0", "0", "0", "0", "0")
    );
    final HBox hb = new HBox();
 
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Organizations Habit Guider");
        stage.setWidth(900);
        stage.setHeight(800);
 
        final Label label = new Label("Cognitive-Affective-Instinctual-Miscellaneous Empathy Matrix");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(true);
 
        TableColumn<Viewpoint, String> factorCol = new TableColumn<>("Factor");
        factorCol.setMinWidth(200);
        factorCol.setCellValueFactory(new PropertyValueFactory<>("factor"));
        factorCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        factorCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFactor(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> cognitiveSalesCol = new TableColumn<>("Cognitive Sales");
        cognitiveSalesCol.setMinWidth(100);
        cognitiveSalesCol.setCellValueFactory(new PropertyValueFactory<>("cognitive sales"));
        cognitiveSalesCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        cognitiveSalesCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSalesCognitive(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> affectiveSalesCol = new TableColumn<>("Affective Sales");
        affectiveSalesCol.setMinWidth(100);
        affectiveSalesCol.setCellValueFactory(new PropertyValueFactory<>("affective sales"));
        affectiveSalesCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        affectiveSalesCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSalesAffective(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> instinctualSalesCol = new TableColumn<>("Instinctual Sales");
        instinctualSalesCol.setMinWidth(100);
        instinctualSalesCol.setCellValueFactory(new PropertyValueFactory<>("instinctual"));
        instinctualSalesCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        instinctualSalesCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSalesInstinctual(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> miscellaneousSalesCol = new TableColumn<>("Miscellaneous Sales");
        miscellaneousCol.setMinWidth(100);
        miscellaneousCol.setCellValueFactory(new PropertyValueFactory<>("miscellaneous sales"));
        miscellaneousCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        miscellaneousCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSalesMiscellaneous(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> cognitiveFinanceCol = new TableColumn<>("Cognitive Finance");
        cognitiveFinanceCol.setMinWidth(100);
        cognitiveFinanceCol.setCellValueFactory(new PropertyValueFactory<>("cognitive finance"));
        cognitiveFinanceCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        cognitiveFinanceCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFinanceCognitive(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> affectiveFinanceCol = new TableColumn<>("Affective Finance");
        affectiveFinanceCol.setMinWidth(100);
        affectiveFinanceCol.setCellValueFactory(new PropertyValueFactory<>("affective finance"));
        affectiveFinanceCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        affectiveFinanceCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFinanceAffective(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> instinctualFinanceCol = new TableColumn<>("Instinctual Finance");
        instinctualFinanceCol.setMinWidth(100);
        instinctualFinanceCol.setCellValueFactory(new PropertyValueFactory<>("instinctual finance"));
        instinctualFinanceCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        instinctualFinanceCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFinanceInstinctual(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> miscellaneousFinanceCol = new TableColumn<>("Miscellaneous Finance");
        miscellaneousCol.setMinWidth(100);
        miscellaneousCol.setCellValueFactory(new PropertyValueFactory<>("miscellaneous finance"));
        miscellaneousCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        miscellaneousCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFinanceMiscellaneous(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> cognitiveTechnologyCol = new TableColumn<>("Cognitive Technology");
        cognitiveTechnologyCol.setMinWidth(100);
        cognitiveTechnologyCol.setCellValueFactory(new PropertyValueFactory<>("cognitive technology"));
        cognitiveTechnologyCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        cognitiveTechnologyCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTechnologyCognitive(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> affectiveTechnologyCol = new TableColumn<>("Affective Technology");
        affectiveTechnologyCol.setMinWidth(100);
        affectiveTechnologyCol.setCellValueFactory(new PropertyValueFactory<>("affective technology"));
        affectiveTechnologyCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        affectiveTechnologyCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTechnologyAffective(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> instinctualTechnologyCol = new TableColumn<>("Instinctual Technology");
        instinctualTechnologyCol.setMinWidth(100);
        instinctualTechnologyCol.setCellValueFactory(new PropertyValueFactory<>("instinctual technology"));
        instinctualTechnologyCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        instinctualTechnologyCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTechnologyInstinctual(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> miscellaneousTechnologyCol = new TableColumn<>("Miscellaneous Technology");
        miscellaneousCol.setMinWidth(100);
        miscellaneousCol.setCellValueFactory(new PropertyValueFactory<>("miscellaneous technology"));
        miscellaneousCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        miscellaneousCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTechnologyMiscellaneous(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> cognitiveOperationsCol = new TableColumn<>("Cognitive Operations");
        cognitiveOperationsCol.setMinWidth(100);
        cognitiveOperationsCol.setCellValueFactory(new PropertyValueFactory<>("cognitive operations"));
        cognitiveOperationsCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        cognitiveOperationsCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setOperationsCognitive(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> affectiveOperationsCol = new TableColumn<>("Affective Operations");
        affectiveOperationsCol.setMinWidth(100);
        affectiveOperationsCol.setCellValueFactory(new PropertyValueFactory<>("affective operations"));
        affectiveOperationsCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        affectiveOperationsCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setOperationsAffective(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> instinctualOperationsCol = new TableColumn<>("Instinctual Operations");
        instinctualOperationsCol.setMinWidth(100);
        instinctualOperationsCol.setCellValueFactory(new PropertyValueFactory<>("instinctual operations"));
        instinctualOperationsCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        instinctualOperationsCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setOperationsInstinctual(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> miscellaneousOperationsCol = new TableColumn<>("Miscellaneous Operations");
        miscellaneousOperationsCol.setMinWidth(100);
        miscellaneousOperationsCol.setCellValueFactory(new PropertyValueFactory<>("miscellaneous operations"));
        miscellaneousOperationsCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        miscellaneousOperationsCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setOperationsMiscellaneous(t.getNewValue());
            }
        );
     
        TableColumn<Viewpoint, String> valueCol = new TableColumn<>("Portion (%)");
        valueCol.setMinWidth(100);
        valueCol.setCellValueFactory(new PropertyValueFactory<>("value"));
        valueCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        valueCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setValue(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> cycleCol = new TableColumn<>("Cycle Sales");
        cycleSalesCol.setMinWidth(100);
        cycleSalesCol.setCellValueFactory(new PropertyValueFactory<>("cycle sales"));
        cycleSalesCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        cycleSalesCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCycleSales(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> cycleCol = new TableColumn<>("Cycle Finance");
        cycleFinanceCol.setMinWidth(100);
        cycleFinanceCol.setCellValueFactory(new PropertyValueFactory<>("finance cycle"));
        cycleFinanceCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        cycleFinanceCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCycleFinance(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> cycleCol = new TableColumn<>("Cycle Technology");
        cycleTechnologyCol.setMinWidth(100);
        cycleTechnologyCol.setCellValueFactory(new PropertyValueFactory<>("technology cycle"));
        cycleTechnologyCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        cycleTechnologyCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCycleTechnology(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> cycleCol = new TableColumn<>("Cycle Operations");
        cycleOperationsCol.setMinWidth(100);
        cycleOperationsCol.setCellValueFactory(new PropertyValueFactory<>("cycle operations"));
        cycleOperationsCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        cycleOperationsCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCycleOperations(t.getNewValue());
            }
        );
 
        table.setItems(data);
        table.getColumns().addAll(factorCol, cognitiveSalesCol, affectiveSalesCol, instinctualSalesCol, miscellaneousSalesCol, cognitiveFinanceCol, affectiveFinanceCol, instinctualFinanceCol, miscellaneousFinanceCol, cognitiveTechnologyCol, affectiveTechnologyCol, instinctualTechnologyCol, miscellaneousTechnologyCol, cognitiveOperationsCol, affectiveOperationsCol, instinctualOperationsCol, miscellaneousOperationsCol, valueCol, cycleSalesCol, cycleFinanceCol, cycleTechnologyCol, cycleOperationsCol);
 
        final TextField addFactor = new TextField();
        addFactor.setPromptText("Factor");
        addFactor.setMaxWidth(factorCol.getPrefWidth());
        final TextField addSalesCognitive = new TextField();
        addSalesCognitive.setMaxWidth(cognitiveSalesCol.getPrefWidth());
        addSalesCognitive.setPromptText("Cognitive Sales");
        final TextField addSalesAffective = new TextField();
        addSalesAffective.setMaxWidth(affectiveSalesCol.getPrefWidth());
        addSalesAffective.setPromptText("Affective Sales");
        final TextField addSalesInstinctual = new TextField();
        addSalesInstinctual.setMaxWidth(instinctualSalesCol.getPrefWidth());
        addSalesInstinctual.setPromptText("Instinctual Sales");
        final TextField addSalesMiscellaneous = new TextField();
        addSalesMiscellaneous.setMaxWidth(miscellaneousSalesCol.getPrefWidth());
        addSalesMiscellaneous.setPromptText("Miscellaneous Sales");
        final TextField addFinanceCognitive = new TextField();
        addFinanceCognitive.setMaxWidth(cognitiveFinanceCol.getPrefWidth());
        addFinanceCognitive.setPromptText("Cognitive Finance");
        final TextField addFinanceAffective = new TextField();
        addFinanceAffective.setMaxWidth(affectiveFinanceCol.getPrefWidth());
        addFinanceAffective.setPromptText("Affective Finance");
        final TextField addFinanceInstinctual = new TextField();
        addFinanceInstinctual.setMaxWidth(instinctualFinanceCol.getPrefWidth());
        addFinanceInstinctual.setPromptText("Instinctual Finance");
        final TextField addFinanceMiscellaneous = new TextField();
        addFinanceMiscellaneous.setMaxWidth(miscellaneousFinanceCol.getPrefWidth());
        addFinanceMiscellaneous.setPromptText("Miscellaneous Finance");
        final TextField addTechnologyCognitive = new TextField();
        addTechnologyCognitive.setMaxWidth(cognitiveTechnologyCol.getPrefWidth());
        addTechnologyCognitive.setPromptText("Cognitive Technology");
        final TextField addTechnologyAffective = new TextField();
        addTechnologyAffective.setMaxWidth(affectiveTechnologyCol.getPrefWidth());
        addTechnologyAffective.setPromptText("Affective Technology");
        final TextField addInstinctual = new TextField();
        addTechnologyInstinctual.setMaxWidth(instinctualTechnologyCol.getPrefWidth());
        addTechnologyInstinctual.setPromptText("InstinctualTechnology");
        final TextField addTechnologyMiscellaneous = new TextField();
        addTechnologyMiscellaneous.setMaxWidth(miscellaneousTechnologyCol.getPrefWidth());
        addTechnologyMiscellaneous.setPromptText("Miscellaneous Technology");
        final TextField addOperationsCognitive = new TextField();
        addOperationsCognitive.setMaxWidth(cognitiveOperationsCol.getPrefWidth());
        addOperationsCognitive.setPromptText("Cognitive Operations");
        final TextField addOperationsAffective = new TextField();
        addOperationsAffective.setMaxWidth(affectiveOperationsCol.getPrefWidth());
        addOperationsAffective.setPromptText("Affective Operations");
        final TextField addOperationsInstinctual = new TextField();
        addOperationsInstinctual.setMaxWidth(instinctualOperationsCol.getPrefWidth());
        addOperationsInstinctual.setPromptText("Instinctual Operations");
        final TextField addOperationsMiscellaneous = new TextField();
        addOperationsMiscellaneous.setMaxWidth(miscellaneousOperationsCol.getPrefWidth());
        addOperationsMiscellaneous.setPromptText("Miscellaneous Operations");
        final TextField addOperationsValue = new TextField();
        addOperationsValue.setMaxWidth(affectiveOperationsCol.getPrefWidth());
        addOperationsValue.setPromptText("Value Operations");
 
        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            data.add(new Viewpoint(
                addFactor.getText(),
                addSalesCognitive.getText(),
                addSalesAffective.getText(),
                addSalesInstinctual.getText(),
                addSalesMiscellaneous.getText(),
                addFinanceCognitive.getText(),
                addFinanceAffective.getText(),
                addFinanceInstinctual.getText(),
                addFinanceMiscellaneous.getText(),
                addTechnologyCognitive.getText(),
                addTechnologyAffective.getText(),
                addTechnologyInstinctual.getText(),
                addTechnologyMiscellaneous.getText(),
                addOperationsCognitive.getText(),
                addOperationsAffective.getText(),
                addOperationsInstinctual.getText(),
                addOperationsMiscellaneous.getText(),
                addOperationsValue.getText()
            ));
            addSalesFactor.clear();
            addSalesCognitive.clear();
            addSalesAffective.clear();
            addSalesInstinctual.clear();
            addFinanceMiscellaneous.clear();
            addFinanceCognitive.clear();
            addFinanceAffective.clear();
            addFinanceInstinctual.clear();
            addFinanceMiscellaneous.clear();
            addTechnologyCognitive.clear();
            addTechnologyAffective.clear();
            addTechnologyInstinctual.clear();
            addTechnologyMiscellaneous.clear();
            addOperationsCognitive.clear();
            addOperationsAffective.clear();
            addOperationsInstinctual.clear();
            addOperationsMiscellaneous.clear();
            addValue.clear();
        });

        final Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction((ActionEvent e) -> {
            Double[] weights = new Double[26];
            Double total = 0.00;
            Viewpoint viewpoint = new Viewpoint("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
            for(int i=0; i<table.getItems().size(); i++) {
                viewpoint = table.getItems().get(i);
                Double weight = Double.parseDouble(viewpoint.cognitiveSales.get())+Double.parseDouble(viewpoint.affectiveSales.get());
                weight += Double.parseDouble(viewpoint.instinctualSales.get())+Double.parseDouble(viewpoint.miscellaneousSales.get());
                weight += Double.parseDouble(viewpoint.cognitiveFinance.get())+Double.parseDouble(viewpoint.affectiveFinance.get());
                weight += Double.parseDouble(viewpoint.instinctualFinance.get())+Double.parseDouble(viewpoint.miscellaneousFinance.get());
                weight += Double.parseDouble(viewpoint.cognitiveTechnology.get())+Double.parseDouble(viewpoint.affectiveTechnology.get());
                weight += Double.parseDouble(viewpoint.instinctualTechnology.get())+Double.parseDouble(viewpoint.miscellaneousTechnology.get());
                weight += Double.parseDouble(viewpoint.cognitiveOperations.get())+Double.parseDouble(viewpoint.affectiveOperations.get());
                weight += Double.parseDouble(viewpoint.instinctualOperations.get())+Double.parseDouble(viewpoint.miscellaneousOperations.get())-80.00;
                weights[i] = weight;
                total += weight;
            }
            Viewpoint row = new Viewpoint(
                viewpoint.factor.get(), 
                viewpoint.congitiveSales.get(), 
                viewpoint.affectiveSales.get(), 
                viewpoint.instinctualSales.get(),
                viewpoint.miscellaneousSales.get(),
                viewpoint.congitiveFinance.get(), 
                viewpoint.affectiveFinance.get(), 
                viewpoint.instinctualFinance.get(),
                viewpoint.miscellaneousFinance.get(),
                viewpoint.congitiveTechnology.get(), 
                viewpoint.affectiveTechnology.get(), 
                viewpoint.instinctualTechnology.get(),
                viewpoint.miscellaneousTechnology.get(),
                viewpoint.congitiveOperations.get(), 
                viewpoint.affectiveOperations.get(), 
                viewpoint.instinctualOperations.get(),
                viewpoint.miscellaneousOperations.get(),
                String.valueOf(0.00)
            );
            for(int i=0; i<table.getItems().size(); i++) {
                if(weights[i] == 0.00) {
                    row = new Viewpoint(
                        viewpoint.factor.get(), 
                        viewpoint.congitiveSales.get(), 
                        viewpoint.affectiveSales.get(), 
                        viewpoint.instinctualSales.get(),
                        viewpoint.miscellaneousSales.get(),
                        viewpoint.congitiveFinance.get(), 
                        viewpoint.affectiveFinance.get(), 
                        viewpoint.instinctualFinance.get(),
                        viewpoint.miscellaneousFinance.get(),
                        viewpoint.congitiveTechnology.get(), 
                        viewpoint.affectiveTechnology.get(), 
                        viewpoint.instinctualTechnology.get(),
                        viewpoint.miscellaneousTechnology.get(),
                        viewpoint.congitiveOperations.get(), 
                        viewpoint.affectiveOperations.get(), 
                        viewpoint.instinctualOperations.get(),
                        viewpoint.miscellaneousOperations.get(),
                        String.valueOf(0.00)
                    );
                } else {
                row = new Viewpoint(
                    viewpoint.factor.get(), 
                    viewpoint.congitiveSales.get(), 
                    viewpoint.affectiveSales.get(), 
                    viewpoint.instinctualSales.get(),
                    viewpoint.miscellaneousSales.get(),
                    viewpoint.congitiveFinance.get(), 
                    viewpoint.affectiveFinance.get(), 
                    viewpoint.instinctualFinance.get(),
                    viewpoint.miscellaneousFinance.get(),
                    viewpoint.congitiveTechnology.get(), 
                    viewpoint.affectiveTechnology.get(), 
                    viewpoint.instinctualTechnology.get(),
                    viewpoint.miscellaneousTechnology.get(),
                    viewpoint.congitiveOperations.get(), 
                    viewpoint.affectiveOperations.get(), 
                    viewpoint.instinctualOperations.get(),
                    viewpoint.miscellaneousOperations.get(),
                    String.valueOf(100*weights[i]/total)
                );        
                }
                table.getItems().set(i, row);
            }
            for(int i=0; i<table.getItems().size(); i++) {
                viewpoint = table.getItems().get(i);

                weights[i] = weight;
                total += weight;
            }
            Viewpoint viewpointTwo = new Viewpoint("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
            for(int i=0; i<table.getItems().size(); i++) {
                viewpointTwo = table.getItems().get(i);
                Double[] weightCognitive = [Double.parseDouble(viewpoint.cognitiveSales.get()), Double.parseDouble(viewpoint.cognitiveFinance.get()), Double.parseDouble(viewpoint.instinctualSales.get()), Double.parseDouble(viewpoint.miscellaneousSales.get())];
                Double[] weightAffective = Double.parseDouble(viewpoint.affectiveFinance.get()), Double.parseDouble(viewpoint.affectiveFinance.get()), Double.parseDouble(viewpoint.affectiveTechnology.get()), Double.parseDouble(viewpoint.affectiveOperations.get())];
                Double[] weightInstinctual = Double.parseDouble(viewpoint.instinctualTechnology.get())+Double.parseDouble(viewpoint.affectiveTechnology.get()), Double.parseDouble(viewpoint.instinctualTechnology.get()), Double.parseDouble(viewpoint.miscellaneousTechnology.get())];
                Double[] weightMiscellaneous = Double.parseDouble(viewpoint.cognitiveOperations.get()), Double.parseDouble(viewpoint.affectiveOperations.get()), Double.parseDouble(viewpoint.instinctualOperations.get())+, ouble.parseDouble(viewpoint.miscellaneousOperations.get())];
                setCycleCognitive(coefficientOfVariation(weightCognitive, weightCognitive.length));
                setCycleAffective(coefficientOfVariation(weightAffective, weightAffective.length));
                setCycleInstinctual(coefficientOfVariation(weightInstinctual, weightInstinctual.length));
                setCycleMiscellaneous(coefficientOfVariation(weightMiscellaneous, weightMiscellaneous.length));
            }           
        });

        //typeface/hierarchy/contrast/consistency/alignment/blankspace/color
        TextArea paragraph = new TextArea("Business modalities may be composed of the following business models: servitisation, platform, social, employee, partner, value, innovation, data, savvy. The overall allocation of resources could be concieved as a long-term survival train trolley problem. In terms of political coring, Ratings of 0-3 are anti (-4 to -1), 4-6 are other (-1 to 1), 7-10 are pro (1 to 4). The last 4 columns are for coefficients of variation for each business modality. Complex typography conversion may allow for many runs to become similar to an encyclopedia.");
     
        hb.getChildren().addAll(addFactor, addCognitiveSales, addAffectiveSales, addInstinctualSales, addMiscellaneousSales, addCognitiveFinance, addAffectiveFinance, addInstinctualFinance, addMiscellaneousFinance, addCognitiveTechnology, addAffectiveTechnology, addInstinctualTechnology, addMiscellaneousTechnology, addCognitiveOperations, addAffectiveOperations, addInstinctualOperations, addMiscellaneousOperations, addCycleSales, addCycleFinance, addCycleTechnology, addCycleOperations, addValue, addButton, calculateButton);
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
        protected final SimpleStringProperty congitiveSales;
        protected final SimpleStringProperty affectiveSales;
        protected final SimpleStringProperty instinctualSales;
        protected final SimpleStringProperty miscellaneousSales;
        protected final SimpleStringProperty congitiveFinance;
        protected final SimpleStringProperty affectiveFinance;
        protected final SimpleStringProperty instinctualFinance;
        protected final SimpleStringProperty cognitiveFinance;
        protected final SimpleStringProperty affectiveTechnology;
        protected final SimpleStringProperty instinctualTechnology;
        protected final SimpleStringProperty miscellaneousTechnology;
        protected final SimpleStringProperty miscellaneousTechnology;
        protected final SimpleStringProperty congitiveOperations;
        protected final SimpleStringProperty affectiveOperations;
        protected final SimpleStringProperty instinctualOperations;
        protected final SimpleStringProperty miscellaneousOperations;
        protected final SimpleStringProperty cycleSales;
        protected final SimpleStringProperty cycleFinance;
        protected final SimpleStringProperty cycleTechnology;
        protected final SimpleStringProperty cycleOperations;
        protected final SimpleStringProperty value;
 
        public Viewpoint(String factor, String cognitiveSales, String affectiveSales, String instinctualSales, String miscellaneousSales, String cognitiveFinance, String affectiveFinance, String instinctualFinance, String miscellaneousFinance, String cognitiveTechnology, String affectiveTechnology, String instinctualTechnology, String miscellaneousTechnology, String cognitiveOperations, String affectiveOperations, String instinctualOperations, String miscellaneousOperations, String cycleSales, String cycleFinance, String cycleTechnology, String cycleOperations, String value) {
            this.factor = new SimpleStringProperty(factor);
            this.congitiveSales = new SimpleStringProperty(cognitive);
            this.affectiveSales = new SimpleStringProperty(affective);
            this.instinctualSales = new SimpleStringProperty(instinctual);
            this.miscellaneousSales = new SimpleStringProperty(miscellaneous);
            this.congitiveFinance = new SimpleStringProperty(cognitive);
            this.affectiveFinance = new SimpleStringProperty(affective);
            this.instinctualFinance = new SimpleStringProperty(instinctual);
            this.miscellaneousFinance = new SimpleStringProperty(miscellaneous);
            this.congitiveTechnology = new SimpleStringProperty(cognitive);
            this.affectiveTechnology = new SimpleStringProperty(affective);
            this.instinctualTechnology = new SimpleStringProperty(instinctual);
            this.miscellaneousTechnology = new SimpleStringProperty(miscellaneous);
            this.congitiveOperations = new SimpleStringProperty(cognitive);
            this.affectiveOperations = new SimpleStringProperty(affective);
            this.instinctualOperations = new SimpleStringProperty(instinctual);
            this.miscellaneousOperations = new SimpleStringProperty(miscellaneous);
            this.value = new SimpleStringProperty(value);
        }
 
        public String getFactor() {
            return factor.get();
        }
 
        public void setFactor(String factor) {
            this.factor.set(factor);
        }
 
        public String getCognitiveSales() {
            return congitiveSales.get();
        }
 
        public void setCognitiveSales(String cognitiveSales) {
            this.congitiveSales.set(cognitiveSales);
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
 
        public void setMiscellaneousSales(String MiscellaneousSales) {
            this.miscellaneousSales.set(miscellaneousSales);
        }

        public String getCognitiveFinance() {
            return congitiveFinance.get();
        }
 
        public void setCognitiveFinance(String cognitiveFinance) {
            this.congitiveFinance.set(cognitiveFinance);
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
 
        public void setMiscellaneousFinance(String MiscellaneousFinance) {
            this.miscellaneousFinance.set(miscellaneousFinance);
        }

        public String getCognitiveTechnology() {
            return congitiveTechnology.get();
        }
 
        public void setCognitiveTechnology(String cognitiveTechnology) {
            this.congitiveTechnology.set(cognitiveTechnology);
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
 
        public void setMiscellaneousTechnology(String MiscellaneousTechnology) {
            this.miscellaneousTechnology.set(miscellaneousTechnology);
        }

        public String getCognitiveOperations() {
            return congitiveOperations.get();
        }
 
        public void setCognitiveOperations(String cognitiveOperations) {
            this.congitiveOperations.set(cognitiveOperations);
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

        public String getCycleCognitive() {
            return cycleCognitive.get();
        }
 
        public void setCycleCognitive(String cycleCognitive) {
            this.cycleCognitive.set(cycleCognitive);
        }

        public String getCycleAffective() {
            return cycleAffective.get();
        }
 
        public void setCycleAffective(String cycleAffective) {
            this.cycleAffective.set(cycleAffective);
        }

        public String getCycleInstinctual() {
            return cycleInstinctual.get();
        }
 
        public void setCycleInstinctual(String cycleInstinctual) {
            this.cycleInstinctual.set(cycleInstinctual);
        }

        public String getCycleMiscellaneous() {
            return cycleMiscellaneous.get();
        }
 
        public void setCycleMiscellaneous(String cycleMiscellaneous) {
            this.cycleMiscellaneous.set(cycleMiscellaneous);
        }
     
    }
}
