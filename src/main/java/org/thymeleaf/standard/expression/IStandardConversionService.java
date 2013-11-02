/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2013, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.thymeleaf.standard.expression;

import org.thymeleaf.Configuration;
import org.thymeleaf.context.IProcessingContext;

/**
 * <p>
 *   Common interface for all implementations of a conversion service, to be used during template execution.
 * </p>
 * <p>
 *   Thymeleaf conversion services work in a way similar to Spring Framework's <tt>ConversionService</tt> interface,
 *   but this is a generic mechanism (not dependent on Spring).
 * </p>
 * <p>
 *   Default implementation &mdash;registered by {@link org.thymeleaf.standard.StandardDialect}&mdash;
 *   is {@link StandardConversionService}, which performs some standard conversions, but the
 *   Spring Standard Dialect used by the Thymeleaf + Spring integration module automatically registers an implementation
 *   of this interface that delegates on any existing Spring <tt>ConversionService</tt> objects (thus using
 *   the Converters and Formatters regitered at the Spring Application Context).
 * </p>
 * <p>
 *   <strong>Important</strong>: there is one conversion that implementations of this interface should
 *   <em>always</em> implement, because it is heavily used at the Thymeleaf core: conversion of any Object to String.
 * </p>
 * <p>
 *   The implementation of this interface that should be used is specified as an <i>execution attribute</i>
 *   by the Standard Dialects (see {@link org.thymeleaf.standard.StandardDialect#getExecutionAttributes()}).
 * </p>
 * <p>
 *   Implementations of this interface should be <strong>thread-safe</strong>.
 * </p>
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 2.1.0
 *
 */
public interface IStandardConversionService {

    /**
     * <p>
     *   Convert a value to the specified target class, if possible.
     * </p>
     * <p>
     *   Might raise an exception (usually {@link IllegalArgumentException}) if a conversion is not available
     *   for the specified object and the target class.
     * </p>
     *
     * @param configuration the Configuration object for the template execution environment.
     * @param processingContext the processing context object containing the variables to be applied to the expression.
     * @param object the object to be converted.
     * @param targetClass the target class the object should be converted to.
     * @param <T> the type of the target class
     * @return the object, converted. Or an exception if the conversion has not been possible.
     */
    public <T> T convert(final Configuration configuration, final IProcessingContext processingContext,
                         final Object object, final Class<T> targetClass);

}
