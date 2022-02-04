package com.datingapp.springbootdatingapp.util;

public class QueryConstants {
	
	public static final String findAllUsersToMatch = "SELECT * FROM basic_user_details "
			+ " WHERE username != ?1 AND username NOT IN ( "
			+ " SELECT username_swiped FROM user_matched_info WHERE username = ?1 UNION "
			+ " SELECT username FROM user_matched_info WHERE username_swiped = ?1)";
	
	public static final String updateImageOrdering = "UPDATE user_images SET ordering = ?1 WHERE id = ?2";
	
	public static final String countImagesUserWise = "SELECT COUNT(*) FROM user_images WHERE username = ?1";
	
	public static final String fetchFirstImage = "SELECT * FROM user_images WHERE username = ?1 ORDER BY ordering LIMIT 1";
	
	public static final String fetchMatches = "SELECT username_swiped FROM ( "
			+ " SELECT username_swiped, date_created FROM user_matched_info WHERE username = ?1 UNION "
			+ " SELECT username as username_swiped, date_created FROM user_matched_info WHERE username_swiped = ?1) A "
			+ " ORDER BY date_created";
}
