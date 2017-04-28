package by.stail.application.components;

import by.stail.data.entities.ZipCode;
import by.stail.data.services.ZipCodeService;
import com.vaadin.data.HasValue;
import com.vaadin.data.ValueProvider;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * Spring component which creates grid for {@link ZipCode} objects
 * with filter form
 *
 * @autor Arthur Kushner
 * @since 4/28/17
 */
@UIScope
@SpringComponent
public class ZipCodeGrid extends VerticalLayout {

    @Inject
    ZipCodeService zipCodeService;

    private Grid<ZipCode> grid;


    @PostConstruct
    private void init() {

        Label label = createLabel();
        this.addComponent(label);
        this.setComponentAlignment(label,Alignment.TOP_CENTER);
        this.addComponent(createFilterForm());
        this.addComponentsAndExpand(initZipCodeGrid());


    }


    private Label createLabel(){
        Label label = new Label("Full-text search sample");
        label.setStyleName(ValoTheme.TEXTFIELD_LARGE);


        return label;
    }

    /**
     * Creates {@link Grid} object for collection of {@link ZipCode} objects
     *
     * @return grid for ZipCode collection
     */
    private Grid<ZipCode> initZipCodeGrid() {
        grid = new Grid<>(ZipCode.class);
        grid.setItems(zipCodeService.getAllZipCodes());
        grid.setSizeFull();

        return grid;

    }


    /**
     * Creates form with text filter fields
     *
     * @return form with filter fields
     */
    private FormLayout createFilterForm() {
        FormLayout filterForm = new FormLayout();

        filterForm.addComponent(createFilterfield("Zip Code", ZipCode::getZipCode));
        filterForm.addComponent(createFilterfield("City", ZipCode::getCity));
        filterForm.addComponent(createFilterfield("State", ZipCode::getState));
        filterForm.setCaption("Type text to filter grid...");
        filterForm.setSpacing(true);
        filterForm.setMargin(false);
        return filterForm;
    }


    /**
     * Creates filter and binds it to grid
     *
     * @param placeholder   filter name
     * @param valueProvider value provider for current filter
     * @return
     */
    private TextField createFilterfield(String placeholder, ValueProvider<ZipCode, Object> valueProvider) {
        TextField filter = new TextField();
        filter.setPlaceholder(placeholder);
        filter.addValueChangeListener(filterEvent -> onNameFilterTextChange(filterEvent, valueProvider));
        filter.setCaption(placeholder);
        filter.setIcon(VaadinIcons.FILTER);

        return filter;
    }


    /**
     * Binds filter event to grid
     *
     * @param event
     * @param valueProvider
     */
    @SuppressWarnings("unchecked")
    private void onNameFilterTextChange(HasValue.ValueChangeEvent<String> event, ValueProvider<ZipCode, Object> valueProvider) {
        ListDataProvider<ZipCode> dataProvider = (ListDataProvider<ZipCode>) grid.getDataProvider();
        dataProvider.setFilter(valueProvider, s -> caseInsensitiveContains(s.toString(), event.getValue()));
    }


    private Boolean caseInsensitiveContains(String where, String what) {
        return where.toLowerCase().contains(what.toLowerCase());
    }
}
