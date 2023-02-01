package todolist;

public class ToDoListVO {
	//변수
	//생성자
	//Getter, Setter
	//Method 순으로 작성한다.
	
	//boolean 변수명 작성시 규칙
	//앞에 is를 붙인다.
	private boolean status;
	private String name;
	
	
	//오버로딩 생성자
	public ToDoListVO(String name) {
//		status = false;
		//-- 굳이 넣을 필요가 없음.
		//-- boolean 변수는 false가 기본값임
		setName(name);
	}
	


	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
