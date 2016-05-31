package io.mpa.orm.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sun.java.xml.ns.persistence.Persistence.PersistenceUnit;
import com.sun.java.xml.ns.persistence.Persistence.PersistenceUnit.Properties.Property;

public class PersistenceUtil {

	public static boolean isEmpty(String str) {
		return (str == null || str.trim().length() == 0);
	}

	public static boolean isEmpty(Collection<?> coll) {
		return (coll == null || coll.isEmpty());
	}

	public static boolean isEmpty(Object str) {
		return (str == null || str.toString().trim().length() == 0);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> List filter(final List<T> collection, final Filter filter) {
		List<T> filterList = new ArrayList<T>();
		filterList.addAll(collection);
		for (final Iterator<T> iter = filterList.iterator(); iter.hasNext();) {
			if (!filter.include(iter.next())) {
				iter.remove();
			}
		}
		return filterList;
	}

	public static String normalize(String source) {
		return PersistenceUtil.isEmpty(source) ? null : source.toLowerCase().replace(" ", "");

	}
	
	public Map<String, String> getProperties(PersistenceUnit unit){
		Map<String, String> map = new HashMap<>();
		for(Property property : unit.getProperties().getProperty())
			map.put(property.getName(), property.getValue());
		
		return map;
	}
}
