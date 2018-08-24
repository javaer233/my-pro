package com.fy.bean;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultipleDataSource extends AbstractRoutingDataSource {  
      
    public static final String DP = "dp";  
    public static final String UM = "um";

    private static final ThreadLocal<String> THREAD_DATA_SOURCE = new ThreadLocal<String>();

   public static void clearDataSource() {
       THREAD_DATA_SOURCE.remove();
   }
	
    public static void setDataSourceKey(String dataSource) {  
    	THREAD_DATA_SOURCE.set(dataSource);
    }  
  
    @Override  
    protected Object determineCurrentLookupKey() {  
    	//System.out.println(THREAD_DATA_SOURCE.get().isEmpty());
    	 return THREAD_DATA_SOURCE.get();
    }  
  
}  