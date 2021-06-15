package test.com.movie;

import java.util.List;

public interface MovieDAO {

	public int insert(MovieVO vo);

	public int update(MovieVO vo);

	public int delete(MovieVO vo);

	public MovieVO selectOne(MovieVO vo);

	public List<MovieVO> selectAll();

	public List<MovieVO> searchList(String searchKey, String searchWord);

}

