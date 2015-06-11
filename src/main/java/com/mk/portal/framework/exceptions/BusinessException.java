package com.mk.portal.framework.exceptions;

/**
 * This Exception class is to be used when a recoverable business exception is
 * to be handled. e.g. when user provides an inappropriate value
 * 
 * @author mohit
 *
 */
public class BusinessException extends Exception implements PortalException {

	private static final long serialVersionUID = 274537820248427937L;

	BusinessException(Exception e) {
		super(e);
	}

	public BusinessException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public BusinessException(Exception e, String errorCode, String errorMessage) {
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
