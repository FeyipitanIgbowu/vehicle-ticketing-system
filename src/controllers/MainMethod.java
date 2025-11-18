//package controllers;
//
//import data.models.*;
//import services.OfficerRegistry;
//import javax.swing.*;
//import java.awt.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainMethod extends JFrame {
//
//    private final List<Vehicle> vehicles = new ArrayList<>();
//    private final List<Ticket> tickets = new ArrayList<>();
//    private final OfficerRegistry officerRegistry = new OfficerRegistry();
//    private Officer currentOfficer = null;
//
//    private final Color PURPLE = new Color(128, 90, 213);
//    private final Color LIGHT_PURPLE = new Color(233, 216, 253);
//
//    public MainMethod() {
//        setTitle("Traffic Ticket System");
//        setSize(500, 350);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//        JPanel panel = new JPanel();
//        panel.setBackground(LIGHT_PURPLE);
//        panel.setLayout(new GridLayout(6, 1, 8, 8));
//
//        JButton loginBtn = makeButton("Login");
//        JButton registerBtn = makeButton("Register Vehicle");
//        JButton issueBtn = makeButton("Issue Ticket");
//        JButton viewBtn = makeButton("View Tickets");
//        JButton payBtn = makeButton("Pay Fine");
//        JButton logoutBtn = makeButton("Logout");
//
//        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
//        panel.add(loginBtn);
//        panel.add(registerBtn);
//        panel.add(issueBtn);
//        panel.add(viewBtn);
//        panel.add(payBtn);
//        panel.add(logoutBtn);
//
//        add(panel);
//
//        loginBtn.addActionListener(e -> loginOfficer());
//        registerBtn.addActionListener(e -> registerVehicle());
//        issueBtn.addActionListener(e -> issueTicket());
//        viewBtn.addActionListener(e -> viewTickets());
//        payBtn.addActionListener(e -> payTicket());
//        logoutBtn.addActionListener(e -> {
//            currentOfficer = null;
//            JOptionPane.showMessageDialog(this, "Logged out.");
//        });
//
//        setLocationRelativeTo(null);
//        setVisible(true);
//    }
//
//    private JButton makeButton(String text) {
//        JButton btn = new JButton(text);
//        btn.setBackground(PURPLE);
//        btn.setForeground(Color.white);
//        btn.setFocusPainted(false);
//        btn.setFont(new Font("Monospaced", Font.BOLD, 14));
//        return btn;
//    }
//
//    private void loginOfficer() {
//        String username = JOptionPane.showInputDialog(this, "Enter Username:");
//        String password = JOptionPane.showInputDialog(this, "Enter Password:");
//        Officer officer = officerRegistry.authenticate(username, password);
//
//        if (officer != null) {
//            currentOfficer = officer;
//            JOptionPane.showMessageDialog(this, "Logged in as " + officer.getName() + " (" + officer.getRank() + ")");
//        } else {
//            JOptionPane.showMessageDialog(this, "Invalid login.");
//        }
//    }
//
//    private void registerVehicle() {
//        String plate = JOptionPane.showInputDialog(this, "Enter Vehicle Plate Number:");
//        if (plate == null || plate.isBlank()) return;
//        vehicles.add(new Vehicle(plate));
//        JOptionPane.showMessageDialog(this, "Vehicle Registered ✅");
//    }
//
//    private void issueTicket() {
//        if (currentOfficer == null) {
//            JOptionPane.showMessageDialog(this, "Login required to issue tickets.");
//            return;
//        }
//
//        String plate = JOptionPane.showInputDialog(this, "Enter Vehicle Plate:");
//        Vehicle vehicle = vehicles.stream().filter(v -> v.getPlateNumber().equalsIgnoreCase(plate)).findFirst().orElse(null);
//
//        if (vehicle == null) {
//            JOptionPane.showMessageDialog(this, "Vehicle not found. Register first.");
//            return;
//        }
//
//        Offense offense = (Offense) JOptionPane.showInputDialog(
//                this,
//                "Select Offense:",
//                "Offense Menu",
//                JOptionPane.PLAIN_MESSAGE,
//                null,
//                Offense.values(),
//                Offense.ONE_WAY
//        );
//
//        if (offense == null) return;
//
//        Ticket ticket = new Ticket(vehicle, offense, currentOfficer, tickets.size() + 1);
//        vehicle.addTicket(ticket);
//        tickets.add(ticket);
//
//        JOptionPane.showMessageDialog(this, "Ticket Issued \nTicket ID: " + ticket.getTicketId());
//    }
//
//    private void viewTickets() {
//        if (tickets.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "No tickets recorded.");
//            return;
//        }
//
//        StringBuilder stringBuilder = new StringBuilder();
//        for (Ticket ticket : tickets)
//            stringBuilder.append(ticket).append("\n--------------------\n");
//
//        JTextArea area = new JTextArea(stringBuilder.toString());
//        area.setEditable(false);
//        area.setBackground(LIGHT_PURPLE);
//        area.setForeground(Color.black);
//        JOptionPane.showMessageDialog(this, new JScrollPane(area), "All Tickets", JOptionPane.INFORMATION_MESSAGE);
//    }
//
//    private void payTicket() {
//        try {
//            int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Ticket ID:"));
//            int amountPaid = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Amount:"));
//            Ticket ticket = tickets.stream().filter(x -> x.getTicketId() == id).findFirst().orElse(null);
//
//            if (ticket == null) {
//                JOptionPane.showMessageDialog(this, "Ticket not found.");
//                return;
//            }
//            ticket.payFine(id,amountPaid);
//            JOptionPane.showMessageDialog(this, "Fine Paid");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Invalid Ticket ID.");
//        }
//    }
//
//    public static void main(String... feyi) {
//
//        new MainMethod();
//    }
//}
