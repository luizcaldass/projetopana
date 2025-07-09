package com.ProjetoPanasonic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataCenter {
    private Connection conexao;
    private String url;
    private String user;
    private String password;

    public DataCenter(String url, String user, String password){
        this.url = "panamain.database.windows.net";
        this.user = "Adminteste";
        this.password = "Luizgamer1@";
    }

    public DataCenter(Connection conexao){
        this.conexao = conexao;
    }

    public Connection conectar() throws Exception{
        if (conexao == null || conexao.isClosed()){
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado com sucesso");
        }
        return conexao;
    }

    public void salvarleitura(String maquina, String tag, int valor) throws Exception{
        String sql = "INSERT INTO DadosProd (maquina, tag, valor) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql)){
            ps.setString(1, maquina);
            ps.setString(2, tag);
            ps.setInt(3, valor);
            ps.executeUpdate();
        }
    }

    public void desconetar(){
        try {
            if (conexao !=null && !conexao.isClosed()){
                conexao.isClosed();
                System.out.println("Conecxao encerrada com sucesso");
            }
        } catch (SQLException e) {
            System.err.println("Erro de desconecxao" + e.getMessage());
        }
    }


}
