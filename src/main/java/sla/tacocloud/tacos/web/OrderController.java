package sla.tacocloud.tacos.web;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import sla.tacocloud.tacos.pdo.Order;
import sla.tacocloud.tacos.pdo.User;
import sla.tacocloud.tacos.repos.OrderRepository;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private OrderRepository orderRepo;

    private OrderProperties props;

    @Autowired
    public OrderController(
            OrderRepository orderRepo,
            OrderProperties props) {
        this.orderRepo = orderRepo;
        this.props = props;
    }

    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(
            @Valid Order order, Errors errors, SessionStatus sessionStatus, @AuthenticationPrincipal
            User user) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        log.info("Order submitted: " + order);
        orderRepo.save(order);
        log.info("Current user : " + user.getFullname());
        sessionStatus.setComplete();

        return "redirect:/";
    }

    @GetMapping
    public String ordersForUser(@AuthenticationPrincipal User user, Model model) {

        log.warn("Current property page size is " + props.getPageSize());
        log.info("using page size " + props.getPageSize());
/*        Pageable pageable = PageRequest.of(0, props.getPageSize());
         model.addAttribute("orders",
                orderRepo.findByUserOrderByPlacedAtDesc(user, pageable));
        return "orderList";*/
        return "/";
    }
}
