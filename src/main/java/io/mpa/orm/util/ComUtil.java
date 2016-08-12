package io.mpa.orm.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ComUtil {

	static final long NUM_100NS_INTERVALS_SINCE_UUID_EPOCH = 0x01b21dd213814000L;

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
		return ComUtil.isEmpty(source) ? null : source.toLowerCase().replace(" ", "");
	}

	public static Object unMarshal(String path, Class<?> className) throws JAXBException {

		JAXBContext jaxbContext = JAXBContext.newInstance(className);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		return jaxbUnmarshaller.unmarshal(new File(path));
	}

	public static Date getDateFromUUID(String uuid) {
		UUID id = UUID.fromString(uuid);
		long time = (id.timestamp() - NUM_100NS_INTERVALS_SINCE_UUID_EPOCH) / 10000;
		return new Date(time);
	}

	public static Date getDateFromUUID(UUID uuid) {
		long time = (uuid.timestamp() - NUM_100NS_INTERVALS_SINCE_UUID_EPOCH) / 10000;
		return new Date(time);
	}

}
