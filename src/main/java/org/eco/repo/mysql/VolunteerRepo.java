package org.eco.repo.mysql;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eco.repo.IVolunteer;
import org.ecoevolution.model.VolounteerParams;
import org.ecoevolution.model.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class VolunteerRepo implements IVolunteer {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String SKILLS_DEFAULT = "Всі вміння";
    private static final String JOIN_UMKA_DEFAULT = "Всі наміри приєднатись";
    private static final String TIME_WITH_US_DEFAUT = "Час з нами";
    private static final String MEMBERS_DEFAULT = "Членство";

    public List<org.ecoevolution.model.Volunteer> getAll() {

        List<org.ecoevolution.model.Volunteer> volunters = new ArrayList<org.ecoevolution.model.Volunteer>();
        String sql = "SELECT * from Volunteer";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map row : rows) {

            org.ecoevolution.model.Volunteer volunteer = new org.ecoevolution.model.Volunteer();
            volunteer.setId((Integer) (row.get("ID")));
            volunteer.setName((String) (row.get("NAME")));
            volunteer.setCity((String) (row.get("CITY")));
            volunteer.setPhone((String) (row.get("PHONE")));
            volunteer.setEmail((String) (row.get("EMAIL")));
            volunteer.setFacebook((String) (row.get("FACEBOOK")));
            volunteer.setUmkaEvents((String) (row.get("UMKAEVENTS")));
            volunteer.setSkills((String) (row.get("SKILLS")));
            volunteer.setJoinUmka((String) (row.get("JOINUMKA")));
            volunteer.setTimeWithUs((String) (row.get("TIMEWITHUS")));
            volunteer.setMembers((String) (row.get("MEMBERS")));
            volunteer.setOrganazation((String) (row.get("ORGANAZATION")));
            volunteer.setAdditionalEvents((String) (row.get("ADDITIONALEVENTS")));
            volunteer.setHobby((String) (row.get("HOBBY")));
            volunteer.setAdditionInfo((String) (row.get("ADDITIONINFO")));
            volunters.add(volunteer);
        }
        return volunters;
    }

    @Override
    public org.ecoevolution.model.Volunteer getById(Integer id) {
        String sql = "SELECT * from Volunteer WHERE id=" + id;
        Map<String, Object> row = jdbcTemplate.queryForMap(sql);

        org.ecoevolution.model.Volunteer volunteer = new org.ecoevolution.model.Volunteer();
        volunteer.setId((Integer) (row.get("ID")));
        volunteer.setName((String) (row.get("NAME")));
        volunteer.setCity((String) (row.get("CITY")));
        volunteer.setPhone((String) (row.get("PHONE")));
        volunteer.setEmail((String) (row.get("EMAIL")));
        volunteer.setFacebook((String) (row.get("FACEBOOK")));
        volunteer.setUmkaEvents((String) (row.get("UMKAEVENTS")));
        volunteer.setSkills((String) (row.get("SKILLS")));
        volunteer.setJoinUmka((String) (row.get("JOINUMKA")));
        volunteer.setTimeWithUs((String) (row.get("TIMEWITHUS")));
        volunteer.setMembers((String) (row.get("MEMBERS")));
        volunteer.setOrganazation((String) (row.get("ORGANAZATION")));
        volunteer.setAdditionalEvents((String) (row.get("ADDITIONALEVENTS")));
        volunteer.setHobby((String) (row.get("HOBBY")));
        volunteer.setAdditionInfo((String) (row.get("ADDITIONINFO")));

        return volunteer;
    }

    @Override
    public List<org.ecoevolution.model.Volunteer> getAllBy(VolounteerParams params) {

        List<org.ecoevolution.model.Volunteer> volunters = new ArrayList<org.ecoevolution.model.Volunteer>();

        ArrayList<String> search = new ArrayList<>();
        if (!params.getSkills().equals(SKILLS_DEFAULT)) {
            search.add("SKILLS LIKE '%" + params.getSkills() + "%'");
        }

        if (!params.getJoinUmka().equals(JOIN_UMKA_DEFAULT)) {
            search.add("JOINUMKA LIKE '%" + params.getJoinUmka() + "%'");
        }

        if (!params.getTimeWithUs().equals(TIME_WITH_US_DEFAUT)) {
            search.add("TIMEWITHUS LIKE '%" + params.getTimeWithUs() + "%'");
        }

        if (!params.getMembers().equals(MEMBERS_DEFAULT)) {
            search.add("MEMBERS LIKE '%" + params.getMembers() + "%'");
        }


        String where = (search.size() > 0) ? " WHERE " + StringUtils.collectionToDelimitedString(search, " AND ") : "";
        String sql = "SELECT * from Volunteer " + where;
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map row : rows) {

            org.ecoevolution.model.Volunteer volunteer = new org.ecoevolution.model.Volunteer();
            volunteer.setId((Integer) (row.get("ID")));
            volunteer.setName((String) (row.get("NAME")));
            volunteer.setCity((String) (row.get("CITY")));
            volunteer.setPhone((String) (row.get("PHONE")));
            volunteer.setEmail((String) (row.get("EMAIL")));
            volunteer.setFacebook((String) (row.get("FACEBOOK")));
            volunteer.setUmkaEvents((String) (row.get("UMKAEVENTS")));
            volunteer.setSkills((String) (row.get("SKILLS")));
            volunteer.setJoinUmka((String) (row.get("JOINUMKA")));
            volunteer.setTimeWithUs((String) (row.get("TIMEWITHUS")));
            volunteer.setMembers((String) (row.get("MEMBERS")));
            volunteer.setOrganazation((String) (row.get("ORGANAZATION")));
            volunteer.setAdditionalEvents((String) (row.get("ADDITIONALEVENTS")));
            volunteer.setHobby((String) (row.get("HOBBY")));
            volunteer.setAdditionInfo((String) (row.get("ADDITIONINFO")));
            volunters.add(volunteer);
        }
        return volunters;

    }

    @Override
    public org.ecoevolution.model.Volunteer add(Volunteer volonteer) {
        String sql_template = "INSERT INTO Volunteer (NAME,CITY,PHONE,EMAIL,FACEBOOK,UMKAEVENTS,SKILLS,JOINUMKA,TIMEWITHUS,"
                + "MEMBERS,ORGANAZATION,ADDITIONALEVENTS,HOBBY,ADDITIONINFO)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String[] values = new String[]{volonteer.getName(), volonteer.getCity(), volonteer.getPhone(),
                volonteer.getEmail(), volonteer.getFacebook(), volonteer.getUmkaEvents(), volonteer.getSkills(),
                volonteer.getJoinUmka(), volonteer.getTimeWithUs(), volonteer.getMembers(), volonteer.getOrganazation(),
                volonteer.getAdditionalEvents(), volonteer.getHobby(), volonteer.getAdditionInfo()};
        System.out.println(Arrays.toString(values));
        jdbcTemplate.update(sql_template, values);

        return volonteer;
    }

    public void insertBatch(final List<Volunteer> volunteers) {

        String sql = "INSERT INTO Volunteer (NAME,CITY,PHONE,EMAIL,FACEBOOK,UMKAEVENTS,SKILLS,JOINUMKA,TIMEWITHUS,"
                + "MEMBERS,ORGANAZATION,ADDITIONALEVENTS,HOBBY,ADDITIONINFO)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
				Volunteer volunteer = volunteers.get(i);
                preparedStatement.setString(1, volunteer.getName());
                preparedStatement.setString(2, volunteer.getCity());
                preparedStatement.setString(3, volunteer.getPhone());
                preparedStatement.setString(4, volunteer.getEmail());
                preparedStatement.setString(5, volunteer.getFacebook());
                preparedStatement.setString(6, volunteer.getUmkaEvents());
                preparedStatement.setString(7, volunteer.getSkills());
                preparedStatement.setString(8, volunteer.getJoinUmka());
                preparedStatement.setString(9, volunteer.getTimeWithUs());
                preparedStatement.setString(10, volunteer.getMembers());
                preparedStatement.setString(11, volunteer.getOrganazation());
                preparedStatement.setString(12, volunteer.getAdditionalEvents());
                preparedStatement.setString(13, volunteer.getHobby());
                preparedStatement.setString(14, volunteer.getAdditionInfo());
            }

            @Override
            public int getBatchSize() {
                return volunteers.size();
            }
        });
    }

    @Override
    public void clean() {
        String sql = "truncate table volunteer";
        jdbcTemplate.execute(sql);
    }

    public VolunteerRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public VolunteerRepo() {
    }


}
