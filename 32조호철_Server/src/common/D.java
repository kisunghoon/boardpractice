package common;

public class D {
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String USERID = "scott26";
	public static final String USERPW = "tiger26";
	
	// 게시글 관련 쿼리문
		public static final String SQL_WRITE_INSERT = 
				"INSERT INTO exam_book"
				+ "(bk_uid, bk_subject, bk_content, bk_price, bk_regdate) "
				+ "VALUES"
				+ "(exam_book_seq.nextval, ?, ?, ?, SYSDATE)";
		
		public static final String SQL_WRITE_SELECT = 
				"SELECT bk_uid \"uid\", bk_subject subject, bk_content content, " +
				"bk_price price, bk_viewcnt viewcnt, bk_regdate regdate " +
				"FROM exam_book ORDER BY bk_uid DESC";
		
		public static final String SQL_WRITE_SELECT_BY_UID =
				"SELECT bk_uid \"uid\", bk_subject subject, bk_content content, " +
				"bk_price price, bk_viewcnt viewcnt, bk_regdate regdate " +
				"FROM exam_book WHERE bk_uid = ?";
		
		public static final String SQL_WRITE_INC_VIEWCNT = 
				"UPDATE exam_book SET bk_viewcnt = bk_viewcnt + 1 WHERE bk_uid = ?";
		
		public static final String SQL_WRITE_DELETE_BY_UID =
				"DELETE FROM exam_book WHERE bk_uid = ?";

		public static final String SQL_WRITE_UPDATE =
				"UPDATE exam_book SET bk_subject = ?, bk_content = ?, bk_price = ? WHERE bk_uid = ?";

	
	
}
