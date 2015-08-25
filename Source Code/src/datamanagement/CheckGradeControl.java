package datamanagement;

/**
 * This class controls the functions for interface between view and model.
 *
 * @author Andrew Tobin
 * @since 2015-08-05
 */
public class CheckGradeControl {

	private CheckGradeUserInterface checkGradeUserInterface_;
	private String currentUnitCode_ = null;
	private Integer currentStudentId_ = null;
	private boolean hasChanged_ = false;

	/**
	 * Empty constructor
	 */
	public CheckGradeControl() {
	}



	/**
	 * Initializes the UI viewmodel
	 */
	public void initialize() {
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



	/**
	 * The changes to the UI when the unit is selected
	 * @param unitCode
	 */
	public void unitSelected(String unitCode) {

		if (unitCode.equals("NONE")) {
			checkGradeUserInterface_.enableStudentRecordsComboBox(false);
		}
		else {
			ListStudentsCTL listStudentsControl = new ListStudentsCTL();
			listStudentsControl.listStudents(checkGradeUserInterface_, unitCode);

			currentUnitCode_ = unitCode;

			checkGradeUserInterface_.enableStudentRecordsComboBox(true);
		}

		checkGradeUserInterface_.enableCheckGradeButton(false);
	}



	/**
	 * The changes to the UI when the student is selected.
	 * @param studentId
	 */
	public void studentSelected(Integer studentId) {
		currentStudentId_ = studentId;

		if (currentStudentId_.intValue() == 0) {
			checkGradeUserInterface_.clearStudentMarks();

			checkGradeUserInterface_.enableCheckGradeButton(false);
			checkGradeUserInterface_.enableChangeGradeButton(false);
			checkGradeUserInterface_.enableEditingMarks(false);
			checkGradeUserInterface_.enableSaveButton(false);
		}
		else {
			IStudent student = StudentManager.getSelf().getStudent(studentId);

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



	/**
	 * When the checkGrade button is pressed.
	 * @param assessment1Mark
	 * @param assessment2Mark
	 * @param examMark
	 * @return
	 */
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



	/**
	 * Enable the Change Marks functions.
	 */
	public void enableChangeMarks() {
		checkGradeUserInterface_.enableChangeGradeButton(false);
		checkGradeUserInterface_.enableSaveButton(false);
		checkGradeUserInterface_.enableEditingMarks(true);

		hasChanged_ = true;
	}



	/**
	 * Save the grade changes for the student for the subject.
	 * @param assessment1Mark
	 * @param assessment2Mark
	 * @param examMark
	 */
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
