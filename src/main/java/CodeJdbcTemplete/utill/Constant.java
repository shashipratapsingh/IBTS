package CodeJdbcTemplete.utill;

public class Constant {

    public static final String SAVE_UNIVERCITY = "INSERT INTO university (universityName, universityCity, universityAddress, universityContact, universityEmail, universityZipCode, remark, createBy, updateBy) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String GET_UNIVERCITY_BY_ID = "SELECT * FROM university WHERE id = ?";
    public static final String GET_UNIVERCITY_BY_UniversityEmail="SELECT * FROM university WHERE universityEmail = ?";
    public static final String INVALID_INPUT_PAYLOAD = "Invalid input payload";
}
