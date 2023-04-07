package de.pdbm;

import jakarta.annotation.Resource;
import jakarta.enterprise.concurrent.ContextServiceDefinition;
import jakarta.enterprise.concurrent.ManagedExecutorDefinition;
import jakarta.enterprise.concurrent.ManagedExecutorService;
import jakarta.enterprise.context.ApplicationScoped;

import static jakarta.enterprise.concurrent.ContextServiceDefinition.APPLICATION;
import static jakarta.enterprise.concurrent.ContextServiceDefinition.SECURITY;

@ManagedExecutorDefinition(
        name = "java:module/concurrent/MyExecutor",
        context = "java:module/concurrent/MyExecutorContext",
        hungTaskThreshold = 120000,
        maxAsync = 5)
@ContextServiceDefinition(
        name = "java:module/concurrent/MyExecutorContext",
        propagated = { SECURITY, APPLICATION })
@ApplicationScoped
public class ManagedExecutorServiceViaDefinition {

    @Resource(name = "java:module/concurrent/MyExecutor")
    ManagedExecutorService executorService;

}
