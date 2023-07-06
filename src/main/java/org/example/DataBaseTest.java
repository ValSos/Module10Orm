package org.example;

import database.HibernateUtil;
import entity.Client;
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

        clientCrudService.create("Valeriia Sosedka");
        clientCrudService.update(3L, "Dmytro Dmytrenko");
        clientCrudService.delete(4L);
        System.out.println(clientCrudService.getAllClients());

        planetCrudService.create("TEST", "Test Planet");
        planetCrudService.update("SOLON", "Sololand");
        planetCrudService.delete("VENA");
        System.out.println(planetCrudService.getAllPlanets());


        HibernateUtil.getInstance().close();
    }


}