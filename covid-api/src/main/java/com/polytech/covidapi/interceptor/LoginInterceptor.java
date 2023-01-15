package com.polytech.covidapi.interceptor;

import com.polytech.covidapi.repository.PeopleRepository;
import com.polytech.covidapi.utils.JWTTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    PeopleRepository peopleRepository;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();

        String authorization = request.getHeader("Authorization");
        if (authorization==null || authorization.isEmpty()){
            writer.write("Vous n'avez pas de droite d'utiliser l'interface.");
            return false;
        }else {
            String[] level=JWTTokenUtil.verifyToken(authorization);
            if (level!=null){
                int id=Integer.parseInt(level[0]);
                if (peopleRepository.findPersonById(id)!=null){
                    int role= Integer.parseInt(level[1]);
                    String url = String.valueOf(request.getRequestURL());
                    if (url.contains("/admin/center") && role!=0){
                        writer.write("Vous n'avez pas de droite d'utiliser l'interface.");
                        return false;
                    }else if (url.contains("/admin/people") && role==2){
                        writer.write("Vous n'avez pas de droite d'utiliser l'interface.");
                        return false;
                    }else {
                        return true;
                    }
                }else {
                    return false;
                }
            }
            return false;
        }
    }
}
