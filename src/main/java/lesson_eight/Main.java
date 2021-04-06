package lesson_eight;

import lesson_eight.model.Client;
import lesson_eight.service.ClientService;
import lesson_eight.service.ClientServiceImpl;

public class Main {
    public static void main(String[] args) {
        ClientService clientService = new ClientServiceImpl();
        Client client = new Client();
        client.setName("AntonTest");
        client.setEmail("antontes111t@mail.com");
        client.setPhone(380939118952L);
        client.setAbout("Test client");
        client.setAge(32);
//        clientService.save(client);
        clientService.getAll();

        long phone = 38093911895L;
        System.out.println(clientService.findByPhone(phone));
        System.out.println(clientService.getAll());
    }
}
