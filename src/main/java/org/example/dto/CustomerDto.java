package org.example.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public record CustomerDto (Long id, String name) {}
