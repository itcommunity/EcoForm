package org.eco.repo;

import java.util.List;

import org.ecoevolution.model.Member;
import org.ecoevolution.model.MemberParams;

public interface IMember {
	List<org.ecoevolution.model.Member> getAll();
	org.ecoevolution.model.Member getById(Integer id);
	List<org.ecoevolution.model.Member> getAllBy(MemberParams params);
	Member add(Member member);
	void insertBatch(List<Member> members);
	void clean();
}
