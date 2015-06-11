package com.mk.portal.framework.exceptions;

/**
 * This Exception class is to be used to inform the system admins about some potential bugs in the system
 * e.g. incorrect configuration
 * 
 * @author mohit
 *
 */
public class PotentialBugException extends RuntimeException implements PortalException {

	private static final long serialVersionUID = 274537820248427937L;

	PotentialBugException(Exception e) {
		super(e);
	}

	public PotentialBugException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public PotentialBugException(Exception e, String errorCode, String errorMessage) {
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
