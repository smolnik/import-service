package net.adamsmolnik.setup.dataimport;

import javax.inject.Singleton;
import net.adamsmolnik.setup.ServiceNameResolver;

/**
 * @author ASmolnik
 *
 */
@Singleton
public class ImportServiceNameResolver implements ServiceNameResolver {

    @Override
    public String getServiceName() {
        return "import-service";
    }

}
