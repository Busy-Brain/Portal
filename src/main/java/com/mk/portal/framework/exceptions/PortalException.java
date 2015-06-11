package com.mk.portal.framework.exceptions;

//TODO Exception hierarchy not good
//define types of exceptions at framework level e.g. info, recoverableProblem, bug, irrecoverableProblem, ProbablyHacking etc
public interface PortalException {
	public String getErrorCode();

	public String getErrorMessage();
}
