package io.actbase.testdb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestdbApplicationTests {

	@Test
	void contextLoads() {
	}

}



    
-- INSERT INTO notification_message (id, created_at, updated_on, body, related_id, scheduled_date_time, send_type, sent_date_time, status, title, `type`, receiver_id, link, is_toast_read) VALUES(8442, '2021-10-12 09:52:45.922744000', '2021-10-12 09:52:45.922744000', '[한방에 끝내는 초등 한글오피스] 시작날이에요! 아이쿠카가 힘차게 응원할게요! ', NULL, '2021-10-1 16:36:00', 'SCHEDULED', NULL, 'PREPARE', '오늘은 챌린지 시작날!', 'CHALLENGE_START_DAY', 972, '/mycontents?tabIndex1=2&tabIndex3=1', NULL);
-- INSERT INTO notification_message (id, created_at, updated_on, body, related_id, scheduled_date_time, send_type, sent_date_time, status, title, `type`, receiver_id, link, is_toast_read) VALUES(8442, '2021-10-12 09:52:45.922744000', '2021-10-12 16:50:49.538476000', '내 챌린지 바로가기> / 인증 바로 하기>', NULL, '2021-10-12 16:36:00', 'SCHEDULED', '2021-10-12 16:40:00.010048000', 'SENT', '[챌린지] 오늘부터 시작이에요!', 'CHALLENGE_START_DAY', 972, '/mycontents?tabIndex1=2&tabIndex3=1', 1);  
    
 
    