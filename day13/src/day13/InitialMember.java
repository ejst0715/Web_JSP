package day13;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitialMember implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ArrayList<Member> datas = new ArrayList<Member>();
		for(int i = 0; i<8; i++) {
			Member data=new Member("티모"+(i+1),"010-1234-123"+i);
			datas.add(data);
		}
		datas.add(new Member("아리",null));
		datas.add(new Member("가렌",null));
		
		
		ServletContext context=sce.getServletContext();
		//context는 서버 scope
		context.setAttribute("datas",datas);
		context.setAttribute("data",new Member());
		
	}

}
