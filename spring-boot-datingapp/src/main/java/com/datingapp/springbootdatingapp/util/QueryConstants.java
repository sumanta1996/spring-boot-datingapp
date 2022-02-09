package com.datingapp.springbootdatingapp.util;

public class QueryConstants {
	
	public static final String findAllUsersToMatch = "SELECT * FROM basic_user_details "
			+ " WHERE username != ?1 AND username NOT IN ( "
			+ " SELECT username_swiped FROM user_matched_info WHERE username = ?1 UNION "
			+ " SELECT username FROM user_matched_info WHERE username_swiped = ?1)";
	
	public static final String updateImageOrdering = "UPDATE user_images SET ordering = ?1 WHERE id = ?2";
	
	public static final String countImagesUserWise = "SELECT COUNT(*) FROM user_images WHERE username = ?1";
	
	public static final String fetchFirstImage = "SELECT * FROM user_images WHERE username = ?1 ORDER BY ordering LIMIT 1";
	
	public static final String fetchMatches = "SELECT A.id, A.username_swiped, A.date_created, A.username FROM "
			+ " (SELECT id, username_swiped, date_created, '' as username FROM user_matched_info WHERE username = ?1 UNION "
			+ " SELECT id, username as username_swiped, date_created, '' as username FROM user_matched_info WHERE username_swiped = ?1) A "
			+ " WHERE A.id not in (SELECT DISTINCT(conversation_id) from conversations)";
	
	public static final String fetchAllMessages = "SELECT RES.*, BUD.first_name, BUD.last_name, BUD.age, UI.image_data FROM ( "
			+ " SELECT CONV.*, A.username_swiped, matched_date FROM (SELECT MAX(B1.id) as id, B1.conversation_id, "
			+ " (CASE WHEN UMI.username = :username THEN UMI.username_swiped ELSE UMI.username END) as username_swiped, UMI.date_created as matched_date "
			+ " FROM conversations B1, user_matched_info UMI WHERE "
			+ " B1.conversation_id = UMI.id AND (UMI.username = :username OR UMI.username_swiped = :username) GROUP BY B1.conversation_id) A "
			+ " LEFT JOIN conversations CONV ON A.id = CONV.id) RES, basic_user_details BUD, "
			+ " user_images UI where RES.username_swiped = BUD.username AND BUD.username = UI.username AND UI.ordering = 1 ORDER BY RES.date_created desc";
}
