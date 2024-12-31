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

        Grid<Person> grid = new Grid<>(Person.class, false);
        Editor<Person> editor = grid.getEditor();
        
        Grid.Column<Person> firstNameColumn = grid.addColumn(Person::getFirstName).setHeader("First name").setWidth("120px").setFlexGrow(0);
        Grid.Column<Person> lastNameColumn = grid.addColumn(Person::getLastName).setHeader("Last name").setWidth("120px").setFlexGrow(0);
        Grid.Column<Person> emailColumn = grid.addColumn(Person::getEmail).setHeader("Email");
        Grid.Column<Person> editColumn = grid.addComponentColumn(person -> {
            Button editButton = new Button("Edit");
            editButton.addClickListener(e -> {
                if (editor.isOpen())
                    editor.cancel();
                grid.getEditor().editItem(person);
            });
            return editButton;
        }).setWidth("150px").setFlexGrow(0);
        
        Binder<Person> binder = new Binder<>(Person.class);
        editor.setBinder(binder);
        editor.setBuffered(true);
        
        TextField firstNameField = new TextField();
        firstNameField.setWidthFull();
        binder.forField(firstNameField).asRequired("First name must not be empty").withStatusLabel(firstNameValidationMessage).bind(Person::getFirstName, Person::setFirstName);
        firstNameColumn.setEditorComponent(firstNameField);
        
        TextField lastNameField = new TextField();
        lastNameField.setWidthFull();
        binder.forField(lastNameField).asRequired("Last name must not be empty").withStatusLabel(lastNameValidationMessage).bind(Person::getLastName, Person::setLastName);
        lastNameColumn.setEditorComponent(lastNameField);
        
        EmailField emailField = new EmailField();
        emailField.setWidthFull();
        binder.forField(emailField).asRequired("Email must not be empty").withValidator(new EmailValidator("Enter a valid email address")).withStatusLabel(emailValidationMessage).bind(Person::getEmail, Person::setEmail);
        emailColumn.setEditorComponent(emailField);
        
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
