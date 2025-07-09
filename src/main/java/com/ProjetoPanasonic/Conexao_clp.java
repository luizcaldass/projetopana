package com.ProjetoPanasonic;
import com.digitalpetri.enip.EtherNetIpClient;

public class Conexao_clp {
    private final String ip;
    private EtherNetIpClient client;

    public Conexao_clp(String ip){
        this.ip = ip;
    }

    public EtherNetIpClient conectar() throws Exception{
        client = new EtherNetIpClient(ip);
        client.connect().get();
        System.out.println("Conectado com sucesso: " + ip);
        return client;
    }

    public void desconectar() throws Exception{
        if(client != null){
            client.disconnect();
            System.out.println("Desconectado com sucesso: " + ip);
        }
    }
}