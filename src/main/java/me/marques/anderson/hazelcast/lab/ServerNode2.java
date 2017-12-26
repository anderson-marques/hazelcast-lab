package me.marques.anderson.hazelcast.lab;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class ServerNode2 
{
    public static void main( String[] args )
    {
        new ServerNode2().iniciarServer();
    }
    
    public void iniciarServer(){
    	HazelcastInstance hzInstance = Hazelcast.newHazelcastInstance();
    	
    	
    	System.out.println(hzInstance.getMap("br.com.bb.oat.caches.funcionarios-nota-dez").get("f0733966"));
    	
    }
}
