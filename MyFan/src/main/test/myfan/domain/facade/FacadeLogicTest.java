package myfan.domain.facade;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import myfan.data.dao.NewsDao;
import myfan.data.models.News;
import myfan.resources.base.RecentNewsResponse;

public class FacadeLogicTest {

	@Test
	public void getNewsByArtistId() {
		String expectedAnswer="";
		FacadeLogic facadeLogic = new FacadeLogic();
		String newsArtistTest=facadeLogic.getRecentNews(10, 0);
		System.out.println(newsArtistTest);
		assertEquals(2,newsArtistTest);
	}

}
