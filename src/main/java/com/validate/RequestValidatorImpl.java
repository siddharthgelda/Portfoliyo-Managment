package com.validate;

import org.springframework.stereotype.Component;

import com.exception.InvalidParameterException;
import com.model.Portfoliyo;

@Component
public class RequestValidatorImpl implements RequestValidator{


	@Override
	public void findCompanyRequestValidate(String query) throws InvalidParameterException {
		if(query.isEmpty())
			throw new InvalidParameterException();
		
		
	}

	@Override
	public void findStockRequestValidate(String query) throws InvalidParameterException {
		if(query.isEmpty())
			throw new InvalidParameterException();
		
		
	}
	@Override
	public void createPorfoliyoRequestValidate(Portfoliyo portfoliyo) throws InvalidParameterException {
		if(portfoliyo==null)
			throw new InvalidParameterException();
		if(portfoliyo.getName().isEmpty())
			throw new InvalidParameterException();
		if(portfoliyo.getUserId() < 1)
			throw new InvalidParameterException();
		
	}

}
