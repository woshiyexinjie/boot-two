package com.helloxin.grpc.lib;

import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public interface HelloReply {
     
	String sayHello(String name);
}
