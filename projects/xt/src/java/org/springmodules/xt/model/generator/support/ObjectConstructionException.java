/*
 * Copyright 2006 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springmodules.xt.model.generator.support;

/**
 * Exception thrown during object construction into a factory method.
 *
 * @author Sergio Bossa
 */
public class ObjectConstructionException extends RuntimeException {
    
    /**
     * Creates a new instance of <code>ObjectConstructionException</code> without detail message.
     */
    public ObjectConstructionException() {
    }
    
    /**
     * Constructs an instance of <code>ObjectConstructionException</code> with the specified detail message.
     * 
     * @param msg the detail message.
     */
    public ObjectConstructionException(String msg) {
        super(msg);
    }
    
    /**
     * Constructs an instance of <code>ObjectConstructionException</code> with the specified nested exception.
     * 
     * @param ex the nested exception.
     */
    public ObjectConstructionException(Throwable ex) {
        super(ex);
    }
    
    /**
     * Constructs an instance of <code>ObjectConstructionException</code> with the specified detail message and nested exception.
     * 
     * @param msg the detail message.
     * @param ex the nested exception.
     */
    public ObjectConstructionException(String msg, Throwable ex) {
        super(msg, ex);
    }
}
