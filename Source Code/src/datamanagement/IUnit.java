package datamanagement;

public interface IUnit {

    public String getUnitCode();
    public String getUnitName();

    public float getPassCutoff();
    public void setPassCutoff(float cutoff);

    public float getCreditCutoff();
    public void setCreditCutoff(float cutoff);

    public float getDistinctionCutoff();
    public void setDistinctionCutoff(float cutoff);

    public float getHighDistinctionCutoff();
    public void setHighDistinctionCutoff(float cutoff);

    public float getAdditionalExamCutoff();
    public void setAdditionalExamCutoff(float cutoff);
    
    public int getAssessment1Weight();
    public int getAssessment2Weight();
    public int getExamWeight();
    public void setAssessmentWeights(int asg1Wgt, int asg2Wgt, int examWgt);

    public String getGrade(float asg1, float asg2, float exam);

    public void addStudentRecord(IStudentUnitRecord record);
    public IStudentUnitRecord getStudentRecord(int studentID);
    
    public StudentUnitRecordList getStudentRecords();
}
