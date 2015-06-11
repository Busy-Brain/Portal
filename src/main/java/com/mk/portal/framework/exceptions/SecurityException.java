package com.mk.portal.framework.exceptions;

/**
 * This Exception class is to be used when a hacking attempt is made or a potential security breach is tried
 * This is specially created to cater security needs of the system
 * 
 * @author mohit
 *
 */
public class SecurityException extends RuntimeException implements PortalException {

	private static final long serialVersionUID = 274537820248427937L;

	SecurityException(Exception e) {
		super(e);
	}

	public SecurityException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public SecurityException(Exception e, String errorCode, String errorMessage) {
		super(e);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	private String errorCode;
	private String errorMessage;

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
