package com.mk.portal.framework.service;

public interface PortalService<InputVo extends PortalVO,ResponseVo extends ServiceResponse> {
public ResponseVo execute( InputVo vo);
}
