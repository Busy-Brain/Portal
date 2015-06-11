package com.mk.portal.framework.exceptions;

/**
 * This Exception class is to be used when an irrecoverable error is to be thrown
 * TODO validate if this class is required
 * 
 * @author mohit
 *
 */
public class IrrecoverableError extends Error implements PortalException {

	private static final long serialVersionUID = 274537820248427937L;

	IrrecoverableError(Exception e) {
		super(e);
	}

	public IrrecoverableError(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public IrrecoverableError(Exception e, String errorCode, String errorMessage) {
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
