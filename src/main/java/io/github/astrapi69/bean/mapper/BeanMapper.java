/**
 * The MIT License
 *
 * Copyright (C) 2021 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.bean.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * The interface {@link BeanMapper} provides the methods for mapping entities to data transfer
 * objects(dto) and back
 *
 * @param <ENTITY>
 *            the element type of the entity object
 * @param <DTO>
 *            the generic type of the data transfer object
 */
public interface BeanMapper<ENTITY, DTO>
{

	/**
	 * Maps the given entity object to a data transfer object
	 *
	 * @param entity
	 *            the entity object
	 * @return the data transfer object
	 */
	DTO toDto(final ENTITY entity);

	/**
	 * Maps the given collection of entity objects to a list of data transfer objects
	 *
	 * @param entities
	 *            the collection of entities objects
	 * @return the list of data transfer objects
	 */
	default List<DTO> toDtos(final Collection<ENTITY> entities)
	{
		Objects.requireNonNull(entities);
		final List<DTO> domainObjects = new ArrayList<>();
		if (!entities.isEmpty())
		{
			for (final ENTITY entity : entities)
			{
				domainObjects.add(toDto(entity));
			}
		}
		return domainObjects;
	}

	/**
	 * Maps the given iterable of entity objects to a list of data transfer objects
	 *
	 * @param entities
	 *            the iterable of entities objects
	 * @return the list of data transfer objects
	 */
	default List<DTO> toDtos(final Iterable<ENTITY> entities)
	{
		Objects.requireNonNull(entities);
		final List<DTO> domainObjects = new ArrayList<>();
		for (final ENTITY entity : entities)
		{
			domainObjects.add(toDto(entity));
		}
		return domainObjects;
	}

	/**
	 * Maps the given list of data transfer objects to a list of entity objects
	 *
	 * @param dtos
	 *            the collection of data transfer objects
	 * @return the list of entity objects.
	 */
	default List<ENTITY> toEntities(final Collection<DTO> dtos)
	{
		Objects.requireNonNull(dtos);
		final List<ENTITY> entities = new ArrayList<>();
		if (!dtos.isEmpty())
		{
			for (final DTO dto : dtos)
			{
				entities.add(toEntity(dto));
			}
		}
		return entities;
	}

	/**
	 * Maps the given iterable of data transfer objects to a list of entity objects
	 *
	 * @param dtos
	 *            the iterable of data transfer objects
	 * @return the list of entity objects.
	 */
	default List<ENTITY> toEntities(final Iterable<DTO> dtos)
	{
		Objects.requireNonNull(dtos);
		final List<ENTITY> entities = new ArrayList<>();
		for (final DTO dto : dtos)
		{
			entities.add(toEntity(dto));
		}
		return entities;
	}

	/**
	 * Maps the given data transfer object to a entity object.
	 *
	 * @param dto
	 *            the data transfer object
	 * @return the entity object
	 */
	ENTITY toEntity(final DTO dto);

}
