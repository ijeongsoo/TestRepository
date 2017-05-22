package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterIncodingFilter implements Filter{
	private String characterset;
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("CharEncodingFilter init()");
		characterset = arg0.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		//전처리(서블릿이 실행하기 전에 처리:요청 처리전 )
		System.out.println("doFilter!!!-전처리 ");
		request.setCharacterEncoding(characterset);
		
		/*기준*/ filterChain.doFilter(request, response);
		
		//후처리(서블릿이 실행한 후에 처리 :응답읇 보내기 전 )
		System.out.println("doFilter!!!-처리 ");
	}

	
	
	@Override
	public void destroy() {
		System.out.println("destroy!!!!!");
	}
	
}
