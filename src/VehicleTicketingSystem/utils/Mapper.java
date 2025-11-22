package utils;


import dtos.reponses.IssueTicketResponse;
import dtos.reponses.RegisterVehicleResponse;
import dtos.reponses.SettleTicketResponse;
import dtos.reponses.ViewTicketResponse;
import dtos.requests.RegisterOfficerRequest;
import data.models.Officer;
import data.models.Owner;
import data.models.Ticket;
import dtos.requests.IssueTicketRequest;
import data.models.Vehicle;
import dtos.requests.RegisterVehicleRequest;
import dtos.requests.SettleTicketRequest;
import dtos.requests.ViewTicketsRequest;

public class Mapper {

    public static Officer mapOfficer(RegisterOfficerRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }

        Officer officer = new Officer();
        officer.setId(request.getOfficerId());
        officer.setEmail(request.getOfficerEmail());
        return officer;
    }

    public static Ticket mapIssueTicket(IssueTicketRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }

        Ticket ticket = new Ticket();
        ticket.setTicketId(request.getTicketId());
        ticket.setOffense(request.getOffense());
        ticket.setIssuer(request.getIssuer());
        ticket.setVehicle(request.getVehicle());
        return ticket;
    }


    public static Ticket mapSettleTicket(SettleTicketRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }

        Ticket ticket = new Ticket();
        ticket.setTicketId(request.getTicketId());
        ticket.setHasPaid(request.isHasPaid());
        ticket.setVehicle(request.getVehicle());

        return ticket;
    }

    public static Ticket mapViewTicket(ViewTicketsRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }

        Ticket ticket = new Ticket();
        ticket.setOffense(request.getOffense());
        ticket.setVehicle(request.getVehicle());
        ticket.setHasPaid(request.isHasPaid());
        ticket.setTicketId(request.getTicketId());

        return ticket;
    }

    public static Vehicle mapVehicle(RegisterVehicleRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("RegisterVehicleRequest cannot be null");
        }

        Owner owner = new Owner();
        owner.setEmail(request.getOwnerEmail());
        owner.setName(request.getOwnerName());
        owner.setAddress(request.getOwnerAddress());
        owner.setPhone(request.getOwnerPhone());

        Vehicle vehicle = new Vehicle();
        vehicle.setColour(request.getVehicleColour());
        vehicle.setName(request.getVehicleName());
        vehicle.setModel(request.getVehicleModel());
        vehicle.setChasisNumber(request.getChasisNumber());
        vehicle.setOwner(owner);

        return vehicle;
    }



    public static SettleTicketResponse mapSettleTicketResponse(Ticket foundTicket) {
        SettleTicketResponse settleTicketResponse = new SettleTicketResponse();
        settleTicketResponse.setTicketId(foundTicket.getTicketId());
        settleTicketResponse.setAmountPaid(foundTicket.getOffense().getFineAmount());
        settleTicketResponse.setPaymentDate(foundTicket.getDateOfPayment() + "");
        settleTicketResponse.setHasPaid(foundTicket.isHasPaid()?"true":"false");
        return settleTicketResponse;
    }

    public static ViewTicketResponse mapViewTicketResponse(Ticket foundTicket) {
        ViewTicketResponse viewTicketResponse = new ViewTicketResponse();
        viewTicketResponse.setTicketId(foundTicket.getTicketId());
        viewTicketResponse.setFineAmount(foundTicket.getOffense().getFineAmount());
        viewTicketResponse.setTicketId(foundTicket.getTicketId());
        viewTicketResponse.setOffense(foundTicket.getOffense());
        return viewTicketResponse;
    }

    public static IssueTicketResponse mapIssueTicketResponse(Ticket foundTicket) {
        IssueTicketResponse issueTicketResponse = new IssueTicketResponse();
        issueTicketResponse.setTicketId(foundTicket.getTicketId());
        issueTicketResponse.setFineAmount(foundTicket.getOffense().getFineAmount());
        issueTicketResponse.setTicketId(foundTicket.getTicketId());
        issueTicketResponse.setOffense(foundTicket.getOffense());
        return issueTicketResponse;
    }

    public static RegisterVehicleResponse mapRegisterOfficer(Vehicle registeredVehicle) {
        RegisterVehicleResponse vehicleResponse = new RegisterVehicleResponse();
        vehicleResponse.setVehicleId(String.valueOf(registeredVehicle.getVehicleId()));
        vehicleResponse.setOwnerName(registeredVehicle.getName());
        vehicleResponse.setPlateNumber(registeredVehicle.getPlateNumber());
        return vehicleResponse;
    }
}

