package com.jeecourse.account.ws.v1;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.SERVER)
public class AccountWsException extends RuntimeException{
    /**
	 * 
	 */
	
    public static final int ACCOUNT_NOT_FOUND = 1;
    public static final int ACCOUNT_ALREADY_EXISTS = 2;
    public static final int INTERNAL_ERROR = 500;
    
	private static final long serialVersionUID = -4522493639341328369L;
	private int errorCode;
    
    public AccountWsException(int errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	
    

}
