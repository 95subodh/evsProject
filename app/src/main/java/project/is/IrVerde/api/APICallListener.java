package project.is.IrVerde.api;

import project.is.IrVerde.api.response.Response;


public interface APICallListener
{
    public void onAPICallRespond(APICallTask task, ResponseStatus status, Response<?> response);
    public void onAPICallFail(APICallTask task, ResponseStatus status, Exception exception);
}
