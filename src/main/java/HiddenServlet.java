import edu.handong.PPTEditer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HiddenServlet", value = "/HiddenServlet")
public class HiddenServlet extends HttpServlet {

    @WebServlet(name = "MyServlet", value = "/MyServlet")
    public class MyServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");

            String param = request.getParameter("text1");
            try (PrintWriter writer = response.getWriter()) {
                writer.println("<!DOCTYPE html><html>");
                writer.println("<head>");
                writer.println("<meta charset=\"UTF-8\" />");
                writer.println("<title>MyServlet.java:doGet(): Servlet code!</title>");
                writer.println("</head>");
                writer.println("<body>");
                writer.println("<h1>" + param + "님 안녕하세요!</h1>");
                writer.println("</body>");
                writer.println("</html>");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        //PPT
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PPTEditer pptEditer = new PPTEditer();
        String param = request.getParameter("in_name");
        String result = pptEditer.function(param);
        String outFileDirPath = request.getServletContext().getRealPath("/");
        String outFileName = "text.txt";
        String outFilePath = outFileDirPath + outFileName;
        pptEditer.saveAs(outFilePath, result);

        request.setAttribute("result", result);
        request.setAttribute("d_file", outFilePath);

        ServletContext app = this.getServletContext();
        RequestDispatcher dispatcher = app.getRequestDispatcher("/index.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            writer.println(e);
        }
    }
}
