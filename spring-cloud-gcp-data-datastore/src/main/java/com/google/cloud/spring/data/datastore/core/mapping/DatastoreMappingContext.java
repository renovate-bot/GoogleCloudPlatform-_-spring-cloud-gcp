/*
 * Copyright 2017-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spring.data.datastore.core.mapping;

import com.google.cloud.spring.data.datastore.core.convert.DatastoreNativeTypes;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.mapping.context.AbstractMappingContext;
import org.springframework.data.mapping.context.MappingContext;
import org.springframework.data.mapping.model.FieldNamingStrategy;
import org.springframework.data.mapping.model.Property;
import org.springframework.data.mapping.model.PropertyNameFieldNamingStrategy;
import org.springframework.data.mapping.model.SimpleTypeHolder;
import org.springframework.data.util.TypeInformation;
import org.springframework.lang.NonNull;

/**
 * A mapping context for Datastore that provides ways to create persistent entities and properties.
 *
 * @since 1.1
 */
public class DatastoreMappingContext
    extends AbstractMappingContext<DatastorePersistentEntity<?>, DatastorePersistentProperty>
    implements ApplicationContextAware {

  private static final FieldNamingStrategy DEFAULT_NAMING_STRATEGY =
      PropertyNameFieldNamingStrategy.INSTANCE;

  private static final FieldNamingStrategy FIELD_NAMING_STRATEGY = DEFAULT_NAMING_STRATEGY;

  private ApplicationContext applicationContext;

  // Maps a given class to the set of other classes with which it shares the same Datastore
  // Kind and that are subclasses of the given class.
  private static final Map<Class, Set<Class>> discriminationFamilies = new ConcurrentHashMap<>();

  private final boolean skipNullValue;

  public DatastoreMappingContext() {
    this(false);
  }

  public DatastoreMappingContext(boolean skipNullValue) {
    this.setSimpleTypeHolder(DatastoreNativeTypes.HOLDER);
    this.skipNullValue = skipNullValue;
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  /**
   * Registers in the DatastoreMappingContext that two classes are discriminated from the same
   * Datastore Kind.
   *
   * @param parentClass the superclass.
   * @param subClass the subclass.
   */
  public static void addDiscriminationClassConnection(Class parentClass, Class subClass) {
    Set<Class> setParent =
        discriminationFamilies.computeIfAbsent(parentClass, unused -> new HashSet<>());
    Set<Class> setSubClass =
        discriminationFamilies.computeIfAbsent(subClass, unused -> new HashSet<>());
    setParent.add(subClass);

    setSubClass.forEach(
        x -> {
          if (!discriminationFamilies.get(parentClass).contains(x)) {
            addDiscriminationClassConnection(parentClass, x);
          }
        });
    Class grandParent = parentClass.getSuperclass();
    if (grandParent != null) {
      addDiscriminationClassConnection(grandParent, subClass);
    }
  }

  /**
   * Get the set of other classes that share the same underlying Datastore Kind and that are
   * subclasses of the given class.
   *
   * @param clazz the class to look up.
   * @return a {@code Set} of other classes that share the same Kind that are subclasses. Will be
   *     {@code null} if this class is not discriminated from a set of other classes.
   */
  public static Set<Class> getDiscriminationFamily(Class clazz) {
    return discriminationFamilies.get(clazz);
  }

  protected <T> DatastorePersistentEntityImpl<T> constructPersistentEntity(
      TypeInformation<T> typeInformation) {
    return new DatastorePersistentEntityImpl<>(typeInformation, this);
  }

  @Override
  protected <T> DatastorePersistentEntity<?> createPersistentEntity(
      TypeInformation<T> typeInformation) {
    DatastorePersistentEntityImpl<T> persistentEntity = constructPersistentEntity(typeInformation);
    if (this.applicationContext != null) {
      persistentEntity.setApplicationContext(this.applicationContext);
    }
    return persistentEntity;
  }

  @Override
  protected DatastorePersistentProperty createPersistentProperty(
      Property property, DatastorePersistentEntity<?> owner, SimpleTypeHolder simpleTypeHolder) {
    return new DatastorePersistentPropertyImpl(
        property, owner, simpleTypeHolder, FIELD_NAMING_STRATEGY, skipNullValue);
  }

  /**
   * A non-null version of the {@link MappingContext#getPersistentEntity(Class)}.
   *
   * @param entityClass the entity type.
   * @return the {@link DatastorePersistentEntity} for the provided type.
   * @throws DatastoreDataException if unable to retrieve a DatastorePersistentEntity for the
   *     provided type.
   */
  @NonNull
  public DatastorePersistentEntity<?> getDatastorePersistentEntity(Class<?> entityClass) {
    DatastorePersistentEntity<?> persistentEntity = this.getPersistentEntity(entityClass);
    if (persistentEntity != null) {
      return persistentEntity;
    } else {
      throw new DatastoreDataException(
          "Unable to find a DatastorePersistentEntity for: " + entityClass);
    }
  }

  public boolean isSkipNullValue() {
    return skipNullValue;
  }
}
