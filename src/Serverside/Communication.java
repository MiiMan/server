package Serverside;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Communication implements Closeable {

    private Socket socket;

    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public Communication(ServerSocket socket) throws IOException {
        this.socket = socket.accept();

        this.bufferedReader = createReader();
        this.bufferedWriter = createWriter();
    }

    public Communication(String ip, int port) throws IOException {
        this.socket = new Socket(ip, port);

        this.bufferedReader = createReader();
        this.bufferedWriter = createWriter();
    }

    public void writeLine(String msg) throws IOException {
        bufferedWriter.write(msg);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }

    public String readLine() throws IOException {
        return bufferedReader.readLine();
    }


    private BufferedReader createReader() throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    private BufferedWriter createWriter() throws IOException {
        return new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    @Override
    public void close() throws IOException {
        socket.close();
    }

}
