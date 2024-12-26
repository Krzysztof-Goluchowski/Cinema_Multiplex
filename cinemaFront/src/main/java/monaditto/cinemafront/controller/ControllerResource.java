package monaditto.cinemafront.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public enum ControllerResource {
    LOGIN,
    REGISTRATION,
    ADMIN_PANEL,
    ADMIN_USER,
    ADMIN_EDIT_USER,
    ADMIN_MOVIE,
    ADMIN_EDIT_MOVIE,
    ADMIN_SCREENINGS,
    ADMIN_EDIT_SCREENING;

    public Resource getResource() {
        String resourceUrl = switch(this) {
            case LOGIN -> "fxml/Login.fxml";
            case REGISTRATION -> "fxml/Registration.fxml";
            case ADMIN_PANEL -> "fxml/AdminPanel.fxml";
            case ADMIN_USER -> "fxml/AdminUser.fxml";
            case ADMIN_EDIT_USER -> "fxml/EditUser.fxml";
            case ADMIN_MOVIE -> "fxml/AdminMovie.fxml";
            case ADMIN_EDIT_MOVIE -> "fxml/EditMovie.fxml";
            case ADMIN_SCREENINGS -> "fxml/AdminScreenings.fxml";
            case ADMIN_EDIT_SCREENING -> "fxml/EditScreening.fxml";
        };

        return new ClassPathResource(resourceUrl);
    }
}
