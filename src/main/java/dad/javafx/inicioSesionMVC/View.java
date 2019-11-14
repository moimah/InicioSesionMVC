package dad.javafx.inicioSesionMVC;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class View extends VBox {
	
	private TextField txt_usuario;
	private PasswordField pass_usuario;
	private Button btn_acceder;
	private Button btn_cancelar;


	public View() {
		super();
		
		/////////////////////
		
		txt_usuario = new TextField();
		txt_usuario.setPromptText("Usuario");
		txt_usuario.setPrefWidth(120);
		
		Label lbl_usuario = new Label("Usuario:");
		lbl_usuario.setPrefWidth(70);
		
		HBox hbox1 = new HBox(lbl_usuario, txt_usuario);
		hbox1.setAlignment(Pos.CENTER);
		hbox1.setSpacing(18);
		
		
		///////////////////////////
		
		pass_usuario = new PasswordField();
		pass_usuario.setPromptText("Contraseña");
		pass_usuario.setPrefWidth(120);
		
		Label lbl_pass = new Label("Contraseña:");
		lbl_pass.setPrefWidth(70);
		
		
		HBox hbox2 = new HBox(lbl_pass, pass_usuario);
		hbox2.setAlignment(Pos.CENTER);
		hbox2.setSpacing(18);
		
		///////////////////////////
		
		btn_acceder = new Button("Acceder");
		btn_acceder.setPrefWidth(65);
		//btn_acceder.setAlignment(Pos.CENTER);
		btn_cancelar = new Button("Cancelar");
		btn_cancelar.setPrefWidth(65);
		//btn_cancelar.setAlignment(Pos.CENTER);
		
		HBox hbox3 = new HBox(btn_acceder, btn_cancelar);
		hbox3.setAlignment(Pos.CENTER);
		hbox3.setPadding(new Insets(8));
		hbox3.setSpacing(10);
		
		
		/////////////////////////////////////
		
		this.setSpacing(10);
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(hbox1, hbox2, hbox3);
		
		
	}

	public TextField getTxt_usuario() {
		return txt_usuario;
	}
	

	public PasswordField getPass_usuario() {
		return pass_usuario;
	}


	
	public Button getBtn_acceder() {
		return btn_acceder;
	}
	
	
	
	public Button getBtn_cancelar() {
		return btn_cancelar;
	}
	
		
	
}
