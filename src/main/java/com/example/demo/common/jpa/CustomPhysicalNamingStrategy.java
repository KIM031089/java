package com.example.demo.common.jpa;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.util.ObjectUtils;

/**
 * Pluggable strategy contract for applying physical naming rules for database
 * object names.<br/>
 * Customized for convert to UpperSnakeCase
 * 
 */
public class CustomPhysicalNamingStrategy implements PhysicalNamingStrategy {

  @Override
  public Identifier toPhysicalCatalogName(final Identifier identifier,
      final JdbcEnvironment jdbcEnv) {
    return convertToUpperSnakeCase(identifier);
  }

  @Override
  public Identifier toPhysicalColumnName(final Identifier identifier,
      final JdbcEnvironment jdbcEnv) {
    return convertToUpperSnakeCase(identifier);
  }

  @Override
  public Identifier toPhysicalSchemaName(final Identifier identifier,
      final JdbcEnvironment jdbcEnv) {
    return convertToUpperSnakeCase(identifier);
  }

  @Override
  public Identifier toPhysicalSequenceName(final Identifier identifier,
      final JdbcEnvironment jdbcEnv) {
    return convertToUpperSnakeCase(identifier);
  }

  @Override
  public Identifier toPhysicalTableName(final Identifier identifier,
      final JdbcEnvironment jdbcEnv) {
    return convertToUpperSnakeCase(identifier);
  }

  private Identifier convertToUpperSnakeCase(final Identifier identifier) {
    if (ObjectUtils.isEmpty(identifier)) {
      return identifier;
    }
    return Identifier.toIdentifier(identifier.getText().toUpperCase());
  }
}