package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private List<ClientHandler> clients = new ArrayList<>();

    public Main() {
        ServerSocket server = null;
        Socket socket = null;

        try {
            AuthService.connection();
            server = new ServerSocket(7777);
            System.out.println("Сервер запущен");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился");

                ExecutorService executorService = Executors.newFixedThreadPool(10);
                executorService.execute( new ClientHandler(socket, this));
                executorService.shutdown();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            AuthService.disconnect();
        }
    }

    public boolean isNickBusy(String nick) {
        for (ClientHandler o : clients) {
            if (o.getNick().equals(nick)) {
                return true;
            }
        }
        return false;
    }

    public void subscribe(ClientHandler client) {
        clients.add(client);
        broadcastClientList();
    }

    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
        broadcastClientList();
    }

    public void broadcastMsg(ClientHandler from, String msg) {
        for (ClientHandler o : clients) {
            if (!o.checkBlackList(from.getNick())) {
                o.sendMsg(msg);
            }
        }
    }

    public void sendPersonalMsg(ClientHandler from, String nickTo, String msg) {
        for (ClientHandler o : clients) {
            if (o.getNick().equals(nickTo)) {
                if (!o.checkBlackList(from.getNick())) {
                    o.sendMsg("from " + from.getNick() + ": " + msg);
                    from.sendMsg("to " + nickTo + ": " + msg);
                    return;
                } else {
                    from.sendMsg("Вы в чёрном списке у пользователя");
                    return;
                }

            }
        }
        from.sendMsg("Клиент с ником " + nickTo + " не найден в чате");
    }


    public void broadcastClientList() {
        StringBuilder sb = new StringBuilder();
        sb.append("/clientlist ");
        for (ClientHandler o : clients) {
            sb.append(o.getNick() + " ");
        }

        String out = sb.toString();

        for (ClientHandler o : clients) {
            o.sendMsg(out);
        }
    }

    public void changeBlackListNewNick (String oldNick,String newNick) {
        for (ClientHandler o : clients) {
            List <String> blackList = o.getBlackList();
            for ( int i = 0; i < blackList.size(); i++) {
                if (blackList.get(i).equals(oldNick) ) {
                    blackList.set(i, newNick);
                }

            }
        }
    }
}