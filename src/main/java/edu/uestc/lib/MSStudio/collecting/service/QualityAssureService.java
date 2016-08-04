package edu.uestc.lib.MSStudio.collecting.service;

import java.util.List;

import edu.uestc.lib.MSStudio.collecting.model.QualityAssure;

public interface QualityAssureService extends OriginService {
	public QualityAssure getQualityAssure(String id);

	public boolean save(QualityAssure record);

	List<QualityAssure> listAllQualityAssure(String num, String size);

	public boolean update(QualityAssure record);
}
