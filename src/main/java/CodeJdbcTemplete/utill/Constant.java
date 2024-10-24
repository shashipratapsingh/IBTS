package CodeJdbcTemplete.utill;

public class Constant {

    public static final String SAVE_UNIVERCITY = "INSERT INTO university (universityName, universityCity, universityAddress, universityContact, universityEmail, universityZipCode, remark, createBy, updateBy) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String GET_UNIVERCITY_BY_ID = "SELECT * FROM university WHERE id = ?";
    public static final String GET_UNIVERCITY_BY_UniversityEmail="SELECT * FROM university WHERE universityEmail = ?";
    public static final String GET_UNIVERSITY_BY_EMAIL_ONLY = "SELECT universityEmail FROM university WHERE universityEmail = ?";
    public static final String GET_COLLAGE_BY_ID="SELECT * FROM collage WHERE id = ?";

  //  ------------------------------------------REGISTER COLLAGE------------------------------
    public static final String REGISTER_COLLAGE="INSERT INTO Collage (collageId, collageName, collageType, collageDescription, collageStatus, collageCity, collageDate,collageLocation,collageContact,collageContactEmail, createdBy, updatedBy)" +
          "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


    //  ------------------------------------------Massages------------------------------
    public static final String INVALID_INPUT_PAYLOAD = "Invalid input payload";
    public static final String EMAIL_ALREADY_EXIST = "Email already exist";
    public static final String COLLAGE_ID = "Collage id not Exist";
}
