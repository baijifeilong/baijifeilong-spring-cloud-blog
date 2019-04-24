/*
 * This file is generated by jOOQ.
 */
package io.github.baijifeilong.blog.generated.jooq.thatcher.tables;


import io.github.baijifeilong.blog.generated.jooq.thatcher.Indexes;
import io.github.baijifeilong.blog.generated.jooq.thatcher.Keys;
import io.github.baijifeilong.blog.generated.jooq.thatcher.Thatcher;
import io.github.baijifeilong.blog.generated.jooq.thatcher.tables.records.GreatUserRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GreatUser extends TableImpl<GreatUserRecord> {

    private static final long serialVersionUID = -1288809558;

    /**
     * The reference instance of <code>thatcher.great_user</code>
     */
    public static final GreatUser GREAT_USER = new GreatUser();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GreatUserRecord> getRecordType() {
        return GreatUserRecord.class;
    }

    /**
     * The column <code>thatcher.great_user.ID</code>.
     */
    public final TableField<GreatUserRecord, Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>thatcher.great_user.username</code>.
     */
    public final TableField<GreatUserRecord, String> USERNAME = createField("username", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>thatcher.great_user</code> table reference
     */
    public GreatUser() {
        this(DSL.name("great_user"), null);
    }

    /**
     * Create an aliased <code>thatcher.great_user</code> table reference
     */
    public GreatUser(String alias) {
        this(DSL.name(alias), GREAT_USER);
    }

    /**
     * Create an aliased <code>thatcher.great_user</code> table reference
     */
    public GreatUser(Name alias) {
        this(alias, GREAT_USER);
    }

    private GreatUser(Name alias, Table<GreatUserRecord> aliased) {
        this(alias, aliased, null);
    }

    private GreatUser(Name alias, Table<GreatUserRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> GreatUser(Table<O> child, ForeignKey<O, GreatUserRecord> key) {
        super(child, key, GREAT_USER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Thatcher.THATCHER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.GREAT_USER_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<GreatUserRecord, Integer> getIdentity() {
        return Keys.IDENTITY_GREAT_USER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<GreatUserRecord> getPrimaryKey() {
        return Keys.KEY_GREAT_USER_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<GreatUserRecord>> getKeys() {
        return Arrays.<UniqueKey<GreatUserRecord>>asList(Keys.KEY_GREAT_USER_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GreatUser as(String alias) {
        return new GreatUser(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GreatUser as(Name alias) {
        return new GreatUser(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public GreatUser rename(String name) {
        return new GreatUser(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public GreatUser rename(Name name) {
        return new GreatUser(name, null);
    }
}