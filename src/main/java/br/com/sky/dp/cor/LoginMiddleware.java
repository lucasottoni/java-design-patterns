package br.com.sky.dp.cor;

public class LoginMiddleware extends Middleware {
    private final ServerData serverData;

    public LoginMiddleware(ServerData serverData) {
        this.serverData = serverData;
    }

    @Override
    public boolean handle(Request request) {
        if (!isValidUser(request)) {
            request.setUserType(UserType.INVALID);
            return false;
        }
        return next(request);
    }

    private boolean isValidUser(Request request) {
        return serverData.isValidUser(request.getUser(), request.getPassword());
    }
}
