package task0861;

public class ConnectionMock implements Connection {
    @Override
    public void connect() throws WrongDataException, ConnectionException {
    }

    @Override
    public void write(Object data) throws WrongDataException, ConnectionException {
    }

    @Override
    public Object read() throws WrongDataException, ConnectionException {
        return null;
    }

    @Override
    public void disconnect() throws WrongDataException, ConnectionException {

    }
}
