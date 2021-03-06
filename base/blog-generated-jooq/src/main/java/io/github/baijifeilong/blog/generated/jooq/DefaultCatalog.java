/*
 * This file is generated by jOOQ.
 */
package io.github.baijifeilong.blog.generated.jooq;


import io.github.baijifeilong.blog.generated.jooq.blog.Blog;
import io.github.baijifeilong.blog.generated.jooq.thatcher.Thatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Schema;
import org.jooq.impl.CatalogImpl;


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
public class DefaultCatalog extends CatalogImpl {

    private static final long serialVersionUID = -812791856;

    /**
     * The reference instance of <code></code>
     */
    public static final DefaultCatalog DEFAULT_CATALOG = new DefaultCatalog();

    /**
     * The schema <code>blog</code>.
     */
    public final Blog BLOG = io.github.baijifeilong.blog.generated.jooq.blog.Blog.BLOG;

    /**
     * The schema <code>thatcher</code>.
     */
    public final Thatcher THATCHER = io.github.baijifeilong.blog.generated.jooq.thatcher.Thatcher.THATCHER;

    /**
     * No further instances allowed
     */
    private DefaultCatalog() {
        super("");
    }

    @Override
    public final List<Schema> getSchemas() {
        List result = new ArrayList();
        result.addAll(getSchemas0());
        return result;
    }

    private final List<Schema> getSchemas0() {
        return Arrays.<Schema>asList(
            Blog.BLOG,
            Thatcher.THATCHER);
    }
}
