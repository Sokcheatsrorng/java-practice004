package view;

import loading.LoadingProperties;
import model.service.UserServiceImpl;

public class Application {
     private static final ViewUI view = new ViewUI();

    public static void main(String[] args) {
        view.ui();
    }
}
