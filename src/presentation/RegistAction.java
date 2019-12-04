package presentation;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class RegistAction extends ActionSupport{
	private String username;
	private String password;
	private String repassword;	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String execute()throws Exception{
			if ("fan".equals(username) && "fan123456".equals(password)) {
				System.out.println("註册成功............");
				return "success";
				} else {
					System.out.println("註册失败............");
				return "error";
				}
	}
	public void validate(){
		if(username.equals("")||username==null){
			addFieldError("username","用户名为空");
		}else if(password.equals("")||password==null){
			addFieldError("password","密码为空");	
		}else if(repassword.equals("")||repassword==null){
			addFieldError("repassword","确认密码为空");	
		}else if(!password.equals(repassword)){
			addFieldError("password","两次输入密码不同");
		}
	}
}
