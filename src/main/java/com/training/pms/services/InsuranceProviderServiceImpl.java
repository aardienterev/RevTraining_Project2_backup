package com.training.pms.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.pms.models.Insurance;
import com.training.pms.models.InsuranceProvider;
import com.training.pms.repository.InsuranceProviderRepository;

@Service
public class InsuranceProviderServiceImpl implements InsuranceProviderService
{
	@Autowired
	private InsuranceProviderRepository repo;
	private static Logger log = Logger.getLogger(InsuranceProviderServiceImpl.class.getName());
	
	@Override
	public String addInsuranceProvider(InsuranceProvider obj)
	{
		String msg = "";
		
		try
		{
			if(obj != null)
				repo.save(obj);
			
			msg = "InsuranceProvider | Id: " + obj.getProviderId()  + " | was added to the database";
			log.info(msg);
		}
		catch (NullPointerException e)
		{
			msg = "InsuranceProvider was null in addInsuranceProvider() | Error Msg: " + e.getMessage();
			log.error(msg);
		}
		catch (Exception e)
		{
			msg = "Unhandled exception in addInsuranceProvider() | " + e.getMessage();
			log.error(msg);
		}
		
		return msg;
	}
	@Override
	public String updateInsuranceProvider(InsuranceProvider obj)
	{
		String msg = "";
		try
		{
			repo.save(obj);
			msg = "InsuranceProvider | Id: " + obj.getProviderId() + " | was updated in the database";
			log.info(msg);
		}
		catch (NullPointerException e)
		{
			msg = "InsuranceProvider was null in updateInsuranceProvider() | Error Msg: " + e.getMessage();
			log.error(msg);
		}
		catch (Exception e)
		{
			msg = "Unhandled exception in updateInsuranceProvider() | " + e.getMessage();
			log.error(msg);
		}
		
		return msg;
	}
	@Override
	public String deleteInsuranceProvider(InsuranceProvider obj)
	{
		String msg = "";
		
		try
		{
			repo.delete(obj);
			
			msg = "InsuranceProvider | Id: " + obj.getProviderId() +  " | was deleted to the database";
			log.info(msg);
		}
		catch (NullPointerException e)
		{
			msg = "InsuranceProvider was null in deleteInsuranceProvider() | Error Msg: " + e.getMessage();
			log.error(msg);
		}
		catch (Exception e)
		{
			msg = "Unhandled exception in deleteInsuranceProvider() | " + e.getMessage();
			log.error(msg);
		}
		
		return msg;
	}
	@Override
	public List<InsuranceProvider> getAllProviders()
	{
		List<InsuranceProvider> pList = null;
		
		try
		{
			pList = (List<InsuranceProvider>) repo.findAll();
			
			if(pList == null)
				throw new NullPointerException("InsuranceProviderRepository returned a null list");
			
			log.info("getAllProviders() called | Result: " + pList);
		}catch(NullPointerException e)
		{
			log.error("NullPointer exception in getAllProviders() | Error: " + e.getMessage());
		}catch (Exception e)
		{
			log.error("Unhandled exception in getAllProviders() | Error: " + e.getMessage());
		}
		
		return pList;
	}
}
