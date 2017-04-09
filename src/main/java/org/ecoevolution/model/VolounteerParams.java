package org.ecoevolution.model;

public class VolounteerParams {

	private String skills;
	private String joinUmka;
	private String timeWithUs;
	private String members;

	public VolounteerParams() {
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getJoinUmka() {
		return joinUmka;
	}

	public void setJoinUmka(String joinUmka) {
		this.joinUmka = joinUmka;
	}

	public String getTimeWithUs() {
		return timeWithUs;
	}

	public void setTimeWithUs(String timeWithUs) {
		this.timeWithUs = timeWithUs;
	}

	public String getMembers() {
		return members;
	}

	public void setMembers(String members) {
		this.members = members;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((joinUmka == null) ? 0 : joinUmka.hashCode());
		result = prime * result + ((members == null) ? 0 : members.hashCode());
		result = prime * result + ((skills == null) ? 0 : skills.hashCode());
		result = prime * result + ((timeWithUs == null) ? 0 : timeWithUs.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VolounteerParams other = (VolounteerParams) obj;
		if (joinUmka == null) {
			if (other.joinUmka != null)
				return false;
		} else if (!joinUmka.equals(other.joinUmka))
			return false;
		if (members == null) {
			if (other.members != null)
				return false;
		} else if (!members.equals(other.members))
			return false;
		if (skills == null) {
			if (other.skills != null)
				return false;
		} else if (!skills.equals(other.skills))
			return false;
		if (timeWithUs == null) {
			if (other.timeWithUs != null)
				return false;
		} else if (!timeWithUs.equals(other.timeWithUs))
			return false;
		return true;
	}

}
