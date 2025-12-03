package org.example.proyectoformsfx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.example.proyectoformsfx.matematicas.Ecuacion;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        // ------------------------------------------
        // Código anterior (comentado según el enunciado)
        /*
        Label label = new Label("Hola mundo!");
        StackPane sceneRoot = new StackPane(label);
        Scene scene = new Scene(sceneRoot, 320, 240);
        stage.setScene(scene);
        stage.show();
        */

        // ------------------------------------------
        // Nuevo formulario con GridPane
        /*
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 0, 0, 30)); // padding de la grilla
        grid.setHgap(10); // espaciado horizontal
        grid.setVgap(10); // espaciado vertical

        // Controles
        Label lblNombre = new Label("Nombre:");
        TextField txtNombre = new TextField();
        Label lblPrueba = new Label("Prueba:");
        Label lblEmail = new Label("Email:");
        TextField txtEmail = new TextField();
        Button btnGuardar = new Button("Guardar");
        Label labelMsg = new Label("Hola JavaFX");

        // Agregar controles al GridPane
        grid.add(lblNombre, 0, 0);
        grid.add(txtNombre, 1, 0);
        grid.add(lblPrueba, 2, 0);

        grid.add(lblEmail, 0, 1);
        grid.add(txtEmail, 1, 1);
        grid.add(btnGuardar, 1, 2);

        // Permitir que el label use 2 columnas
        GridPane.setColumnSpan(labelMsg, 2);
        grid.add(labelMsg, 0, 3);

        // Evento del botón Guardar
        btnGuardar.setOnAction(e -> {
            if (txtNombre.getText().isEmpty()) {
                labelMsg.setText("Debes ingresar el nombre");
                System.out.println("El nombre es obligatorio");
                return;
            }
            String nombre = txtNombre.getText();
            labelMsg.setText("Nombre guardado: " + nombre);
            System.out.println("Nombre guardado: " + nombre);
        });

        // Crear escena con StackPane como contenedor externo
        Scene scene = new Scene(new StackPane(grid), 400, 300);
        stage.setTitle("Título del formulario");
        stage.setScene(scene);
        scene.getStylesheets().add("estilos.css"); // si tienes el archivo CSS
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        */

                Label lbl1 = new Label("Ingrese el valor de a:");
                TextField txt1 = new TextField();

                Label lbl2 = new Label("Ingrese el valor de b:");
                TextField txt2 = new TextField();

                Label lbl3 = new Label("Ingrese el valor de c:");
                TextField txt3 = new TextField();

                Label lbl4 = new Label("Respuesta X1:");
                TextField txt4 = new TextField();

                Label lbl5 = new Label("Respuesta X2:");
                TextField txt5 = new TextField();

                Label lbl6 = new Label("Resultado:");
                TextField txt6 = new TextField();

                Label lbl7 = new Label(); // mensaje dinámico

                Button btnCalcular = new Button("CALCULAR");
                Button btnNuevo = new Button("NUEVO");

                // IDs para aplicar estilos CSS
                btnCalcular.setId("btnCalcular");
                btnNuevo.setId("btnNuevo");

                // Layout
                GridPane grid = new GridPane();
                grid.setPadding(new Insets(20));
                grid.setHgap(10);
                grid.setVgap(10);

                // Ubicación de controles
                grid.add(lbl1, 0, 0);
                grid.add(txt1, 1, 0);

                grid.add(lbl2, 0, 1);
                grid.add(txt2, 1, 1);

                grid.add(lbl3, 0, 2);
                grid.add(txt3, 1, 2);

                grid.add(lbl4, 0, 3);
                grid.add(txt4, 1, 3);

                grid.add(lbl5, 0, 4);
                grid.add(txt5, 1, 4);

                grid.add(lbl6, 0, 5);
                grid.add(txt6, 1, 5);

                GridPane.setColumnSpan(lbl7, 2);
                grid.add(lbl7, 0, 6);

                grid.add(btnCalcular, 0, 7);
                grid.add(btnNuevo, 1, 7);

                // Campos de respuesta solo lectura
                txt4.setEditable(false);
                txt5.setEditable(false);
                txt6.setEditable(false);

                // Evento CALCULAR usando la clase Ecuacion
                btnCalcular.setOnAction(e -> {
                    try {
                        double a = Double.parseDouble(txt1.getText());
                        double b = Double.parseDouble(txt2.getText());
                        double c = Double.parseDouble(txt3.getText());

                        Ecuacion ecuacion = new Ecuacion(a, b, c);
                        ecuacion.calcular();

                        if (ecuacion.getX1() == null || ecuacion.getX2() == null) {
                            lbl7.setText(ecuacion.getError());
                            txt4.clear();
                            txt5.clear();
                            txt6.clear();
                        } else {
                            txt4.setText(String.valueOf(ecuacion.getX1()));
                            txt5.setText(String.valueOf(ecuacion.getX2()));
                            txt6.setText("Δ = " + ecuacion.getDiscriminante());
                            lbl7.setText("Cálculo exitoso.");
                        }
                    } catch (NumberFormatException ex) {
                        lbl7.setText("Ingrese valores numéricos válidos.");
                        txt4.clear();
                        txt5.clear();
                        txt6.clear();
                    }
                });

                // Evento NUEVO
                btnNuevo.setOnAction(e -> {
                    txt1.clear();
                    txt2.clear();
                    txt3.clear();
                    txt4.clear();
                    txt5.clear();
                    txt6.clear();
                    lbl7.setText("");
                });

                // Escena
                Scene scene = new Scene(new StackPane(grid), 500, 450);
                stage.setTitle("Formulario Cuadrático");
                stage.setScene(scene);
                scene.getStylesheets().add(getClass().getResource("/estilos.css").toExternalForm());
                stage.show();
            }

            public static void main(String[] args) {
                launch(args);
            }
        }



