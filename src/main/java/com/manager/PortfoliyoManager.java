package com.manager;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dto.*;
import com.exception.CommuncationException;
import com.model.Portfoliyo;
@Component
public interface PortfoliyoManager  {
public List<Company> getCompanys(String query)throws CommuncationException;

public List<Stock> getStocks(String query)throws CommuncationException;

public Portfoliyo createPortfoliyo(Portfoliyo portfoliyo);

public Portfoliyo getPortfoliyo(Long Id);
}
