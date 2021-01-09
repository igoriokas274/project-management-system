package dev.sda.team2.pma.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AppErrorController implements ErrorController {

    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "errors/error-404";
            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
                return "errors/error-403";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "errors/error-500";
            } else if (statusCode == HttpStatus.METHOD_NOT_ALLOWED.value()) {
                return "errors/error-405";
            }
        }

        return "errors/error-000";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}
