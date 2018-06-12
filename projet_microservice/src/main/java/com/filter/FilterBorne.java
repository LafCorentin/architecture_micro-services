package com.filter;

import com.logs.GeneLog;
import java.util.Date;

public class FilterBorne extends AbstractFilter {
	Date borne_inf;
	Date borne_sup;
	
	public FilterBorne(Date inf, Date sup) {
		borne_inf = inf;
		borne_sup = sup;
	}
	
	public Date getInf()  {  
		return borne_inf;
	}
	
	public Date getSup() {
		 return borne_sup;
	}
	
	public void setSup(Date sup) {
		borne_sup = sup;
	}
	
	public void setInf(Date inf) {
		borne_inf = inf;
	}
	
	@Override
	public boolean tester(GeneLog log) {
		Date date_log = log.getDate();
		return (date_log.after(borne_inf) && date_log.before(borne_sup));
	}
}

