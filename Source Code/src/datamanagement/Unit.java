package datamanagement;

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

	public Unit(String unitCode, String unitName, float passCutoff, float creditCutoff,
				float distinctionCutoff, float highDistinctionCutoff, float additionalExaminationCutoff,
				int assessment1Weight, int assessment2Weight, int examWeight,
				StudentUnitRecordList studentRecords) {

		unitCode_ = unitCode;
		unitName_ = unitName;

		setCutoffs(passCutoff, creditCutoff, distinctionCutoff, highDistinctionCutoff, additionalExaminationCutoff);
		setAssessmentWeights(assessment1Weight, assessment2Weight, examWeight);

		studentRecords_ = studentRecords == null ? new StudentUnitRecordList() : studentRecords;
	}

	public String getUnitCode() {
		return unitCode_;
	}

	public String getUnitName() {
		return unitName_;
	}

	public void setPassCutoff(float cutoff) {
		passCutoff_ = cutoff;
	}

	public float getPassCutoff() {
		return passCutoff_;
	}

	public void setCreditCutoff(float cutoff) {
		creditCutoff_ = cutoff;
	}

	public float getCreditCutoff() {
		return creditCutoff_;
	}

	public void setDistinctionCutoff(float cutoff) {
		distinctionCutoff_ = cutoff;
	}

	public float getDistinctionCutoff() {
		return distinctionCutoff_;
	}

	public void setHighDistinctionCutoff(float cutoff) {
		highDistinctionCutoff_ = cutoff;
	}

	public float getHighDistinctionCutoff() {
		return highDistinctionCutoff_;
	}

	public void setAdditionalExamCutoff(float cutoff) {
		additionalExaminationCutoff_ = cutoff;
	}

	public float getAdditionalExamCutoff() {
		return additionalExaminationCutoff_;
	}

	public void addStudentRecord(IStudentUnitRecord record) {
		studentRecords_.add(record);
	}

	public IStudentUnitRecord getStudentRecord(int studentId) {
		for (IStudentUnitRecord record : studentRecords_) {
			if (record.getStudentID() == studentId)
                return record;
		}

		return null;
	}

	public StudentUnitRecordList getStudentRecords() {
        return studentRecords_;
	}

	@Override
	public int getAssessment1Weight() {
		return assessment1Weight_;
	}

	@Override
	public int getAssessment2Weight() {
		return assessment2Weight_;
	}

	@Override
	public int getExamWeight() {
		return examWeight_;
	}

	@Override
	public void setAssessmentWeights(int assessment1Weight, int assessment2Weight, int examWeight) {
		if (assessment1Weight < 0 || assessment1Weight > 100 ||
			assessment2Weight < 0 || assessment2Weight > 100 ||
			examWeight < 0 || examWeight > 100 ) {
			throw new RuntimeException("Assessment weights cant be less than zero or greater than 100");
		}

		if (assessment1Weight + assessment2Weight + examWeight != 100) {
			throw new RuntimeException("Assessment weights must add to 100");
		}

		assessment1Weight_ = assessment1Weight;
		assessment2Weight_ = assessment2Weight;
		examWeight_ = examWeight;
	}
	
	private void setCutoffs(float passCutoff, float creditCutoff, float distinctionCutoff,
                            float highDistinctionCutoff, float additionalExaminationCutoff) {

		if (passCutoff < 0 || passCutoff > 100 ||
			creditCutoff < 0 || creditCutoff > 100 ||
			distinctionCutoff < 0 || distinctionCutoff > 100 ||
			highDistinctionCutoff < 0 || highDistinctionCutoff > 100 ||
			additionalExaminationCutoff < 0 || additionalExaminationCutoff > 100 ) {
			throw new RuntimeException("Assessment cutoffs cant be less than zero or greater than 100");
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
	
	public String getGrade(float assessment1Score, float assessment2Score, float examScore) {
		float totalScore = assessment1Score + assessment2Score + examScore;
		
		if (assessment1Score < 0 || assessment1Score > assessment1Weight_ ||
			assessment2Score < 0 || assessment2Score > assessment2Weight_ ||
			examScore < 0 || examScore > examWeight_) {
			throw new RuntimeException("Marks cannot be less than zero or greater than assessment weights");
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