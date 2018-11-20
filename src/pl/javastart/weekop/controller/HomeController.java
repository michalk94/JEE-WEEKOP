package pl.javastart.weekop.controller;

import pl.javastart.weekop.model.Discovery;
import pl.javastart.weekop.service.DiscoveryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@WebServlet("")
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        saveDiscoveriesInRequest(request);
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);

    }

    private void saveDiscoveriesInRequest(HttpServletRequest request) {
        DiscoveryService discoveryService = new DiscoveryService();
        List<Discovery> allDiscoveries = discoveryService.getAllDiscoveries(new Comparator<Discovery>() {
            @Override
            public int compare(Discovery o1, Discovery o2) {
                int o1Vote = o1.getUpVote() - o1.getDownVote();
                int o2Vote = o2.getUpVote() - o2.getDownVote();
                if (o1Vote < o2Vote) {
                    return 1;
                } else if (o1Vote > o2Vote) {
                    return -1;
                }
                return 0;
            }
        });
        request.setAttribute("discoveries", allDiscoveries);
    }
}
