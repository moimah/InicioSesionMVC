package dad.javafx.inicioSesionMVC;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {
	
	private StringProperty sp_nombreUsuario = new SimpleStringProperty();
	private StringProperty sp_passUsuario = new SimpleStringProperty();
		
	
	public final StringProperty sp_nombreUsuarioProperty() {
		return this.sp_nombreUsuario;
	}
	
	public final String getSp_nombreUsuario() {
		return this.sp_nombreUsuarioProperty().get();
	}
	
	public final void setSp_nombreUsuario(final String sp_nombreUsuario) {
		this.sp_nombreUsuarioProperty().set(sp_nombreUsuario);
	}
	
	public final StringProperty sp_passUsuarioProperty() {
		return this.sp_passUsuario;
	}
	
	public final String getSp_passUsuario() {
		return this.sp_passUsuarioProperty().get();
	}
	
	public final void setSp_passUsuario(final String sp_passUsuario) {
		this.sp_passUsuarioProperty().set(sp_passUsuario);
	}
	

	
	
}
