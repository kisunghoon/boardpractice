package common;

public interface D {
	
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String USERID = "scott26";
	public static final String USERPW = "tiger26";
	
	public static final String SQL_EXAM_INSERT =
			"INSERT INTO EXAM_STOCK VALUES (exam_stock_seq.nextval, ?, ?, ?, sysdate)";
	
	public static final String SQL_EXAM_SELECT =
			"SELECT ex_uid \"uid\", ex_name name, ex_intro intro, ex_total total, ex_regdate regdate "
			+ "FROM exam_stock ORDER BY ex_uid DESC";
	
	public static final String SQL_EXAM_SELECT_BY_UID = 
			"SELECT ex_uid \"uid\", ex_name name, ex_intro intro, ex_total total, ex_regdate regdate "
			+ "FROM exam_stock WHERE ex_uid = ?";
	
	public static final String SQL_EXAM_DELETE_BY_UID = 
			"DELETE FROM exam_stock WHERE ex_uid = ?";
	
	public static final String SQL_EXAM_UPDATE = 
			"UPDATE exam_stock SET ex_name = ?, ex_intro = ?, ex_total = ? WHERE ex_uid = ?";

}
