package datamanagement;

public class CheckGradeControl {

	private CheckGradeUserInterface checkGradeUserInterface_;
	private String currentUnitCode_ = null;
	private Integer currentStudentId_ = null;
	private boolean hasChanged_ = false;

	public CheckGradeControl() {
	}

	public void execute() {
		checkGradeUserInterface_ = new CheckGradeUserInterface(this);
		checkGradeUserInterface_.enableUnitsComboBox(false);

		checkGradeUserInterface_.enableStudentRecordsComboBox(false);
		checkGradeUserInterface_.enableCheckGradeButton(false);
		checkGradeUserInterface_.enableChangeGradeButton(false);
		checkGradeUserInterface_.enableEditingMarks(false);
		checkGradeUserInterface_.enableSaveButton(false);
		checkGradeUserInterface_.clearStudentMarks();

		ListUnitsControl listUnitsControl = new ListUnitsControl();
		listUnitsControl.listUnits(checkGradeUserInterface_);
		checkGradeUserInterface_.setVisible(true);
		checkGradeUserInterface_.enableUnitsComboBox(true);
	}

	public void unitSelected(String code) {

		if (code.equals("NONE"))
			checkGradeUserInterface_.enableStudentRecordsComboBox(false);
		else {
			ListStudentsCTL listStudentsControl = new ListStudentsCTL();
			listStudentsControl.listStudents(checkGradeUserInterface_, code);

			currentUnitCode_ = code;

			checkGradeUserInterface_.enableStudentRecordsComboBox(true);
		}

		checkGradeUserInterface_.enableCheckGradeButton(false);
	}

	public void studentSelected(Integer id) {
		currentStudentId_ = id;

		if (currentStudentId_.intValue() == 0) {
			checkGradeUserInterface_.clearStudentMarks();
			checkGradeUserInterface_.enableCheckGradeButton(false);
			checkGradeUserInterface_.enableChangeGradeButton(false);
			checkGradeUserInterface_.enableEditingMarks(false);
			checkGradeUserInterface_.enableSaveButton(false);
		}
		else {
			IStudent student = StudentManager.getSelf().getStudent(id);

			IStudentUnitRecord studentUnitRecord =
					student.getUnitRecord(currentUnitCode_);

			checkGradeUserInterface_.setRecord(studentUnitRecord);
			checkGradeUserInterface_.enableCheckGradeButton(true);
			checkGradeUserInterface_.enableChangeGradeButton(true);
			checkGradeUserInterface_.enableEditingMarks(false);
			checkGradeUserInterface_.enableSaveButton(false);

			hasChanged_ = false;
		}
	}

	public String checkGrade(float assessment1Mark,
							 float assessment2Mark,
							 float examMark) {

		IUnit unit = UnitManager.getInstance().getUnit(currentUnitCode_);
		String studentGrade = unit.getGrade(assessment1Mark,
				assessment2Mark, examMark);

		checkGradeUserInterface_.enableChangeGradeButton(true);
		checkGradeUserInterface_.enableEditingMarks(false);

		if (hasChanged_) {
			checkGradeUserInterface_.enableSaveButton(true);
		}

		return studentGrade;
	}

	public void enableChangeMarks() {
		checkGradeUserInterface_.enableChangeGradeButton(false);
		checkGradeUserInterface_.enableSaveButton(false);
		checkGradeUserInterface_.enableEditingMarks(true);
		hasChanged_ = true;
	}

	public void saveGrade(float assessment1Mark,
						  float assessment2Mark,
						  float examMark) {

		IStudent student = StudentManager.getSelf()
				.getStudent(currentStudentId_);

		IStudentUnitRecord studentUnitRecord =
				student.getUnitRecord(currentUnitCode_);

		studentUnitRecord.setAssignment1Mark(assessment1Mark);
		studentUnitRecord.setAssignment2Mark(assessment2Mark);
		studentUnitRecord.setExamMark(examMark);

		StudentUnitRecordManager.getSelf().saveRecord(studentUnitRecord);

		checkGradeUserInterface_.enableChangeGradeButton(true);
		checkGradeUserInterface_.enableEditingMarks(false);
		checkGradeUserInterface_.enableSaveButton(false);
	}
}
