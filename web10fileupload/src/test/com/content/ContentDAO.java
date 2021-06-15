package test.com.content;

import java.util.List;

public interface ContentDAO {

	public int insert(ContentVO vo);

	public int update(ContentVO vo);

	public int delete(ContentVO vo);

	public ContentVO selectOne(ContentVO vo);

	public List<ContentVO> selectAll();

	public List<ContentVO> searchList(String searchKey, String searchWord);
	
}
