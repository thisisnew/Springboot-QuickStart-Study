package com.rubypaper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	private BoardRepository boardRepo;
	
//	@Test
//	public void testInsertBoard() {
//		
//		Board board = new Board();
//		board.setTitle("첫 번째 게시글");
//		board.setWriter("테스터");
//		board.setContent("잘 등록되나요?");
//		board.setCreateDate(new Date());
//		board.setCnt(0L);
//		
//		boardRepo.save(board);
//	}
	
//	@Test
//	public void testGetBoard() {
//		Board board = boardRepo.findById(1L).get();
//		System.out.println(board.toString());
//	}
	
//	@Test
//	public void testUpdateBoard() {
//		System.out.println("===1번 게시글 조회===");
//		Board board = boardRepo.findById(1L).get();
//		
//		System.out.println("===1번 게시글 수정===");
//		board.setTitle("제목을 11111했습니다");
//		boardRepo.save(board);
//	}
	
//	@Test
//	public void testDeleteBoard() {
//		boardRepo.deleteById(1L);
//	}
	
//	@Before
//	public void dataPrepare() {
//		for(int i=0; i<=200; i++) {
//			Board board = new Board();
//			board.setTitle("테스트 제목 "+i);
//			board.setWriter("테스터");
//			board.setContent("테스트 내용"+i);
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			boardRepo.save(board);
//		}
//	}
//	
//	@Test
//	public void testFindByTitle() {
//		List<Board> boardList = boardRepo.findByTitle("테스트 제목 10");
//		System.out.println("-----검색 결과-----");
//		for(Board board : boardList) {
//			System.out.println("--->" + board.toString());
//		}
//	}
	
//	@Test
//	public void testByContentContaining() {
//		List<Board> boardList = boardRepo.findByContentContaining("17");
//		System.out.println("-----검색 결과-----");
//		for(Board board : boardList) {
//			System.out.println("--->" + board.toString());
//		}
//	}
	
//	@Test
//	public void testFindByTitleContainingOrContentContaining() {
//		List<Board> boardList = boardRepo.findByTitleContainingOrContentContaining("17", "17");
//		System.out.println("-----검색 결과-----");
//		for(Board board : boardList) {
//			System.out.println("--->" + board.toString());
//		}
//	}
	
//	@Test
//	public void testFindByTitleContainingOrderBySeqDesc() {
//		List<Board> boardList = boardRepo.findByTitleContainingOrderBySeqDesc("17");
//		System.out.println("-----검색 결과-----");
//		for(Board board : boardList) {
//			System.out.println("--->" + board.toString());
//		}
//	}
	
	@Test
	public void testFindByTitleContaining() {
		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC,"seq");
		
		Page<Board> pageInfo = boardRepo.findByTitleContaining("제목", paging);
		
		System.out.println("PAGE SIZE : " + pageInfo.getSize());
		System.out.println("TOTAL PAGES : " + pageInfo.getTotalPages());
		System.out.println("TOTAL COUNT : " + pageInfo.getTotalElements());
		System.out.println("NEXT : " + pageInfo.nextPageable());
		System.out.println("이전페이지 존재 여부 : " + pageInfo.hasPrevious());
		
		List<Board> boardList = pageInfo.getContent();
		
		System.out.println("-----검색 결과-----");
		for(Board board : boardList) {
			System.out.println("--->" + board.toString());
		}
	}
}
