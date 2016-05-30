package io.mpa.factory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.sun.java.xml.ns.persistence.Persistence;
import com.sun.java.xml.ns.persistence.Persistence.PersistenceUnit;

import io.mpa.orm.schema.EntityMappings;

public class PersistenceFactory {

	private Persistence persistence;
	private File persistenceFile;
	private Map<String, PersistenceUnit> persistenceUnitMap;

	public PersistenceFactory(String path) throws JAXBException {
		this.persistenceFile = new File(path);
		this.loadPersistence();
	}

	public void loadPersistence() throws JAXBException {

		JAXBContext jaxbContext = JAXBContext.newInstance(Persistence.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		persistence = (Persistence) jaxbUnmarshaller.unmarshal(this.persistenceFile);

		persistenceUnitMap = new HashMap<>();
		for (PersistenceUnit unit : persistence.getPersistenceUnit())
			persistenceUnitMap.put(unit.getName(), unit);

	}

	public EntityMappings loadORM(String unitName) throws JAXBException {

		String ormPath = persistenceUnitMap.get(unitName).getMappingFile().get(0);
		File file = new File(persistenceFile.getParent() + "/" + ormPath);
		JAXBContext jaxbContext = JAXBContext.newInstance(EntityMappings.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		EntityMappings mappings = (EntityMappings) jaxbUnmarshaller.unmarshal(file);
		return mappings;
	}

	public Persistence getPersistence() {
		return persistence;
	}

	public PersistenceUnit getPersistenceUnit(String unitName) {
		return persistenceUnitMap.get(unitName);
	}
}