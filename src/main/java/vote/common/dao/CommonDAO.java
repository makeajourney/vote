package vote.common.dao;

import org.springframework.stereotype.Repository;

import vote.com.vo.VoteFile;

@Repository("commonDAO")
public class CommonDAO extends AbstractDAO{
	
	public VoteFile selectFileInfo(int no) throws Exception{
	    return (VoteFile) selectOne("common.selectFileInfo", no);
	}
}
