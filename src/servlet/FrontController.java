package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ApplicationController;
import view.ViewResolver;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/app/*")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ApplicationController applicationController;
    private ViewResolver viewResolver;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==================FrontController==========================");
		System.out.println("path info: " + request.getPathInfo());
		
		String errorMessage="";
		ProcessRequest(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==================FrontController==========================");
		System.out.println("path info: " + request.getPathInfo());
		
		String errorMessage="";
		ProcessRequest(request, response);
		
	}
	
	private void ProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = applicationController.processRequest(request.getPathInfo(), request);
		String page = viewResolver.getPage(view);
		System.out.println("FrontController klasa, metoda ProcessRequest view = " + view + " i page = " + page);
		request.getRequestDispatcher(page).forward(request, response); 
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		applicationController = new ApplicationController();
		System.out.println("Application controller created");
		viewResolver = new ViewResolver();
		System.out.println("View resolver created");
	}

}
