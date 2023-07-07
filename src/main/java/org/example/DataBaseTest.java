package org.example;

import database.HibernateUtil;
import entity.Client;
import entity.Planet;
import org.flywaydb.core.Flyway;
import service.ClientCrudService;
import service.PlanetCrudService;

import java.util.ResourceBundle;

public class DataBaseTest {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("hibernate");
    private static final String JDBC_URL = "hibernate.connection.url";

    public static void main(String[] args) {
        Flyway.configure()
                .dataSource(resourceBundle.getString(JDBC_URL), null, null)
                .load()
                .migrate();

        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();
        Client clientById = clientCrudService.getById(1L);
        System.out.println(clientById);

        Client client = new Client();
        client.setName("Valeriia Sosedka");
        clientCrudService.create(client);
        Client client2 = new Client();
        client2.setId(3L);
        client2.setName("Dmytro Dmytrenko");
        clientCrudService.update(client2);
        clientCrudService.delete(4L);
        System.out.println(clientCrudService.getAllClients());

        Planet planet = new Planet();
        planet.setId("TEST");
        planet.setName("Test Planet");
        planetCrudService.create(planet);
        Planet planet2 = new Planet();
        planet2.setId("SOLON");
        planet2.setName("Sololand");
        planetCrudService.update(planet2);
        planetCrudService.delete("VENA");
        System.out.println(planetCrudService.getAllPlanets());


        HibernateUtil.getInstance().close();
    }


}