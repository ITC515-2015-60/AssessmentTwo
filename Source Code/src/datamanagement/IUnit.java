package datamanagement;

public interface IUnit {

    public String getUnitCode();
    public String getUnitName();

    public float getPassCutoff();
    public void setPassCutoff(float passCutoff);

    public float getCreditCutoff();
    public void setCreditCutoff(float creditCutoff);

    public float getDistinctionCutoff();
    public void setDistinctionCutoff(float distinctionCutoff);

    public float getHighDistinctionCutoff();
    public void setHighDistinctionCutoff(float highDistinctionCutoff);

    public float getAdditionalExamCutoff();
    public void setAdditionalExamCutoff(float additionalExamCutoff);
    
    public int getAssessment1Weight();
    public int getAssessment2Weight();
    public int getExamWeight();
    public void setAssessmentWeights(int assessment1Weight, int assessment2Weight, int examWeight);

    public String getGrade(float assignment1, float assignment2, float exam);

    public void addStudentRecord(IStudentUnitRecord record);
    public IStudentUnitRecord getStudentRecord(int studentID);
    
    public StudentUnitRecordList getStudentRecords();
}
