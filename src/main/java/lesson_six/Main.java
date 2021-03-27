package lesson_six;

import lesson_six.model.Client;
import lesson_six.service.ClientService;
import lesson_six.service.ClientServiceImpl;

public class Main {
    public static void main(String[] args) {
        ClientService clientService = new ClientServiceImpl();
        Client client = new Client();
        client.setName("AntonTest");
        client.setEmail("antontest@mail.com");
        client.setPhone(380939118958L);
        client.setAbout("Test client");
        client.setAge(32);
//        clientService.delete(client);

        long phone = 380939118958L;
        System.out.println(clientService.findByPhone(phone));
    }
}
