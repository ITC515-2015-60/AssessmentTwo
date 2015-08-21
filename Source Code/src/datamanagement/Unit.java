package datamanagement;

/**
 * Concrete instance of the Unit class
 */
public class Unit implements IUnit {

	private String unitCode_;
	private String unitName_;

    private float passCutoff_;
	private float creditCutoff_;
	private float distinctionCutoff_;
	private float highDistinctionCutoff_;
	private float additionalExaminationCutoff_;

    private int assessment1Weight_;
    private int assessment2Weight_;
    private int examWeight_;
	
	private StudentUnitRecordList studentRecords_;

	/**
	 * Constructor for the Unit class, creates a Unit from values assigned.
	 * @param unitCode
	 * @param unitName
	 * @param passCutoff
	 * @param creditCutoff
	 * @param distinctionCutoff
	 * @param highDistinctionCutoff
	 * @param additionalExaminationCutoff
	 * @param assessment1Weight
	 * @param assessment2Weight
	 * @param examWeight
	 * @param studentRecords
	 */
	public Unit(String unitCode, String unitName, float passCutoff,
				float creditCutoff, float distinctionCutoff,
				float highDistinctionCutoff, float additionalExaminationCutoff,
				int assessment1Weight, int assessment2Weight, int examWeight,
				StudentUnitRecordList studentRecords) {

		unitCode_ = unitCode;
		unitName_ = unitName;

		setCutoffs(passCutoff, creditCutoff, distinctionCutoff,
				highDistinctionCutoff, additionalExaminationCutoff);
		setAssessmentWeights(assessment1Weight, assessment2Weight, examWeight);

		studentRecords_ = studentRecords == null
				? new StudentUnitRecordList()
				: studentRecords;
	}


	/**
	 * Return the Code for the Subject
	 * @return
	 */
	public String getUnitCode() {
		return unitCode_;
	}


	/**
	 * Return the name for the subject
	 * @return
	 */
	public String getUnitName() {
		return unitName_;
	}


	/**
	 * Set the Pass mark cutoff for the subject
	 * @param cutoff
	 */
	public void setPassCutoff(float cutoff) {
		passCutoff_ = cutoff;
	}

	/**
	 * Get the Pass mark cutoff for the subject
	 * @return
	 */
	public float getPassCutoff() {
		return passCutoff_;
	}


	/**
	 * Set the Credit mark cutoff for the subject
	 * @param cutoff
	 */
	public void setCreditCutoff(float cutoff) {
		creditCutoff_ = cutoff;
	}


	/**
	 * Get the Credit mark cutoff for the subject
	 * @return
	 */
	public float getCreditCutoff() {
		return creditCutoff_;
	}


	/**
	 * Set the Distinction mark cutoff for the subject
	 * @param cutoff
	 */
	public void setDistinctionCutoff(float cutoff) {
		distinctionCutoff_ = cutoff;
	}


	/**
	 * Get the Distinction mark cutoff for the subject
	 * @return
	 */
	public float getDistinctionCutoff() {
		return distinctionCutoff_;
	}


	/**
	 * Set the High Distinction cutoff for the subject
	 * @param cutoff
	 */
	public void setHighDistinctionCutoff(float cutoff) {
		highDistinctionCutoff_ = cutoff;
	}


	/**
	 * Get the High Distinction cutoff for the subject
	 * @return
	 */
	public float getHighDistinctionCutoff() {
		return highDistinctionCutoff_;
	}


	/**
	 * Set the Additional Exam cutoff for the subject
	 * @param cutoff
	 */
	public void setAdditionalExamCutoff(float cutoff) {
		additionalExaminationCutoff_ = cutoff;
	}


	/**
	 * Get the Additional Exam cutoff for the subject
	 * @return
	 */
	public float getAdditionalExamCutoff() {
		return additionalExaminationCutoff_;
	}


	/**
	 * Add a student record to the subject's student collection
	 * @param record
	 */
	public void addStudentRecord(IStudentUnitRecord record) {
		studentRecords_.add(record);
	}


	/**
	 * Get a student's record for the subject from the collection
	 * @param studentId
	 * @return
	 */
	public IStudentUnitRecord getStudentRecord(int studentId) {
		for (IStudentUnitRecord record : studentRecords_) {
			if (record.getStudentID() == studentId)
                return record;
		}

		return null;
	}

