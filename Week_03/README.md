# netty-gateway网关

myclient包下使用简单的httpclient作为client，在HttpOutboundHandler请求真正被代理Server
HttpHeaderFilter过滤器用于对请求添加nio请求头，在HttpInboundHandler中处理