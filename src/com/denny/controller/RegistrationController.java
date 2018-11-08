package com.denny.controller;

import com.denny.dao.Connector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/registration", loadOnStartup = 1)
public class RegistrationController extends HttpServlet {
    Connection connection;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            connection = Connector.setupConnection();
            System.out.println("Connection setup");
        } catch (SQLException e) {
            System.out.println("Failed to setup the connection");
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String postalCode = request.getParameter("postalcode");
        String gender = request.getParameter("gender");
        UserData userData = new UserData(firstName, lastName, username, password, address, city, postalCode, gender);

        if(!firstName.isEmpty() && !lastName.isEmpty() && !username.isEmpty() && !password.isEmpty() && !address.isEmpty() && !city.isEmpty() && !postalCode.isEmpty() && !gender.isEmpty()) {
            if (!userExistanceCheck(username, connection)) {
                registerUserInDb(userData, connection);
                response.getWriter().println("SUCCESS");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
                requestDispatcher.include(request, response);
            } else {
                request.setAttribute("failure", true);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("registration.jsp");

                requestDispatcher.forward(request, response);
            }
        } else {

        }
    }

    private void registerUserInDb(UserData userData, Connection connection) {

        String insertSql = "insert into user(firstName, lastName, username, password, address, city, postalCode, gender) values(?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, userData.getFirstName());
            preparedStatement.setString(2, userData.getLastName());
            preparedStatement.setString(3, userData.getUsername());
            preparedStatement.setString(4, userData.getPassword());
            preparedStatement.setString(5, userData.getAddress());
            preparedStatement.setString(6, userData.getCity());
            preparedStatement.setString(7, userData.getPostalcode());
            preparedStatement.setString(8, userData.getGender());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static boolean userExistanceCheck(String username, Connection connection) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT 1 FROM user WHERE username=?;");
        } catch(SQLException e) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setString(1, username);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSet = null;
        try {
            resultSet = preparedStatement.executeQuery();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        try {
            if(resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
