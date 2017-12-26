package me.marques.anderson.hazelcast.lab;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class ServerNode 
{
    public static void main( String[] args )
    {
        new ServerNode().iniciarServer();
    }
    
    public void iniciarServer(){
    	HazelcastInstance hzInstance = Hazelcast.newHazelcastInstance();
    	
    	IMap<String, String> funcisNotaDez = hzInstance.getMap("br.com.bb.oat.caches.funcionarios-nota-dez");
    	
    	funcisNotaDez.put("f0733966", "anderson");
    	
    }
}
