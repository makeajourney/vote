package vote.common.util;

import java.util.UUID;

public class CommonUtils {
	
	// 32글자의 랜덤한 스트링을 만들어서 반환.
	public static String getRandomString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
