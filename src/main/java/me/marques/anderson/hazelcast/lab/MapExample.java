package me.marques.anderson.hazelcast.lab;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class MapExample {

	public static void main(String[] args) {
		HazelcastInstance hz = Hazelcast.newHazelcastInstance();
		
		// Cache namespace -> "countries-by-prefix"
		IMap<String, String> countries = hz.getMap("countries-by-prefix");
		
		countries.put("BR", "Brazil");
		countries.put("US", "United States of America");
		countries.put("CA", "Canada");
		countries.put("PT", "Portugal");
		
		System.out.println("CA country: " + countries.get("CA"));
		
		System.out.println("Known coutries: " + countries.size());
		
	}
}
