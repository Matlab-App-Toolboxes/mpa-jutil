package io.mpa.orm.util;


import java.io.Serializable;

public interface Filter<T> extends Serializable{

	public boolean include(T obj); 
		
	public static interface CustomFilter<T,K> extends Filter<T>	{
		public void setCustomParam(K... obj);
	}
}
