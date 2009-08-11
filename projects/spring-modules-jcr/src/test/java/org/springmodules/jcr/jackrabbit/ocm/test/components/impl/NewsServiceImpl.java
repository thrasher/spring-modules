/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springmodules.jcr.jackrabbit.ocm.test.components.impl;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.jackrabbit.ocm.query.Filter;
import org.apache.jackrabbit.ocm.query.Query;
import org.apache.jackrabbit.ocm.query.QueryManager;
import org.springmodules.jcr.jackrabbit.ocm.JcrMappingTemplate;
import org.springmodules.jcr.jackrabbit.ocm.test.components.NewsService;
import org.springmodules.jcr.jackrabbit.ocm.test.model.News;

/**
 * Default implementation for
 * {@link org.springmodules.jcr.jackrabbit.ocm.test.components.ArticleService}
 * 
 * @author <a href="mailto:christophe.lombart@sword-technologies.com">Lombart
 *         Christophe </a>
 * 
 */
public class NewsServiceImpl implements NewsService {
	private static final Log log = LogFactory.getLog(NewsServiceImpl.class);

	private JcrMappingTemplate jcrMappingtemplate;

	public void createNews(News news) {
		jcrMappingtemplate.insert(news);
		jcrMappingtemplate.save();

	}

	public Collection getNews() {

		QueryManager queryManager = jcrMappingtemplate.createQueryManager();
		Filter filter = queryManager.createFilter(News.class);

		Query query = queryManager.createQuery(filter);
		return jcrMappingtemplate.getObjects(query);
	}

	/**
	 * @return Returns the template.
	 */
	public JcrMappingTemplate getJcrMappingTemplate() {
		return jcrMappingtemplate;
	}

	/**
	 * @param template
	 *            The template to set.
	 */
	public void setJcrMappingTemplate(JcrMappingTemplate template) {
		this.jcrMappingtemplate = template;
	}

}
