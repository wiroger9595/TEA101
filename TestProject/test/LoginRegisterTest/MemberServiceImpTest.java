package LoginRegisterTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.spacevent.member.model.MemberVO;
import com.spacevent.member.service.MemberLoginRegisterService;
import com.spacevent.member.service.MemberLoginRegisterServiceImp;

public class MemberServiceImpTest {
	
	MemberLoginRegisterService memberLoginRegisterService;
	
	
	@BeforeEach
	void setUp() {
		memberLoginRegisterService = new MemberLoginRegisterServiceImp();
	}
	
	@AfterEach
	void tearDown() {
		memberLoginRegisterService = null;
	}
	
//	@Test
//	@DisplayName("login success")
//	void login1() {
//		MemberVO memberVO = new MemberVO();
//		memberVO.setMember_account("");
//		memberVO.setMember_password("");
//		
//		assertTrue(memberLoginRegisterService.login(memberVO));
//		assertNotNull(memberVO);
//		assertEquals("MEM445", memberVO.getMember_id());
//		assertEquals("CB239876470", memberVO.getMember_account());
//		assertEquals("74Jg4Fp4iaL", memberVO.getMember_password());
//		assertEquals("昆昆", memberVO.getMember_name());
//		assertEquals("Kunun", memberVO.getMember_nickname());
//		assertEquals("sjoesbury7@pbs.org", memberVO.getMember_email());
//		assertEquals(null, memberVO.getMember_photo());
//		assertEquals("372-167-8741", memberVO.getMember_phone());
//		assertEquals("新北市三峽區", memberVO.getMember_address());
//		assertEquals(357667200000L, memberVO.getMember_birth().getTime());
//		assertEquals("M", memberVO.getMember_sex());
//		assertEquals("Philippines", memberVO.getMember_country());
//		assertEquals(1493913600000L, memberVO.getMember_signup_date().getTime());
//		assertEquals(2, memberVO.getMember_auth());
//		assertEquals("T", memberVO.getMember_status());
//		
//	}
	
	@Test
	@DisplayName("login fail")
	void login2() {
		
		MemberVO memberVO = new MemberVO();
		memberVO.setMember_account("CB239876470");
		memberVO.setMember_password("123");
		assertFalse(memberLoginRegisterService.login(memberVO));
	}
	
	@Test
	void register() {
		
	}
}
