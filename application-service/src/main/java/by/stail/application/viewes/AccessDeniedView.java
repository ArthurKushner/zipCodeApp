package by.stail.application.viewes;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * @autor Arthur Kushner
 * @since 4/25/17
 */
@UIScope
@SpringView(name = AccessDeniedView.VIEW_NAME)
public class AccessDeniedView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "denied";


    @PostConstruct
    private void init() {
        this.addComponent(new Label("Access denied"));
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // This view is constructed in the init() method() by Spring container and not by Vaadin framework
    }
}
