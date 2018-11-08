package com.denny.controller;

import com.denny.dao.Connector;

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

@WebServlet(urlPatterns = "/login", loadOnStartup = 1)
public class LoginController extends HttpServlet {

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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        if(userCheck(username, password, connection)) {
            resp.getWriter().println("Tu beda dupy najlepsze w miescie");
            req.getSession().setAttribute("Logged", true);
            if(isGenderMale(username, connection)){
                req.getSession().setAttribute("Male", true);
            } else {
                req.getSession().setAttribute("Male", false);
            }
            resp.sendRedirect("uploadImage.jsp");
        } else {
            resp.sendRedirect("error.jsp");
        }
    }

    public static boolean userCheck(String username, String password, Connection connection){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT 1 FROM user WHERE username=? AND password=?;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSet = null;
        try {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
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

    public static boolean isGenderMale(String username, Connection connection){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT gender FROM user WHERE username=?;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setString(1, username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSet = null;
        try {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(resultSet.next()) {
                String genderFromDb = resultSet.getString(1);
                if(genderFromDb.equals("m")){
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
