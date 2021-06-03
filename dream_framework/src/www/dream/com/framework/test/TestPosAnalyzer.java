package www.dream.com.framework.test;

import java.util.Map;

import org.junit.Test;

import www.dream.com.framework.langPosAnalyzer.PosAnalyzer;

public class TestPosAnalyzer {
	@Test
	public void test() {
		Post post = new Post();
		post.setTitle("질문");
		post.setContent("단어 명사 오존");

		Party writer = new Party();
		writer.setName("전오늘글러먹었습니다");
		post.setWriter(writer);
		
		ContactPoint cp = new ContactPoint();
		cp.setInfo("서울 특별시 구로구 가산 디지털");
		writer.addCP(cp);
		
		cp = new ContactPoint();
		cp.setInfo("needsomewater@naver.com");
		writer.addCP(cp);

		Map<String, Integer> map = PosAnalyzer.getHashTags(post);

		for (String k : map.keySet()) {
			System.out.println(k + " : " + map.get(k));
		}

		/*
		 * hashList = PosAnalyzer.getHashTags(post.getTitle()); hashList =
		 * PosAnalyzer.getHashTags(post.getContent()); hashList =
		 * PosAnalyzer.getHashTags(post.getWriter().getName());
		 */

	}

}
