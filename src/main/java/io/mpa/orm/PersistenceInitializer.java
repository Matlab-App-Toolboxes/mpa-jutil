package io.mpa.orm;

import com.sun.java.xml.ns.persistence.Persistence.PersistenceUnit;

import io.mpa.orm.schema.EntityMappings;

public interface PersistenceInitializer {

	PersistenceUnit loadPersistence(String path, String unitName);

	EntityMappings loadMapping(String path);
}