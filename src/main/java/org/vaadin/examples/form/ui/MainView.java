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
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.binder.ValidationResult;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.router.Route;

//The backendservice and data class are in the <code>.data</code> package.

@Route("")
public class MainView extends VerticalLayout {

    private TextArea message;

    private UserDetailsService service;
    private BeanValidationBinder<UserDetails> binder;

    public MainView(@Autowired UserDetailsService service) {

        this.service = service;

        H3 title = new H3("Signup form");

        TextArea message = new TextArea("1wX XSTJ, 2wX XNFJ, 3wX XNTJ, 4wX XSFP, 5wX XSTP, 6wX XXXX, 7wX XNFP, 8wX XNTP, 9wX XSFJ.");

        FormLayout formLayout = new FormLayout(title, message);

        formLayout.setMaxWidth("500px");
        formLayout.getStyle().set("margin", "0 auto");

        formLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1, FormLayout.ResponsiveStep.LabelsPosition.TOP),
                new FormLayout.ResponsiveStep("490px", 2, FormLayout.ResponsiveStep.LabelsPosition.TOP));

        formLayout.setColspan(title, 2);

        errorMessage.getStyle().set("color", "var(--lumo-error-text-color)");
        errorMessage.getStyle().set("padding", "15px 0");

        add(formLayout);
        
        binder = new BeanValidationBinder<UserDetails>(UserDetails.class);

        binder.setStatusLabel(errorMessage);
    }

    private void showSuccess(UserDetails detailsBean) {
        Notification notification = Notification.show("Data saved, welcome " + detailsBean.getHandle());
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
    }

    private ValidationResult validateHandle(String handle, ValueContext ctx) {

        String errorMsg = service.validateHandle(handle);

        if (errorMsg == null) {
            return ValidationResult.ok();
        }

        return ValidationResult.error(errorMsg);
    }
}
