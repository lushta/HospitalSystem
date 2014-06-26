package model.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lushta on 15.06.14.
 */
public class ExitCommand extends Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("userId");
        request.getSession().removeAttribute("userName");
        request.getSession().removeAttribute("userRole");
        request.getSession().removeAttribute("language");
    }
}
