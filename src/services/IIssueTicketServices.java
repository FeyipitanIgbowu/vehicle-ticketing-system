package services;

import dtos.requests.IssueTicketRequest;
import data.models.Ticket;

public interface IIssueTicketServices {

    Ticket issueTicket(IssueTicketRequest request);
}
