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

import java.util.Collection;

/**
 * The interface {@link GenericMapper} extends {@link BeanMapper} provides methods for get the
 * mapper, the class type of entity and the dto
 *
 * @param <ENTITY>
 *            the element type of the entity object
 * @param <DTO>
 *            the generic type of the data transfer object
 * @param <MAPPER>
 *            the generic type of the mapper object
 */
public interface GenericMapper<ENTITY, DTO, MAPPER> extends BeanMapper<ENTITY, DTO>
{

	/**
	 * Gets the mapper
	 *
	 * @return the mapper
	 */
	MAPPER getMapper();

	/**
	 * Gets the data transfer object class.
	 *
	 * @return the data transfer object class
	 */
	Class<DTO> getDtoClass();

	/**
	 * Gets the entity class.
	 *
	 * @return the entity class
	 */
	Class<ENTITY> getEntityClass();

	/**
	 * Constructs new instances of destinationClass and performs mapping between from source.
	 *
	 * @param <S>
	 *            the generic type of the source
	 * @param <D>
	 *            the generic type of the destinationClass
	 * @param sources
	 *            the collection of source objects
	 * @param destinationClass
	 *            the destination class
	 * @return the new instance of destinationClass mapped to source object.
	 */
	<D, S> Collection<D> map(final Collection<S> sources, final Class<D> destinationClass);

	/**
	 * Constructs new instance of destinationClass and performs mapping between from source.
	 *
	 * @param <S>
	 *            the generic type of the source
	 * @param <D>
	 *            the generic type of the destinationClass
	 * @param source
	 *            the source
	 * @param destinationClass
	 *            the destination class
	 * @return the new instance of destinationClass mapped to source object.
	 */
	<D, S> D map(final S source, final Class<D> destinationClass);

}
