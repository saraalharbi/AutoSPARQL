package org.aksw.autosparql.tbsl.algorithm.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;

public class SolrServerAkswTest
{
	@Test public void testDBpediaIndices()
	{
		{
			List<String> resources = SolrServerAksw.INSTANCE.resourcesIndex.getResources("Premier League");
			System.out.println(resources);
		}
		{
			List<String> objectProperties = SolrServerAksw.INSTANCE.objectPropertiesIndex.getResources("author");
			assertNotNull(objectProperties);
			assertFalse(objectProperties.isEmpty());
			assertTrue(objectProperties.contains("http://dbpedia.org/ontology/author"));
		}
		{
			List<String> objectProperties = SolrServerAksw.INSTANCE.objectPropertiesIndex.getResources("written");
			assertNotNull(objectProperties);			
			assertFalse("boa doesn't find author by 'written'",objectProperties.isEmpty());
			assertTrue("boa doesn't find author by 'written'",objectProperties.contains("http://dbpedia.org/ontology/author"));
		}
		{
			List<String> resources = SolrServerAksw.INSTANCE.resourcesIndex.getResources("Leipzig");
			assertNotNull(resources);
			assertFalse(resources.isEmpty());
			assertTrue(resources.contains("http://dbpedia.org/resource/Leipzig"));
		}
	}

}