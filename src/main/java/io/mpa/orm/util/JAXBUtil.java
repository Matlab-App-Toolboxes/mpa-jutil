package io.mpa.orm.util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXBUtil {

	public static Object unMarshal(String path, Class<?> className) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(className);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		return jaxbUnmarshaller.unmarshal(new File(path));
	}
}