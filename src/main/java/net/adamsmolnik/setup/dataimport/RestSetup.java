package net.adamsmolnik.setup.dataimport;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import net.adamsmolnik.boundary.dataimport.ImportService;

/**
 * @author ASmolnik
 *
 */
@ApplicationPath("/*")
public class RestSetup extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(ImportService.class);
        return classes;
    }
}
