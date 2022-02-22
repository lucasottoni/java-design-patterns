package br.com.sky.dp.cor;

public class RoleMiddleware extends Middleware {
    private final ServerData serverData;

    public RoleMiddleware(ServerData serverData) {
        this.serverData = serverData;
    }

    @Override
    public boolean handle(Request request) {
        request.setUserType(checkRole(request));
        return next(request);
    }

    private UserType checkRole(Request request) {
        return serverData.getUserType(request.getUser());
    }
}
