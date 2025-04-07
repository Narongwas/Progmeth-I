package gui;

import java.net.URL;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class ControlGridPane extends GridPane{
	private final String miningImageURL = "bitcoin.png";
	private ControlPane controlPane;
	
	public ControlGridPane(ControlPane controlPane) {
		setControlPane(controlPane);
		URL miningImageStringURL = ClassLoader.getSystemResource(miningImageURL);
		ImageView miningImage = new ImageView(new Image(miningImageStringURL.toString()));
		miningImage.setFitWidth(150);
		miningImage.setFitHeight(150);
		BorderPane borderPane = new BorderPane();
		borderPane.setPrefWidth(150);
		borderPane.setPrefHeight(200);
		borderPane.setCenter(miningImage);
		this.add(borderPane, 0, 0);
		this.add(this.controlPane, 0, 1);
	}

	public void setControlPane(ControlPane controlPane) {
		this.controlPane = controlPane;
	}
	
}
