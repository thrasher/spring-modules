/* 
 * Created on May 30, 2005
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 * Copyright @2005 the original author or authors.
 */
package org.springmodules.xmlrpc.server;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.apache.xmlrpc.XmlRpcServer;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;

/**
 * <p>
 * Template for exporters of business services as XML-RPC handlers.
 * </p>
 * 
 * @author Alex Ruiz
 * 
 * @version $Revision: 1.1 $ $Date: 2005/06/01 08:48:49 $
 */
public abstract class AbstractXmlRpcServiceExporter implements InitializingBean {

  /**
   * Registry of handlers. Methods of this objects will be callable over XML-RPC
   * as "handlername.methodname".
   */
  private Map handlers;

  /**
   * Multithreaded XML-RPC server.
   */
  private XmlRpcServer xmlRpcServer;

  /**
   * Constructor.
   */
  public AbstractXmlRpcServiceExporter() {
    super();
  }

  /**
   * Initializes the XML-RCP server and sets its handlers an maximum number of
   * threads.
   * 
   * @see InitializingBean#afterPropertiesSet()
   */
  public final void afterPropertiesSet() {
    this.xmlRpcServer = new XmlRpcServer();

    if (this.handlers == null || this.handlers.isEmpty()) {
      throw new BeanCreationException(
          "The registry of handlers should not be empty");
    }

    Iterator handlerIterator = this.handlers.entrySet().iterator();
    while (handlerIterator.hasNext()) {
      Map.Entry entry = (Map.Entry) handlerIterator.next();

      String handlerName = (String) entry.getKey();
      Object handler = entry.getValue();

      this.xmlRpcServer.addHandler(handlerName, handler);
    }

    this.onInitialize();
  }

  /**
   * Returns an unmodifiable view of <code>{@link #handlers}</code>.
   * 
   * @return an unmodifiable view of the handlers of the XML-RPC server.
   */
  protected final Map getHandlers() {
    return Collections.unmodifiableMap(this.handlers);
  }

  /**
   * Getter for field <code>{@link #xmlRpcServer}</code>.
   * 
   * @return the field <code>xmlRpcServer</code>.
   */
  protected final XmlRpcServer getXmlRpcServer() {
    return this.xmlRpcServer;
  }

  /**
   * Allows subclasses to initialize/validate their properties.
   */
  protected void onInitialize() {
    // subclasses may override this method.
  }

  /**
   * Setter for the field <code>{@link #handlers}</code>.
   * 
   * @param handlers
   *          the new value to set.
   */
  public final void setHandlers(Map handlers) {
    this.handlers = handlers;
  }

}