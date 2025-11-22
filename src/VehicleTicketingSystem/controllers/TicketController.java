package controllers;

import dtos.reponses.IssueTicketResponse;
import dtos.reponses.SettleTicketResponse;
import dtos.reponses.ViewTicketResponse;
import dtos.requests.IssueTicketRequest;
import dtos.requests.SettleTicketRequest;
import dtos.requests.ViewTicketsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.ITicketServices;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private ITicketServices ticketServices;

    @PostMapping("/issue")
    public IssueTicketResponse issueTicket(@RequestBody IssueTicketRequest request) {
        return ticketServices.ticketResponse(request);
    }

    @GetMapping("/view")
    public ViewTicketResponse viewTicket(ViewTicketsRequest request) {
        return ticketServices.viewTicketResponse(request);
    }

    @PostMapping("/settle")
    public SettleTicketResponse settleTicket(@RequestBody SettleTicketRequest request) {
        return ticketServices.settleResponse(request);
    }
}
