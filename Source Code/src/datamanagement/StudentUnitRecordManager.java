package datamanagement;

import org.jdom.Element;

import java.util.List;

/**
 * The class controls student-unit record object.
 *
 * @author Zeno Li
 * @since 2015-08-05
 */
public class StudentUnitRecordManager
{
    private static StudentUnitRecordManager self_ = null;

    private StudentUnitRecordMap studentUnitRecordMap_;
    private java.util.HashMap<String, StudentUnitRecordList>
            unitStudentRecordListMap_;
    private java.util.HashMap<Integer, StudentUnitRecordList>
            studentIdStudentRecordListMap_;



    /**
     * Class constructor.
     */
    private StudentUnitRecordManager()
    {
        studentUnitRecordMap_ = new StudentUnitRecordMap();
        unitStudentRecordListMap_ = new java.util.HashMap<>();
        studentIdStudentRecordListMap_ = new java.util.HashMap<>();
    }



    /**
     * Return static student-unit record object self_.
     *
     * @return Student-unit record.
     */
    public static StudentUnitRecordManager getSelf()
    {
        if (self_ == null) self_ = new StudentUnitRecordManager();
        return self_;
    }



    /**
     * Return student-unit record by student ID and unit code.
     *
     * @param studentID Student ID.
     * @param unitCode  Unit Code.
     * @return  Student-unit record.
     */
    public IStudentUnitRecord getStudentUnitRecord(Integer studentID,
                                                   String unitCode)
    {
        IStudentUnitRecord record = studentUnitRecordMap_.
                                    get(studentID.toString() + unitCode);

        return record != null ? record :
                         createStudentUnitRecord(studentID, unitCode);
    }



    private IStudentUnitRecord createStudentUnitRecord(Integer studentId, String unitCode)
    {
        IStudentUnitRecord record;

        for (Element element : (List<Element>)
             XMLManager.getXML().getDocument().getRootElement().
                        getChild("studentUnitRecordTable").
                        getChildren("record")) {
            String recordStudentId = element.getAttributeValue("sid");
            String recordUnitCode = element.getAttributeValue("uid");

            if (studentId.toString().equals(recordStudentId) &&
                unitCode.equals(recordUnitCode)) {
                float assignment1 = new Float(
                        element.getAttributeValue("asg1")).floatValue();
                float assignment2 = new Float(
                        element.getAttributeValue("asg2")).floatValue();
                float exam = new Float(
                        element.getAttributeValue("exam")).floatValue();

                record = new StudentUnitRecord(studentId, unitCode,
                                               assignment1, assignment2, exam);

                studentUnitRecordMap_.put(record.getStudentID().toString() +
                                          record.getUnitCode(), record);

                return record;
            }
        }

        throw new RuntimeException("DBMD: createStudent : " +
                                   "student unit record not in file");
    }



    /**
     * Return student-unit record list by unit code.
     *
     * @param unitCode  Unit code.
     * @return  Student-unit record list.
     */
    public StudentUnitRecordList getRecordsByUnit(String unitCode)
    {
        StudentUnitRecordList recordList =
                unitStudentRecordListMap_.get(unitCode);

        if (recordList != null)
            return recordList;

        recordList = new StudentUnitRecordList();
        for (Element element : (List<Element>)
             XMLManager.getXML().getDocument().getRootElement().
                        getChild("studentUnitRecordTable").
                        getChildren("record")) {
            String recordUnitCode = element.getAttributeValue("uid");

            if (unitCode.equals(recordUnitCode)) {
                Integer recordStudentId = new Integer(element.getAttributeValue("sid"));

                recordList.add(new StudentUnitRecordProxy(recordStudentId,
                                                          recordUnitCode));
            }
        }

        if (recordList.size() > 0)
            // be careful - this could be empty
            unitStudentRecordListMap_.put(unitCode, recordList);

        return recordList;
    }



    /**
     * Return student-unit by student ID.
     *
     * @param studentID Student ID.
     * @return  Student-unit record list.
     */
    public StudentUnitRecordList getRecordsByStudent(Integer studentID)
    {
        StudentUnitRecordList recordList =
                studentIdStudentRecordListMap_.get(studentID);

        if (recordList != null)
            return recordList;

        recordList = new StudentUnitRecordList();
        for (Element element : (List<Element>)
             XMLManager.getXML().getDocument().getRootElement().
                        getChild("studentUnitRecordTable").
                        getChildren("record")) {
            String recordStudentId = element.getAttributeValue("sid");

            if (studentID.toString().equals(recordStudentId)) {
                String recordUnitCode = element.getAttributeValue("uid");

                recordList.add(new StudentUnitRecordProxy(studentID,
                                                          recordUnitCode));
            }
        }

        if (recordList.size() > 0)
            // be careful - this could be empty
            studentIdStudentRecordListMap_.put(studentID, recordList);

        return recordList;
    }



    /**
     * Save student-unit record into XML.
     *
     * @param studentUnitRecord Student-unit record.
     */
    public void saveRecord(IStudentUnitRecord studentUnitRecord)
    {
        for (Element element : (List<Element>)
             XMLManager.getXML().getDocument().getRootElement().
                        getChild("studentUnitRecordTable").
                        getChildren("record")) {
            Integer studentId = studentUnitRecord.getStudentID();
            String recordStudentId = element.getAttributeValue("sid");

            String unitCode = studentUnitRecord.getUnitCode();
            String recordUnitCode = element.getAttributeValue("uid");

            if (studentId.toString().equals(recordStudentId) &&
                unitCode.equals(recordUnitCode)) {
                String assignment1Mark = new Float(
                        studentUnitRecord.getAssignment1Mark()).toString();
                String assignment2Mark = new Float(
                        studentUnitRecord.getAssignment2Mark()).toString();
                String examMark = new Float(
                        studentUnitRecord.getExamMark()).toString();

                element.setAttribute("asg1", assignment1Mark);
                element.setAttribute("asg2", assignment2Mark);
                element.setAttribute("exam", examMark);

                //write out the XML file for continuous save
                XMLManager.getXML().saveDocument();

                return;
            }
        }

        throw new RuntimeException("DBMD: saveRecord : " +
                                   "no such student record in data");
    }
}
