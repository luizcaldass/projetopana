package com.ProjetoPanasonic;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataCenter {
    private String url;
    private String user;
    private String password;

    public DataCenter(String url, String user, String password){
        this.url = "panamain.database.windows.net";
        this.user = "Adminteste";
        this.password = "Luizgamer1@";
    }

    public Connection conectar() throws Exception{
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("Conectado com sucesso");
        return conn;
    }
}
