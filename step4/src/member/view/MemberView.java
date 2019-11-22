package member.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import member.model.vo.Member;

public class MemberView {
	public void displayError(String code) {
		switch(code) {
			case "insert" : System.out.println("회원 정보 입력 실패!"); break;
			case "update" : System.out.println("회원 정보 수정 실패!"); break;
			case "delete" : System.out.println("회원 정보 삭제 실패!"); break;
			default : System.out.println("알 수 없는 에러 발생!"); break;
		}
	}
	
	public void display(ArrayList<Member> list) {
		for(Member m : list) {
			System.out.println(m);
		}
	}
	
	public void displayMember(Member m) {
		System.out.println(m);
	}
	
	public void displayMap(HashMap<String, Member> hmap) {
		Iterator iter = hmap.keySet().iterator();
		
		while(iter.hasNext()) {
			System.out.println(hmap.get(iter.next()));
		}
	}
}
















