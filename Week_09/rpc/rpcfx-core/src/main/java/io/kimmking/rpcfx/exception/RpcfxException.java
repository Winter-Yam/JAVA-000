package io.kimmking.rpcfx.exception;

import io.kimmking.rpcfx.api.RpcfxResponse;

public class RpcfxException extends RpcfxResponse {

    public RpcfxException(Exception e) {
        this.exception = e;
        this.status = false;
    }
}
