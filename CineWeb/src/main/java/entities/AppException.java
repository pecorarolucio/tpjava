package entities;

@SuppressWarnings("serial")
public class AppException extends Exception {
	String errormsg;
	
	public AppException(String errormsg) {
		this.errormsg = errormsg;
	}
}
