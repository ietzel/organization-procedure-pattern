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
 
    private static final TableView<Viewpoint> table = new TableView<>();
    private final ObservableList<Viewpoint> data = FXCollections.observableArrayList(
        new Viewpoint("honesty/integrity/transparency", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0"),
        new Viewpoint("compassion/respect", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0"),
        new Viewpoint("responsibility/accountability", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0"),
        new Viewpoint("loyalty/trustworthiness", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0"),
        new Viewpoint("law-abiding", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0"),
        new Viewpoint("fairness", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0"),
        new Viewpoint("leadership", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0"),
        new Viewpoint("anti-discrimination", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0"),
        new Viewpoint("workplace health/safety/security", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0"),
        new Viewpoint("employee code of conduct & anti-harassment", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0"),
        new Viewpoint("attendance & vacation & time-off", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0"),
        new Viewpoint("employee complaint", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0"),
        new Viewpoint("work schedule & rest period", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0"),
        new Viewpoint("substance abuse", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0"),
        new Viewpoint("mobile device management", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0"),
        new Viewpoint("compensation and benefits", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0"),
        new Viewpoint("travel", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0"),
        new Viewpoint("inclement weather", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0"),
        new Viewpoint("remote work", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0"),
        new Viewpoint("conflict of interest", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0"),
        new Viewpoint("acceptable use", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0"),
        new Viewpoint("compensation", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0"),
        new Viewpoint("safety", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0"),
        new Viewpoint("relationships", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0"),
        new Viewpoint("skill discretion", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0"),
        new Viewpoint("prospects", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "0")
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
 
        final Label label = new Label("Cognitive-Affective-Instinctual-Chemical Empathy Matrix");
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
 
        TableColumn<Viewpoint, String> chemicalSalesCol = new TableColumn<>("Chemical Sales");
        chemicalCol.setMinWidth(100);
        chemicalCol.setCellValueFactory(new PropertyValueFactory<>("chemical sales"));
        chemicalCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        chemicalCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSalesChemical(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> cognitiveCol = new TableColumn<>("Cognitive Finance");
        cognitiveFinanceCol.setMinWidth(100);
        cognitiveFinanceCol.setCellValueFactory(new PropertyValueFactory<>("cognitive finance"));
        cognitiveFinanceCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        cognitiveFinanceCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFinanceCognitive(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> affectiveCol = new TableColumn<>("Affective Finance");
        affectiveFinanceCol.setMinWidth(100);
        affectiveFinanceCol.setCellValueFactory(new PropertyValueFactory<>("affective finance"));
        affectiveFinanceCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        affectiveFinanceCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFinanceAffective(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> instinctualCol = new TableColumn<>("Instinctual Finance");
        instinctualFinanceCol.setMinWidth(100);
        instinctualFinanceCol.setCellValueFactory(new PropertyValueFactory<>("instinctual finance"));
        instinctualFinanceCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        instinctualFinanceCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFinanceInstinctual(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> chemicalCol = new TableColumn<>("Chemical Finance");
        chemicalCol.setMinWidth(100);
        chemicalCol.setCellValueFactory(new PropertyValueFactory<>("chemical finance"));
        chemicalCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        chemicalCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFinanceChemical(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> cognitiveCol = new TableColumn<>("Cognitive Technology");
        cognitiveTechnologyCol.setMinWidth(100);
        cognitiveTechnologyCol.setCellValueFactory(new PropertyValueFactory<>("cognitive technology"));
        cognitiveTechnologyCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        cognitiveTechnologyCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTechnologyCognitive(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> affectiveCol = new TableColumn<>("Affective Technology");
        affectiveTechnologyCol.setMinWidth(100);
        affectiveTechnologyCol.setCellValueFactory(new PropertyValueFactory<>("affective technology"));
        affectiveTechnologyCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        affectiveTechnologyCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTechnologyAffective(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> instinctualCol = new TableColumn<>("Instinctual Technology");
        instinctualTechnologyCol.setMinWidth(100);
        instinctualTechnologyCol.setCellValueFactory(new PropertyValueFactory<>("instinctual technology"));
        instinctualTechnologyCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        instinctualTechnologyCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTechnologyInstinctual(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> chemicalCol = new TableColumn<>("Chemical Technology");
        chemicalCol.setMinWidth(100);
        chemicalCol.setCellValueFactory(new PropertyValueFactory<>("chemical technology"));
        chemicalCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        chemicalCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTechnologyChemical(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> cognitiveCol = new TableColumn<>("Cognitive Operations");
        cognitiveOperationsCol.setMinWidth(100);
        cognitiveOperationsCol.setCellValueFactory(new PropertyValueFactory<>("cognitive operations"));
        cognitiveOperationsCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        cognitiveOperationsCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setOperationsCognitive(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> affectiveCol = new TableColumn<>("Affective Operations");
        affectiveOperationsCol.setMinWidth(100);
        affectiveOperationsCol.setCellValueFactory(new PropertyValueFactory<>("affective operations"));
        affectiveOperationsCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        affectiveOperationsCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setOperationsAffective(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> instinctualCol = new TableColumn<>("Instinctual Operations");
        instinctualOperationsCol.setMinWidth(100);
        instinctualOperationsCol.setCellValueFactory(new PropertyValueFactory<>("instinctual operations"));
        instinctualOperationsCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        instinctualOperationsCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setOperationsInstinctual(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> chemicalCol = new TableColumn<>("Chemical Operations");
        chemicalOperationsCol.setMinWidth(100);
        chemicalOperationsCol.setCellValueFactory(new PropertyValueFactory<>("chemical operations"));
        chemicalOperationsCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        chemicalOperationsCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setOperationsChemical(t.getNewValue());
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
 
        table.setItems(data);
        table.getColumns().addAll(factorCol, cognitiveSalesCol, affectiveSalesCol, instinctualSalesCol, chemicalSalesCol, cognitiveFinanceCol, affectiveFinanceCol, instinctualFinanceCol, chemicalFinanceCol, cognitiveTechnologyCol, affectiveTechnologyCol, instinctualTechnologyCol, chemicalTechnologyCol, cognitiveOperationsCol, affectiveOperationsCol, instinctualOperationsCol, chemicalOperationsCol, valueCol);
 
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
        final TextField addSalesChemical = new TextField();
        addSalesChemical.setMaxWidth(chemicalSalesCol.getPrefWidth());
        addSalesChemical.setPromptText("Chemical Sales");
        final TextField addFinanceCognitive = new TextField();
        addFinanceCognitive.setMaxWidth(cognitiveFinanceCol.getPrefWidth());
        addFinanceCognitive.setPromptText("Cognitive Finance");
        final TextField addFinanceAffective = new TextField();
        addFinanceAffective.setMaxWidth(affectiveFinanceCol.getPrefWidth());
        addFinanceAffective.setPromptText("Affective Finance");
        final TextField addFinanceInstinctual = new TextField();
        addFinanceInstinctual.setMaxWidth(instinctualFinanceCol.getPrefWidth());
        addFinanceInstinctual.setPromptText("Instinctual Finance");
        final TextField addFinanceChemical = new TextField();
        addFinanceChemical.setMaxWidth(chemicalFinanceCol.getPrefWidth());
        addFinanceChemical.setPromptText("Chemical Finance");
        final TextField addTechnologyCognitive = new TextField();
        addTechnologyCognitive.setMaxWidth(cognitiveTechnologyCol.getPrefWidth());
        addTechnologyCognitive.setPromptText("Cognitive Technology");
        final TextField addTechnologyAffective = new TextField();
        addTechnologyAffective.setMaxWidth(affectiveTechnologyCol.getPrefWidth());
        addTechnologyAffective.setPromptText("Affective Technology");
        final TextField addInstinctual = new TextField();
        addTechnologyInstinctual.setMaxWidth(instinctualTechnologyCol.getPrefWidth());
        addTechnologyInstinctual.setPromptText("InstinctualTechnology");
        final TextField addTechnologyChemical = new TextField();
        addTechnologyChemical.setMaxWidth(chemicalTechnologyCol.getPrefWidth());
        addTechnologyChemical.setPromptText("Chemical Technology");
        final TextField addOperationsCognitive = new TextField();
        addOperationsCognitive.setMaxWidth(cognitiveOperationsCol.getPrefWidth());
        addOperationsCognitive.setPromptText("Cognitive Operations");
        final TextField addOperationsAffective = new TextField();
        addOperationsAffective.setMaxWidth(affectiveOperationsCol.getPrefWidth());
        addOperationsAffective.setPromptText("Affective Operations");
        final TextField addOperationsInstinctual = new TextField();
        addOperationsInstinctual.setMaxWidth(instinctualOperationsCol.getPrefWidth());
        addOperationsInstinctual.setPromptText("Instinctual Operations");
        final TextField addOperationsChemical = new TextField();
        addOperationsChemical.setMaxWidth(chemicalOperationsCol.getPrefWidth());
        addOperationsChemical.setPromptText("Chemical Operations");
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
                addSalesChemical.getText(),
                addFinanceCognitive.getText(),
                addFinanceAffective.getText(),
                addFinanceInstinctual.getText(),
                addFinanceChemical.getText(),
                addTechnologyCognitive.getText(),
                addTechnologyAffective.getText(),
                addTechnologyInstinctual.getText(),
                addTechnologyChemical.getText(),
                addOperationsCognitive.getText(),
                addOperationsAffective.getText(),
                addOperationsInstinctual.getText(),
                addOperationsChemical.getText(),
                addOperationsValue.getText()
            ));
            addSalesFactor.clear();
            addSalesCognitive.clear();
            addSalesAffective.clear();
            addSalesInstinctual.clear();
            addFinanceChemical.clear();
            addFinanceCognitive.clear();
            addFinanceAffective.clear();
            addFinanceInstinctual.clear();
            addFinanceChemical.clear();
            addTechnologyCognitive.clear();
            addTechnologyAffective.clear();
            addTechnologyInstinctual.clear();
            addTechnologyChemical.clear();
            addOperationsCognitive.clear();
            addOperationsAffective.clear();
            addOperationsInstinctual.clear();
            addOperationsChemical.clear();
            addValue.clear();
        });

        final Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction((ActionEvent e) -> {
            Double[] weights = new Double[26];
            Double total = 0.00;
            Viewpoint viewpoint = new Viewpoint("", "", "", "", "", "");
            for(int i=0; i<table.getItems().size(); i++) {
                viewpoint = table.getItems().get(i);
                Double weight = Double.parseDouble(viewpoint.cognitive.get())+Double.parseDouble(viewpoint.affective.get());
                weight += Double.parseDouble(viewpoint.instinctual.get())+Double.parseDouble(viewpoint.chemical.get());
                weight += Double.parseDouble(viewpoint.cognitive.get())+Double.parseDouble(viewpoint.affective.get());
                weight += Double.parseDouble(viewpoint.instinctual.get())+Double.parseDouble(viewpoint.chemical.get());
                weight += Double.parseDouble(viewpoint.cognitive.get())+Double.parseDouble(viewpoint.affective.get());
                weight += Double.parseDouble(viewpoint.instinctual.get())+Double.parseDouble(viewpoint.chemical.get());
                weight += Double.parseDouble(viewpoint.cognitive.get())+Double.parseDouble(viewpoint.affective.get());
                weight += Double.parseDouble(viewpoint.instinctual.get())+Double.parseDouble(viewpoint.chemical.get())-80.00;
                weights[i] = weight;
                total += weight;
            }
            Viewpoint row = new Viewpoint(
                viewpoint.factor.get(), 
                viewpoint.congitive.get(), 
                viewpoint.affective.get(), 
                viewpoint.instinctual.get(),
                viewpoint.chemical.get(),
                viewpoint.congitive.get(), 
                viewpoint.affective.get(), 
                viewpoint.instinctual.get(),
                viewpoint.chemical.get(),
                viewpoint.congitive.get(), 
                viewpoint.affective.get(), 
                viewpoint.instinctual.get(),
                viewpoint.chemical.get(),
                viewpoint.congitive.get(), 
                viewpoint.affective.get(), 
                viewpoint.instinctual.get(),
                viewpoint.chemical.get(),
                String.valueOf(0.00)
            );
            for(int i=0; i<table.getItems().size(); i++) {
                if(weights[i] == 0.00) {
                    row = new Viewpoint(
                        viewpoint.factor.get(), 
                        viewpoint.congitive.get(), 
                        viewpoint.affective.get(), 
                        viewpoint.instinctual.get(),
                        viewpoint.chemical.get(),
                        viewpoint.congitive.get(), 
                        viewpoint.affective.get(), 
                        viewpoint.instinctual.get(),
                        viewpoint.chemical.get(),
                        viewpoint.congitive.get(), 
                        viewpoint.affective.get(), 
                        viewpoint.instinctual.get(),
                        viewpoint.chemical.get(),
                        viewpoint.congitive.get(), 
                        viewpoint.affective.get(), 
                        viewpoint.instinctual.get(),
                        viewpoint.chemical.get(),
                        String.valueOf(0.00)
                    );
                } else {
                row = new Viewpoint(
                    viewpoint.factor.get(), 
                    viewpoint.congitive.get(), 
                    viewpoint.affective.get(), 
                    viewpoint.instinctual.get(),
                    viewpoint.chemical.get(),
                    viewpoint.congitive.get(), 
                    viewpoint.affective.get(), 
                    viewpoint.instinctual.get(),
                    viewpoint.chemical.get(),
                    viewpoint.congitive.get(), 
                    viewpoint.affective.get(), 
                    viewpoint.instinctual.get(),
                    viewpoint.chemical.get(),
                    viewpoint.congitive.get(), 
                    viewpoint.affective.get(), 
                    viewpoint.instinctual.get(),
                    viewpoint.chemical.get(),
                    String.valueOf(100*weights[i]/total)
                );        
                }
                table.getItems().set(i, row);
            }
        });

        //typeface/hierarchy/contrast/consistency/alignment/blankspace/color
        TextArea paragraph = new TextArea("Business modalities may be composed of the following business models: servitisation, platform, social, employee, partner, value, innovation, data, savvy. The overall allocation of resources could be concieved as a long-term survival train trolley problem. In terms of political coring, Ratings of 0-3 are anti (-4 to -1), 4-6 are other (-1 to 1), 7-10 are pro (1 to 4). Complex typography conversion may allow for many runs to become similar to an encyclopedia.");
     
        hb.getChildren().addAll(addFactor, addCognitive, addAffective, addInstinctual, addChemical, addCognitive, addAffective, addInstinctual, addChemical, addCognitive, addAffective, addInstinctual, addChemical, addCognitive, addAffective, addInstinctual, addChemical, addValue, addButton, calculateButton);
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
        protected final SimpleStringProperty chemicalSales;
        protected final SimpleStringProperty congitiveFinance;
        protected final SimpleStringProperty affectiveFinance;
        protected final SimpleStringProperty instinctualFinance;
        protected final SimpleStringProperty cognitiveFinance;
        protected final SimpleStringProperty affectiveTechnology;
        protected final SimpleStringProperty instinctualTechnology;
        protected final SimpleStringProperty chemicalTechnology;
        protected final SimpleStringProperty chemicalTechnology;
        protected final SimpleStringProperty congitiveOperations;
        protected final SimpleStringProperty affectiveOperations;
        protected final SimpleStringProperty instinctualOperations;
        protected final SimpleStringProperty chemicalOperations;
        protected final SimpleStringProperty value;
 
        public Viewpoint(String factor, String cognitive, String affective, String instinctual, String chemical, String cognitive, String affective, String instinctual, String chemical, String cognitive, String affective, String instinctual, String chemical, String cognitive, String affective, String instinctual, String chemical, String value) {
            this.factor = new SimpleStringProperty(factor);
            this.congitive = new SimpleStringProperty(cognitive);
            this.affective = new SimpleStringProperty(affective);
            this.instinctual = new SimpleStringProperty(instinctual);
            this.chemical = new SimpleStringProperty(chemical);
            this.congitive = new SimpleStringProperty(cognitive);
            this.affective = new SimpleStringProperty(affective);
            this.instinctual = new SimpleStringProperty(instinctual);
            this.chemical = new SimpleStringProperty(chemical);
            this.congitive = new SimpleStringProperty(cognitive);
            this.affective = new SimpleStringProperty(affective);
            this.instinctual = new SimpleStringProperty(instinctual);
            this.chemical = new SimpleStringProperty(chemical);
            this.congitive = new SimpleStringProperty(cognitive);
            this.affective = new SimpleStringProperty(affective);
            this.instinctual = new SimpleStringProperty(instinctual);
            this.chemical = new SimpleStringProperty(chemical);
            this.value = new SimpleStringProperty(value);
        }
 
        public String getFactor() {
            return factor.get();
        }
 
        public void setFactor(String factor) {
            this.factor.set(factor);
        }
 
        public String getCognitive() {
            return congitive.get();
        }
 
        public void setCognitive(String cognitive) {
            this.congitive.set(cognitive);
        }
 
        public String getAffective() {
            return affective.get();
        }
 
        public void setAffective(String affective) {
            this.affective.set(affective);
        }

        public String getInstinctual() {
            return instinctual.get();
        }
 
        public void setInstinctual(String instinctual) {
            this.instinctual.set(instinctual);
        }

        public String getChemical() {
            return chemical.get();
        }
 
        public void setChemical(String Chemical) {
            this.chemical.set(chemical);
        }

                public String getCognitive() {
            return congitive.get();
        }
 
        public void setCognitive(String cognitive) {
            this.congitive.set(cognitive);
        }
 
        public String getAffective() {
            return affective.get();
        }
 
        public void setAffective(String affective) {
            this.affective.set(affective);
        }

        public String getInstinctual() {
            return instinctual.get();
        }
 
        public void setInstinctual(String instinctual) {
            this.instinctual.set(instinctual);
        }

        public String getChemical() {
            return chemical.get();
        }
 
        public void setChemical(String Chemical) {
            this.chemical.set(chemical);
        }

                public String getCognitive() {
            return congitive.get();
        }
 
        public void setCognitive(String cognitive) {
            this.congitive.set(cognitive);
        }
 
        public String getAffective() {
            return affective.get();
        }
 
        public void setAffective(String affective) {
            this.affective.set(affective);
        }

        public String getInstinctual() {
            return instinctual.get();
        }
 
        public void setInstinctual(String instinctual) {
            this.instinctual.set(instinctual);
        }

        public String getChemical() {
            return chemical.get();
        }
 
        public void setChemical(String Chemical) {
            this.chemical.set(chemical);
        }

                public String getCognitive() {
            return congitive.get();
        }
 
        public void setCognitive(String cognitive) {
            this.congitive.set(cognitive);
        }
 
        public String getAffective() {
            return affective.get();
        }
 
        public void setAffective(String affective) {
            this.affective.set(affective);
        }

        public String getInstinctual() {
            return instinctual.get();
        }
 
        public void setInstinctual(String instinctual) {
            this.instinctual.set(instinctual);
        }

        public String getChemical() {
            return chemical.get();
        }
 
        public void setChemical(String Chemical) {
            this.chemical.set(chemical);
        }
     
        public String getValue() {
            return value.get();
        }
 
        public void setValue(String value) {
            this.value.set(value);
        }
    }
}
