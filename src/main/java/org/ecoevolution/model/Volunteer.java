package org.ecoevolution.model;

public class Volunteer {
	private Integer id;
	private String name;
	private String city;
	private String phone;
	private String email;
	private String facebook;
	private String umkaEvents;
	private String skills;
	private String joinUmka;
	private String timeWithUs;
	private String members;
	private String organazation;
	private String additionalEvents;
	private String hobby;
	private String additionInfo;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Volunteer(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getUmkaEvents() {
		return umkaEvents;
	}

	public void setUmkaEvents(String umkaEvents) {
		this.umkaEvents = umkaEvents;
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

	public String getOrganazation() {
		return organazation;
	}

	public void setOrganazation(String organazation) {
		this.organazation = organazation;
	}

	public String getAdditionalEvents() {
		return additionalEvents;
	}

	public void setAdditionalEvents(String additionalEvents) {
		this.additionalEvents = additionalEvents;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getAdditionInfo() {
		return additionInfo;
	}

	public void setAdditionInfo(String additionInfo) {
		this.additionInfo = additionInfo;
	}

	public Volunteer() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((additionInfo == null) ? 0 : additionInfo.hashCode());
		result = prime * result + ((additionalEvents == null) ? 0 : additionalEvents.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((facebook == null) ? 0 : facebook.hashCode());
		result = prime * result + ((hobby == null) ? 0 : hobby.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((joinUmka == null) ? 0 : joinUmka.hashCode());
		result = prime * result + ((members == null) ? 0 : members.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((organazation == null) ? 0 : organazation.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((skills == null) ? 0 : skills.hashCode());
		result = prime * result + ((timeWithUs == null) ? 0 : timeWithUs.hashCode());
		result = prime * result + ((umkaEvents == null) ? 0 : umkaEvents.hashCode());
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
		Volunteer other = (Volunteer) obj;
		if (additionInfo == null) {
			if (other.additionInfo != null)
				return false;
		} else if (!additionInfo.equals(other.additionInfo))
			return false;
		if (additionalEvents == null) {
			if (other.additionalEvents != null)
				return false;
		} else if (!additionalEvents.equals(other.additionalEvents))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (facebook == null) {
			if (other.facebook != null)
				return false;
		} else if (!facebook.equals(other.facebook))
			return false;
		if (hobby == null) {
			if (other.hobby != null)
				return false;
		} else if (!hobby.equals(other.hobby))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (organazation == null) {
			if (other.organazation != null)
				return false;
		} else if (!organazation.equals(other.organazation))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
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
		if (umkaEvents == null) {
			if (other.umkaEvents != null)
				return false;
		} else if (!umkaEvents.equals(other.umkaEvents))
			return false;
		return true;
	}

}
