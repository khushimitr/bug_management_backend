package com.example.springbugtracker.model.domain.generators;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.generator.BeforeExecutionGenerator;
import org.hibernate.generator.EventType;
import org.hibernate.id.IdentifierGeneratorHelper;
import org.hibernate.id.IntegralDataTypeHolder;
import org.hibernate.id.factory.spi.StandardGenerator;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EnumSet;

import static org.hibernate.generator.EventTypeSets.INSERT_ONLY;

public class BugKeyValueGenerator implements BeforeExecutionGenerator {

    private IntegralDataTypeHolder previousValueHolder;

    @Override
    public synchronized Object generate(SharedSessionContractImplementor session, Object obj, Object currentValue, EventType eventType) {

        String sql = String.format("select max( %s ) as id from %s",
                session.getEntityPersister(obj.getClass().getName(), obj)
                        .getIdentifierPropertyName(),
                obj.getClass().getSimpleName());

        previousValueHolder = new IdentifierGeneratorHelper.BasicHolder(Integer.class);

        try {
            PreparedStatement st = session.getJdbcCoordinator().getStatementPreparer().prepareStatement(sql);
            try {
                ResultSet rs = session.getJdbcCoordinator().getResultSetReturn().extract(st);
                try {
                    if (rs.next()) {
                        previousValueHolder.initialize(rs, 0L).increment();
                    } else {
                        previousValueHolder.initialize(1L);
                    }
                    sql = null;
                } finally {
                    session.getJdbcCoordinator().getLogicalConnection().getResourceRegistry().release(rs, st);
                }
            } finally {
                session.getJdbcCoordinator().getLogicalConnection().getResourceRegistry().release(st);
                session.getJdbcCoordinator().afterStatementExecution();
            }
        } catch (SQLException sqle) {
            throw session.getJdbcServices().getSqlExceptionHelper().convert(
                    sqle,
                    "could not fetch initial value for increment generator",
                    sql
            );
        }
        return previousValueHolder.makeValueThenIncrement();
    }

    @Override
    public EnumSet<EventType> getEventTypes() {
        return INSERT_ONLY;
    }
}
