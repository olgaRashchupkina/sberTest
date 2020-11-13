import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet")
public class ServiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    Producer sender;
    Listener listener;

    private final String BR = "<br />";

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String element = request.getParameter("element");
            String value = request.getParameter("value");

//            response.setContentType("text/html;charset=UTF-8");
//            PrintWriter out = response.getWriter();
//            out.print("send messages :" + BR);
//            for (int i = 0; i < 3; i++) {
//                String msg = value + " #" + i;
//                out.print("&bull; " + msg + BR);
//                sender.sendMessage(msg);
//            }
//            Producer sender = new Producer();
            sender.sendMessage(element + "_" + value);
//            out.close();

//         else {
//            out.print("receive messages :" + BR);
//            listener.onMessage();
//            if (listener.messages.size() > 0) {
//                for (int i=0; i<Receiver.messages.size(); i++) {
//                    out.print("&mdash; " +
//                            Receiver.messages.get(i) + BR);
//                }
//                Receiver.messages.clear();
//            }
//            out.close();
//        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    static showValue(){

    }
}