package org.ecoevolution.model;

public class MemberParams {

	private String skills;
	private String responsibility;
	private String timeWithUs;

	public MemberParams() {
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}

	public String getTimeWithUs() {
		return timeWithUs;
	}

	public void setTimeWithUs(String timeWithUs) {
		this.timeWithUs = timeWithUs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((responsibility == null) ? 0 : responsibility.hashCode());
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
		MemberParams other = (MemberParams) obj;
		if (responsibility == null) {
			if (other.responsibility != null)
				return false;
		} else if (!responsibility.equals(other.responsibility))
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
