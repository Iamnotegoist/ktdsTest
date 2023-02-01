package todolist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoListService {

	private List<ToDoListVO> toDoList;
	
	public ToDoListService() {
	
		toDoList = new ArrayList<>();

	}
	
	public void register(String name) {
		//등록
//		ToDoListVO toDoListVO = new ToDoListVO(name);
		toDoList.add(new ToDoListVO(name));
		
	}
	
	public void update(int index, boolean status) {
		//수정
		ToDoListVO toDoListVO = toDoList.get(index);
		toDoListVO.setStatus(status);
		
	}
	
	public void delete(int index) {
		//삭제
		toDoList.remove(index);
		
	}
	
	
	public void read() {
		//조회
		for(ToDoListVO toDoListVO: toDoList) {
//			String statusSymbol = toDoListVO.isStatus() ?"X" : " "
			if(toDoListVO.isStatus()) {
				System.out.println("[X]" + toDoListVO.getName());
			}
			else System.out.println("[ ]" + toDoListVO.getName());
		}
		
//		int size = toDoList.size();
		System.out.println("총 " + toDoList.size() + "개의 아이템이 조회되었습니다.");
		
	}
	
	public String getName(int index) {
		ToDoListVO toDoListVO = toDoList.get(index);
		String name = toDoListVO.getName();
		
		return name;
	}
	
	public static void main(String[] args) {
		
		ToDoListService toDoListService = new ToDoListService();
		Scanner scan = new Scanner(System.in);

		while(true) {
			System.out.println("=========");
			System.out.println("1. 등록");
			System.out.println("2. 수정");
			System.out.println("3. 삭제");
			System.out.println("4. 조회");
			System.out.println("5. 종료");
			System.out.println("=========");
			System.out.println("메뉴를 입력하세요.");
			
			int menu = scan.nextInt();
			scan.nextLine();
			
			if(menu == 1) {
				//등록
				System.out.println("TODO 이름을 입력하세요.");
				String name = scan.nextLine();
				toDoListService.register(name);
				System.out.println("아이템이 등록되었습니다.");
				
			}
			else if(menu == 2) {
				//수정
				System.out.println("수정할 아이템 번호를 입력하세요.");
				int index = scan.nextInt();
				scan.nextLine();
				
				
				
				if(index < toDoListService.toDoList.size()) {
					System.out.println("아이템이 완료되었다면 \"Y\"를 입력하세요. : ");
					String isY = scan.nextLine();
					
					if(isY.equalsIgnoreCase("Y")) {
						toDoListService.update(index, true);
						
						System.out.println("[" + toDoListService.getName(index) + "]" + "이 완료되었습니다.");
					}
					else {
						System.out.println("[" + toDoListService.getName(index) + "]" + "이 미완료되었습니다.");
					}
				}
				else {
					System.out.println("아이템이 존재하지 않습니다.");
				}
				
				
				
			}
			else if(menu == 3) {
				//삭제
				
				System.out.println("삭제할 아이템 번호를 입력하세요.");
				int index = scan.nextInt();
				scan.nextLine();
				
				if(index < toDoListService.toDoList.size()) {
					toDoListService.toDoList.remove(index);
					System.out.println("아이템이 삭제되었습니다.");
				}
				else {
					System.out.println("아이템이 존재하지 않습니다.");
				}
				
			}
			else if(menu == 4) {
				//조회
				toDoListService.read();
	
				
			}
			else {
				System.out.println("프로그램이 종료되었습니다.");
				break;
			}
			
		}
	}
	
}
