package com.mk.portal.framework.exceptions;

/**
 * This Exception class is to be used to inform the user about some actions, 
 * e.g. when inputs are defaulted or a business exception is handled by the system
 * 
 * @author mohit
 *
 */
public class BusinessInfoException extends Exception implements PortalException {

	private static final long serialVersionUID = 274537820248427937L;

	BusinessInfoException(Exception e) {
		super(e);
	}

	public BusinessInfoException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public BusinessInfoException(Exception e, String errorCode, String errorMessage) {
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
