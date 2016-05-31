package io.mpa.orm.util;

import java.util.Arrays;
import java.util.List;

import com.sun.java.xml.ns.persistence.Persistence;
import com.sun.java.xml.ns.persistence.Persistence.PersistenceUnit;

import io.mpa.orm.schema.Attributes;
import io.mpa.orm.schema.Entity;

public class PersistenceFilter {

	public static PersistenceFilter createInstance() {
		return new PersistenceFilter();
	}

	private Filter.CustomFilter<PersistenceUnit, String> persistenceUnitFilter;
	private Filter.CustomFilter<Entity, String> entityFilter;

	@SuppressWarnings("serial")
	public Filter.CustomFilter<PersistenceUnit, String> getPersistenceUnit() {
		if (persistenceUnitFilter == null) {
			persistenceUnitFilter = new Filter.CustomFilter<PersistenceUnit, String>() {
				String name;

				@Override
				public boolean include(PersistenceUnit obj) {
					return obj.getName().equals(name);
				}

				@Override
				public void setCustomParam(String... obj) {
					this.name = obj[0];

				}
			};
		}

		return persistenceUnitFilter;
	}

	@SuppressWarnings("serial")
	public Filter.CustomFilter<Entity, String> getEntity() {
		if (entityFilter == null) {
			entityFilter = new Filter.CustomFilter<Entity, String>() {
				String name;

				@Override
				public boolean include(Entity obj) {
					return obj.getName().equals(name);
				}

				@Override
				public void setCustomParam(String... obj) {
					this.name = obj[0];

				}
			};
		}

		return entityFilter;
	}

	@SuppressWarnings("serial")
	public Filter.CustomFilter<Entity, String> getEntityMappings() {
		if (entityFilter == null) {
			entityFilter = new Filter.CustomFilter<Entity, String>() {
				List<String> mappings;

				@Override
				public boolean include(Entity obj) {
					return mappings.contains(obj.getName());
				}

				@Override
				public void setCustomParam(String... obj) {
					this.mappings = Arrays.asList(obj);
				}
			};
		}

		return entityFilter;
	}

	public static PersistenceUnit getPersistenceUnit(Persistence persistence,String name) {
		Filter.CustomFilter<PersistenceUnit, String> filter = PersistenceFilter.createInstance().getPersistenceUnit();
		filter.setCustomParam(name);
		List<PersistenceUnit> matchedUnits = PersistenceUtil.filter(persistence.getPersistenceUnit(), filter);
		return matchedUnits.get(0);
	}

	public static List<Entity> getEntityMappings(List<Entity> entities, PersistenceUnit persistenceUnit) {

		String[] clazzes = persistenceUnit.getClazz().toArray(new String[persistenceUnit.getClazz().size()]);
		Filter.CustomFilter<Entity, String> filter = PersistenceFilter.createInstance().getEntityMappings();
		filter.setCustomParam(clazzes);
		List<Entity> matchedEntities = PersistenceUtil.filter(entities, filter);
		return matchedEntities;
	}

	public static Attributes getEntityAttributes(List<Entity> entities, String name) {
		Filter.CustomFilter<Entity, String> filter = PersistenceFilter.createInstance().getEntityMappings();
		filter.setCustomParam(name);
		List<Entity> matchedEntities = PersistenceUtil.filter(entities, filter);
		return matchedEntities.get(0).getAttributes();
	}

}
