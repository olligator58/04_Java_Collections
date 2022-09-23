package task0861;

public interface Connection {
    void connect() throws WrongDataException, ConnectionException;

    void write(Object data) throws WrongDataException, ConnectionException;

    Object read() throws WrongDataException, ConnectionException;

    void disconnect() throws WrongDataException, ConnectionException;
}
