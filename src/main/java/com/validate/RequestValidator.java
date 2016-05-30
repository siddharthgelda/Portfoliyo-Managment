package com.validate;

import org.springframework.stereotype.Component;

import com.exception.InvalidParameterException;
import com.model.Portfoliyo;

@Component
public interface RequestValidator {
	public void findCompanyRequestValidate(String query)throws InvalidParameterException ;

	public void findStockRequestValidate(String query)throws InvalidParameterException ;

	public void createPorfoliyoRequestValidate(Portfoliyo portfoliyo)throws InvalidParameterException ;
	

}
