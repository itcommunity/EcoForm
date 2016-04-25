package org.eco.configs;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.eco.repo.IMember;
import org.eco.repo.IVolunteer;
import org.ecoevolution.model.Member;
import org.ecoevolution.model.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class XLSParser {

//	@Autowired
//	private IVolunteer repoVolonteer;
//	@Autowired
//	private IMember repoMember;
//
//	public XLSParser() {
//	}
//
//	public IVolunteer getRepo() {
//		return repoVolonteer;
//	}
//
//	public void setRepo(IVolunteer repo) {
//		this.repoVolonteer = repo;
//	}
//
//	public IMember getRepoMember() {
//		return repoMember;
//	}
//
//	public void setRepoMember(IMember repoMember) {
//		this.repoMember = repoMember;
//	}

	public List<Volunteer> exportDataVolunteers(InputStream inputStream) throws IOException {

//		InputStream in = new FileInputStream(XLSParser.class.getClassLoader().getResource("volounteer.xls").getFile());
		InputStream in = inputStream;
		HSSFWorkbook wb = new HSSFWorkbook(in);

		List<Volunteer> volunteer_list = new ArrayList<>();
		Sheet sheet = wb.getSheetAt(0);
		Iterator<Row> it = sheet.iterator();
		while (it.hasNext()) {
			Row row = it.next();
			Iterator<Cell> cells = row.iterator();
			List<String> rowValues = new ArrayList<String>();
			while (cells.hasNext()) {
				Cell cell = cells.next();
				int cellType = cell.getCellType();
				switch (cellType) {
				case Cell.CELL_TYPE_STRING:
					rowValues.add(cell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {

						rowValues.add(cell.getDateCellValue().toString());
					} else {
						// TODO:check value what exactly insert in DB

						// double numValueD = new
						// Double(cell.getNumericCellValue()).doubleValue();
						BigDecimal cellValue = new BigDecimal(cell.getNumericCellValue());
						rowValues.add(cellValue.toBigInteger().toString());

					}
					break;

				case Cell.CELL_TYPE_FORMULA:
					System.out.print("-!-" + cell.getNumericCellValue() + "-!-");
					break;
				default:
					rowValues.add("");
					break;
				}
			}
			volunteer_list.add(buildModelVolunteers(rowValues));
		}
		return volunteer_list;
	}

	public List<Member> exportDataMembers(InputStream inputStream) throws IOException {

//		InputStream in = new FileInputStream(XLSParser.class.getClassLoader().getResource("members.xls").getFile());
		InputStream in = inputStream;
		HSSFWorkbook wb = new HSSFWorkbook(in);

		List<Member> member_list = new ArrayList<>();
		Sheet sheet = wb.getSheetAt(0);
		Iterator<Row> it = sheet.iterator();
		while (it.hasNext()) {
			Row row = it.next();
			//iterator return values without null
			short num = row.getLastCellNum();
			//HSSFCell cell=row.getCell(c, org.apache.poi.ss.usermodel.Row.CREATE_NULL_AS_BLANK );
			List<String> rowValues = new ArrayList<String>();
			for(int i=0;i<num;i++){
				Cell cell=row.getCell(i, org.apache.poi.ss.usermodel.Row.CREATE_NULL_AS_BLANK );
				int cellType = cell.getCellType();
				switch (cellType) {
				case Cell.CELL_TYPE_STRING:
					rowValues.add(cell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {

						rowValues.add(cell.getDateCellValue().toString());
					} else {
						BigDecimal cellValue = new BigDecimal(cell.getNumericCellValue());
						rowValues.add(cellValue.toBigInteger().toString());

					}
					break;

				case Cell.CELL_TYPE_FORMULA:
					System.out.print("-!-" + cell.getNumericCellValue() + "-!-");
					break;
				default:
					rowValues.add(" ");
					break;
				}
			}
			member_list.add(buildModelMember(rowValues));
		}
		return member_list;
	}

	private static Volunteer buildModelVolunteers(List<String> params) {
		Volunteer volunteer = new Volunteer();
		volunteer.setName(normalize(params.get(0)));
		volunteer.setCity(normalize(params.get(1)));
		volunteer.setPhone(normalize(params.get(2)));
		volunteer.setEmail(normalize(params.get(3)));
		volunteer.setFacebook(normalize(params.get(4)));
		volunteer.setUmkaEvents(normalize(params.get(5)));
		volunteer.setSkills(normalize(params.get(6)));
		volunteer.setJoinUmka(normalize(params.get(7)));
		volunteer.setTimeWithUs(normalize(params.get(8)));
		volunteer.setMembers(normalize(params.get(9)));
		volunteer.setOrganazation(normalize(params.get(10)));
		volunteer.setAdditionalEvents(normalize(params.get(11)));
		volunteer.setHobby(normalize(params.get(12)));
		String addInfo = "";
		if (params.size() > 13) {
			addInfo = params.get(13);
		}

		volunteer.setAdditionInfo(addInfo);

		return volunteer;
	}
	
	private static String normalize(String value){
//		String newVal = value.replaceAll("[\'\"()]","");
		return value;
	}

	private static Member buildModelMember(List<String> params) {
		Member member = new Member();
		member.setName(normalize(params.get(0)));
		member.setBirthday(normalize(params.get(1)));
		member.setPhone(normalize(params.get(2)));
		member.setEmail(normalize(params.get(3)));
		member.setFacebook(normalize(params.get(4)));
		member.setPostaddress(normalize(params.get(5)));
		//forgot about hystory
		member.setTimeWithUs(normalize(params.get(7)));
		member.setHands(normalize(params.get(8)));
		member.setSkills(normalize(params.get(9)));
		member.setResponsability(normalize(params.get(10)));
		member.setArea(normalize(params.get(11)));
		member.setMentor(normalize(params.get(12)));
		member.setOrganazation(normalize(params.get(13)));
		member.setManagersEvents(normalize(params.get(14)));
		member.setHobby(normalize(params.get(15)));

		return member;
	}
	
}
