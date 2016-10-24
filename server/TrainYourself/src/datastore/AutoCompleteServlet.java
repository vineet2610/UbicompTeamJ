package datastore;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AutoCompleteServlet
 */
@WebServlet("/autocomplete")
public class AutoCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ComposerData compData = new ComposerData();
	private HashMap composers = compData.getComposers();
	private static int i=1;
	private ServletContext context;

	@Override
	public void init(ServletConfig config) throws ServletException {
	    this.context = config.getServletContext();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoCompleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");
        response.getWriter().write("<composers>" + Integer.toString(i) + "</composers>");
        i++;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
