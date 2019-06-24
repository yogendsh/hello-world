package com.cg.onlinehotelmanagementsystem.utility;

import com.cg.onlinehotelmanagementsystem.exception.AreaNameException;
import com.cg.onlinehotelmanagementsystem.exception.CityNameException;
import com.cg.onlinehotelmanagementsystem.staticdb.ListData;

public class ValidCity {
	ListData listdata=new ListData();
	public int validCityName(String cityname)throws CityNameException
	{
		 for(int i=0;i<listdata.cityList().size();i++)
		 {
			 String check=(String) listdata.cityList().get(i);
			
			 if(cityname.toUpperCase().equals(check.toUpperCase()))
				 return ++i;
		 }
		 throw new CityNameException("Enter City Properly");
		
	}
	public int validAreaName(String areaname,int loc)throws AreaNameException
	{
		if(loc==1)
		{
			for(int i=0;i<listdata.areaListPune().size();i++)
			 {
				 String check=(String) listdata.areaListPune().get(i);
				
				 if(areaname.toUpperCase().equals(check.toUpperCase()))
					 return ++i;
			 }	
		}
		if(loc==2)
		{
			for(int i=0;i<listdata.areaListJaipur().size();i++)
			 {
				 String check=(String) listdata.areaListJaipur().get(i);
				
				 if(areaname.toUpperCase().equals(check.toUpperCase()))
					 return ++i;
			 }	
		}
		if(loc==3)
		{
			for(int i=0;i<listdata.areaListMumbai().size();i++)
			 {
				 String check=(String) listdata.areaListMumbai().get(i);
				
				 if(areaname.toUpperCase().equals(check.toUpperCase()))
					 return ++i;
			 }	
		}
		if(loc==4)
		{
			for(int i=0;i<listdata.areaListDelhi().size();i++)
			 {
				 String check=(String) listdata.areaListDelhi().get(i);
				 if(areaname.toUpperCase().equals(check.toUpperCase()))
					 return ++i;
			 }	
		}
		 
		 throw new AreaNameException("Enter Area Properly");
	}
	

}
