package main;

import gui.ControlGridPane;
import gui.ControlPane;
import gui.MineSweeperPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import logic.GameLogic;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10));
		hBox.setSpacing(10);
		hBox.setPrefWidth(800);
		hBox.setPrefHeight(400);
		MineSweeperPane mineSweeperPane = new MineSweeperPane();
		ControlPane controlPane = new  ControlPane(mineSweeperPane);
		ControlGridPane controlGridPane = new ControlGridPane(controlPane);
		GameLogic.getInstance().setControlPane(controlPane);
		hBox.getChildren().add(mineSweeperPane);
		hBox.getChildren().add(controlGridPane);
		Scene scene = new Scene(hBox);
		primaryStage.setScene(scene);
		primaryStage.setTitle("MineSweeper");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
