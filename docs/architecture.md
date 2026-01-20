# User Management API – Architecture

## Overview
This service provides user and role management with authentication and authorization.

## Layers
- Controller layer: REST APIs
- Service layer: business logic
- Repository layer: database access (JPA)
- Security layer: Spring Security

## Authentication (planned)
- JWT-based authentication
- Role-based access control (RBAC)

## Database (planned)
- Users
- Roles
- User-Role mapping