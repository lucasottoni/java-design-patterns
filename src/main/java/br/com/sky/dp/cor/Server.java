package br.com.sky.dp.cor;

public class Server {

    private Middleware middleware;

    public void setMiddleware(Middleware middleware) {
        this.middleware = middleware;
    }

    public boolean logIn(Request request) {
        return middleware.handle(request);
    }

}
