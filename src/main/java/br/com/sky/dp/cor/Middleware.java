package br.com.sky.dp.cor;

public abstract class Middleware implements Handler {
    private Middleware nextMiddleware;

    public Middleware linkWith(Middleware middleware) {
        this.nextMiddleware = middleware;
        return this.nextMiddleware;
    }

    public abstract boolean handle(Request request);

    protected boolean next(Request request) {
        if (nextMiddleware != null) {
            return nextMiddleware.handle(request);
        }
        return true;
    }
}
