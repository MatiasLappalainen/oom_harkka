package demot.demo5;

public class DA5Main {
    // alustaa demo-ohjelman (JavaFX)
    public static void main(String[] args) {
        System.out.println("Hi there, if you get: Error: JavaFX runtime components are missing, and are required to run this application");
        System.out.println("remember to set --module-path openjfx/javafx-sdk-11/lib/ --add-modules=javafx.base,javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web");
        System.out.println("when launching java");
        DemoApp5.launch(DemoApp5.class, args);
    }
}