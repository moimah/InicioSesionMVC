package dad.javafx.inicioSesionMVC;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.commons.codec.digest.DigestUtils;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.Property;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {
	
	private Model model = new Model();
	private View view = new View();
	
	
	public Controller() {
		
		//Bindeos
		
		model.sp_nombreUsuarioProperty().bind(view.getTxt_usuario().textProperty());					
		model.sp_passUsuarioProperty().bind(view.getPass_usuario().textProperty());
		
				
				
		//Listener
		
		view.getBtn_acceder().setOnAction(e -> onAccederActionEvent(e));
		
		view.getBtn_cancelar().setOnAction(e -> onCancelarActionEvent(e));
		
		view.setOnKeyPressed(e -> onPressEnter(e));
		
	
	}	



	//Si se ha validado al usuario, mostrar mensaje y llamar a metodo accesoPermitido
	//En caso de no validar, mostrar mensaje y llamar a metodo acceso denegado	
	

	private void onAccederActionEvent(ActionEvent e) {
		
		if(validarUsuario()) {
			System.out.println("Se ha validado");
			accesoPermitido();
			
		}else {
			System.out.println("No se ha podido validar");
			accesoDenegado();
		}		
		
	}
	
	
	//Realiza lo mismo que el método anterior pero al pulsar la tecla ENTER
	//Si se ha validado al usuario, mostrar mensaje y llamar a metodo accesoPermitido
	//En caso de no validar, mostrar mensaje y llamar a metodo acceso denegado
	
	
	private void onPressEnter(KeyEvent e) {
		
		if (e.getCode() == KeyCode.ENTER) {           
			
			if(validarUsuario()) {
				System.out.println("Se ha validado");
				accesoPermitido();
				
			}else {
				System.out.println("No se ha podido validar");
				accesoDenegado();
			}
					
			
        }
		
	}
	
	
	 
	
	//Si se ha pulsado en cancelar abandonar la aplicación
	
	private void onCancelarActionEvent(ActionEvent e) {
		
		Platform.exit();
		
	}
	
	public View getRoot() {
		return view;
		
	}
	
	
		public boolean validarUsuario() {
		
		//Variables de metodo
		
		String temp_user = model.getSp_nombreUsuario();
		String temp_pass = DigestUtils.md5Hex(model.getSp_passUsuario()).toUpperCase();		
		boolean acceso = false;
		
		
		//BLOQUE DE LECTURA DE FICHERO
		
		String fichero = "users.csv";
		String line = "";
		String separador = ",";
		
		try {
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);
			
			line = br.readLine();
			
			while(line != null) {
				
				String[] datos = line.split(separador);
				
				//Condicional que se encarga de comprobar que coincide nombre y contraseña con los almacenados
				
				if(  (temp_user.equals(datos[0]))  &&  (temp_pass.equals(datos[1]))  ) { 														
					acceso = true; //Validamos el acceso
					br.close();
					fr.close();
					break; //Abandonamos el bucle	
				
				}
				
				
				line = br.readLine();
				
			}
			br.close();
			fr.close();
			
			
		} catch (Exception e1) {
			
			System.out.println("Error en la lectura");
		}
		
		
		return acceso;
		
	}
	
		
		//Método que a traves de alert envia mensaje de validación afirmativa y abandona el programa
		
		public void accesoPermitido() {
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Iniciar sesion");
			alert.setHeaderText("Acceso permitido");
			alert.setContentText("Las credenciales de acceso son válidas");
			alert.showAndWait();
			Platform.exit();
			
		}
		
		//Método que a traves de alert envia mensaje de acceso denegado y borra el contenido del password
		
	public void accesoDenegado() {
		
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Iniciar sesion");
		alert.setHeaderText("Acceso denegado");
		alert.setContentText("El usuario y/o la contraseña no son validos");
		alert.showAndWait();
		
	
		
		view.getPass_usuario().textProperty().set("");
	
				
	}
	
}
