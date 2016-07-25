package edu.uestc.lib.MSStudio.collecting.service;

//每个service都应该有的放在这里
public interface OriginService {
	
	boolean deleteObjectByID(String id);

	boolean checkObjectByID(String id);
}
