module org.example.proyectoformsfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.jfr;


    opens org.example.proyectoformsfx to javafx.fxml;
    exports org.example.proyectoformsfx;
}