package by.stail.application.viewes;

import by.stail.application.components.LoginPanel;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Image;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import static by.stail.application.scss.ClassSelector.BOTTOM_LINE;
import static by.stail.application.scss.ClassSelector.LOGIN_PAGE;
import static by.stail.application.scss.ClassSelector.TOP_LINE;

/**
 * Application view for login
 *
 * @autor Arthur Kushner
 * @since 4/26/17
 */
@UIScope
@SpringView(name = LoginView.VIEW_NAME)
public class LoginView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "login";

    @Inject
    LoginPanel loginPanel;


    /**
     *  Creates login page view
     */
    @PostConstruct
    private void init() {


        // creates header
        VerticalLayout topLine = this.getTopLine();

        // creates footer
        VerticalLayout bottomLine = this.getBottomLine();

        // general css styling
        this.setMargin(false);
        this.addStyleName(LOGIN_PAGE);
        this.setSizeFull();

        // setting components into current view
        this.addComponent(topLine);
        this.addComponent(loginPanel);
        this.setExpandRatio(loginPanel, 1f);
        this.setComponentAlignment(loginPanel, Alignment.MIDDLE_CENTER);
        this.addComponent(bottomLine);



    }


    /**
     * Creates top header for current view
     *
     * @return header for current view with logo
     */
    private VerticalLayout getTopLine() {
        VerticalLayout topLine = new VerticalLayout();
        topLine.addStyleName(TOP_LINE);
        topLine.setMargin(false);
        topLine.setHeightUndefined();

        Image logo = new Image(null, new ThemeResource("images/companyLogo.png"));
        topLine.addComponent(logo);
        return topLine;
    }


    /**
     * Creates footer for current view
     *
     * @return footer for current view
     */
    private VerticalLayout getBottomLine() {
        VerticalLayout bottomLine = new VerticalLayout();
        bottomLine.addStyleName(BOTTOM_LINE);
        return bottomLine;
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // This view is constructed in the init() method() by Spring container and not by Vaadin framework
    }

}
