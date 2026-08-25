package com.example.servlet;

import com.example.model.User;
import com.example.service.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String  Id = req.getParameter("id");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");

        if (Id==null || email == null || name == null || mobile == null) {
            res.setStatus(400);
            res.setContentType("application/json");
            res.getWriter().write("{\n"+
                "    \"message\":\"Some fields are missing\"\n"+
            "}");
            return;
        }
        Integer id=Integer.parseInt(Id);
        User user = new User(id, name, email, mobile);

        userService.createUser(user);

        res.setContentType("application/json");
        res.setStatus(200);
        res.getWriter().write("{\n"+
                "    \"message\":\"User Added Successfully\"\n"+
                "}"
        );
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String idParam = req.getParameter("id");

        if (idParam == null) {
            List<User> users = userService.getAllUsers();
            res.setStatus(200);
            res.setContentType("application/json");
            res.getWriter().write(usersToJson(users));
            return;
        }

        Integer id = Integer.parseInt(idParam);

        User user = userService.getUserById(id);

        if (user == null) {
            res.setStatus(404);
            res.setContentType("application/json");
            res.getWriter().write("{\n" +
                    "    \"message\":\"User not found\"\n" +
                    "}"
            );
            return;
        }

        res.setContentType("application/json");
        res.setStatus(200);
        res.getWriter().write(userToJson(user));
    }

    @Override
    public void doPut(HttpServletRequest req, HttpServletResponse res) {

    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse res) {

    }

    private String userToJson(User user){
        return "{\n" +
                "    \"id\": "+ user.getId()+",\n" +
                "    \"name\":" + user.getName() +",\n" +
                "    \"email\": " + user.getEmail() + ",\n" +
                "    \"mobile\": " + user.getMobile() +"\n" +
                "}";
    }

    private String usersToJson(List<User>users){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("[");
        for(int i=0;i<users.size();i++){
            stringBuilder.append(userToJson(users.get(i)));
            if(i<users.size()-1)
                stringBuilder.append(",");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
