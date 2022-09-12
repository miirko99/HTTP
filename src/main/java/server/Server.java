package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Employee;
/**
 * Servlet implementation class Server
 */
@WebServlet("/Server")
@MultipartConfig
public class Server extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */

    private HashMap<Integer, Employee> employees = new HashMap<>();

    public Server() {

        Employee e1 = new Employee("Mitar Miric", 18, 500, "Pevac");
        Employee e2 = new Employee("Dragan Markovic", 41, 350, "Konobar");
        Employee e3 = new Employee("Jovan Jovanovic", 234, 150, "Zmaj");
        employees.put(1, e1);
        employees.put(2, e2);
        employees.put(3, e3);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));

        if(employees.containsKey(id))
        {
            Employee e = employees.get(id);
            String[] i=e.getInfo();
            writer.println(""
                    + "<html><head><title>Zaposlen</title></head>" + "<body>"
                    + "ime: " + i[0] + "<br>"
                    + "godine: " + i[1] + "<br>"
                    + "plata: " + i[2] + "<br>"
                    + "pozicija: " + i[3] + "<br>"
                    + "</body>"
                    + "</html>");
        }
        else
        {
            writer.println("<html><head></head><body>Zaposlen sa zadatim ID-em ne postoji</body></html>");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));


        if(employees.containsKey(id))
        {
            writer.println("<html><head></head><body>Zaposen sa zadatim ID-jem vec postoji</body></html>");
        }
        else
        {
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            double salary = Double.parseDouble(request.getParameter("salary"));
            String jobTitle = request.getParameter("jobTitle");

            Employee e = new Employee(name, age, salary, jobTitle);
            employees.put(id, e);
            writer.println("<html><head></head><body>Zaposlen je uspesno dodat</body></html>");
        }

    }


    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));

        if(!employees.containsKey(id))
        {
            writer.println("<html><head></head><body>Zaposlen sa zadatim ID-jem je uspesno izmenjen</body></html>");
        }
        else
        {
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            double salary = Double.parseDouble(request.getParameter("salary"));
            String jobTitle = request.getParameter("jobTitle");

            Employee e = new Employee(name, age, salary, jobTitle);
            employees.put(id, e);
            writer.println("<html><head></head><body>Zaposlen je uspesno dodat</body></html>");
        }
    }


    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));

        if(employees.containsKey(id))
        {
            employees.remove(id);
            writer.println(""
                    + "<html><head><title>Zaposlen</title></head>" + "<body>"
                    + "Zaposlen je uspesno obrisan "
                    + "</body>"
                    + "</html>");
        }
        else
        {
            writer.println("<html><head></head><body>Zaposlen sa zadatim ID-em ne postoji</body></html>");
        }

    }

}
