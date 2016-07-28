package vote.common.service;

import vote.com.vo.VoteFile;

public interface CommonService {
	VoteFile selectFileInfo(int no) throws Exception;

}
