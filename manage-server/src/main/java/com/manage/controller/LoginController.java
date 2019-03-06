package com.manage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manage.utils.BrowserUtil;

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * @return
     * @throws IOException 
     * @throws ServletException 
     */
    @RequestMapping(value = "/index", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public void index( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("*********indexcontroller slect leiji selectbysum.do start***********");
        String os = (String) request.getSession().getAttribute("os") ;
        if(os == null){
        	os = BrowserUtil.getOsAndBrowserInfo(request) ;
            request.getSession().setAttribute("os", os);
        }
        if(os.equals("IPhone") || os.equals("Android") ){
        	 request.getRequestDispatcher("h5Login.jsp").forward(request, response);
        }
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }


    

}
