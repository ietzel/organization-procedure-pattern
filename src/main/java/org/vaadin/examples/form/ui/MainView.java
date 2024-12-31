package org.vaadin.examples.form.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.examples.form.data.UserDetails;
import org.vaadin.examples.form.data.UserDetailsService;
import org.vaadin.examples.form.data.UserDetailsService.ServiceException;
import org.vaadin.examples.form.ui.components.AvatarField;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid;
import com.vaadin.flow.component.gridpro;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

    private TextArea message;

    private UserDetailsService service;
    private BeanValidationBinder<UserDetails> binder;

    public MainView(@Autowired UserDetailsService service) {

        this.service = service;

        H3 title = new H3("Signup form");

        TextArea message = new TextArea("Pick a Business Function: Sales & Marketing, Finance & Accounting, Technology, Operations.");

        Grid<Viewpoint> grid = new Grid<>(Viewpoint.class, false);
        Editor<Viewpoint> editor = grid.getEditor();
        
        Grid.Column<Viewpoint> congitiveColumn = grid.addColumn(Viewpoint::getCongitive).setHeader("Congitive").setWidth("120px").setFlexGrow(0);
        Grid.Column<Viewpoint> affectiveColumn = grid.addColumn(Viewpoint::getAffective).setHeader("Affective").setWidth("120px").setFlexGrow(0);
        Grid.Column<Viewpoint> instinctualColumn = grid.addColumn(Viewpoint::getInstinctual).setHeader("Instinctual");
        Grid.Column<Viewpoint> miscColumn = grid.addComponentColumn(Viewpoint -> {
            Button editButton = new Button("Edit");
            editButton.addClickListener(e -> {
                if (editor.isOpen())
                    editor.cancel();
                grid.getEditor().editItem(Viewpoint);
            });
            return editButton;
        }).setWidth("150px").setFlexGrow(0);
        
        Binder<Viewpoint> binder = new Binder<>(Viewpoint.class);
        editor.setBinder(binder);
        editor.setBuffered(true);
        
        TextField cognitiveField = new TextField();
        firstNameField.setWidthFull();
        binder.forField(firstNameField).asRequired("Cognitive must not be empty").withStatusLabel(firstNameValidationMessage).bind(Viewpoint::getFirstName, Viewpoint::setFirstName);
        firstNameColumn.setEditorComponent(firstNameField);
        
        TextField affectiveField = new TextField();
        lastNameField.setWidthFull();
        binder.forField(lastNameField).asRequired("Affective name must not be empty").withStatusLabel(lastNameValidationMessage).bind(Viewpoint::getLastName, Viewpoint::setLastName);
        lastNameColumn.setEditorComponent(lastNameField);

        TextField instinctualField = new TextField();
        instinctualField.setWidthFull();
        binder.forField(Field).asRequired("Instinctual must not be empty").withStatusLabel(firstNameValidationMessage).bind(Viewpoint::getInstinctual, Viewpoint::setInstinctual);
        instinctualColumn.setEditorComponent(Field);
        
        TextField miscField = new TextField();
        miscField.setWidthFull();
        binder.forField(miscField).asRequired("Miscellaneous must not be empty").withStatusLabel(lastNameValidationMessage).bind(Viewpoint::getMisc, Viewpoint::setMisc);
        miscColumn.setEditorComponent(miscField);
        
        Button saveButton = new Button("Save", e -> editor.save());
        Button cancelButton = new Button(VaadinIcon.CLOSE.create(), e -> editor.cancel());
        cancelButton.addThemeVariants(ButtonVariant.LUMO_ICON, ButtonVariant.LUMO_ERROR);
        HorizontalLayout actions = new HorizontalLayout(saveButton, cancelButton);
        actions.setPadding(false);
        editColumn.setEditorComponent(actions);
        
        FormLayout formLayout = new FormLayout(title, message);

        formLayout.setMaxWidth("500px");
        formLayout.getStyle().set("margin", "0 auto");

        formLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1, FormLayout.ResponsiveStep.LabelsPosition.TOP), new FormLayout.ResponsiveStep("490px", 2, FormLayout.ResponsiveStep.LabelsPosition.TOP));

        formLayout.setColspan(title, 2);

        add(formLayout);
        
        binder = new BeanValidationBinder<UserDetails>(UserDetails.class);

        binder.setStatusLabel(errorMessage);
    }
}
