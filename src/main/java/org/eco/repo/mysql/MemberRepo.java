package org.eco.repo.mysql;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eco.repo.IMember;
import org.ecoevolution.model.Member;
import org.ecoevolution.model.MemberParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class MemberRepo implements IMember {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String OTHRES = "інше";
	private static final String SKILLS_DEFAULT = "Всі вміння";
	private static final String RESPONSIBILITY = "Відповідальність";
	private static final String TIME_WITH_US_DEFAUT = "Час з нами";

	// IM TODO
	private static final List<String> SKILLS_LIST = Arrays.asList("координування проектів", "фандрейзінг",
			"адміністрування", "програмування", "дизайн", "піар");
	private static final List<String> RESPONSIBILITY_LIST = Arrays.asList("", "", "", "", "", "", "", "", "", "", "",
			"");
	private static final List<String> TIME_WITH_US_DEFAUT_LIST = Arrays.asList(
			"full-time (5 разів на тиждень, повний робочий день)", "пару разів на тиждень по декілька годин",
			"раз на тиждень", "декілька разів на місяць");

	public MemberRepo(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public MemberRepo() {
	}

	@Override
	public List<Member> getAll() {
		List<Member> members = new ArrayList<Member>();
		String sql = "SELECT * from Members";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {

			Member member = new Member();
			member.setId((Integer) (row.get("ID")));
			member.setName((String) (row.get("NAME")));
			member.setBirthday((String) (row.get("BIRTHDAY")));
			member.setPhone((String) (row.get("PHONE")));
			member.setEmail((String) (row.get("EMAIL")));
			member.setFacebook((String) (row.get("FACEBOOK")));
			member.setPostaddress((String) (row.get("POSTADDRESS")));
			member.setTimeWithUs((String) (row.get("TIMEWITHUS")));
			member.setSkills((String) (row.get("SKILLS")));
			member.setResponsability((String) (row.get("RESPONSABILITY")));
			member.setHands((String) (row.get("HANDS")));
			member.setArea((String) (row.get("AREA")));
			member.setMentor((String) (row.get("MENTOR")));
			member.setOrganazation((String) (row.get("ORGANAZATION")));
			member.setManagersEvents((String) (row.get("MANAGERSEVENTS")));
			member.setHobby((String) (row.get("HOBBY")));
			members.add(member);
		}
		return members;
	}

	@Override
	public Member getById(Integer id) {
		String sql = "SELECT * from Members WHERE id=" + id;
		Map<String, Object> row = jdbcTemplate.queryForMap(sql);

		Member member = new Member();
		member.setId((Integer) (row.get("ID")));
		member.setName((String) (row.get("NAME")));
		member.setBirthday((String) (row.get("BIRTHDAY")));
		member.setPhone((String) (row.get("PHONE")));
		member.setEmail((String) (row.get("EMAIL")));
		member.setFacebook((String) (row.get("FACEBOOK")));
		member.setPostaddress((String) (row.get("POSTADDRESS")));
		member.setTimeWithUs((String) (row.get("TIMEWITHUS")));
		member.setSkills((String) (row.get("SKILLS")));
		member.setResponsability((String) (row.get("RESPONSABILITY")));
		member.setHands((String) (row.get("HANDS")));
		member.setArea((String) (row.get("AREA")));
		member.setMentor((String) (row.get("MENTOR")));
		member.setOrganazation((String) (row.get("ORGANAZATION")));
		member.setManagersEvents((String) (row.get("MANAGERSEVENTS")));
		member.setHobby((String) (row.get("HOBBY")));
		return member;
	}

	@Override
	public List<Member> getAllBy(MemberParams params) {
		List<Member> members = new ArrayList<Member>();

		ArrayList<String> search = new ArrayList<>();
		if (!params.getSkills().equals(SKILLS_DEFAULT)) {
			if (!params.getSkills().equals(OTHRES)) {
				search.add("SKILLS LIKE '%" + params.getSkills() + "%'");
			} else {
				for (String skill : SKILLS_LIST) {
					search.add("SKILLS NOT LIKE '%" + skill + "%'");
				}
			}

		}

		if (!params.getResponsibility().equals(RESPONSIBILITY)) {
			if (!params.getResponsibility().equals(OTHRES)) {
				search.add("RESPONSABILITY LIKE '%" + params.getResponsibility() + "%'");
			} else {
				for (String reponsability : RESPONSIBILITY_LIST) {
					search.add("RESPONSABILITY NOT LIKE '%" + reponsability + "%'");
				}
			}
		}

		if (!params.getTimeWithUs().equals(TIME_WITH_US_DEFAUT)) {
			if (!params.getTimeWithUs().equals(OTHRES)) {
				search.add("TIMEWITHUS LIKE '%" + params.getTimeWithUs() + "%'");
			} else {
				for (String timeWithUs : TIME_WITH_US_DEFAUT_LIST) {
					search.add("TIMEWITHUS NOT LIKE '%" + timeWithUs + "%'");
				}
			}

		}

		String where = (search.size() > 0) ? " WHERE " + StringUtils.collectionToDelimitedString(search, " AND ") : "";
		String sql = "SELECT * from Members " + where;
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {

			Member member = new Member();
			member.setId((Integer) (row.get("ID")));
			member.setName((String) (row.get("NAME")));
			member.setBirthday((String) (row.get("BIRTHDAY")));
			member.setPhone((String) (row.get("PHONE")));
			member.setEmail((String) (row.get("EMAIL")));
			member.setFacebook((String) (row.get("FACEBOOK")));
			member.setPostaddress((String) (row.get("POSTADDRESS")));
			member.setTimeWithUs((String) (row.get("TIMEWITHUS")));
			member.setSkills((String) (row.get("SKILLS")));
			member.setResponsability((String) (row.get("RESPONSABILITY")));
			member.setHands((String) (row.get("HANDS")));
			member.setArea((String) (row.get("AREA")));
			member.setMentor((String) (row.get("MENTOR")));
			member.setOrganazation((String) (row.get("ORGANAZATION")));
			member.setManagersEvents((String) (row.get("MANAGERSEVENTS")));
			member.setHobby((String) (row.get("HOBBY")));
			members.add(member);
		}
		return members;
	}

	@Override
	public Member add(Member member) {
		String sql_template = "INSERT INTO Members (NAME,BIRTHDAY,PHONE,EMAIL,FACEBOOK,"
				+ "POSTADDRESS,TIMEWITHUS,SKILLS,RESPONSABILITY,HANDS,"
				+ "AREA,MENTOR,ORGANAZATION,MANAGERSEVENTS,HOBBY)" + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String[] values = new String[] { member.getName(), member.getBirthday(), member.getPhone(), member.getEmail(),
				member.getFacebook(), member.getPostaddress(), member.getTimeWithUs(), member.getSkills(),
				member.getResponsability(), member.getHands(), member.getArea(), member.getMentor(),
				member.getOrganazation(), member.getManagersEvents(), member.getHobby() };
		// System.out.println(Arrays.toString(values));
		jdbcTemplate.update(sql_template, values);

		return member;
	}

	@Override
	public void insertBatch(final List<Member> members) {
		String sql = "INSERT INTO Members (NAME,BIRTHDAY,PHONE,EMAIL,FACEBOOK,"
				+ "POSTADDRESS,TIMEWITHUS,SKILLS,RESPONSABILITY,HANDS,"
				+ "AREA,MENTOR,ORGANAZATION,MANAGERSEVENTS,HOBBY)" + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
				Member member = members.get(i);
				preparedStatement.setString(1, member.getName());
				preparedStatement.setString(2, member.getBirthday());
				preparedStatement.setString(3, member.getPhone());
				preparedStatement.setString(4, member.getEmail());
				preparedStatement.setString(5, member.getFacebook());
				preparedStatement.setString(6, member.getPostaddress());
				preparedStatement.setString(7, member.getTimeWithUs());
				preparedStatement.setString(8, member.getSkills());
				preparedStatement.setString(9, member.getResponsability());
				preparedStatement.setString(10, member.getHands());
				preparedStatement.setString(11, member.getArea());
				preparedStatement.setString(12, member.getMentor());
				preparedStatement.setString(13, member.getOrganazation());
				preparedStatement.setString(14, member.getManagersEvents());
				preparedStatement.setString(15, member.getHobby());
			}

			@Override
			public int getBatchSize() {
				return members.size();
			}
		});

	}

	@Override
	public void clean() {
		String sql = "truncate table members";
		jdbcTemplate.execute(sql);
	}
}