	/**
	 * Get all student records for the subject
	 * @return
	 */
	public StudentUnitRecordList getStudentRecords() {
        return studentRecords_;
	}


	/**
	 * Get the weighting for the first assessment
	 * @return
	 */
	@Override
	public int getAssessment1Weight() {
		return assessment1Weight_;
	}


	/**
	 * Get the weighting for the second assessment
	 * @return
	 */
	@Override
	public int getAssessment2Weight() {
		return assessment2Weight_;
	}


	/**
	 * Get the weighting for the exam
	 * @return
	 */
	@Override
	public int getExamWeight() {
		return examWeight_;
	}


	/**
	 * Set the assessment and exam weightings for the subject.
	 * @param assessment1Weight
	 * @param assessment2Weight
	 * @param examWeight
	 */
	@Override
	public void setAssessmentWeights(int assessment1Weight,
									 int assessment2Weight, int examWeight) {
		if (assessment1Weight < 0 || assessment1Weight > 100 ||
			assessment2Weight < 0 || assessment2Weight > 100 ||
			examWeight < 0 || examWeight > 100 ) {
			throw new RuntimeException(
					"Assessment weights cant be less than zero or greater than 100");
		}

		if (assessment1Weight + assessment2Weight + examWeight != 100) {
			throw new RuntimeException("Assessment weights must add to 100");
		}

		assessment1Weight_ = assessment1Weight;
		assessment2Weight_ = assessment2Weight;
		examWeight_ = examWeight;
	}


	/**
	 * Set the cutoff marks for the grades for the subject
	 * @param passCutoff
	 * @param creditCutoff
	 * @param distinctionCutoff
	 * @param highDistinctionCutoff
	 * @param additionalExaminationCutoff
	 */
	private void setCutoffs(float passCutoff, float creditCutoff,
							float distinctionCutoff, float highDistinctionCutoff,
							float additionalExaminationCutoff) {

		if (passCutoff < 0 || passCutoff > 100 ||
			creditCutoff < 0 || creditCutoff > 100 ||
			distinctionCutoff < 0 || distinctionCutoff > 100 ||
			highDistinctionCutoff < 0 || highDistinctionCutoff > 100 ||
			additionalExaminationCutoff < 0 || additionalExaminationCutoff > 100 ) {
			throw new RuntimeException(
					"Assessment cutoffs cant be less than zero or greater than 100");
		}

		if (additionalExaminationCutoff >= passCutoff)
			throw new RuntimeException("AE cutoff must be less than PS cutoff");

        if (passCutoff >= creditCutoff)
			throw new RuntimeException("PS cutoff must be less than CR cutoff");

        if (creditCutoff >= distinctionCutoff)
			throw new RuntimeException("CR cutoff must be less than DI cutoff");

        if (distinctionCutoff >= highDistinctionCutoff)
			throw new RuntimeException("DI cutoff must be less than HD cutoff");

        passCutoff_ = passCutoff;
        creditCutoff_ = creditCutoff;
        distinctionCutoff_ = distinctionCutoff;
        highDistinctionCutoff_ = highDistinctionCutoff;
        additionalExaminationCutoff_ = additionalExaminationCutoff;
	}


	/**
	 * Get a student's grade for the subject based on their marks
	 * @param assessment1Score
	 * @param assessment2Score
	 * @param examScore
	 * @return
	 */
	public String getGrade(float assessment1Score, float assessment2Score,
						   float examScore) {
		float totalScore = assessment1Score + assessment2Score + examScore;
		
		if (assessment1Score < 0 || assessment1Score > assessment1Weight_ ||
			assessment2Score < 0 || assessment2Score > assessment2Weight_ ||
			examScore < 0 || examScore > examWeight_) {
			throw new RuntimeException(
					"Marks cannot be less than zero or greater than assessment weights");
		}

		if (totalScore < additionalExaminationCutoff_)
			return "FL";
		else if (totalScore < passCutoff_)
			return "AE";
		else if (totalScore < creditCutoff_)
			return "PS";
		else if (totalScore < distinctionCutoff_)
			return "CR";
		else if (totalScore < highDistinctionCutoff_)
			return "DI";
		else
			return "HD";
	}
}