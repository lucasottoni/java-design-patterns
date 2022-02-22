package br.com.sky.dp.cor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ServerTest {

    private Server server;
    private ServerData serverData;

    @BeforeEach
    public void setUp() {
        server = new Server();
        serverData = new ServerData();

        AuthenticationMiddleware middleware = new AuthenticationMiddleware(serverData);
        server.setMiddleware(middleware);
    }
    
    @Test
    public void adminLogin() {
        //given
        serverData.addUser("admin", "pwd", UserType.ADMIN);
        
        //when
        Request req = new Request("admin", "pwd");
        boolean authenticated = server.logIn(req);

        // then
        assertTrue(authenticated);
        assertEquals(UserType.ADMIN, req.getUserType());
    }

    @Test
    public void userLogin() {
        //given
        serverData.addUser("user", "pwd", UserType.USER);

        //when
        Request req = new Request("user", "pwd");
        boolean authenticated = server.logIn(req);

        // then
        assertTrue(authenticated);
        assertEquals(UserType.USER, req.getUserType());
    }

    @Test
    public void invalidLogin() {
        //given
        serverData.addUser("user", "pwd", UserType.USER);

        //when
        Request req = new Request("user", "pwdX");
        boolean authenticated = server.logIn(req);

        // then
        assertFalse(authenticated);
        assertEquals(UserType.INVALID, req.getUserType());
    }
}
