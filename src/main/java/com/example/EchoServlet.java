package com.example;

// import io.opentracing.Span;
// import io.opentracing.util.GlobalTracer;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Map;

@WebServlet (value={"/echo","/echo/"}, name="echoServlet")
public class EchoServlet  extends HttpServlet {
	private @Resource(name="jdbc/MyDs") DataSource ds;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Span span = GlobalTracer.get().buildSpan("echoServletDoGet").start();
		simulateWork();
		StringBuilder sb = new StringBuilder(req.getRequestURL());
		if(req.getQueryString() != null) sb.append("?").append(req.getQueryString());
		sb.append("\n");
		for (Map.Entry<String,String[]> entry : req.getParameterMap().entrySet()) {
			sb.append("\n");
			sb.append(entry.getKey());
			sb.append(" : ");
			sb.append(entry.getValue()[0]);
		}
		//new WorkTest().doWork();
		new SqlWork().doWork(ds);
		simulateWork();
		resp.getWriter().println(sb.toString());
		//span.finish();
	}

	public void simulateWork() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

