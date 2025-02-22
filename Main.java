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
 
        TableColumn<Viewpoint, String> cognitiveCol = new TableColumn<>("Cognitive");
        cognitiveCol.setMinWidth(100);
        cognitiveCol.setCellValueFactory(new PropertyValueFactory<>("cognitive"));
        cognitiveCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        cognitiveCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCognitive(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> affectiveCol = new TableColumn<>("Affective");
        affectiveCol.setMinWidth(100);
        affectiveCol.setCellValueFactory(new PropertyValueFactory<>("affective"));
        affectiveCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        affectiveCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAffective(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> instinctualCol = new TableColumn<>("Instinctual");
        instinctualCol.setMinWidth(100);
        instinctualCol.setCellValueFactory(new PropertyValueFactory<>("instinctual"));
        instinctualCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        instinctualCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setInstinctual(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> chemicalCol = new TableColumn<>("Chemical");
        ChemicalCol.setMinWidth(100);
        ChemicalCol.setCellValueFactory(new PropertyValueFactory<>("Chemical"));
        ChemicalCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        ChemicalCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setChemical(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> cognitiveCol = new TableColumn<>("Cognitive");
        cognitiveCol.setMinWidth(100);
        cognitiveCol.setCellValueFactory(new PropertyValueFactory<>("cognitive"));
        cognitiveCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        cognitiveCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCognitive(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> affectiveCol = new TableColumn<>("Affective");
        affectiveCol.setMinWidth(100);
        affectiveCol.setCellValueFactory(new PropertyValueFactory<>("affective"));
        affectiveCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        affectiveCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAffective(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> instinctualCol = new TableColumn<>("Instinctual");
        instinctualCol.setMinWidth(100);
        instinctualCol.setCellValueFactory(new PropertyValueFactory<>("instinctual"));
        instinctualCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        instinctualCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setInstinctual(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> chemicalCol = new TableColumn<>("Chemical");
        ChemicalCol.setMinWidth(100);
        ChemicalCol.setCellValueFactory(new PropertyValueFactory<>("Chemical"));
        ChemicalCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        ChemicalCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setChemical(t.getNewValue());
            }
        );

                TableColumn<Viewpoint, String> cognitiveCol = new TableColumn<>("Cognitive");
        cognitiveCol.setMinWidth(100);
        cognitiveCol.setCellValueFactory(new PropertyValueFactory<>("cognitive"));
        cognitiveCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        cognitiveCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCognitive(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> affectiveCol = new TableColumn<>("Affective");
        affectiveCol.setMinWidth(100);
        affectiveCol.setCellValueFactory(new PropertyValueFactory<>("affective"));
        affectiveCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        affectiveCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAffective(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> instinctualCol = new TableColumn<>("Instinctual");
        instinctualCol.setMinWidth(100);
        instinctualCol.setCellValueFactory(new PropertyValueFactory<>("instinctual"));
        instinctualCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        instinctualCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setInstinctual(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> chemicalCol = new TableColumn<>("Chemical");
        ChemicalCol.setMinWidth(100);
        ChemicalCol.setCellValueFactory(new PropertyValueFactory<>("Chemical"));
        ChemicalCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        ChemicalCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setChemical(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> cognitiveCol = new TableColumn<>("Cognitive");
        cognitiveCol.setMinWidth(100);
        cognitiveCol.setCellValueFactory(new PropertyValueFactory<>("cognitive"));
        cognitiveCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        cognitiveCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCognitive(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> affectiveCol = new TableColumn<>("Affective");
        affectiveCol.setMinWidth(100);
        affectiveCol.setCellValueFactory(new PropertyValueFactory<>("affective"));
        affectiveCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        affectiveCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAffective(t.getNewValue());
            }
        );

        TableColumn<Viewpoint, String> instinctualCol = new TableColumn<>("Instinctual");
        instinctualCol.setMinWidth(100);
        instinctualCol.setCellValueFactory(new PropertyValueFactory<>("instinctual"));
        instinctualCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());
        instinctualCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setInstinctual(t.getNewValue());
            }
        );
 
        TableColumn<Viewpoint, String> chemicalCol = new TableColumn<>("Chemical");
        ChemicalCol.setMinWidth(100);
        ChemicalCol.setCellValueFactory(new PropertyValueFactory<>("Chemical"));
        ChemicalCol.setCellFactory(TextFieldTableCell.<Viewpoint>forTableColumn());       
        ChemicalCol.setOnEditCommit(
            (CellEditEvent<Viewpoint, String> t) -> {
                ((Viewpoint) t.getTableView().getItems().get(t.getTablePosition().getRow())).setChemical(t.getNewValue());
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
        table.getColumns().addAll(factorCol, cognitiveCol, affectiveCol, instinctualCol, chemicalCol, cognitiveCol, affectiveCol, instinctualCol, chemicalCol, cognitiveCol, affectiveCol, instinctualCol, chemicalCol, cognitiveCol, affectiveCol, instinctualCol, chemicalCol, valueCol);
 
        final TextField addFactor = new TextField();
        addFactor.setPromptText("Factor");
        addFactor.setMaxWidth(factorCol.getPrefWidth());
        final TextField addCognitive = new TextField();
        addCognitive.setMaxWidth(cognitiveCol.getPrefWidth());
        addCognitive.setPromptText("Cognitive");
        final TextField addAffective = new TextField();
        addAffective.setMaxWidth(affectiveCol.getPrefWidth());
        addAffective.setPromptText("Affective");
        final TextField addInstinctual = new TextField();
        addInstinctual.setMaxWidth(instinctualCol.getPrefWidth());
        addInstinctual.setPromptText("Instinctual");
        final TextField addChemical = new TextField();
        addChemical.setMaxWidth(chemicalCol.getPrefWidth());
        addChemical.setPromptText("Chemical");
        final TextField addCognitive = new TextField();
        addCognitive.setMaxWidth(cognitiveCol.getPrefWidth());
        addCognitive.setPromptText("Cognitive");
        final TextField addAffective = new TextField();
        addAffective.setMaxWidth(affectiveCol.getPrefWidth());
        addAffective.setPromptText("Affective");
        final TextField addInstinctual = new TextField();
        addInstinctual.setMaxWidth(instinctualCol.getPrefWidth());
        addInstinctual.setPromptText("Instinctual");
        final TextField addChemical = new TextField();
        addChemical.setMaxWidth(chemicalCol.getPrefWidth());
        addChemical.setPromptText("Chemical");
        final TextField addCognitive = new TextField();
        addCognitive.setMaxWidth(cognitiveCol.getPrefWidth());
        addCognitive.setPromptText("Cognitive");
        final TextField addAffective = new TextField();
        addAffective.setMaxWidth(affectiveCol.getPrefWidth());
        addAffective.setPromptText("Affective");
        final TextField addInstinctual = new TextField();
        addInstinctual.setMaxWidth(instinctualCol.getPrefWidth());
        addInstinctual.setPromptText("Instinctual");
        final TextField addChemical = new TextField();
        addChemical.setMaxWidth(chemicalCol.getPrefWidth());
        addChemical.setPromptText("Chemical");
        final TextField addCognitive = new TextField();
        addCognitive.setMaxWidth(cognitiveCol.getPrefWidth());
        addCognitive.setPromptText("Cognitive");
        final TextField addAffective = new TextField();
        addAffective.setMaxWidth(affectiveCol.getPrefWidth());
        addAffective.setPromptText("Affective");
        final TextField addInstinctual = new TextField();
        addInstinctual.setMaxWidth(instinctualCol.getPrefWidth());
        addInstinctual.setPromptText("Instinctual");
        final TextField addChemical = new TextField();
        addChemical.setMaxWidth(chemicalCol.getPrefWidth());
        addChemical.setPromptText("Chemical");
        final TextField addValue = new TextField();
        addValue.setMaxWidth(affectiveCol.getPrefWidth());
        addValue.setPromptText("Value");
 
        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            data.add(new Viewpoint(
                addFactor.getText(),
                addCognitive.getText(),
                addAffective.getText(),
                addInstinctual.getText(),
                addChemical.getText(),
                addCognitive.getText(),
                addAffective.getText(),
                addInstinctual.getText(),
                addChemical.getText(),
                addCognitive.getText(),
                addAffective.getText(),
                addInstinctual.getText(),
                addChemical.getText(),
                addCognitive.getText(),
                addAffective.getText(),
                addInstinctual.getText(),
                addChemical.getText(),
                addValue.getText()
            ));
            addFactor.clear();
            addCognitive.clear();
            addAffective.clear();
            addInstinctual.clear();
            addChemical.clear();
            addCognitive.clear();
            addAffective.clear();
            addInstinctual.clear();
            addChemical.clear();
            addCognitive.clear();
            addAffective.clear();
            addInstinctual.clear();
            addChemical.clear();
            addCognitive.clear();
            addAffective.clear();
            addInstinctual.clear();
            addChemical.clear();
            addValue.clear();
        });

        final Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction((ActionEvent e) -> {
            Double[] weights = new Double[26];
            Double total = 0.00;
            Viewpoint viewpoint = new Viewpoint("", "", "", "", "", "");
            for(int i=0; i<table.getItems().size(); i++) {
                viewpoint = table.getItems().get(i);
                Double weight = Double.parseDouble(viewpoint.congitive.get())+Double.parseDouble(viewpoint.affective.get());
                weight += Double.parseDouble(viewpoint.instinctual.get())+Double.parseDouble(viewpoint.chemical.get());
                weight += Double.parseDouble(viewpoint.congitive.get())+Double.parseDouble(viewpoint.affective.get());
                weight += Double.parseDouble(viewpoint.instinctual.get())+Double.parseDouble(viewpoint.chemical.get());
                weight += Double.parseDouble(viewpoint.congitive.get())+Double.parseDouble(viewpoint.affective.get());
                weight += Double.parseDouble(viewpoint.instinctual.get())+Double.parseDouble(viewpoint.chemical.get());
                weight += Double.parseDouble(viewpoint.congitive.get())+Double.parseDouble(viewpoint.affective.get());
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
        protected final SimpleStringProperty congitive;
        protected final SimpleStringProperty affective;
        protected final SimpleStringProperty instinctual;
        protected final SimpleStringProperty chemical;
        protected final SimpleStringProperty congitive;
        protected final SimpleStringProperty affective;
        protected final SimpleStringProperty instinctual;
        protected final SimpleStringProperty chemical;
        protected final SimpleStringProperty chemical;
        protected final SimpleStringProperty congitive;
        protected final SimpleStringProperty affective;
        protected final SimpleStringProperty instinctual;
        protected final SimpleStringProperty chemical;
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
