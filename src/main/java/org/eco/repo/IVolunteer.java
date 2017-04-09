package org.eco.repo;

import java.util.List;

import org.ecoevolution.model.VolounteerParams;
import org.ecoevolution.model.Volunteer;

public interface IVolunteer {
	public List<org.ecoevolution.model.Volunteer> getAll();
	public org.ecoevolution.model.Volunteer getById(Integer id);
	public List<org.ecoevolution.model.Volunteer> getAllBy(VolounteerParams params);
	Volunteer add(Volunteer volonteer);
	void insertBatch(List<Volunteer> volunteers);
	void clean();
}
