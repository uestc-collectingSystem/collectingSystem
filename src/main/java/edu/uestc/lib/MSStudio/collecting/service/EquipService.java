package edu.uestc.lib.MSStudio.collecting.service;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.Equipment;

public interface EquipService extends OriginService {
	public Equipment getEquipment(String id);

	public boolean save(Equipment record);

	List<Equipment> listAllEquipment(String num, String size);
}
