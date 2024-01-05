package entities;

@SuppressWarnings("serial")
public class AppException extends Exception {
	private String errormsg;
	private String error;
	private String errorPila;
	
	public AppException(String errormsg) {
		this.errormsg = errormsg;
	}
	
	public AppException(Throwable excepcion) {
		this.error = excepcion.getMessage();
		this.errorPila = excepcion.getStackTrace().toString();
	}
	
	public AppException(String errormsg, Throwable excepcion) {
		this.errormsg = errormsg;
		this.error = excepcion.getMessage();
		this.errorPila = excepcion.getStackTrace().toString();
	}
	
	public String getErrormsg() {
		return this.errormsg;
	}
	
	public void setErrormsg(String errormsg) {
		this.errormsg=errormsg;
	}
	
	public String getError() {
		return this.error;
	}
	
	public void setError(String error) {
		this.error=error;
	}
	
	public String getErrorPila() {
		return this.errorPila;
	}
	
	public void setErrorPila(String errorPila) {
		this.errorPila=errorPila;
	}
}
