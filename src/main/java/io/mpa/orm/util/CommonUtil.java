package io.mpa.orm.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CommonUtil {

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
		return CommonUtil.isEmpty(source) ? null : source.toLowerCase().replace(" ", "");

	}
}
