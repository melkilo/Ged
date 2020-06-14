package org.Ged.service.exception;

public class clientException extends RuntimeException {
	
	public clientException(String errorMessage) {
		super(errorMessage);
	}
	
	public clientException(clientExceptionEnum errorMessage) {
		super(errorMessage.getMessage());
	}
		
	public static enum clientExceptionEnum{
		
		CLIENT_ID_NOT_FOUND("Client n'existe pas");
		
		clientExceptionEnum(String message) {
			this.message = message;
		}

		private final String message;

		public String getMessage() {
			return this.message;
		}
	}
}
