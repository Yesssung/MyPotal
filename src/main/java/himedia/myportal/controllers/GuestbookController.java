package himedia.myportal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.myportal.repositories.vo.GuestbookVo;
import himedia.myportal.services.GuestbookService;

@RequestMapping("/guestbook")
@Controller
public class GuestbookController {
	@Autowired
	GuestbookService guestbookService;
	
//	@ResponseBody
	@RequestMapping({"", "/", "/list"})
	public String list(Model model) {
		List<GuestbookVo> list = guestbookService.getMessageList();
		model.addAttribute("list", list);
		return "guestbook/list";			// view로 forwarding
//		return list.toString();
	}
	
	// Guestbook Write(POST) -> 방명록 기록 관련 요청 처리하기
	// /guestbook/write (POST)
	@PostMapping("/write")
	public String write(@ModelAttribute GuestbookVo vo) {
		System.out.println("HTML Form: " + vo);
		boolean success = guestbookService.writeMessage(vo);
		System.out.println("Write Result: " + success);
		// INSERT -> Redirect
		return "redirect:/guestbook";
		}
	
	// Guestbook Delete(no)	-> delete form 으로 이동
	// /guestbook/delete/{no}
	@GetMapping("/delete/{no}")
	public String delete(@PathVariable("no") Long no, Model model) {
		model.addAttribute("no", no);
		return "guestbook/deleteform";
	}
	
	// Guestbook Delete(POST) -> 실제 게시물 삭제
	// /guestbook/delete (POST)
	@PostMapping("/delete")
	public String delete(@ModelAttribute GuestbookVo vo) {
		boolean success = guestbookService.deleteMessage(vo);
		System.out.println("Delete Result: " + success);
		return "redirect:/guestbook";
	}
}
