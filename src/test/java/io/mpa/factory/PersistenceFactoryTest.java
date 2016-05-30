package io.mpa.factory;

import java.io.File;

import javax.xml.bind.JAXBException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersistenceFactoryTest {

	PersistenceFactory factory;

	@Before
	public void setFactory() throws JAXBException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("persistence.xml").getFile());
		this.factory = new PersistenceFactory(file.getAbsolutePath());
	}

	@Test
	public void testLoadPersistence() {
		Assert.assertNotNull(factory.getPersistence());
	}

	@Test
	public void testLoadORM() throws JAXBException {
		Assert.assertNotNull(factory.loadORM("patch-rig"));
	}

}
