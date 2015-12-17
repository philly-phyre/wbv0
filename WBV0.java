package org.tempestdesign.webviewzero;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class WBV0 extends Application {
	private String title = "WeightLess Browser \u0020\u0020 |  | \u0020\u0020 Welcome Home";
	private String home = "http://www.tempestdesign.org/";
	@Override
	public void start(Stage win) {
		win.setTitle(title);
		WebView wbv = new WebView();
		wbv.autosize();
		wbv.setPrefHeight(1896);
		for( String s : wbv.getStylesheets())
			System.out.println(s);
		WebEngine wbngn = wbv.getEngine();
		wbngn.load(home);
		GridPane portal = new GridPane();
		HBox cmds = new HBox(1);
		Button btnREF, btnMIN, btnEXIT;
		btnREF = new Button("ld");
		btnMIN = new Button("rld");
		btnEXIT = new Button("xt");
		TextField searchbar = new TextField();
		searchbar.setPrefSize(911, 16);
		searchbar.setPromptText("\t >> ?Enter URL . . .");
		searchbar.setOnKeyReleased(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				String site = searchbar.getText();
				if (!site.endsWith(".com") && !site.endsWith(".org") && !site.endsWith(".net") && !site.endsWith(".co.nf")){
					site.replaceAll("\\s+", "%");
					site = "https://www.google.com/search?q=" + site + "&ie=&oe=";
				}
				if (!site.startsWith("http"))
					site = "http://" + site + "/";
				System.out.println(">> ? " + site);
				wbngn.load(site);
				System.out.println("------------------------------------ \n>> ? " + wbngn.getLocation());
			}
		});
		cmds.getChildren().addAll(searchbar, btnREF, btnMIN, btnEXIT);
		portal.add(cmds, 0, 0);
		portal.add(wbv, 0, 1);
		Scene s0 = new Scene(portal, 987, 765);
		win.setScene(s0);
		win.show();
		win.setResizable(false);
		win.setAlwaysOnTop(true);
	}
	public static void main(String args[]) {
		launch(args);
	}
	
}
