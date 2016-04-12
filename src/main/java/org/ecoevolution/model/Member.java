package org.ecoevolution.model;

public class Member {
	private Integer id;
	private String name;
	private String birthday;
	private String phone;
	private String email;
	private String facebook;
	private String postaddress;
	private String timeWithUs;
	private String skills;
	private String responsability;
	private String hands;
	private String area;
	private String mentor;
	private String organazation;
	private String managersEvents;
	private String hobby;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
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

	public String getPostaddress() {
		return postaddress;
	}

	public void setPostaddress(String postaddress) {
		this.postaddress = postaddress;
	}

	public String getTimeWithUs() {
		return timeWithUs;
	}

	public void setTimeWithUs(String timeWithUs) {
		this.timeWithUs = timeWithUs;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getResponsability() {
		return responsability;
	}

	public void setResponsability(String responsability) {
		this.responsability = responsability;
	}

	public String getHands() {
		return hands;
	}

	public void setHands(String hands) {
		this.hands = hands;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getMentor() {
		return mentor;
	}

	public void setMentor(String mentor) {
		this.mentor = mentor;
	}

	public String getOrganazation() {
		return organazation;
	}

	public void setOrganazation(String organazation) {
		this.organazation = organazation;
	}

	public String getManagersEvents() {
		return managersEvents;
	}

	public void setManagersEvents(String managersEvents) {
		this.managersEvents = managersEvents;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((facebook == null) ? 0 : facebook.hashCode());
		result = prime * result + ((hands == null) ? 0 : hands.hashCode());
		result = prime * result + ((hobby == null) ? 0 : hobby.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((managersEvents == null) ? 0 : managersEvents.hashCode());
		result = prime * result + ((mentor == null) ? 0 : mentor.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((organazation == null) ? 0 : organazation.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((postaddress == null) ? 0 : postaddress.hashCode());
		result = prime * result + ((responsability == null) ? 0 : responsability.hashCode());
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
		Member other = (Member) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
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
		if (hands == null) {
			if (other.hands != null)
				return false;
		} else if (!hands.equals(other.hands))
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
		if (managersEvents == null) {
			if (other.managersEvents != null)
				return false;
		} else if (!managersEvents.equals(other.managersEvents))
			return false;
		if (mentor == null) {
			if (other.mentor != null)
				return false;
		} else if (!mentor.equals(other.mentor))
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
		if (postaddress == null) {
			if (other.postaddress != null)
				return false;
		} else if (!postaddress.equals(other.postaddress))
			return false;
		if (responsability == null) {
			if (other.responsability != null)
				return false;
		} else if (!responsability.equals(other.responsability))
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

	public Member() {
	}

}
