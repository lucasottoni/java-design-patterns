package br.com.sky.dp.cor;

public class AuthenticationMiddleware extends Middleware {

    public AuthenticationMiddleware(ServerData serverData) {
        this.linkWith(new LoginMiddleware(serverData)).linkWith(new RoleMiddleware(serverData));
    }

    @Override
    public boolean handle(Request request) {
        if (request == null || request.getUser() == null) return false;
        return this.next(request);
    }
}
