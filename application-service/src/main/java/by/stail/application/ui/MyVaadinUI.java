package by.stail.application.ui;

import by.stail.application.viewes.AccessDeniedView;
import by.stail.application.viewes.LoginView;
import by.stail.application.viewes.MainView;
import by.stail.data.entities.User;
import by.stail.data.services.UserService;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.UI;
import org.bson.types.ObjectId;

import javax.inject.Inject;
import java.util.*;

/**
 * @autor Arthur Kushner
 * @since 4/7/17
 */
@Theme("cust")
@SpringUI(path = "")
@SpringViewDisplay
public class MyVaadinUI extends UI {


    @Inject
    SpringNavigator applicationNavigator;

    @Inject
    UserService userService;



    @Inject
    LoginView loginView;

    @Inject
    MainView mainView;


    @Override
    protected void init(VaadinRequest request) {

        applicationNavigator.setErrorView(AccessDeniedView.class);

        this.setSizeFull();


        updateContent();


    }

    private void updateContent() {

        ObjectId userId = (ObjectId) VaadinSession.getCurrent().getAttribute("userId");
        Optional<User> user = userService.findUserById(userId);

        if(user.isPresent()){

            getNavigator().navigateTo(getNavigator().getState());
        }
        else {

            getNavigator().navigateTo(LoginView.VIEW_NAME);
        }

    }


}