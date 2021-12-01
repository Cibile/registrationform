module com.example.registrationform {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.registrationform to javafx.fxml;
    exports com.example.registrationform;
}