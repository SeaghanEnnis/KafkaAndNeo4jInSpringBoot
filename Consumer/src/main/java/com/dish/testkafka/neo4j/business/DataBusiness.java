package com.dish.testkafka.neo4j.business;

import java.util.List;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.springframework.stereotype.Component;

@Component
public class DataBusiness {

    private final Driver driver;

    
	public DataBusiness(Driver driver) { 
		this.driver = driver;
	}

    public List<Object> getNameOfObjectById(String id){
        
        try (Session session = driver.session()) { 
			return session.run("MATCH (n) where id = " + id+ "RETURN n")
				.list(r -> r.get("m").asNode().get("name").asString());
		}catch(Exception e){
            return null;
        }
    }


    public List<Object> createObjectWithProperty(String value){
        
        try (Session session = driver.session()) { 
			return session.run("MERGE (n:Device{property:\""+ value +"\"}) ON CREATE SET n:Device, n.property= \"" + value + "\" RETURN n")
				.list(r -> r.get("n").asNode().get("property").asString());
		}catch(Exception e){
            e.printStackTrace();
            return null;

        }
    }
    
}
